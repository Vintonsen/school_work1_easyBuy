package cn.easybuy.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import cn.easybuy.entity.User;

/**
 * 
 * @author chsm
 * @date  2018年4月13日下午3:20:23
 * @version 1.0
 */
public interface UserMapper {
	
	/**
	 * 添加(注册)用户
	 * @param user
	 * @return
	 */
	public int add(User user);
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public int update(User user);
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	public int deleteUserById(Integer id);
	
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	public List<User> queryByLimit(Map<String, Integer> map);
	
	/**
	 * 查询用户记录数
	 * @return
	 */
	public int count();
	
	/**
	 * 通过loginName或id查询用户
	 * @return
	 */
	public User getUser(User user);
	
}
