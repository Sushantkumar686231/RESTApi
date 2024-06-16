package com.app.dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.app.entities.Role;
import com.app.entities.User;

public interface UserDao {

	//1
	String RegisterUser(User user);
	
	//2
	User getUserDetails(Long userId);
	
	//3
	List<User> getAllUsers();
	
	//4
	List<User> getUserByDobAndRole
	(LocalDate start,LocalDate end,Role role);
	
	//5
	User sigIn(String email,String password);
	
	//6
	List<String> getLastNameByRole(Role role);
	
	//7 
	List<User> getNamesAndDobByRole(Role role);
	
	//8
	String changePassword(String email,String oldpass,String newpass);
	
	//9
	String applyDiscount(LocalDate date,double discount);
	
	//10
	String deleteUserDetails(long uId);
	
	//**MOST IMP
	//11
	String storeImage(String filename,Long uId) throws IOException;
	
	//12
	String restoreImage(String newFilename, Long uId)throws IOException;
} 
