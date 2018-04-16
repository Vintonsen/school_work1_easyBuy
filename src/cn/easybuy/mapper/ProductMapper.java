package cn.easybuy.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.easybuy.entity.Product;

/**
 * @author chsm
 * @date  2018年4月14日下午9:30:41
 * @version 1.0
 */
public interface ProductMapper {
	
	/**
	 * 通过id更新库存
	 * @return
	 */
	int updateStock(Product product);
	
	/**
	 * 添加商品
	 * @return
	 */
	int add(Product product, @Param("isDelete")Integer isDelete);
	
	/**
	 * 更新商品
	 * @param product
	 * @return
	 */
	int update(Product product);
	
	/**
	 * 通过id删除商品
	 * @param id
	 * @return
	 */
	int deleteProductById(Integer id);
	
	/**
	 * 通过id查找商品
	 * @param id
	 * @return
	 */
	Product getProductById(Integer id);
	
	/**
	 * 按条件查询分页
	 * @param map
	 * @return
	 */
	List<Product> getProductList(Map<String, Object> map);
	
	/**
	 * 按条件查询总商品数量
	 * @return
	 */
	int queryProductCount(Map<String, Object> map);
	
}
