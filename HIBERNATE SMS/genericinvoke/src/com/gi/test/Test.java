package com.gi.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;

public class Test {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class clazz = Class.forName("com.gi.beans.GasStation");
		Object obj = clazz.newInstance();
		Method method = clazz.getDeclaredMethod("getFuelPrice", String.class, int.class);
		Object price = method.invoke(obj, "petrol", 2);
		System.out.println("price : " + price);
	}
}
