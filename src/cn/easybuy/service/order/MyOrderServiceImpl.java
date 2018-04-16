package cn.easybuy.service.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.easybuy.entity.Order;
import cn.easybuy.entity.OrderDetail;
import cn.easybuy.entity.Product;
import cn.easybuy.entity.User;
import cn.easybuy.mapper.OrderDetailMapper;
import cn.easybuy.mapper.OrderMapper;
import cn.easybuy.mapper.ProductMapper;
import cn.easybuy.service.MyBaseService;
import cn.easybuy.utils.MyBatisUtil;
import cn.easybuy.utils.ShoppingCart;
import cn.easybuy.utils.ShoppingCartItem;
import cn.easybuy.utils.StringUtils;

/**
 * 由于该service依赖于多个mapper，现有的通用service无法只针对一个mapper做了封装，
 * 所以无法继承MyBaseService，有时间再对MyBaseService进行扩展
 * 
 * @author chsm
 * @date 2018年4月16日上午9:10:15
 * @version 1.0
 */
public class MyOrderServiceImpl implements OrderService {

	@Override
	public Order payShoppingCart(ShoppingCart cart, User user, String address) {
		SqlSession session = MyBatisUtil.getSession();
		// 初始化所需类
		Order order = new Order();
		OrderMapper orderMapper = session.getMapper(OrderMapper.class);
		OrderDetailMapper orderDetailMapper = session
				.getMapper(OrderDetailMapper.class);
		ProductMapper productMapper = session.getMapper(ProductMapper.class);
		// 设置值并添加
		order.setUserId(user.getId());
		order.setLoginName(user.getLoginName());
		order.setUserAddress(address);
		order.setCreateTime(new Date());
		order.setCost(cart.getTotalCost());
		order.setSerialNumber(StringUtils.randomUUID());
		try {
			orderMapper.add(order);
		} catch (Exception e) {
			e.printStackTrace();
			// 若出现异常则回滚并关闭session
			session.rollback();
			session.close();
			order = null;
		}
		// 遍历设置订单明细
		for (ShoppingCartItem item : cart.getItems()) {
			OrderDetail orderDetail = new OrderDetail();
			Product product = new Product();
			orderDetail.setOrderId(order.getId());
			orderDetail.setCost(item.getCost());
			orderDetail.setProduct(item.getProduct());
			orderDetail.setQuantity(item.getQuantity());
			orderDetail.setProductId(item.getProduct().getId());
			// 修改库存
			product.setId(item.getProduct().getId());
			product.setStock(item.getQuantity());
			try {
				orderDetailMapper.add(orderDetail);
				productMapper.updateStock(product);
			} catch (Exception e) {
				e.printStackTrace();
				// 若出现异常则回滚并关闭session
				session.rollback();
				session.close();
				order = null;
			}
		}
		// 若未出现异常则提交事物并关闭session
		session.commit();
		session.close();
		return order;
	}

	@Override
	public List<Order> getOrderList(Integer userId, Integer currentPageNo,
			Integer pageSize) {
		SqlSession session = MyBatisUtil.getSession();
		List<Order> orders = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("init", (currentPageNo - 1) * pageSize);
		map.put("pageSize", pageSize);
		OrderMapper orderMapper = session.getMapper(OrderMapper.class);
		OrderDetailMapper orderDetailMapper = session
				.getMapper(OrderDetailMapper.class);
		
		try {
			orders = orderMapper.getOrderList(map);
			for (Order order : orders) {
				order.setOrderDetailList(orderDetailMapper.getOrderDetailList(order.getId()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.commit();
			session.close();
		}
		return orders;
	}

	@Override
	public int count(Integer userId) {
		int count = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		SqlSession session = MyBatisUtil.getSession();
		OrderMapper orderMapper = session.getMapper(OrderMapper.class);
		map.put("userId", userId);
		try {
			count = orderMapper.count(map);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return count;
	}

	@Override
	public List<OrderDetail> getOrderDetailList(Integer orderId) {
		List<OrderDetail> orderDetails = null;
		SqlSession session = MyBatisUtil.getSession();
		OrderDetailMapper orderDetailMapper = session
				.getMapper(OrderDetailMapper.class);
		try {
			orderDetails = orderDetailMapper.getOrderDetailList(orderId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return orderDetails;
	}

}
