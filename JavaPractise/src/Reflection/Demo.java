package Reflection;

public class Demo extends DemoBase{
	public int fieldA;
	private int fieldB;
	
	static {
		System.out.println("Class Demo Loading");
	}
	
	public Demo(){
		this.fieldA = 1;
		this.fieldB = 2;
	}
	
	public Demo(int a, int b){
		this.fieldA = a;
		this.fieldB = b;
	}
	
	@Override
	public String toString(){
		return Demo.class.getSimpleName() + "'s instance";
	}
	
	public static class Factory implements Reflection.Factory<Demo> {

		@Override
		public Demo create() {
			return new Demo();
		}
		
	}
}
