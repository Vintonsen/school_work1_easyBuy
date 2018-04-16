package cn.easybuy.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.easybuy.entity.UserAddress;

/**
 * @author chsm
 * @date  2018年4月16日上午8:47:06
 * @version 1.0
 */
public interface UserAddressMapper {
	
	/**
	 * 条件查询并分页
	 * @param map
	 * @return
	 */
	List<UserAddress> queryUserAddressList(Map<String, Object> map);
	
	/**
	 * 添加用户地址
	 * @param userAddress
	 * @return
	 */
	int add(UserAddress userAddress, @Param("isDefault") Integer isDefault);
	
	/**
	 * 通过id查询用户地址
	 * @param id
	 * @return
	 */
	UserAddress getUserAddressById(Integer id);
	
}
