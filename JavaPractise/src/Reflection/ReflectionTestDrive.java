package Reflection;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;


public class ReflectionTestDrive {
	public static void main(String[] args){

		try {
			
			//产生Class引用
//			Class demoClass1 = Class.forName(Demo.class.getName());
//			Class demoClass2 = Demo.class;
			
			
			
			//为Class引用指定类型或使用范型或限定继承类型
//			Class<Integer> intClass = int.class;
////			intClass = double.class; //Error
//			
//			Class<?> anyClass = int.class;
//			anyClass = double.class;
//			
//			Class<? extends Number> anyNumberClass = int.class;
//			anyNumberClass = double.class;
////			anyNumberClass = Demo.class; // Error
			
//			Class< Number> numberClass = int.class; //Error
			
			
		    
		    //使用范型生成具体的newInstance
			
//		    Class <Demo> demoClazz = Demo.class;
//		    Demo demo = demoClazz.newInstance();
//			
//		    Class < ? extends Demo> demoDerivativeClazz = Demo.class;
//		    DemoDerivative1 demoDerivative1 = (DemoDerivative1) demoDerivativeClazz.newInstance();
//		    DemoDerivative2 demoDerivative2 = (DemoDerivative2) demoDerivativeClazz.newInstance();
//		    
//		    Class < ? super Demo> demoBaseClazz = demoClazz.getSuperclass();
//		    Object demoBase = demoBaseClazz.newInstance();
			
			//instanceof vs isinstance
//			Demo demo = new Demo();
//			System.out.println(demo instanceof Demo);
//			System.out.println(Demo.class.isInstance(demo));
//			
//			Map<Class, String> baseHirachyMap = new HashMap<Class, String>();
//			baseHirachyMap.put(DemoBase.class, "DemoBase");
//			baseHirachyMap.put(Demo.class, "Demo");
//			baseHirachyMap.put(DemoDerivative1.class, "DemoDerivative1");
//			
//			for (Map.Entry<Class, String> entry : baseHirachyMap.entrySet()){
//				System.out.println("demo is instance of " + entry.getValue() + " : " + entry.getKey().isInstance(demo));
////				System.out.println("demo is instance of " + entry.getValue() + " : " + (demo instanceof entry.getKey()));
//			}
//			
//			List objList = new ArrayList<Object>();
//			DemoBase demoBase = new DemoBase();
//			objList.add(demoBase);
//			
//			for (Map.Entry<Class, String> entry : baseHirachyMap.entrySet()){
//				System.out.println("demoBase is instance of " + entry.getValue() + " : " + entry.getKey().isInstance(objList.get(0)));
//			}
			
			//Factory
//			System.out.println("create: " + DemoBaseFactory.createDemoBaseObject(Demo.class.getSimpleName()));
			
			//isinstance / instanceof VS equals / ==
//			Demo demo = new Demo();
//			System.out.println(DemoBase.class.isInstance(demo));//true
//			System.out.println(demo instanceof DemoBase);//true
//			System.out.println(DemoBase.class.equals(demo.getClass()));//false
//			compareClass(demo, DemoBase.class);//false
////			System.out.println(demo.getClass() == DemoBase.class);//Compile Error!
			
			Class demoClass = Demo.class;
			
			System.out.println("======Constructors======");
			
			Constructor[] constructors = demoClass.getConstructors();
			for (Constructor constructor : constructors){
				System.out.println(constructor);
			}
			
			System.out.println("======Fields======");
			
			Field[] fileds = demoClass.getFields();//get all public fields, declared in this class or herid
			for (Field field : fileds){
				System.out.println(field + "	:	" + field.getModifiers());
			}
			
			System.out.println("======DeclaredFields======");
			
			Field[] declaredFields = demoClass.getDeclaredFields(); //get all fields declared in this class
			for (Field field : declaredFields){
				System.out.println(field + "	:	" + field.getModifiers());
			}
			
			System.out.println("======DeclaredMethod======");
			
			Method toStringMethod = demoClass.getDeclaredMethod("toString");
			Demo demo = (Demo) demoClass.newInstance();
			System.out.println("Invoke toString: " + toStringMethod.invoke(demo, null));
			
//			Demo demo = null;
//			demo = (Demo) constructors[1].newInstance(3,4);
//			System.out.println("filedA: " + demo.fieldA);
//			System.out.println("filedB: " + demo.fieldB);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void compareClass(Object x, Class clazz){
		System.out.println(x.getClass() == clazz);
	}
}

