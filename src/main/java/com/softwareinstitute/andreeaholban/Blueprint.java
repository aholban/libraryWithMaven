package com.softwareinstitute.andreeaholban;

import java.time.LocalDate;


//Maps can be included in this class, maybe
public class Blueprint extends LibraryItem{
    ////////////////////////////////////Attributes///////////////////////////////////////////////////////////////////

    private String author;

    //////////////////////////////////Constructors////////////////////////////////////////////////////////////////////
    public Blueprint(String title, String author, LocalDate publicationDate, String ISBN, Boolean isBorrowable, String format, String section, int shelf, int copiesAvailable) {
        super(title, publicationDate, ISBN, isBorrowable, format, section, shelf, copiesAvailable);
        this.author = author;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    ////////////////////////////////////Methods///////////////////////////////////////////////////////////////////////
}
