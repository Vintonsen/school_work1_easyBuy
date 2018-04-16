package cn.easybuy.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.easybuy.entity.User;
import cn.easybuy.mapper.UserMapper;
import cn.easybuy.service.MyBaseService;
import cn.easybuy.utils.MyBatisUtil;

/**
 * @author chsm
 * @date 2018年4月13日下午3:39:44
 * @version 1.0
 */
public class MyUserServiceImpl extends MyBaseService<UserMapper> implements
		UserService {

	@Override
	public boolean add(User user) {
		before();
		System.out.println(t);
		int count = 0;
		try {
			count = t.add(user);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return count == 0 ? false : true;
	}

	@Override
	public boolean update(User user) {
		before();
		int count = 0;
		try {
			count = t.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return count == 0 ? false : true;
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		before();
		int count = 0;
		try {
			count = t.deleteUserById(userId);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return count == 0 ? false : true;
	}

	@Override
	public User getUser(Integer userId, String loginName) {
		before();
		User user = new User();
		user.setId(userId);
		user.setLoginName(loginName);
		try {
			user = t.getUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return user;
	}

	@Override
	public List<User> getUserList(Integer currentPageNo, Integer pageSize) {
		before();
		System.out.println(t);
		List<User> users = null;
		try {
			users = t.queryByLimit(getPage(currentPageNo, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return users;
	}

	@Override
	public int count() {
		before();
		int count = 0;
		try {
			count = t.count();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return count;
	}

}
