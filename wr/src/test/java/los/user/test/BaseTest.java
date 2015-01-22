// Copyright (C) 2012-2013 UUZZ All rights reserved
package los.user.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/** 
 * 类 名: BaseTest<br/>
 * 描 述: 基础测试类<br/>
 * 作 者: 李长跃<br/>
 * 创 建： 2013-11-20<br/>
 *
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
@ContextConfiguration(locations = { 
		"classpath:sp/los-*.xml"})
@TransactionConfiguration(transactionManager = "userTransactionManager", defaultRollback = false)
@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
public class BaseTest {
	/**
	 * 日志对象
	 */
	protected Logger log = LoggerFactory.getLogger(super.getClass());
	@Test
	public void test(){}
}
