package com.softwareinstitute.andreeaholban;

import java.time.LocalDate;


//Maps can be included in this class, maybe
public class Blueprint extends LibraryItem{
    ////////////////////////////////////Attributes///////////////////////////////////////////////////////////////////

    private String author;

    //////////////////////////////////Constructors////////////////////////////////////////////////////////////////////

    public Blueprint(String title, String author){
        super(title);
        this.author = author;
    }


    ///////////////////////////////////////Methods/////////////////////////////////////////////////////////////////////

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
