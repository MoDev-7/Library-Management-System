/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenprojectassignment;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Mohammad Sukary
 */
public class MainClass {
    public static void menue (Library library) {
        Scanner in = new Scanner (System.in);
        System.out.println("Welcome to this library, choose an action from these options:");
        System.out.println("1. View all books registered in the library.");
        System.out.println("2. View all projects registered in the library.");
        System.out.println("3. View all members registered in the library and the books they have borroed.");
        System.out.println("4. Add item to the library.");
        System.out.println("5. Search for an item by title, ID, or specialization.");
        System.out.println("6. Request to borrow an item.");
        System.out.println("7. Request to return an item.");
        System.out.println("8. View books available for borrowing.");
        System.out.println("9. View third year projects.");
        System.out.println("10. View members who have borrowed artificial intelligence books.");
        System.out.println("11. View members who are late in returning a book at this time.");
        System.out.println("12. View the members who borrowed a book in certain period.");
        System.out.println("13. Add new member");
        int choice = in .nextInt();
        switch (choice) {
            case 1:
                System.out.println("*************************");
                System.out.println("Non-borrowed books:");
                library.printAllBooks();
                System.out.println("-------------------------");
                System.out.println("Borrowed books:");
                library.printBorrowedBooks();
                System.out.println("*************************");
                in.next();
                menue(library);
                break;
            case 2:
                System.out.println("*************************");
                System.out.println("Non-borrowed projects:");
                library.printAllProjects();
                System.out.println("-------------------------");
                System.out.println("Borrowed projects:");
                library.printBorrowedProjects();
                System.out.println("*************************");
                menue(library);
                break;
            case 3:
                System.out.println("*************************");
                library.printAllMembers();
                System.out.println("*************************");
                menue(library);
                break;
            case 4:
                System.out.println("Shoose item type:");
                System.out.println("1. Book.");
                System.out.println("2. Project.");
                int tchoice = in .nextInt();
                switch (tchoice) {
                    case 1:
                        library.addBook();
                        menue(library);
                        break;
                        
                    case 2:
                        library.addProject();
                        menue(library);
                        break;
                }
                menue(library);
                break;
            case 5:
                System.out.println("1. Book.");
                System.out.println("2. Project.");
                int num=in.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("Enter title, ID, or specialization.");
                        String schoice = in.next();
                        Book book = library.searcheForBookByIdOrTitleOrSecialization(schoice);
                        //System.out.println("oi");
                        if (book == null) 
                            System.out.println("This book is not exsist.");
                        else  
                            library.printBook(book);
                        menue(library);
                        break;
                    case 2:
                        System.out.println("Enter title, ID, or specialization.");
                        String schoice3 = in.next();
                        Project project = library.searcheForProjectByIdOrTitleOrSecialization(schoice3);
                        if (schoice3 == null) 
                            System.out.println("This project is not exsist.");
                        else 
                            library.printProject(project);
                        menue(library);
                        break;
                }
                    
            case 6:
                System.out.println("Shoose item type:");
                System.out.println("1. Book.");
                System.out.println("2. Project.");
                int e = in .nextInt();
                switch (e) {
                    case 1:
                        System.out.println("Enter the Id of the book you want to borroe.");
                        String bookId = in.next();
                        System.out.println("Enter the title of the book you want to borroe.");
                        String bookTitle = in.next();
                        System.out.println("Enter the ID of the member who want to borrow");
                        String memID = in.next();
                        System.out.println("Enter the Name of the member who want to borrow");
                        String memName = in.next();
                        library.borrowBook(bookId, bookTitle, memID, memName);
                        menue(library);
                        break;
                    case 2:
                        System.out.println("Enter the Id of the Project you want to borroe.");
                        String ProjectId = in.next();
                        System.out.println("Enter the title of the Project you want to borroe.");
                        String ProjectTitle = in.next();
                        System.out.println("Enter the ID of the member who want to borrow");
                        String memID2 = in.next();
                        System.out.println("Enter the Name of the member who want to borrow");
                        String memName2 = in.next();
                        library.borrowProject(ProjectId, ProjectTitle, memID2, memName2);
                        menue(library);
                        break;
                }
            case 7:
                System.out.println("Shoose item type:");
                System.out.println("1. Book.");
                System.out.println("2. Project.");
                int er = in .nextInt();
                switch (er) {
                    case 1:
                        System.out.println("Enter the Id of the book you want to return.");
                        String rbookId = in.next();
                        System.out.println("Enter the title of the book you want to return.");
                        String rbookTitle = in.next();
                        System.out.println("Enter the ID of the member who want to return");
                        String rmemID = in.next();
                        System.out.println("Enter the Name of the member who want to return");
                        String rmemName = in.next();
                        library.returnBook(rbookId, rbookTitle, rmemID, rmemName);
                        menue(library);
                        break;
                    case 2:
                        System.out.println("Enter the Id of the Project you want to return.");
                        String rProjectId = in.next();
                        System.out.println("Enter the title of the Project you want to return.");
                        String rProjectTitle = in.next();
                        System.out.println("Enter the ID of the member who want to return");
                        String rmemID2 = in.next();
                        System.out.println("Enter the Name of the member who want to return");
                        String rmemName2 = in.next();
                        library.returnProject(rProjectId, rProjectTitle, rmemID2, rmemName2);
                        menue(library);
                        break;
                }
            case 8:
                library.printAllBooks();
                menue(library);
                break;
            case 9:
                library.printThirdYearProjects();
                menue(library);
                break;
            case 10:
                for (int i = 0; i < library.getMembers().size(); i++) {
                    for (int j = 0; j < library.getMembers().get(i).getBorrowedBooksByMwmber().size(); j++) {
                        if (library.getMembers().get(i).getBorrowedBooksByMwmber().get(j).getSpecialization().equals("ArtificialIntellegence")) 
                            library.printMember(library.getMembers().get(i));
                    }
                    
                }
                menue(library);
                break;
            case 11:
                for (int i = 0; i < library.getMembers().size(); i++) {
                    LocalDate today = LocalDate.now();
                    for (int j = 0; j < library.getMembers().get(i).getBorrowedBooksByMwmber().size(); j++) {
                        if(today.isEqual(library.getMembers().get(i).getBorrowedBooksByMwmber().get(j).getEndDate()) || today.isAfter(library.getMembers().get(i).getBorrowedBooksByMwmber().get(j).getEndDate())) {
                            System.out.println("Member name: " +library.getMembers().get(i).getMemberName());
                            System.out.println("Member ID: " + library.getMembers().get(i).getMemberId());
                            break;
                        }
                    }
                    for (int j = 0; j < library.getMembers().get(i).getBorrowedBooksByMwmber().size(); j++) {
                        if(today.isEqual(library.getMembers().get(i).getBorrowedBooksByMwmber().get(j).getEndDate()) || today.isAfter(library.getMembers().get(i).getBorrowedBooksByMwmber().get(j).getEndDate())) {
                            System.out.println("Book title: " + library.getMembers().get(i).getBorrowedBooksByMwmber().get(j).getTitle() + ',' + "Book ID: " + library.getMembers().get(i).getBorrowedBooksByMwmber().get(j).getId());
                        }
                    }
                    System.out.println("******************");
                    
                }
                menue(library);
                break;
            case 12:
                LocalDate start,end;
                int startDay,startMonth,startYear,endDay,endMonth,endYear;
                System.out.println("Enter a start day.");
                startDay = in.nextInt();
                System.out.println("Enter a start month.");
                startMonth = in.nextInt();
                System.out.println("Enter a start year.");
                startYear = in.nextInt();
                System.out.println("Enter a end day.");
                endDay = in.nextInt();
                System.out.println("Enter a end month.");
                endMonth = in.nextInt();
                System.out.println("Enter a end year.");
                endYear = in.nextInt();
                start = LocalDate.of(startYear, startMonth, startDay);
                end = LocalDate.of(endYear, endMonth, endDay);
                for (int i = 0; i < library.getBooksHistory().size(); i++) {
                    if (library.getBooksHistory().get(i).getStartDate().isAfter(start) && library.getBooksHistory().get(i).getStartDate().isBefore(end)) {
                        System.out.println("-------------------------");
                        System.out.println("Member name: " + library.getBooksHistory().get(i).getMemberName() + ',' + "member ID: " + library.getBooksHistory().get(i).getMemberID());
                        System.out.println("Book name: " + library.getBooksHistory().get(i).getBookName() + ',' + "book ID: " + library.getBooksHistory().get(i).getBookID());
                        System.out.println("Start borrowing date: " + library.getBooksHistory().get(i).getStartDate() + ',' + "end borrowing date: " + library.getBooksHistory().get(i).getEndDate());
                        System.out.println("-------------------------");
                    }
                }
                menue(library);
                break;
            case 13:
                String namem,idmember;
                System.out.println("Enter member name.");
                namem = in.next();
                System.out.println("Enter member ID.");
                idmember = in.next();
                Member newMember = new Member (namem,idmember);
                library.getMembers().add(newMember);
                menue(library);
                break;
            default :
                System.out.println("Wrong option");
                menue(library);
        }
    }
    public static void main(String[] args) {
        Library library = new Library ();
        Book b1 = new Book ("book1","title1",1,"ArtificialIntellegence","author1",100,"publisher1"); //(String id, String title, int year, String specialization, String author, int pages, String publisher)
        Book b2 = new Book ("book2","title2",2,"basicSciences","author2",200,"publisher2");
        Book b3 = new Book ("book3","title3",3,"basicSciences","author3",300,"publisher3");
        library.adddbook(b1);
        library.adddbook(b2);
        library.adddbook(b3);
        Member m1 = new Member ("a","b");
        library.aaam(m1);
        menue(library);
    }
}
