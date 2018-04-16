package cn.easybuy.test;

import cn.easybuy.entity.User;
import cn.easybuy.mapper.UserMapper;
import cn.easybuy.proxy.MyProxy;
import cn.easybuy.service.MyBaseService;
import cn.easybuy.service.user.MyUserServiceImpl;
import cn.easybuy.service.user.UserService;

/**
 * @author chsm
 * @date  2018年4月14日上午10:12:18
 * @version 1.0
 */
public class ProxyClass {
	
	public static void main(String[] args) {
		MyProxy<UserMapper> myProxy = new MyProxy<UserMapper>();
		UserService proxy = (UserService) myProxy.getObj(new MyUserServiceImpl(), UserMapper.class);
		User user = new User();
		user.setLoginName("cs");
		user.setUserName("cs");
		user.setPassword("cs2");
		user.setSex(1);
		boolean bl= proxy.add(user);
		System.out.println(bl);
	}
	
}
