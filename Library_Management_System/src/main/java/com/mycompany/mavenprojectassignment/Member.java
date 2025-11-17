/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectassignment;

import java.util.ArrayList;

/**
 *
 * @author Mohammad Sukary
 */
public class Member {
    private String memberName;
    private String memberId;
    private ArrayList <Book> borrowedBooksByMwmber = new ArrayList();
    private ArrayList <Project> borrowedProjectsByMwmber = new ArrayList();
  
    public Member(){}
    public Member(String memberId, String memberName) {       
        this.memberName = memberName;
        this.memberId = memberId;
    }
    
    
    
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }
    public String getMemberId() {
        return memberId;
    }
    public ArrayList<Book> getBorrowedBooksByMwmber() {
        return borrowedBooksByMwmber;
    }
    public ArrayList<Project> getBorrowedProjectsByMwmber() {
        return borrowedProjectsByMwmber;
    }

    @Override
    public String toString() {
        return "Member{" + "memberName=" + memberName + ", memberId=" + memberId + ", borrowedBooksByMwmber=" + borrowedBooksByMwmber + ", borrowedProjectsByMwmber=" + borrowedProjectsByMwmber + '}';
    }
    
}
