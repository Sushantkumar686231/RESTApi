package com.app.tester;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.Student.Student;

public class test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("bean_config.xml");
		
		Student stu=(Student) context.getBean("student");
		System.out.println(stu);

	}

}
