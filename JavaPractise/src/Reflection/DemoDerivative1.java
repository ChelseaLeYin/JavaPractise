package Reflection;

public class DemoDerivative1 extends Demo{
	
	static {
		System.out.println("Class DemoDerivative1 Loading");
	}
	
	@Override
	public String toString(){
		return DemoDerivative1.class.getSimpleName() + "'s instance";
	}
	
	public static class Factory implements Reflection.Factory<DemoDerivative1>{

		@Override
		public DemoDerivative1 create() {
			return new DemoDerivative1();
		}
		
	}
}
