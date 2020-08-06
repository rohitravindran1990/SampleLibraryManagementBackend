package com.LibraryManagement.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="BOOKS")
public class Books 
{
	@Id
	@Column(name = "Book_id")
	private long BookId;
	@Column(name = "BookAuthor")
	private String BookAuthor;
	@Column(name = "BookGenre")
	private String BookGenre;
	@Column(name = "Fk_Id")
	private Long Fk_Id;
	
	public Books()
	{
		
	}
	public Books(long bookId, String bookAuthor, String bookGenre, Long fk_Id, String bookname, Library library) {
		super();
		BookId = bookId;
		BookAuthor = bookAuthor;
		BookGenre = bookGenre;
		Fk_Id = fk_Id;
		Bookname = bookname;
		this.library = library;
	}
	public Long getFk_Id() {
		return Fk_Id;
	}
	public void setFk_Id(Long fk_Id) {
		Fk_Id = fk_Id;
	}
	public long getBookId() {
		return BookId;
	}
	public void setBookId(long bookId) {
		BookId = bookId;
	}
	public String getBookAuthor() {
		return BookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}
	public String getBookGenre() {
		return BookGenre;
	}
	public void setBookGenre(String bookGenre) {
		BookGenre = bookGenre;
	}
	public String getBookname() {
		return Bookname;
	}
	public void setBookname(String bookname) {
		Bookname = bookname;
	}
	@Column(name = "Book_name")
	private String Bookname;

	
	@ManyToOne
	@JoinColumn(name= "Fk_Id",insertable= false , updatable=false, nullable=false)
    private Library library;
	
	@JsonBackReference
	public Library getLibrary() {
		return library;
	}
	public void setLibrary(Library library) {
		this.library = library;
	}
    
}
