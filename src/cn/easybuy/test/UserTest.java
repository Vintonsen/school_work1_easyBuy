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

import cn.easybuy.entity.User;
import cn.easybuy.mapper.UserMapper;

public class UserTest {
	
	private SqlSession sqlSession;
	private UserMapper userMapper;
	
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
		userMapper = sqlSession.getMapper(UserMapper.class);
	}
	
	@Test
	public void add() {
		User user = new User();
		user.setLoginName("cs");
		user.setUserName("cs");
		user.setPassword("cs2");
		user.setSex(1);
		int count = 0;
		try {
			count = userMapper.add(user);
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
		System.out.println(count);
	}
	
	@Test
	public void update() {
		User user = new User();
		user.setId(23);
		user.setLoginName("cs2");
		user.setUserName("cs2");
		user.setPassword("cs3");
		user.setSex(1);
		int count = 0;
		try {
			count = userMapper.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
		System.out.println(count);
	}
	
	@Test
	public void delete() {
		int count = 0;
		try {
			count = userMapper.deleteUserById(23);
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
		System.out.println(count);
	}
	
	@Test
	public void count() {
		System.out.println(userMapper.count());
	}
	
	@Test
	public void queryByLimit() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("init", 0);
		map.put("pageSize", 7);
		List<User> users = userMapper.queryByLimit(map);
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void getUser() {
		User user = new User();
		user.setId(20);
		user.setLoginName("yhzl");
		System.out.println(userMapper.getUser(user));
	}
	
	@After
	public void after() {
		sqlSession.commit();
		sqlSession.close();
	}
	
}
