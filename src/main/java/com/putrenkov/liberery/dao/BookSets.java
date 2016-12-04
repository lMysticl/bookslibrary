package com.putrenkov.liberery.dao;

import com.putrenkov.liberery.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

//BD requests
public class BookSets implements BookSetsI {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("users_auth");

	private static EntityManager em = factory.createEntityManager();

    //Add book
	public String addBook(Book book) {
		try{
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();
		} catch (Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
			return e.getMessage();
		}

		return book.toString()+" was added";
	}
	
	//Returns an array of all books
	public List allBooks(){
		return em.createNativeQuery("select * from Books", Book.class).getResultList();
	}
	
	//Returns an array of books on behalf of the book
	public List getBookByName(String name){
		return  em.createNativeQuery("select * from Books where name like \""+name+"\"", Book.class).getResultList();
	}
	
	//Remove book
	public String removeBook(Book book){
		try{
		em.getTransaction().begin();
		em.remove(book);
		em.getTransaction().commit();
		return book.toString();
		} catch (Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
			return e.getMessage();

		}
		
	}


}
