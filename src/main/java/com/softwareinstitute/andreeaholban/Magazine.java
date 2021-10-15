package com.softwareinstitute.andreeaholban;

import java.time.LocalDate;

public class Magazine extends LibraryItem{
    /////////////////////////////////////////////Attributes/////////////////////////////////////////////////////////////////////

    private String publisher;

    /////////////////////////////////////////////Constructors//////////////////////////////////////////////////////////////////

    public Magazine(String title, String author, LocalDate publicationDate, String ISBN, Boolean isBorrowable, String format, String section, int shelf, int copiesAvailable) {
        super(title, publicationDate, ISBN, isBorrowable, format, section, shelf, copiesAvailable);
        this.publisher = author;
    }


    @Override
    public String getAuthor() {
        return publisher;
    }

    @Override
    public void setAuthor(String author) {
        this.publisher = author;
    }

    /////////////////////////////////////////////////Methods////////////////////////////////////////////////////////////////////
}
