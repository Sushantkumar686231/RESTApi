package com.app.tester;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.Student.Student;
import com.app.config.BeanConfig;

public class test {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(BeanConfig.class);
		
		Student stu=(Student) context.getBean("student");
		System.out.println(stu);

	}

}
