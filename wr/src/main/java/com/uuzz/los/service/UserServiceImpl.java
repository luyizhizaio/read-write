package com.uuzz.los.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuzz.los.dao.IUserInfoDao;
import com.uuzz.los.entity.UserInfo;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserInfoDao userInfoDao;

	public void insert(UserInfo user) {
		// TODO Auto-generated method stub
		userInfoDao.insert(user);
	}

	public List<UserInfo> queryAll() {
		return userInfoDao.queryAll();
	}

}
