package com.LibraryManagement.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="LIBRARY")
public class Library 
{
	@Id
	private Long LibraryId;
	@Column(name="LibName")
	private String LibraryName;
	@Column(name="Address")
	private String Address;
	
	public Library()
	{
		
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Long getLibraryId() {
		return LibraryId;
	}
	public void setLibraryId(Long libraryId) {
		LibraryId = libraryId;
	}
	public String getLibraryName() {
		return LibraryName;
	}
	public List<Books> getBook() {
		return book;
	}
	public void setBook(List<Books> book) {
		this.book = book;
	}
	public void setLibraryName(String libraryName) {
		LibraryName = libraryName;
	}
	
	@JsonManagedReference
	@OneToMany(mappedBy="library",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Books> book;
	
	@Override
	public String toString() {
		return "Library [LibraryId=" + LibraryId + ", LibraryName=" + LibraryName + ", Address=" + Address + "]";
	}

}
