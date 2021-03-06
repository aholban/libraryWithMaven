package com.softwareinstitute.andreeaholban;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        setupCollection(items);

    }


    public static List<String> findExistingGenres(List<LibraryItem> items){
        List<String> genres = new ArrayList<>();
        for( LibraryItem item: items){
            String genre = item.getSection();
            if(!genres.contains(genre)){
                genres.add(genre);
            }
        }
        return genres;
    }

    public static Member findMember(List<Member> members, String name, String id){
        Member result = null;
        for(Member visitor : members){
            if(visitor.getName().equals(name) && visitor.getCardID().equals(id))
                result = visitor;
        }

        return result;
    }

    public static String generateMemberID(List<Member> members){
        String id = "";
        id = id + members.size()+1;
        return id;
    }

    public static String generateLibraryID(List<LibraryItem> items){
        String id = "";
        id = id + items.size()+1;
        return id;
    }

    public static Member register(List<Member> members, String name){

        String id = generateMemberID(members);
        Member visitor = new Member(name, id);
        members.add(visitor);
        System.out.println("Name: " + visitor.getName());
        System.out.println("Card ID: " + visitor.getCardID());

        return visitor;
    }

    public static void setupCollection(List<LibraryItem> items){
        LibraryItem book = new Book("Mistborn", "Brandon Sanderson", null, generateLibraryID(items), Boolean.TRUE, "physical", "Fantasy", 1, 5, "available");
        items.add(book);
        book = new Book("Harry Potter", "JK Rowling", null, generateLibraryID(items), Boolean.FALSE, "physical", "Fantasy", 1, 5, "available");
        items.add(book);
        book = new Book("Pride and prejudice", "Jane Austen", null, generateLibraryID(items), Boolean.TRUE, "physical", "Romance", 1, 5, "available");
        items.add(book);
        book = new Book("Emma", "Jane Austen", null, generateLibraryID(items), Boolean.TRUE, "physical", "Romance", 1, 5, "available");
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
                newItem = new Book(title, author, null, generateLibraryID(items), Boolean.TRUE, format, section, 1, 1, "available");
                items.add(newItem);
            }
            else if(itemToAdd.equals("document")){
                newItem = new Document(title, author, null, generateLibraryID(items), Boolean.TRUE, format, section, 1, 1, 0, references);
                items.add(newItem);
            }
            else {
                System.out.println("Can't recognize type");
            }
        }
    }

}
