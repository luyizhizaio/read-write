package com.uuzz.los.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.uuzz.los.dao.IUserInfoDao;
import com.uuzz.los.entity.UserInfo;

@Repository("userInfoDao")
public class UserInfoDaoImpl implements IUserInfoDao {

	@Autowired
	private  SqlMapClientTemplate userSqlMapClientTemplate;
	
	public void insert(UserInfo user) {
		// TODO Auto-generated method stub
		userSqlMapClientTemplate.update("UserInfo.insert", user);
	}

	public List<UserInfo> queryAll() {
		return userSqlMapClientTemplate.queryForList("UserInfo.queryAll");
	}
}
