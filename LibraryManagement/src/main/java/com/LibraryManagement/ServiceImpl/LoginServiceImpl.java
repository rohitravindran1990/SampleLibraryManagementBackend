package com.LibraryManagement.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LibraryManagement.DAO.UserRepository;
import com.LibraryManagement.Entity.User;
import com.LibraryManagement.Service.LoginService;

@Service
public class LoginServiceImpl implements LoginService
{
    @Autowired
	private UserRepository userrepo;

	@Override
	public User loginservice(User user) {
		// TODO Auto-generated method stub
     	return userrepo.getByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
}
