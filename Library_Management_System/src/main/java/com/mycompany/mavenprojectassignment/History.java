/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectassignment;

import java.time.LocalDate;

/**
 *
 * @author Mohammad Sukary
 */
public class History {
    private String bookName, BookID, memberName, memberID;
    private LocalDate startDate, endDate;

    public String getBookName() {
        return bookName;
    }

    
    public String getBookID() {
        return BookID;
    }

    
    public String getMemberName() {
        return memberName;
    }

    public String getMemberID() {
        return memberID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    
    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
    
}
