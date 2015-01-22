package com.uuzz.los.dao;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import com.uuzz.los.utils.CollectionUtils;

public class DataSourceAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice {
    
    private static Logger log = LoggerFactory.getLogger(DataSourceAdvice.class);
    
    private long beginTime = 0;
    
    private List<String> readMethodPrefixList = null;
    @Override
    public void before(Method method, Object[] arg, Object target) throws Throwable {
        String methodName = method.getName();
        log.debug("当前调用的方法名称是" + methodName + "];类名是" + target.getClass().getName() + "]");
        beginTime = System.currentTimeMillis();
        boolean isReadMethod = false;
        for (String prefix : readMethodPrefixList) {
            if (methodName.startsWith(prefix)) {
                isReadMethod = true;
            }
        }
        if (isReadMethod) {
            DataSourceSwitch.setSlave();
        } else {
            DataSourceSwitch.setMaster();
        }
    }
    /**
     * service鏂规硶璋冪敤缁撴潫鍚庤皟鐢�.
     */
    @Override
    public void afterReturning(Object arg, Method method, Object[] args, Object target) throws Throwable {
        DataSourceSwitch.clear();
        log.debug("执行完成的方法：[" + method.getName() + "];消耗时间:" + (System.currentTimeMillis() - beginTime) + "毫秒;"
                + target.getClass().getName() + "]");
    }
    /**
     * 鎶涘嚭Exception寮傚父璋冪敤
     */
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
        log.debug("鏁版嵁婧愯皟鐢ㄥ彂鐢熷紓甯�,鏁版嵁婧愬垏鎹㈠埌:slave");
        DataSourceSwitch.clear();
        log.error("鏁版嵁婧愯皟鐢ㄥ紓甯镐俊鎭�" + ex.getMessage() 
                + ";执行的方法：" + target.getClass().getName() + "." + method.getName() + "]");
    }
    public void setReadMethodPrefixs(String readMethodPrefixs) {
        readMethodPrefixList = new ArrayList<String>(CollectionUtils.split(readMethodPrefixs));
    }
}