package cn.easybuy.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.easybuy.entity.Product;
import cn.easybuy.mapper.ProductMapper;
import cn.easybuy.service.MyBaseService;

/**
 * @author chsm
 * @date 2018年4月14日下午10:33:01
 * @version 1.0
 */
public class MyProductServiceImpl extends MyBaseService<ProductMapper>
		implements ProductService {

	@Override
	public boolean add(Product product) {
		before();
		int count = 0;
		try {
			count = t.add(product, 0);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return count == 0 ? false : true;
	}

	@Override
	public boolean update(Product product) {
		before();
		int count = 0;
		try {
			count = t.update(product);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return count == 0 ? false : true;
	}

	@Override
	public boolean deleteProductById(Integer productId) {
		before();
		int count = 0;
		try {
			count = t.deleteProductById(productId);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return count == 0 ? false : true;
	}

	@Override
	public Product getProductById(Integer productId) {
		before();
		Product product = null;
		try {
			product = t.getProductById(productId);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return product;
	}

	@Override
	public List<Product> getProductList(Integer currentPageNo,
			Integer pageSize, String proName, Integer categoryId, Integer level) {
		before();
		List<Product> products = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("init", (currentPageNo - 1) * pageSize);
		map.put("pageSize", pageSize);
		map.put("name", proName);
		map.put("categoryId", categoryId);
		try {
			products = t.getProductList(map);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return products;
	}

	@Override
	public int count(String proName, Integer categoryId, Integer level) {
		before();
		int count = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", proName);
		map.put("categoryId", categoryId);
		try {
			count = t.queryProductCount(map);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return count;
	}

	@Override
	public boolean updateStock(Integer productId, Integer stock) {
		before();
		int count = 0;
		Product product = new Product();
		product.setId(productId);
		product.setStock(stock);
		try {
			count = t.updateStock(product);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return count == 0 ? false : true;
	}

}
