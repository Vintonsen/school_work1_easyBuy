package cn.easybuy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;

import cn.easybuy.mapper.UserMapper;
import cn.easybuy.service.MyBaseService;

/**
 * @author chsm
 * @date  2018年4月14日上午9:50:49
 * @version 1.0
 */
public class MyProxy<T> implements InvocationHandler{

	private Object obj;
	private MyBaseService<T> myBaseDao = new MyBaseService<T>();
	
	/**
	 * @return the obj
	 */
	public Object getObj(Object obj, Class<T> entityClass) {
		try {
			myBaseDao.setEntityClass(entityClass);
			myBaseDao.before();
			Method method = obj.getClass().getMethod("setMapper", myBaseDao.getEntityClass());
			method.invoke(obj, myBaseDao.t);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object object = null;
//		myBaseDao.before();
		try {
			object = method.invoke(obj, args);
		} catch (Exception e) {
			e.printStackTrace();
			myBaseDao.session.rollback();
		}
		myBaseDao.after();
		return object;
	}

}
