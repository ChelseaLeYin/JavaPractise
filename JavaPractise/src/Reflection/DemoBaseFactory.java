package Reflection;

import java.util.HashMap;
import java.util.Map;

public class DemoBaseFactory {
	static Map<String, Factory<? extends DemoBase>> factoryMap = new HashMap<String, Factory<? extends DemoBase>>();

	static {
		factoryMap.put(DemoBase.class.getSimpleName(), new DemoBase.Factory());
		factoryMap.put(Demo.class.getSimpleName(),new Demo.Factory());
		factoryMap.put(DemoDerivative1.class.getSimpleName(), new DemoDerivative1.Factory());
	}

	public static DemoBase createDemoBaseObject(String key) {
		return factoryMap.get(key).create();
	}
}
