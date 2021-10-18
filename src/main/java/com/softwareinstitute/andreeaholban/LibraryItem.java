package com.softwareinstitute.andreeaholban;

import java.time.LocalDate;

public abstract class LibraryItem implements Searchable{

    ///////////////////////////////////////Attributes//////////////////////////////////////////////////

    private String title;
    private LocalDate publicationDate;
    private String ISBN;
    private Boolean isBorrowable;
    private String format;
    private String section;
    private int shelf;
    private int copiesAvailable;

    ///////////////////////////////////////Constraints////////////////////////////////////////////////

    public LibraryItem(String title){
        this.title = title;
    }

    public LibraryItem(String title, LocalDate publicationDate, String ISBN, Boolean isBorrowable, String format, String section, int shelf, int copiesAvailable){
        this.title = title;
        this.publicationDate = publicationDate;
        this.ISBN = ISBN;
        this.isBorrowable = isBorrowable;
        this.format = format;
        this.section = section;
        this.shelf = shelf;
        this.copiesAvailable = copiesAvailable;
    }

    ///////////////////////////////////////Methods///////////////////////////////////////////////////


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Boolean getBorrowable() {
        return isBorrowable;
    }

    public void setBorrowable(Boolean borrowable) {
        isBorrowable = borrowable;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public abstract String getAuthor();

    public abstract void setAuthor(String author);

    public String findLocation(){
        String location = "";
        if(format.equals("digital")){
            location = "Check our digital catalogue on one of our computers.";
        }
        else{
            location = "You can find it in the " + section + " section on the shelf " + shelf;
        }
        return location;
    }
}
