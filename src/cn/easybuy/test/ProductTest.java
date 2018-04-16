package cn.easybuy.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.easybuy.entity.Product;
import cn.easybuy.mapper.ProductMapper;
import cn.easybuy.mapper.UserMapper;

/**
 * @author chsm
 * @date  2018年4月14日下午9:34:48
 * @version 1.0
 */
public class ProductTest {
	
	private SqlSession sqlSession;
	private ProductMapper productMapper;
	
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
		productMapper = sqlSession.getMapper(ProductMapper.class);
	}
	
	@Test
	public void add() {
		Product product = new Product();
		product.setName("test");
		product.setPrice(1000.0f);
		product.setStock(100);
		System.out.println(productMapper.add(product, 0));
	}
	
	@Test
	public void updateStock() {
		Product product = new Product();
		product.setId(771);
		product.setStock(1000);
		System.out.println(productMapper.updateStock(product));
	}
	
	@Test
	public void update() {
		Product product = new Product();
		product.setId(771);
		product.setName("chear");
		System.out.println(productMapper.update(product));
	}
	
	@Test
	public void deleteProductById() {
		System.out.println(productMapper.deleteProductById(771));
	}
	
	@Test
	public void getProductById() {
		System.out.println(productMapper.getProductById(770));
	}
	
	@Test
	public void getProductList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "儿");
//		map.put("categoryId", "676");
		map.put("init", 0);
		map.put("pageSize", 3);
		List<Product> products = productMapper.getProductList(map);
		for (Product product : products) {
			System.out.println(product);
		}
	}
	
	@Test
	public void queryProductCount() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "儿");
		map.put("categoryId", "676");
		System.out.println(productMapper.queryProductCount(map));
	}
	
	@After
	public void after() {
		sqlSession.commit();
		sqlSession.close();
	}
	
}
