/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenprojectassignment;

//import static com.mycompany.mavenprojectassignment.SemesterProject_Programming2_Main.in;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mohammad Sukary
 */
public class Library {
    private ArrayList <Book> books  = new ArrayList();
    private ArrayList <Member> members = new ArrayList();
    private ArrayList <Project> projects = new ArrayList();
    private ArrayList <Book> borrowedBooks = new ArrayList();
    private ArrayList <Project> borrowedProjects = new ArrayList();
    private ArrayList <History> booksHistory = new ArrayList ();

    public ArrayList <Book> getBooks() {
        return books;
    }
    public ArrayList <Member> getMembers() {
        return members;
    }
    public ArrayList <Project> getProjects() {
        return projects;
    }
    public ArrayList <Book> getBorrowedBooks() {
       return borrowedBooks;
    }
    public ArrayList <Project> getBorrowedProjects() {
        return borrowedProjects;
    }
    public ArrayList<History> getBooksHistory() {
        return booksHistory;
    }
    
    public Scanner in = new Scanner(System.in);
     
    public void addBook() {
        Book book = new Book();
        System.out.println("Ener the folloing information to add the new book:");
        System.out.println("Book ID:");
        book.setId(in.next());
        System.out.println("Book title:");
        book.setTitle(in.next());
        System.out.println("Year:");
        book.setYear(in.nextInt());
        chooseSpecialization(book);
        System.out.println("Book author:");
        book.setAuthor(in.next());
        System.out.println("Book pages:");
        book.setPages(in.nextInt());
        System.out.println("Book publisher:");
        book.setPublisher(in.next());
        books.add(book);
    }
    public void addProject() {
        Project project = new Project();
        System.out.println("Ener the folloing information to add the new project:");
        System.out.println("project ID:");
        project.setId(in.next());
        System.out.println("project title:");
        project.setTitle(in.next());
        System.out.println("Year:");
        project.setYear(in.nextInt());
        chooseSpecialization(project);
        chooseProjectYear (project);
        System.out.println("project team name:");
        project.setTeamName(in.next());
        projects.add(project);
    }
    public void addMember () {
        Member member = new Member();
        System.out.println("enter member's name");
        member.setMemberName(in.next());
        System.out.println("enter memberId");
        member.setMemberId(in.next());
        members.add(member);
    }
    
    public void printBook(Book book) {
        System.out.println("Book{" + "author=" + book.getAuthor() + ", pages=" + book.getPages() + ", publisher=" + book.getPublisher() + ", id=" + book.getId() + ", title=" + book.getTitle() + ", year=" + book.getYear() + ", specialization=" + book.getSpecialization() + '}'); ;
    }
    public void printProject (Project project) {
        System.out.println("Project{" + "id=" + project.getId() + ", title=" + project.getTitle() + ", year=" + project.getYear() + ", specialization=" + project.getSpecialization() + ", teamName=" + project.getTeamName() + ", projectYear=" + project.getProjectYear() + '}');
    }
    public void printMember (Member member) {
        System.out.println("Member{" + "memberName=" + member.getMemberName() + ", memberId=" + member.getMemberId() + '}');
        System.out.println("borrowed books by this member:");
        for (int i = 0; i < member.getBorrowedBooksByMwmber().size(); i++) {
            printBook(member.getBorrowedBooksByMwmber().get(i));
        }
        System.out.println("------");
        System.out.println("borrowed projects by this member:");
        for (int i = 0; i < member.getBorrowedProjectsByMwmber().size(); i++) {
            printProject(member.getBorrowedProjectsByMwmber().get(i));
        }
    }
    public void printAllBooks () {
        for (int i = 0; i < books.size() ; i++) {
            printBook(books.get(i));
        }
    }
    public void printBorrowedBooks () {
        for (int i = 0; i < borrowedBooks.size() ; i++) {
            printBook(borrowedBooks.get(i));
        }
    }
    public void printAllProjects () { 
        for (int i = 0; i < borrowedProjects.size() ; i++) {
            printProject(borrowedProjects.get(i));
        }
    }
    public void printBorrowedProjects () {
        for (int i = 0; i < projects.size() ; i++) {
            printProject(projects.get(i));
        }
    }
    public void printAllMembers () {
        for (int i = 0; i < members.size() ; i++) {
            printMember(members.get(i));
            System.out.println("*************");
        }
    }
       
