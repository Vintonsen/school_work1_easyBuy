package cn.easybuy.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import cn.easybuy.entity.Order;
import cn.easybuy.mapper.OrderMapper;
import cn.easybuy.mapper.ProductCategoryMapper;

/**
 * @author chsm
 * @date  2018年4月15日下午8:45:08
 * @version 1.0
 */
public class OrderTest {
	
	private SqlSession sqlSession;
	private OrderMapper orderMapper;
	
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
		orderMapper = sqlSession.getMapper(OrderMapper.class);
	}
	
	public void add() {
		Order order = new Order();
	}
	
	@After
	public void after() {
		sqlSession.commit();
		sqlSession.close();
	}
	
}
