package org.brijframework.bean.factories.scope.impl;

import java.util.concurrent.ConcurrentHashMap;

import org.brijframework.bean.factories.scope.asm.AbstractBeanScopeFactory;
import org.brijframework.bean.scope.BeanScope;
import org.brijframework.container.Container;
import org.brijframework.support.config.OrderOn;
import org.brijframework.support.config.SingletonFactory;

@OrderOn(3)
public final class BeanScopeFactoryImpl extends AbstractBeanScopeFactory{
	
	private static BeanScopeFactoryImpl factory;
	
	@SingletonFactory
	public static BeanScopeFactoryImpl getFactory() {
		if(factory==null) {
			factory=new BeanScopeFactoryImpl();
		}
		return factory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public BeanScopeFactoryImpl loadFactory() {
		Container container = getContainer();
		if(container==null) {
			return this;
		}
		getContainer().getCache().forEach((key,group)->{
			ConcurrentHashMap<String, BeanScope> cache = group.getCache();
			this.getCache().putAll(cache);
		});
		return this;
	}
	
}
