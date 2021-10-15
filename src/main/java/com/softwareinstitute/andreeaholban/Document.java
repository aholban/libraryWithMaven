package com.softwareinstitute.andreeaholban;

import java.time.LocalDate;
import java.util.List;

//Scientific papers can be included in this class
public class Document extends LibraryItem{
    //////////////////////////////////////////////Attributes/////////////////////////////////////////////////////////////////////

    private String authors;  //this should probably be a list
    private int citationsNumber;
    private List<String> references;

    ///////////////////////////////////////////////Constructors/////////////////////////////////////////////////////////////////
    public Document(String title, String author, LocalDate publicationDate, String ISBN, Boolean isBorrowable, String format, String section, int shelf, int copiesAvailable, int citationsNumber, List<String> references) {
        super(title, publicationDate, ISBN, isBorrowable, format, section, shelf, copiesAvailable);
        this.authors = author;
        this.citationsNumber = citationsNumber;
        this.references = references;
    }

    ////////////////////////////////////////////////Methods//////////////////////////////////////////////////////////////////////




    public int getCitationsNumber() {
        return citationsNumber;
    }

    public void setCitationsNumber(int citationsNumber) {
        this.citationsNumber = citationsNumber;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }

    @Override
    public String getAuthor() {
        return authors;
    }

    @Override
    public void setAuthor(String author) {
        this.authors = author;
    }
}
