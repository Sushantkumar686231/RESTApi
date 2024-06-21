package com.app.tester;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.Student;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("bean-config.xml");
		
		Student std=(Student)context.getBean("stdId");
		
	System.out.println(std);

	}

}
