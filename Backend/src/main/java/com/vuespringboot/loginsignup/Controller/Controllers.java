package com.vuespringboot.loginsignup.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vuespringboot.loginsignup.DTO.Login_DTO;
import com.vuespringboot.loginsignup.DTO.User_DTO;
import com.vuespringboot.loginsignup.Model.Response.LoginResponse;
import com.vuespringboot.loginsignup.Service.User_Service;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class Controllers {
	@Autowired
	private User_Service _userServie;
	

    @PostMapping("/add")
	public String createUser(@RequestBody User_DTO userdto){
    	String createNewByUserDTO = this._userServie.addUserInfo(userdto);
    	
    	return createNewByUserDTO;
    	
    }
	
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Login_DTO dtoLogin){
    	LoginResponse loginResp = this._userServie.loginUserInfo(dtoLogin);
    	return ResponseEntity.ok(loginResp);
    }
	
}
