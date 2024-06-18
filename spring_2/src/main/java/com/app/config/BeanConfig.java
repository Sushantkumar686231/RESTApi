package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.Student.Student;

@Configuration
public class BeanConfig {

	//way 1 from s_id1
		@Bean
		public Student s_id1(){
			
			Student stu1=new Student();
			
			stu1.setEmail("a1@gmail.com");
			stu1.setName("a1");
			stu1.setRoll(101);
			
			return stu1;
		}
		
		//way2 from s_id2
		@Bean("s_id2")
		public Student createBeanObj2(){
			
			Student stu1=new Student();
			
			stu1.setEmail("b11@gmail.com");
			stu1.setName("b1");
			stu1.setRoll(105);
			
			return stu1;
		}
}
