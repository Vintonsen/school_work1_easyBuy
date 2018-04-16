package cn.easybuy.service;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.easybuy.utils.MyBatisUtil;

/**
 * @author chsm
 * @date 2018年4月13日下午3:43:57
 * @version 1.0
 */
public class MyBaseService<T> {

	public T t;
	public SqlSession session;
	// this.getClass().getGenericSuperclass() 获取当前类的超类
	// (ParameterizedType) 参数化类型
	// getActualTypeArguments()[0] 返回实际参数列表的数组
	public Class<T> entityClass = (Class<T>) ((ParameterizedType) this
			.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void before() {
		session = MyBatisUtil.getSession();
		// 由于java泛型使用了类型擦除所以不能直接使用T.class
		t = session.getMapper(entityClass);
	}

	public Map<String, Integer> getPage(Integer init, Integer pageSize) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("init", (init - 1) * pageSize);
		map.put("pageSize", pageSize);
		return map;
	}

	public void after() {
		session.commit();
		session.close();
	}

}
