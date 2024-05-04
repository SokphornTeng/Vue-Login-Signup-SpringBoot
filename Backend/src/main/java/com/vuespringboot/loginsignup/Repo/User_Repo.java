package com.vuespringboot.loginsignup.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vuespringboot.loginsignup.DTO.User_DTO;
import com.vuespringboot.loginsignup.Model.Entity.User;

@Repository
public interface User_Repo extends JpaRepository<User, Long> {

	Optional<User> findOneByEmailAndPassword(String email, String password);
	
	User findByEmail(String email);

	
}
