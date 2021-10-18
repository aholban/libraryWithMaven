package com.softwareinstitute.andreeaholban;

import java.time.LocalDate;


public class Member implements Searchable{
    ////////////////////////////////////////////Attributes/////////////////////////////////////////////////////

    private String name;
    private String cardID;
    private LocalDate issuedDate;
    private int numberBooksBorrowed;

    ////////////////////////////////////////////Constructors//////////////////////////////////////////////////

    public Member(String name, String id){
        this(name,id, LocalDate.now(), 0);
    }
    public Member(String name, String cardID, LocalDate issuedDate, int numberBooksBorrowed){
        this.name = name;
        this.cardID = cardID;
        this.issuedDate = issuedDate;
        this.numberBooksBorrowed = numberBooksBorrowed;
    }

    ////////////////////////////////////////////Methods///////////////////////////////////////////////////////




    public String borrow(LibraryItem book){
        String result = "";
        if(Boolean.TRUE.equals(book.getBorrowable())){
            if(this.numberBooksBorrowed<5 && book.getCopiesAvailable()>0){
                if(!book.getFormat().equals("digital")) {
                    book.setCopiesAvailable(book.getCopiesAvailable() - 1);
                }
                this.numberBooksBorrowed = numberBooksBorrowed +1;
                result = "Successfully borrowed";
            }
            else if (this.numberBooksBorrowed>=5){
                result = "You have reached the maximum amount of books you can borrow at once";

            }
            else if(book.getCopiesAvailable()==0){
                result = "No copies of this item are currently available";
            }

        }
        else{
            result = "Item can't be borrowed";
        }
        return result;
    }

    public void returnBook(LibraryItem book){
        book.setCopiesAvailable(book.getCopiesAvailable() + 1);
        this.numberBooksBorrowed = numberBooksBorrowed -1;
    }

    public void readingInLibrary(LibraryItem book){
        if(!book.getFormat().equals("digital")) book.setCopiesAvailable(book.getCopiesAvailable() - 1);
        System.out.println("You are reading " + book.getTitle() + " in the library.");
    }

    public void finishedReading(LibraryItem book){
        book.setCopiesAvailable(book.getCopiesAvailable() + 1);
        System.out.println("Finished reading " + book.getTitle() );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public int getNumberBooksBorrowed() {
        return numberBooksBorrowed;
    }

    public void setNumberBooksBorrowed(int numberBooksBorrowed) {
        this.numberBooksBorrowed = numberBooksBorrowed;
    }
}
