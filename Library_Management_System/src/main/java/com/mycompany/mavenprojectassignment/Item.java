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
public abstract class Item {
    private String id;
    private String title;
    private int year;
    private String specialization;
    public LocalDate startDate;
    public LocalDate endDate;
    
    public Item () {}
    public Item(String id, String title, int year, String specialization) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.specialization = specialization;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public int getYear() { return year; }
    public String getSpecialization() { return specialization; }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    

    public void setId(String id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public void setStartDate(int year, int month, int day) {
        this.startDate = LocalDate.of(year, month, day);
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
    
}
