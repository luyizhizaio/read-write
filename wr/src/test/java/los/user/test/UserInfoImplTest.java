// Copyright (C) 2012-2013 UUZZ All rights reserved
package los.user.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.uuzz.los.entity.UserInfo;
import com.uuzz.los.service.IUserService;



/** 
 * 类 名: UserInfoImplTest<br/>
 * 描 述: IAccountUserService接口测试类<br/>
 * 作 者: 李长跃<br/>
 * 创 建： 2013-6-21<br/>
 *
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public class UserInfoImplTest extends BaseTest {
	
	@Autowired
	private  IUserService userInfoService;
	
	
	/**
	 * 描 述：公共方法测试<br/>
	 * 作 者：李长跃<br/>
	 * 历 史: (版本) 作者 时间 注释<br/>
	 */
	@Test
	public void save() {
		
		UserInfo userInfoVo = new UserInfo();
		userInfoVo.setMobile("18310328083");
		userInfoService.insert(userInfoVo);
	}
	
	@Test
	public void queryAll(){
		List<UserInfo> queryAll = userInfoService.queryAll();
		System.out.println(queryAll.size());
	}

	
}
