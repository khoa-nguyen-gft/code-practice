package design_pattern.constructor_singleston;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Step02 {
	
	@SuppressWarnings("resource")
	static void saveToFile(String filename, BasicSingleton02 singleton) throws Exception {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
		objectOutputStream.writeObject(singleton);
	}
	
	
	@SuppressWarnings("resource")
	static BasicSingleton02 readFromFile(String fileName) throws Exception {
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
		return (BasicSingleton02) inputStream.readObject();
	}
	
	
	public static void main(String[] args) throws Exception {
		BasicSingleton02 singleton = BasicSingleton02.getInstance();
		singleton.setValue(111);
		
		saveToFile("singleton.txt", singleton);
		
		
		singleton.setValue(222);
		
		BasicSingleton02 secondSingleton = readFromFile("singleton.txt");
		
		System.out.println(singleton);
		System.out.println(secondSingleton);
		
	}
}

class BasicSingleton02 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final BasicSingleton02 INSTANCE = new BasicSingleton02();

	private int value;
	
	private BasicSingleton02() {
	}
	
	public static BasicSingleton02 getInstance() {
		return INSTANCE;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "BasicSingleton [value=" + value + "]";
	}	
	
	
	protected Object readResolve() {
		return INSTANCE;
	}
	 
	
}
