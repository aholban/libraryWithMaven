package com.softwareinstitute.andreeaholban;

import java.time.LocalDate;

public class Book extends LibraryItem{
    ////////////////////////////////////////////Attributes//////////////////////////////////////////////////////////////

    private String author;
    private String refNumber;
    private String status;

    ////////////////////////////////////////////Constructors////////////////////////////////////////////////////////////

    public Book(String title, String author, Boolean isBorrowable, String status){
        this(title, author, null, "" , isBorrowable, "physical", "unknown", 1, 5, "", status);
    }

    public Book(String title, String author, Boolean isBorrowable, String status, String refNumber){
        this(title, author, null, "", isBorrowable, "physical", "unknown", 1, 5, refNumber, status);
    }

    public Book(String title, String author, LocalDate publicationDate, String ISBN, Boolean isBorrowable, String format, String section, int shelf, int copiesAvailable, String refNumber, String status){
        super(title, publicationDate, ISBN, isBorrowable, format, section, shelf, copiesAvailable);
        this.author = author;
        this.refNumber = refNumber;
        this.status = status;
    }
    /////////////////////////////////////////////Methods///////////////////////////////////////////////////////////////




    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
