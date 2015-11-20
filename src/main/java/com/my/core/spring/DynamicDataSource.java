package com.my.core.spring;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * BUG 调用切换数据源必须在开启事物之前，调用完切换数据源，最好清除。
 * @author liaozq
 * @DATE 2015年11月19日
 */
public class DynamicDataSource extends AbstractRoutingDataSource{
	@Override
	protected Object determineCurrentLookupKey() {
		return DBContextHolder.getDBSource();
	}
}
