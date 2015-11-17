package com.my.core.spring;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * ������Դʵ����   BUG ������������֮ǰ��������Դ�л����������������޷��л��� service������󣬱����ڵ���DBContextHolder.clear()����
 * ��Ϊ��web��������ʹ���̳߳صģ������������������õ�֮ǰ�Ѿ�������������̡߳�����Ĭ������Դ�޷���Ч.
 * @author liaozq
 * @DATE 2015��11��17��
 */
public class DynamicDataSource extends AbstractRoutingDataSource{
	@Override
	protected Object determineCurrentLookupKey() {
		return DBContextHolder.getDBSource();
	}
}
