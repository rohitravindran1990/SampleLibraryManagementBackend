package com.LibraryManagement.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LibraryManagement.Entity.Books;

public interface BookJpaRepository extends JpaRepository<Books,Long>{
	
	
	
}
