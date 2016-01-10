package Reflection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DemoBase {
	
	public int fieldBase;
	
	public static class Factory implements Reflection.Factory<DemoBase>{

		@Override
		public DemoBase create() {
			return new DemoBase();
		}
		
	}
}