    public boolean verifyBookIsExistInBooksByIdAndTitle (String id, String title) {
        boolean value = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(id) && books.get(i).getTitle().equals(title)) {
                value = true;
                break;
            }
        }
            return value;
        
    }
    public Book getBookFromBooks (String id, String title) {
        Book book = null;
        for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getId().equals(id) && books.get(i).getTitle().equals(title))
                    book = books.get(i);
        }
        return book;
    }
    public boolean verifyProjectIsExistInProjectsByIdAndTitle (String id, String title) {
        boolean value = false;
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId().equals(id) && projects.get(i).getTitle().equals(title)) {
                value = true;
                break;
            }
        }
            return value;
        
    }
    public Project getProjectFromProjects (String id, String title) {
        Project project = null;
        for (int i = 0; i < projects.size(); i++) {
                if (projects.get(i).getId().equals(id) && projects.get(i).getTitle().equals(title))
                    project = projects.get(i);
        }
        return project;
    }
    public Member searchMemberByMemberIdAndMemberName (String memberId, String memberName){
        Member member = null;
        if (members.size()==0) {
            System.out.println("This member is not registerd with the members of the library. register an account for this member and try again.");
            member = null;
        }
        else {
            for (int j = 0; j < members.size(); j++) {
                if (members.get(j).getMemberId().equals(memberId) && members.get(j).getMemberName().equals(memberName)) {
                    member = members.get(j);
                    break;
                }
                else if (j+1==members.size()) {
                    System.out.println("This member is not registerd with the members of the library, register an account for this member and try again.");
                    member = null;
                }
            }
        }
        return member;
    }
    public boolean verifyMemberBorroweds3 (Member member) {
        if ((member.getBorrowedBooksByMwmber().size()+member.getBorrowedProjectsByMwmber().size())<3)
            return true;
        else
            return false;
    }
    
    public void borrowBook (String bookId, String bookTitle, String memberId, String memberName) {
        Book book;
        Member member;
        if (books.size()!=0) {
            if (verifyBookIsExistInBooksByIdAndTitle(bookId, bookTitle)) {
                book = getBookFromBooks(bookId, bookTitle);
                member = searchMemberByMemberIdAndMemberName(memberId, memberName);
                if (member == null) {
                }
                else {
                    if (verifyMemberBorroweds3(member)) {
                        addBookToBorrowedBooks(book);
                        addBookToBorrowedBooksByMember(book, member);
                            System.out.println("Enter the start of the book's borrowing year..");
                            int year = in.nextInt();
                            System.out.println("Enter the start of the book's borrowing month..");
                            int month = in.nextInt();
                            System.out.println("Enter the start of the book's borrowing day..");
                            int day = in.nextInt();
                        book.setStartDate(year, month, day);
                        book.setEndDate(book.getStartDate().plusDays(7));
                        History history = new History ();
                        history.setBookID(book.getId());
                        history.setBookName(book.getTitle());
                        history.setMemberID(member.getMemberId());
                        history.setMemberName(member.getMemberName());
                        history.setStartDate(book.startDate);
                        history.setEndDate(book.endDate);
                        booksHistory.add(history);
                        books.remove(book);
                        System.out.println("The operation was completed successfully. You can benefit from this book until the date of: " + book.getEndDate() + ".");
                    }
                    else {
                        System.out.println("This member has already borrowed (3) items, cannot borrow more than (3) items.");
                    }
                }
            }
            else {
                if (borrowedBooks.size()==0) {
                    System.out.println("This book is not found in the library.");
                }
                else {
                    for (int k = 0; k < borrowedBooks.size(); k++) {
                        if (borrowedBooks.get(k).getId().equals(bookId) && borrowedBooks.get(k).getTitle().equals(bookTitle))
                            System.out.println("This book is not found in the library, it was borrowed befor, review us after the date of: " + borrowedBooks.get(k).getEndDate() + ".");
                        else if (k+1==borrowedBooks.size())
                            System.out.println("This book is not found in the library.");
                    }
                }
            }            
        }
        else {
            if (borrowedBooks.size()==0) {
                System.out.println("This book is not found in the library.");
            }
            else {
                for (int k = 0; k < borrowedBooks.size(); k++) {
                    if (borrowedBooks.get(k).getId().equals(bookId) && borrowedBooks.get(k).getTitle().equals(bookTitle))
                        System.out.println("This book is not found in the library, it was borrowed befor, review us after the date of: " + borrowedBooks.get(k).getEndDate() + ".");
                    else if (k+1==borrowedBooks.size())
                        System.out.println("This book is not found in the library.");
                }
            }
        }
    }
    public void borrowProject (String projectId, String projectTitle, String memberId, String memberanam) {
        Project project;
        Member member;
        if (projects.size()!=0) {
            if (verifyBookIsExistInBooksByIdAndTitle(projectId, projectTitle)) {
                project = getProjectFromProjects(projectId, projectTitle);
                member = searchMemberByMemberIdAndMemberName(memberId, memberanam);
                if (member == null) {
                }
                else {
                    if (verifyMemberBorroweds3(member)) {
                        addProjectToBorrowedProjects(project);
                        addProjectToBorrowedProjectsByMember(project, member);
                            System.out.println("Enter the start of the project's borrowing year..");
                            int year = in.nextInt();
                            System.out.println("Enter the start of the project's borrowing month..");
                            int month = in.nextInt();
                            System.out.println("Enter the start of the project's borrowing day..");
                            int day = in.nextInt();
                        project.setStartDate(year, month, day);
                        project.setEndDate(project.getStartDate().plusDays(7));
                        projects.remove(project);
                        System.out.println("The operation was completed successfully. You can benefit from this project until the date of: " + project.getEndDate() + ".");
                    }
                    else {
                        System.out.println("This member has already borrowed (3) items, cannot borrow more than (3) items.");
                    }
                }
            }
            else {
                if (borrowedProjects.size()==0) {
                    System.out.println("This project is not found in the library.");
            }
                else {
                    for (int k = 0; k < borrowedProjects.size(); k++) {
                        if (borrowedProjects.get(k).getId().equals(projectId) && borrowedProjects.get(k).getTitle().equals(projectTitle))
                            System.out.println("This project is not found in the library, it was borrowed befor, review us after the date of: " + borrowedProjects.get(k).getEndDate() + ".");
                        else if (k+1==borrowedProjects.size())
                            System.out.println("This project is not found in the library.");
                    }
                }
            }            
        }
        else {
            if (borrowedProjects.size()==0) {
                System.out.println("This project is not found in the library.");
            }
            else {
                for (int k = 0; k < borrowedProjects.size(); k++) {
                    if (borrowedProjects.get(k).getId().equals(projectId) && borrowedProjects.get(k).getTitle().equals(projectTitle))
                        System.out.println("This project is not found in the library, it was borrowed befor, review us after the date of: " + borrowedProjects.get(k).getEndDate() + ".");
                    else if (k+1==borrowedProjects.size())
                        System.out.println("This project is not found in the library.");
                }
            }
        }
    }
    public void returnBook (String bookId, String bookTitle, String memberId, String memberName) {
        Book book;
        Member member;
        if (borrowedBooks.size()==0) {
            System.out.println("This book is not borrowed.");
        }
        else {
            for (int k = 0; k < borrowedBooks.size(); k++) {
                if (borrowedBooks.get(k).getId().equals(bookId) && borrowedBooks.get(k).getTitle().equals(bookTitle)) {
                    book = borrowedBooks.get(k);
                    member = searchMemberByMemberIdAndMemberName(memberId, memberName);
                    if (member == null) {}
                    else {
                        books.add(book);
                        borrowedBooks.remove(book);
                        member.getBorrowedBooksByMwmber().remove(book);
                        LocalDate today = LocalDate.now();
                        if(today.isEqual(book.getEndDate()) || today.isAfter(book.getEndDate()))
                            System.out.println("You are late to return this book. We will take the book back frome you and impose a fine on you.");
                        else
                            System.out.println("The operation was completed successfully.");
                        book.startDate = null;
                        book.endDate = null;
                    }
                    break;
                }
                else if (k+1==borrowedBooks.size())
                    System.out.println("This book is not borrowed.");
            }
        }
    }
    public void returnProject (String projectId, String projectTitle, String memberId, String memberName) {
        Project project;
        Member member;
        if (borrowedProjects.size()==0) {
            System.out.println("This project is not borrowed.");
        }
        else {
            for (int k = 0; k < borrowedProjects.size(); k++) {
                if (borrowedProjects.get(k).getId().equals(projectId) && borrowedProjects.get(k).getTitle().equals(projectTitle)) {
                    project = borrowedProjects.get(k);
                    member = searchMemberByMemberIdAndMemberName(memberId, memberName);
                    if (member == null) {}
                    else {
                        projects.add(project);
                        borrowedProjects.remove(project);
                        member.getBorrowedProjectsByMwmber().remove(project);
                        LocalDate today = LocalDate.now();
                        if(today.isEqual(project.getEndDate()) || today.isAfter(project.getEndDate()))
                            System.out.println("You are late to return this project. We will take the project back frome you and impose a fine on you.");
                        else
                            System.out.println("The operation was completed successfully.");
                        project.startDate = null;
                        project.endDate = null;
                    }
                    break;
                }
                else if (k+1==borrowedProjects.size())
                    System.out.println("This project is not borrowed.");
            }
        }
    }
    
    public void addBookToBorrowedBooks(Book book) {
        this.borrowedBooks.add(book);
    }
    public void addBookToBorrowedBooksByMember(Book book, Member member) {
        member.getBorrowedBooksByMwmber().add(book);
    }   
    public void addProjectToBorrowedProjects(Project project) {
        this.borrowedProjects.add(project);
    }
    public void addProjectToBorrowedProjectsByMember(Project project, Member member) {
        member.getBorrowedProjectsByMwmber().add(project);
    }   
   
    public Book searcheForBookByIdOrTitleOrSecialization (String bookIdOrTitleOrSpecialization) {
        Book book = new Book();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(bookIdOrTitleOrSpecialization)) {
                book = books.get(i);
                break;
            }
            else if (books.get(i).getTitle().equals(bookIdOrTitleOrSpecialization)) {
                 book = books.get(i);
                break;
            }
            else if (books.get(i).getSpecialization().equals(bookIdOrTitleOrSpecialization)) {
                 book = books.get(i);
                break;
            }
            else {
                book = null;
            }
        }
        return book;
    }
    public Project searcheForProjectByIdOrTitleOrSecialization (String projectIdOrTitleOrSpecialization) {
        Project project = new Project();
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId().equals(projectIdOrTitleOrSpecialization)) {
                project = projects.get(i);
                break;
            }
            else if (projects.get(i).getTitle().equals(projectIdOrTitleOrSpecialization)) {
                 project = projects.get(i);
                break;
            }
            else if (projects.get(i).getSpecialization().equals(projectIdOrTitleOrSpecialization)) {
                 project = projects.get(i);
                break;
            }
            else {
                project = null;
            }
        }
        return project;
    }
    public boolean verifyProjectIsExistInProjectsByIdOrTitleOrSecialization (String projectIdOrTitleOrSpecialization) {
        boolean value = false;
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId().equals(projectIdOrTitleOrSpecialization)) {
                value = true;
                break;
            }
            else if (projects.get(i).getTitle().equals(projectIdOrTitleOrSpecialization)) {
                value = true;
                break;
            }
            else if (projects.get(i).getSpecialization().equals(projectIdOrTitleOrSpecialization)) {
                value = true;
                break;
            }
        }
            return value;
        
    }
        
    public void chooseProjectYear (Project project) {
        System.out.println("Choose project project's year:");
        System.out.println("1. ThirdYear.");
        System.out.println("2. ForthYear.");
        System.out.println("3. GraduationYear.");
        int choice = in.nextInt();
        switch (choice){
            case 1: 
                project.setProjectYear("ThirdYear");
                break;
            case 2:
                project.setProjectYear("ForthYear");
                break;
            case 3:
                project.setProjectYear("GraduationYear");
                break;
            default :
                System.out.println("This option is not available. Please choose from the previous options.");
                chooseProjectYear (project);
        }            
            
    }
    public void chooseSpecialization (Project project) {
        System.out.println("Choose project's specialization:");
        System.out.println("1. BasicSciences.");
        System.out.println("2. ArtificialIntellegence.");
        System.out.println("3. Sowftware.");
        System.out.println("4. Networks");
        int choice = in.nextInt();
        switch (choice){
            case 1: 
                project.setSpecialization("BasicSciences");
                break;
            case 2:
                project.setSpecialization("ArtificialIntellegence");
                break;
            case 3:
                project.setSpecialization("Sowftware");
                break;
            case 4:
                project.setSpecialization("Networks");
                break;
            default :
                System.out.println("This option is not available. Please choose from the previous options.");
                chooseSpecialization (project);
        }            
            
    }
    public void chooseSpecialization (Book book) {
        System.out.println("Choose book's specialization:");
        System.out.println("1. BasicSciences.");
        System.out.println("2. ArtificialIntellegence.");
        System.out.println("3. Sowftware.");
        System.out.println("4. Networks");
        int choice = in.nextInt();
        switch (choice){
            case 1: 
                book.setSpecialization("BasicSciences");
                break;
            case 2:
                book.setSpecialization("ArtificialIntellegence");
                break;
            case 3:
                book.setSpecialization("Sowftware");
                break;
            case 4:
                book.setSpecialization("Networks");
                break;
            default :
                System.out.println("This option is not available. Please choose from the previous options.");
                chooseSpecialization (book);
        }            
            
    }
    
    public void printThirdYearProjects () {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getProjectYear().equals("ThirdYear"))
                printProject(projects.get(i));
        }
    }
    
    
    
    public void adddbook(Book book) {
books.add(book);
}
public void aaam(Member m) {
members.add(m);

}
}      