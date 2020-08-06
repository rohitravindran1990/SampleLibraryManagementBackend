package com.LibraryManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.LibraryManagement.Entity.Books;
import com.LibraryManagement.Entity.Library;
import com.LibraryManagement.ServiceImpl.LibraryManagementServiceImpl;

@CrossOrigin(origins="http://localhost:3001")
@RestController
public class LibraryManagementController 
{
	@Autowired
	public LibraryManagementServiceImpl service;
	
	@RequestMapping(method = RequestMethod.GET,path = "/getLibrary")
	public List<Library> getLibrary()
	{
		List<Library> library = service.getLibrary();
		return library;	
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/getBooks/{libId}")
	public List<Books> getBooks(@PathVariable long libId)
	{
		List<Books> books = service.getBooksbyLibrary(libId);
		return books;	
	}
	
	@RequestMapping(method = RequestMethod.PUT,path = "/updateBooks")
	public Boolean addBook(@RequestBody Books book)
	{
		return service.saveBooks(book);
	}
	
	

}
