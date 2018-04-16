package cn.easybuy.mapper;

import java.util.List;
import java.util.Map;

import cn.easybuy.entity.Order;

/**
 * @author chsm
 * @date  2018年4月15日下午8:42:02
 * @version 1.0
 */
public interface OrderMapper {
	
	int add(Order order);
	
	int deleteById(Integer id);
	
	Order getOrderById(Integer id);
	
	List<Order> getOrderList(Map<String, Object> map);
	
	int count(Map<String, Integer> map);
	
}
