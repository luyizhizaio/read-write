package com.uuzz.los.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    
    private static Logger log = LoggerFactory.getLogger(DynamicDataSource.class);
    
    private List slaveDataSourceKeys = null;
    
    private int slaveNum = 0;
    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = DataSourceSwitch.getDataSouce();
        if ("slave".equals(dataSource) && (slaveNum > 0)) {
            int selected = RandomUtils.nextInt(slaveNum);
            dataSource = (String) slaveDataSourceKeys.get(selected);
        }
        
        if (StringUtils.isBlank(dataSource)) {
            log.warn("读区操作数据源为空切换到master");
            dataSource = "master";
        }
        log.debug("当前选择的数据源是{}", dataSource);
        return dataSource;
    }
    @Override
    public void setTargetDataSources(Map targetDataSources) {
        super.setTargetDataSources(targetDataSources);
        
        slaveDataSourceKeys = new ArrayList();
        Set<String> keys = targetDataSources.keySet();
        for (String key : keys) {
            if (key.startsWith("slave")) {
                slaveDataSourceKeys.add(key);
            }
        }
        slaveNum = slaveDataSourceKeys.size();
    }
}