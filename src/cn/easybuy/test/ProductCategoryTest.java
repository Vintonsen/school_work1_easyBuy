package cn.easybuy.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.easybuy.entity.ProductCategory;
import cn.easybuy.mapper.ProductCategoryMapper;
import cn.easybuy.mapper.ProductMapper;
import cn.easybuy.param.ProductCategoryParam;
import cn.easybuy.service.product.MyProductCategoryService;
import cn.easybuy.service.product.ProductCategoryService;
import cn.easybuy.service.product.ProductCategoryServiceImpl;
import cn.easybuy.utils.ProductCategoryVo;

/**
 * @author chsm
 * @date  2018年4月15日上午8:54:36
 * @version 1.0
 */
public class ProductCategoryTest {
	
	private SqlSession sqlSession;
	private ProductCategoryMapper productCategoryMapper;
	
	@Before
	public void before() {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sessionFactory.openSession();
		productCategoryMapper = sqlSession.getMapper(ProductCategoryMapper.class);
	}
	
	@Test
	public void queryProductCategorylist() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "手");
//		map.put("type", 3);
		map.put("init", 0);
		map.put("pageSize", 1);
		map.put("isPage", false);
		List<ProductCategory> productCategories = productCategoryMapper.queryProductCategorylist(map);
		for (ProductCategory productCategory : productCategories) {
			System.out.println(productCategory);
		}
	}
	
	@Test
	public void add() {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setName("测试1");
		productCategory.setParentId(696);
		productCategory.setType(3);
		System.out.println(productCategoryMapper.add(productCategory));
	}
	
	@Test
	public void update() {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setId(697);
		productCategory.setName("测试4214");
		productCategory.setParentId(696);
		productCategory.setType(3);
		System.out.println(productCategoryMapper.update(productCategory));
	}
	
	@Test
	public void deleteById() {
		System.out.println(productCategoryMapper.deleteById(697));
	}
	
	@Test
	public void queryProductCategoryCount() {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setName("手");
		productCategory.setParentId(681);
		System.out.println(productCategoryMapper.queryProductCategoryCount(productCategory));
	}
	
	@Test
	public void queryProductCategoryById() {
		System.out.println(productCategoryMapper.queryProductCategoryById(681));
	}
	
	@Test
	public void queryAllProductCategoryList() {
		ProductCategoryService productCategoryService = new MyProductCategoryService();
		ProductCategoryService productCategoryService2 = new ProductCategoryServiceImpl();
		ProductCategoryParam param = new ProductCategoryParam();
		List<ProductCategoryVo> productCategoryVos = productCategoryService2.queryAllProductCategoryList();
		System.out.println(productCategoryService.queryAllProductCategoryList().equals(productCategoryService2.queryAllProductCategoryList()));
		for (ProductCategoryVo productCategoryVo : productCategoryVos) {
			System.out.println(productCategoryVo);
		}
	}
	
	
	@After
	public void after() {
		sqlSession.commit();
		sqlSession.close();
	}
	
}
