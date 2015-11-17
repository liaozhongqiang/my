package com.my.core.spring;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 多数据源实现类   BUG 必须在事务开启之前进行数据源切换，若事务开启后，则无法切换。 service操作完后，必须在调用DBContextHolder.clear()方法
 * 因为在web环境下是使用线程池的，后面进来的请求可能拿到之前已经结束的请求的线程。导致默认数据源无法生效.
 * @author liaozq
 * @DATE 2015年11月17日
 */
public class DynamicDataSource extends AbstractRoutingDataSource{
	@Override
	protected Object determineCurrentLookupKey() {
		return DBContextHolder.getDBSource();
	}
}
