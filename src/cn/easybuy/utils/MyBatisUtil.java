package cn.easybuy.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author chsm
 * @date  2018年4月13日下午2:40:25
 * @version 1.0
 */
public class MyBatisUtil {
	
	private static SqlSessionFactory sessionFactory;
	
	static {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static SqlSession getSession() {
		return sessionFactory.openSession();
	}
	
}
