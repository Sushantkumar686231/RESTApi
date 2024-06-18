package com.app.tester;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.Student.Student;

public class test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("bean-config.xml");
		
		Student stu1= (Student)context.getBean("s_id1");
		System.out.println(stu1);
		
		Student stu2= (Student)context.getBean("s_id2");
		System.out.println(stu2);

	}

}
