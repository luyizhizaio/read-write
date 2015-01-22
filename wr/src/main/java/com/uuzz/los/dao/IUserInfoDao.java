// Copyright (C) 2012-2014 UUZZ All rights reserved
package com.uuzz.los.dao;

import java.util.List;

import com.uuzz.los.entity.UserInfo;

/** 
 * 类 名: IUserInfoDao<br/>
 * 描 述: <br/>
 * 作 者: 李长跃<br/>
 * 创 建： 2014-12-22<br/>
 *
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public interface IUserInfoDao {
	
	void insert(UserInfo user);

	List<UserInfo> queryAll();
}
