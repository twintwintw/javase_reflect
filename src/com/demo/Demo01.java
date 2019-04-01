package com.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Demo01 {

	public static void main(String[] args) {
		
		// 反射
		/**
		 * JAVA反射机制是在运行状态中， 对于任意一个类，都能够知道这个类的所有属性和方法； 对于任意一个对象，都能够调用它的任意一个方法和属性；
		 * 这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
		 * 
		 **/

		// 以前 学完JAVA 面向对象 ，我们都是这样 由类的构造方法，通过关键字 new 生成一个对象
		Person person = new Person();
		
		//调用方法
		person.setName("Wei");
		person.setAge(10);

		// now 我们通过反射机制来做这件事
		try {
			
			Class<?> clazz = Class.forName("com.demo.Person");
			
			Constructor<?> constructor = clazz.getDeclaredConstructor();
			Object object = constructor.newInstance();
			
			Method method_setName = clazz.getDeclaredMethod("setName", String.class);
			Method method_setAge = clazz.getDeclaredMethod("setAge", int.class);
			
			method_setName.invoke(object, "Jerry");
			method_setAge.invoke(object, 10);
			
			System.out.println(object);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		//反射 还可以做更多的事 ,看Demo02 
		
		
	}

}

class Person {

	private String name;
	private int age;

	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
