package com.app.tester;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.Student.Student;
import com.app.config.BeanConfig;

public class test {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(BeanConfig.class);
		
		//WAY 1
		Student stu1= (Student)context.getBean("s_id1");
		System.out.println(stu1);
		
		Student stu2= (Student)context.getBean("s_id2");
		System.out.println(stu2);
		
		
		///WAY2---------if single bean is there
//		Student stu1=(Student)context.getBean(Student.class);
//		System.out.println(stu1);
		
		
		
	}

}
