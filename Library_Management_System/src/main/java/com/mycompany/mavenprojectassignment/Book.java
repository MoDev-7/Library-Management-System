/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectassignment;

/**
 *
 * @author Mohammad Sukary
 */
public class Book extends Item {
    private String author;
    private int pages;
    private String publisher;
    
    public Book () {}
    public Book(String id, String title, int year, String specialization, String author, int pages, String publisher) {
        super(id, title, year, specialization);
        this.author = author;
        this.pages = pages;
        this.publisher = publisher;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }
    public int getPages() {
        return pages;
    }
    public String getPublisher() {
        return publisher;
    }
}
