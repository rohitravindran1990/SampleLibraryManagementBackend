package com.LibraryManagement.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LibraryManagement.Entity.User;


public interface UserRepository extends JpaRepository<User,String>
{
   public User getByUsernameAndPassword(String username,String password);
}
