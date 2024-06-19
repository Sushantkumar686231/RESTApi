package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	//POST---------------------------------------------------------->Create 
	@PostMapping("/employees")
	public String createNewEmp(@RequestBody Employee emp)
	{
		employeeRepository.save(emp);
		return "Employee Creted Succesfully";
	}
	
	//GETT-------------------------------------------------->RETRIVE or Say READ
	//retriving the value so list needed
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> emp_list=new ArrayList<Employee>();
		
		employeeRepository.findAll().forEach(emp_list::add);
		return new ResponseEntity<List<Employee>>(emp_list,HttpStatus.OK);
	}
	
	//retrive emp by emp_id
	@GetMapping("/employees/{empid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long empid){
		Optional<Employee> emp=employeeRepository.findById(empid);
		if(emp.isPresent())
			return new ResponseEntity<Employee>(emp.get(),HttpStatus.FOUND);
		else
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	//PUT------------------------------------------------------------>Update
	@PutMapping("/employees/{empid}")
	public String updateEmployeeById(@PathVariable long empid,@RequestBody Employee employee)
	{
		Optional<Employee> emp=employeeRepository.findById(empid);
		if(emp.isPresent())
		{
			Employee existEmp=emp.get();
			existEmp.setEmp_age(employee.getEmp_age());
			existEmp.setEmp_city(employee.getEmp_city());
			employeeRepository.save(existEmp);
			return "Sucessfully updated";
		}
		return "Error occured";
	}
	
	
	//DELETE------------------------------------------------------------>delete
	//delete by Id
	
	@DeleteMapping("/employees/{empid}")
	public String deleteEmployeeById(@PathVariable long empid) {
		employeeRepository.deleteById(empid);
		return "Employee Deleted Succesfully!!!!!";
	}
	
	//delete
	@DeleteMapping("/employees")
	public String deleteEmployee()
	{
		employeeRepository.deleteAll();
		return "Succesfully Deleted";
	}
	
	
}
