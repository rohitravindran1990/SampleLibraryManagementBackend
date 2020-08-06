package com.LibraryManagement.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LibraryManagement.Entity.Books;
import com.LibraryManagement.Entity.Library;

@Repository
public interface LibraryJpaRepository extends JpaRepository<Library,Long>
{
//  	@Query("select b.Bookname from Books b JOIN Library l where b.Fk_Id=:id")
//  	public List<Books>  getBooks(@Param("id") Long id);

}
