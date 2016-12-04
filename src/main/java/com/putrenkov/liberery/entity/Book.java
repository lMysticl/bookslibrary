package com.putrenkov.liberery.entity;

import javax.persistence.*;

@Entity
@Table(name = "Books")
public class Book implements BookI {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private
    int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "author", nullable = false)
    private String author;

    public Book() {
    }


    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book name '" + name + '\'' +
                ", author '" + author + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;

        if (getId() != book.getId()) return false;
        if (!getName().equals(book.getName())) return false;
        return getAuthor().equals(book.getAuthor());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getAuthor().hashCode();
        return result;
    }
}
