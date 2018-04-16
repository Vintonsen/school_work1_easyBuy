package cn.easybuy.mapper;

import java.util.List;
import java.util.Map;

import cn.easybuy.entity.ProductCategory;

/**
 * @author chsm
 * @date  2018年4月15日上午8:49:03
 * @version 1.0
 */
public interface ProductCategoryMapper {
	
	/**
	 * 按条件查询商品类别
	 * @param map
	 * @return
	 */
	List<ProductCategory> queryProductCategorylist(Map<String, Object> map);
	
	/**
	 * 通过id删除商品类别
	 * @param id
	 * @return
	 */
	int deleteById(Integer id);
	
	/**
	 * 按条件查询商品类别数量
	 * @param productCategory
	 * @return
	 */
	Integer queryProductCategoryCount(ProductCategory productCategory);
	
	/**
	 * 按id查询商品类别
	 * @param id
	 * @return
	 */
	ProductCategory queryProductCategoryById(Integer id);
	
	/**
	 * 添加商品类别
	 * @param productCategory
	 * @return
	 */
	int add(ProductCategory productCategory);
	
	/**
	 * 按id更新商品类别
	 * @param productCategory
	 * @return
	 */
	int update(ProductCategory productCategory);
	
}
