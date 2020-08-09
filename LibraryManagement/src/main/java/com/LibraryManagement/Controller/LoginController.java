package com.LibraryManagement.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LibraryManagement.Configuration.JwtService;
import com.LibraryManagement.Entity.User;
import com.LibraryManagement.ServiceImpl.LoginServiceImpl;

@RestController
public class LoginController 
{
	@Autowired
	private LoginServiceImpl login;
	
	@Autowired
	private JwtService jwtservice;
	
	@PostMapping("/login")
	public HttpServletResponse Login(HttpServletResponse response ,@RequestBody User user) throws Exception
	{
		User loggeduser = login.loginservice(user);
		if(loggeduser!=null)
		{
			Cookie cookie = new Cookie("accesstoken", jwtservice.getTokenForUser(loggeduser));
		    //add cookie to response
		    response.addCookie(cookie);
			return response;
		}
		return response;
		
	}

}



