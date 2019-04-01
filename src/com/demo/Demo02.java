package com.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo02 {

	public static void main(String[] args) {

		try {

			Class<?> clazz = Class.forName("com.demo.Student");

			Constructor constructor = clazz.getConstructor();

			Object object = constructor.newInstance();

			// 1.获取所有已声明属性
			Field[] fields = clazz.getDeclaredFields();

			for (Field field : fields) {

				System.out.println(field.getName());

				// 通过反射机制调用属性
				if (null != field && field.getName().equals("name")) {

					// 判断属性是否可访问，私有属性，不可访问
					if (!field.canAccess(object)) {

						// 对不不可访问属性，需要设定可访问，否则无效
						field.setAccessible(true);
						field.set(object, "Wei");

					}

				}

			}

			System.out.println(object);

			// 2.获取所有已声明方法
			Method[] methods = clazz.getDeclaredMethods();

			for (Method method : methods) {

				System.out.println(method.getName() + " " + method.getParameterCount());

				// 通过反射机制调用方法
				if (null != method && method.getName().equals("test")) {

					// 调用方法
					method.invoke(object, "adadasda");
				}
				
			}

			System.out.println("======获取所有方法");
			System.out.println("包含所有父类(包括Object)的所有public方法=====");
			Method[] methods2 = clazz.getMethods();

			for (Method method : methods2) {

				System.out.println(method.getName());

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

abstract class APerson {

	public abstract void speak(String string);

	protected abstract void test(String string);

}

class Student extends APerson {

	private String name;
	private int age;

	public Student() {
		super();
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
		return "Student [name=" + name + ", age=" + age + "]";
	}

	@Override
	public void speak(String string) {

		System.out.println("speak:" + string);

	}

	@Override
	protected void test(String string) {
		
		System.out.println("test:" + string);

	}

}