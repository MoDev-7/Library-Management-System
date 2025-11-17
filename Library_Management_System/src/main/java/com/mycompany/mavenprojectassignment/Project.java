/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectassignment;

/**
 *
 * @author Mohammad Sukary
 */
public class Project extends Item{
    private String teamName;
    private String projectYear;

    public Project(String id, String title, int year, String specialization, String teamName, String projectYear) {
        super(id, title, year, specialization);
        this.teamName = teamName;
        this.projectYear = projectYear;
    }
    public Project () {}

    public String getTeamName() {
        return teamName;
    }
    public String getProjectYear() {
        return projectYear;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }    
    public void setProjectYear(String projectYear) {
        this.projectYear = projectYear;
    }

}
