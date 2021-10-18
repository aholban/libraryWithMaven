package com.softwareinstitute.andreeaholban;

import java.util.*;

public class Main {

    public static void main(String[] args) {


    }


    public static Member findMember(List<Member> members, String name, String id){
        Member result = null;
        for(Member visitor : members){
            if(visitor.getName().equals(name) && visitor.getCardID().equals(id))
                result = visitor;
        }

        return result;
    }

    public static String generateID(){
        String id = "";
        Random r = new Random();
        for(int i=0; i<7; i++){
            if(r.nextBoolean()) {
                char c = (char) (r.nextInt(26) + 'a');
                id = id + c;
            }
            else{
                int c = r.nextInt(10);
                id = id + c;
            }
        }

        return id;
    }

    public static Member register(List<Member> members, String name){

        String id = generateID();
        Member visitor = new Member(name, id);
        members.add(visitor);
        System.out.println("Name: " + visitor.getName());
        System.out.println("Card ID: " + visitor.getCardID());

        return visitor;
    }

    public static void setupCollection(List<LibraryItem> items){
        LibraryItem book = new Book("Mistborn", "Brandon Sanderson", null, generateID(), Boolean.TRUE, "physical", "Fantasy", 1, 5, generateID(), "available");
        items.add(book);
        book = new Book("Harry Potter", "JK Rowling", null, generateID(), Boolean.FALSE, "physical", "Fantasy", 1, 5, generateID(), "available");
        items.add(book);
        book = new Book("Pride and prejudice", "Jane Austen", null, generateID(), Boolean.TRUE, "physical", "Romance", 1, 5, generateID(), "available");
        items.add(book);
        book = new Book("Emma", "Jane Austen", null, generateID(), Boolean.TRUE, "physical", "Romance", 1, 5, generateID(), "available");
        items.add(book);
    }

    public static void addBook(List<LibraryItem> items, String itemToAdd, String title, String author, String format, String section, List<String> references){
        int itemAlreadyExists=0;
        LibraryItem newItem = null;
        for(LibraryItem item : items){
            if(item.getTitle().equals(title) && item.getAuthor().equals(author) && item.getFormat().equals(format)){
                item.setCopiesAvailable(item.getCopiesAvailable()+1);
                itemAlreadyExists=1;
            }
        }
        if(itemAlreadyExists == 0){
            if(itemToAdd.equals("book")) {
                newItem = new Book(title, author, null, generateID(), Boolean.TRUE, format, section, 1, 1, generateID(), "available");
                items.add(newItem);
            }
            else if(itemToAdd.equals("document")){
                newItem = new Document(title, author, null, generateID(), Boolean.TRUE, format, section, 1, 1, 0, references);
                items.add(newItem);
            }
            else {
                System.out.println("Can't recognize type");
            }
        }
    }

}
