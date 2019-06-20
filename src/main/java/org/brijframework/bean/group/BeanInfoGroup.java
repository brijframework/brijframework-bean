package org.brijframework.bean.group;

import java.util.concurrent.ConcurrentHashMap;

import org.brijframework.asm.group.DefaultGroup;
import org.brijframework.data.impl.BeanInfoImpl;

public class BeanInfoGroup implements DefaultGroup {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object groupKey;
	private ConcurrentHashMap<String,BeanInfoImpl> cache=new ConcurrentHashMap<>();
	
	public BeanInfoGroup(Object groupKey) {
		this.groupKey=groupKey;
	}

	@Override
	public Object getGroupKey() {
		return groupKey;
	}

	@Override
	public ConcurrentHashMap<String,BeanInfoImpl> getCache() {
		return cache;
	}

	@Override
	public <T> T find(String parentID, Class<?> type) {
		return null;
	}
}