package com.vuespringboot.loginsignup.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vuespringboot.loginsignup.DTO.Login_DTO;
import com.vuespringboot.loginsignup.DTO.User_DTO;
import com.vuespringboot.loginsignup.Model.Entity.User;
import com.vuespringboot.loginsignup.Model.Response.LoginResponse;
import com.vuespringboot.loginsignup.Repo.User_Repo;

@Service
public class UserImplement implements User_Service {

	@Autowired
	private PasswordEncoder passwordEncoder;
	 @Autowired
	private User_Repo userRepo;
	
	@Override
	public String addUserInfo(User_DTO userDto) {
		
		User newUser = new User(
				
				userDto.getId(),
				userDto.getFirstName(),
				userDto.getLastName(),
				userDto.getEmail(),
				this.passwordEncoder.encode(userDto.getPassword())
				
				);
		
		this.userRepo.save(newUser);
		return newUser.getFirstName();
	}
	User_DTO userDto;

	@Override
	public LoginResponse loginUserInfo(Login_DTO dtoLogin) {
		
		String msg = "";
		User newInfor = this.userRepo.findByEmail(dtoLogin.getEmail());
		if(newInfor != null) {
			String password = dtoLogin.getPassword();
			String encodedPassword = newInfor.getPassword();
			Boolean isPWdRight = passwordEncoder.matches(password, encodedPassword);
			if(isPWdRight) {
				Optional<User> info = this.userRepo.findOneByEmailAndPassword(dtoLogin.getEmail(), encodedPassword);
				if(info.isPresent()) {
					return new LoginResponse("Login Success",  true);
				}else {
					return new LoginResponse( "Login Fail",  false);
				}
			}else {
				return new LoginResponse("Password is not match",  false);
			}
		}else {
			return new LoginResponse("Email not Exist", false);
		}
		
	}

	
}
