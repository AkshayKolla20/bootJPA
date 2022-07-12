package com.example.bootJPA.Controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootJPA.Pojo.User;
import com.example.bootJPA.ServiceI.BootJpaServiceI;

@RestController
public class BootJpaController {

	@Autowired
	private BootJpaServiceI bootJpaServiceI;
	
	@PostMapping("/saveUser")
	public void saveUserDtls(@RequestBody User user) {
		LocalDate currDt = LocalDate.now();
		LocalDate dob = user.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		Integer age = Period.between(dob, currDt).getYears();
		user.setAge(age);
		
		bootJpaServiceI.saveUserDtls(user);
	}
	
	@GetMapping("getUsers")
	public List<User> getUserDtls() {
		List<User> userList = bootJpaServiceI.getUserDtls();
		return userList;
	}
	
	@GetMapping("/getUserById/{id}")
	public Optional<User> getUserDtlsById(@PathVariable("id") Integer userId) {
		return bootJpaServiceI.getUserDtlsById(userId);
	}
	
	@PutMapping("/updateUser/{id}")
	public void updateUserDtls(@PathVariable("id") Integer userId, @RequestBody User user) {
		User updateUser = bootJpaServiceI.getUserDtlsById(userId).orElseThrow(() -> new NullPointerException());
		
		LocalDate dob = user.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate currDt = LocalDate.now();
		Integer age = Period.between(dob, currDt).getYears();
		
		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		updateUser.setAge(age);
		updateUser.setDob(user.getDob());
		updateUser.setAddress(user.getAddress());
		
		bootJpaServiceI.saveUserDtls(updateUser);
	}
	
	
	@PatchMapping("/updateUserDtlsById/{id}")
	public void updateUserDtlsById(@PathVariable("id") Integer userId, @RequestBody User user) {
		User updateUser = bootJpaServiceI.getUserDtlsById(userId).orElseThrow(() -> new NullPointerException());
		
		updateUser.setFirstName(user.getFirstName());
		
		bootJpaServiceI.saveUserDtls(updateUser);
	}
	
	@DeleteMapping("/deleteUserDtlsById/{id}")
	public String deleteUserDtlsById(@PathVariable("id") Integer userId) {
		bootJpaServiceI.deleteUserDtlsById(userId);
		return "Deleted Successfully...!";
	}
}
