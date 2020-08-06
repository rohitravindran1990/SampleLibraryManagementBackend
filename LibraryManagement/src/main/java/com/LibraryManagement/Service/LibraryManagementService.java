package com.LibraryManagement.Service;

import java.util.List;

import com.LibraryManagement.Entity.Books;
import com.LibraryManagement.Entity.Library;

public interface LibraryManagementService 
{
	public List<Books> getBooksbyLibrary(long id);
	public List<Library> getLibrary();
	public Boolean saveBooks(Books book);
	
}
