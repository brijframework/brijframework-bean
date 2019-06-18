package org.brijframework.data.context;

import org.brijframework.asm.context.AbstractModuleContext;
import org.brijframework.data.container.DataContainer;
import org.brijframework.meta.context.MetaContext;
import org.brijframework.support.model.DepandOn;
import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.util.reflect.ReflectionUtils;

@DepandOn(depand=MetaContext.class)
public class DataContext extends AbstractModuleContext{

	@Override
	@SuppressWarnings("unchecked")
	public void init() {
		try {
			ReflectionUtils.getClassListFromExternal().forEach(cls->{
				if(DataContainer.class.isAssignableFrom(cls) && InstanceUtil.isAssignable(cls)) {
					register((Class<? extends DataContainer>) cls);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ReflectionUtils.getClassListFromInternal().forEach(cls->{
				if(DataContainer.class.isAssignableFrom(cls) && InstanceUtil.isAssignable(cls)) {
					register((Class<? extends DataContainer>) cls);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void startup() {
		System.err.println("DataContext register start.");
		super.startup();
		System.err.println("DataContext register done.");
	}

	@Override
	public void destory() {
		System.err.println("DataContext destory start.");
		super.destory();
		System.err.println("DataContext destory done.");
	}
}