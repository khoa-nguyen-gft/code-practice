package design_pattern.constructor_singleston;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Step03 {
	

	
	
	public static void main(String[] args) throws Exception {
		StaticSingleSton.getInstance();
		
	}
}

class StaticSingleSton {
	
	private static StaticSingleSton instance; 
	
	 private StaticSingleSton () throws IOException {
		 System.out.println("Singleton is Intitialzation");
		 //File.createTempFile(".", ".");
	 }
	 
	 static {
		 try {
			 System.out.println("Static is Intitialzation");

			//instance = new BasicSingleton03();
		} catch (Exception e) {
			System.out.println("false to init Instance");
		}
	 }
	 
	 public static StaticSingleSton getInstance() {
		 return instance;
	 }
	
}
