package com.uuzz.los.dao;

import org.apache.commons.lang.ObjectUtils;

public class DataSourceSwitch {
    
    @SuppressWarnings("rawtypes")
    private static final ThreadLocal contextHolder = new ThreadLocal();
    
    public static void setMaster() {
        contextHolder.remove();
        contextHolder.set("master");
    }
    
    public static void setSlave() {
        contextHolder.remove();
        contextHolder.set("slave");
    }
    
    public static void clear() {
        contextHolder.remove();
    }
    
    public static String getDataSouce() {
        return ObjectUtils.toString(contextHolder.get());
    }
}