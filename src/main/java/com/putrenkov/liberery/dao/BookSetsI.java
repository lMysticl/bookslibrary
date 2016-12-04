package com.putrenkov.liberery.dao;


import com.putrenkov.liberery.entity.Book;

import java.util.List;

public interface BookSetsI {


    //Add book
     String addBook(Book book);

    //Array of all books
     List allBooks();


    //Array duplicate books
     List getBookByName(String name);

    //Remove book
     String removeBook(Book book);
}
