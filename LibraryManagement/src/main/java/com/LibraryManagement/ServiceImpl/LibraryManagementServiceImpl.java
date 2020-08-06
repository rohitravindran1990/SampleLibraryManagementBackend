package com.LibraryManagement.ServiceImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LibraryManagement.DAO.BookJpaRepository;
import com.LibraryManagement.DAO.LibraryJpaRepository;
import com.LibraryManagement.Entity.Books;
import com.LibraryManagement.Entity.Library;
import com.LibraryManagement.Service.LibraryManagementService;

@Service
public class LibraryManagementServiceImpl implements LibraryManagementService {
	@Autowired
	private LibraryJpaRepository libraryrepo;

	@Autowired
	private BookJpaRepository bookrepo;

	public List<Books> getBooksbyLibrary(long id) {
		try {
			Library lib = libraryrepo.getOne(id);
			return lib.getBook();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public List<Library> getLibrary() {
		try {
			return libraryrepo.findAll();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public Boolean saveBooks(Books book) {
		// TODO Auto-generated method stub
		try {
			Books bo = bookrepo.save(book);
			return true;
		} catch (Exception ex) {
			return false;
		}

	}

}
