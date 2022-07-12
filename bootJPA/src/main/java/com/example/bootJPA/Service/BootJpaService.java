package com.example.bootJPA.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bootJPA.Pojo.User;
import com.example.bootJPA.Respository.BootJpaRepository;
import com.example.bootJPA.ServiceI.BootJpaServiceI;

@Service
public class BootJpaService implements BootJpaServiceI{

	@Autowired
	private BootJpaRepository bootJpaRepository;
	
	@Override
	public void saveUserDtls(User user) {
		bootJpaRepository.save(user);
	}

	@Override
	public List<User> getUserDtls() {
		return bootJpaRepository.findAll();
	}

	@Override
	public Optional<User> getUserDtlsById(Integer userId) {
		return bootJpaRepository.findById((long) userId);
	}

	@Override
	public void updateUserDtlsById(User user) {
		bootJpaRepository.save(user);
	}

	@Override
	public void deleteUserDtlsById(Integer userId) {
		bootJpaRepository.deleteById((long) userId);
	}

}
