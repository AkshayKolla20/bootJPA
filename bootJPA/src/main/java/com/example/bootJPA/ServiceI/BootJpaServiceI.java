package com.example.bootJPA.ServiceI;

import java.util.List;
import java.util.Optional;

import com.example.bootJPA.Pojo.User;

public interface BootJpaServiceI {

	public void saveUserDtls(User user);

	public List<User> getUserDtls();

	public Optional<User> getUserDtlsById(Integer userId);

	public void updateUserDtlsById(User user);

	public void deleteUserDtlsById(Integer userId);

}
