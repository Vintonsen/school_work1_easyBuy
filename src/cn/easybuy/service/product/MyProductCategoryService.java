package cn.easybuy.service.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.easybuy.entity.Product;
import cn.easybuy.entity.ProductCategory;
import cn.easybuy.mapper.ProductCategoryMapper;
import cn.easybuy.param.ProductCategoryParam;
import cn.easybuy.service.MyBaseService;
import cn.easybuy.utils.ProductCategoryVo;

/**
 * @author chsm
 * @date 2018年4月15日下午3:20:47
 * @version 1.0
 */
public class MyProductCategoryService extends
		MyBaseService<ProductCategoryMapper> implements ProductCategoryService {

	@Override
	public ProductCategory getById(Integer id) {
		before();
		ProductCategory productCategory = null;
		try {
			productCategory = t.queryProductCategoryById(id);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return productCategory;
	}

	@Override
	public List<ProductCategory> queryProductCategoryList(
			ProductCategoryParam params) {
		before();
		List<ProductCategory> productCategories = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", params.getName());
		map.put("parentId", params.getParentId());
		map.put("type", params.getType());
		map.put("isPage", params.isPage());
		map.put("init", params.getStartIndex());
		map.put("pageSize", params.getPageSize());
		try {
			productCategories = t.queryProductCategorylist(map);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return productCategories;
	}

	@Override
	public int queryProductCategoryCount(ProductCategoryParam params) {
		before();
		int count = 0;
		try {
			count = t.queryProductCategoryCount(params);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return count;
	}

	@Override
	public void modifyProductCategory(ProductCategory productCategory) {
		before();
		try {
			t.update(productCategory);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
	}

	@Override
	public void addProductCategory(ProductCategory productCategory) {
		before();
		try {
			t.add(productCategory);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
	}

	@Override
	public void deleteById(Integer id) {
		before();
		try {
			t.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
	}

	@Override
	public List<ProductCategoryVo> queryAllProductCategoryList() {
		return queryTest(0);
	}

	public List<ProductCategoryVo> queryTest(Integer parentId) {
		// 存放每一级数据
		List<ProductCategoryVo> productCategoryVos = new ArrayList<ProductCategoryVo>();
		// 存放查询出的数据
		List<ProductCategory> productCategories = null;
		before();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", parentId);
		try {
			// 执行查询
			productCategories = t.queryProductCategorylist(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		after();
		// 判断查询数据是否为空，若为空代表遍历到最终目录，否则继续遍历
		if (productCategories == null || productCategories.size() == 0) {
			return productCategoryVos;
		}
		// 遍历数据下一级分类
		for (ProductCategory productCategory : productCategories) {
			// 封装数据
			ProductCategoryVo productCategoryVo = new ProductCategoryVo();
			productCategoryVo.setProductCategory(productCategory);
			productCategoryVo
					.setProductCategoryVoList(queryTest(productCategory.getId()));
			productCategoryVos.add(productCategoryVo);
		}
		return productCategoryVos;
	}

}
