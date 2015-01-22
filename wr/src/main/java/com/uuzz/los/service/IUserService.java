package com.uuzz.los.service;

import java.util.List;

import com.uuzz.los.entity.UserInfo;

public interface IUserService {
	
	void insert(UserInfo user);
	
	List<UserInfo> queryAll();

}
