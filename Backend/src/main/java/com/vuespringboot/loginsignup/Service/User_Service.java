package com.vuespringboot.loginsignup.Service;

import com.vuespringboot.loginsignup.DTO.Login_DTO;
import com.vuespringboot.loginsignup.DTO.User_DTO;
import com.vuespringboot.loginsignup.Model.Response.LoginResponse;


public interface User_Service {

  String addUserInfo(User_DTO userDto);
  LoginResponse loginUserInfo(Login_DTO dtoLogin);
	
}
