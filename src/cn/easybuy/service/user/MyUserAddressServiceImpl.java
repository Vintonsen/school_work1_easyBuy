package cn.easybuy.service.user;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.easybuy.entity.UserAddress;
import cn.easybuy.mapper.UserAddressMapper;
import cn.easybuy.service.MyBaseService;

/**
 * @author chsm
 * @date 2018年4月16日上午9:01:13
 * @version 1.0
 */
public class MyUserAddressServiceImpl extends MyBaseService<UserAddressMapper>
		implements UserAddressService {

	@Override
	public List<UserAddress> queryUserAdressList(Integer id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", id);
		List<UserAddress> userAddresses = null;
		before();
		try {
			userAddresses = t.queryUserAddressList(map);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return userAddresses;
	}

	@Override
	public Integer addUserAddress(Integer id, String address, String remark)
			throws Exception {
		UserAddress userAddress = new UserAddress();
		userAddress.setUserId(id);
		userAddress.setAddress(address);
		userAddress.setRemark(remark);
		userAddress.setCreateTime(new Date());
		before();
		int count = 0;
		try {
			count = t.add(userAddress, 0);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return count;
	}

	@Override
	public UserAddress getUserAddressById(Integer id) {
		before();
		UserAddress userAddress = null;
		try {
			userAddress = t.getUserAddressById(id);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			after();
		}
		return userAddress;
	}

}
