package com.example.bootJPA.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bootJPA.Pojo.User;

@Repository
public interface BootJpaRepository extends JpaRepository<User, Long>{

}
