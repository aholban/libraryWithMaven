package com.softwareinstitute.andreeaholban;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        List<Member> members = new ArrayList<Member>();
        List<LibraryItem> items = new ArrayList<LibraryItem>();
        setupCollection(items);
        int terminate =0;
        while(terminate==0){

            System.out.println("Welcome to the Library! What do you want to do?");
            System.out.println("Type \"visitor\" if you are here as a visitor");
            System.out.println("Type \"add book\" if you want to add a book to the collection");
            System.out.println("Type \"leave\" if you wish to leave");
            String command = input.nextLine();
            switch (command){
                case "visitor":
                    Member visitor;
                    System.out.println("Hello! Are you new here? (yes/no)");
                    String isNew = input.nextLine();
                    if (isNew.equals("yes")) {
                        visitor = register(members);

                    }
                    else if(isNew.equals("no")){
                        System.out.println("What is your full name?");
                        String name = input.nextLine();
                        System.out.println("What is your card ID?");
                        String id = input.nextLine();
                        visitor = findMember(members, name, id);
                        if (visitor == null) {
                            System.out.println("It seems you are not in our record. Do you wish to register? (yes/no)");
                            String toRegister = input.nextLine();
                            if(toRegister.equals("yes")){
                                visitor = register(members);
                            }
                            else{
                                break;
                            }

                        }
                    }
                    else{
                        System.out.println("Incorrect input");
                        break;
                    }

                    int browsing =1;
                    do {
                        System.out.println("Do you wish to browse a section or are you looking for a specific item?");
                        System.out.println("Type \"section\" to view the genres available or \"item\" to look for a book.");
                        String toSearch = input.nextLine();
                        List<LibraryItem> itemsFound = new ArrayList<>();
                        if (toSearch.equals("section")) {
                            System.out.println("Please choose from the following genres:");
                            List<String> genres = new ArrayList<>();
                            for( LibraryItem item: items){
                                String genre = item.getSection();
                                if(!genres.contains(genre)){
                                    genres.add(genre);
                                }
                            }
                            for( String genre: genres){
                                System.out.println(genre);
                            }

                            String section = input.nextLine();
                            itemsFound = visitor.search(items, "", "", section);
                            for (LibraryItem item : itemsFound) {
                                System.out.println(item.getTitle() + " " + item.getAuthor() + " ISBN: "+ item.getISBN());
                                System.out.println(item.findLocation());
                                System.out.println();
                            }
                            if(itemsFound.isEmpty()){
                                System.out.println("No items were found");
                            }
                        } else if (toSearch.equals("item")){
                            System.out.println("What is the title of the book? (First letter should be uppercase)");
                            System.out.println("Type \"unknown\" if you don't know");
                            String titleBook= input.nextLine();
                            if(titleBook.equals("unknown")) titleBook="";
                            System.out.println("Who is the author of the book? (Type \"unknown\" if you don't know)");
                            String authorBook = input.nextLine();
                            if(authorBook.equals("unknown")) authorBook="";
                            itemsFound = visitor.search(items, titleBook, authorBook, "");
                            for (LibraryItem item : itemsFound) {
                                System.out.println(item.getTitle() + " " + item.getAuthor() + " ISBN: " + item.getISBN());
                                System.out.println(item.findLocation());
                                System.out.println();
                            }
                            if(itemsFound.isEmpty()){
                                System.out.println("No items were found");
                            }
                        }


                        System.out.println("Do you wish to borrow one of the items you've seen? (yes/no)");
                        String toBorrow = input.nextLine();
                        if(toBorrow.equals("yes")){
                            System.out.println("Please type the ISBN of the item");
                            String isbn = input.nextLine();
                            LibraryItem itemToBorrow = null;
                            while(itemToBorrow == null) {
                                for (LibraryItem item : itemsFound) {
                                    if (item.getISBN().equals(isbn)) itemToBorrow = item;
                                }
                                if(itemToBorrow == null){
                                    System.out.println("Wrong ISBN. Please type it again.");
                                    isbn = input.nextLine();
                                }
                            }

                            String result = visitor.borrow(itemToBorrow);
                            System.out.println(result);
                            if(result.equals("Item can't be borrowed")){
                                System.out.println("Do you want to read it in the library? (yes/no)");
                                String readInLibrary = input.nextLine();
                                if(readInLibrary.equals("yes")) {
                                    visitor.readingInLibrary(itemToBorrow);
                                    System.out.println("Please type \"done\" when you're finished");
                                    String done = input.nextLine();
                                    visitor.finishedReading(itemToBorrow);
                                }
                            }
                        }


                        System.out.println("Do you wish to browse again? (yes/no)");
                        String toBrowse = input.nextLine();
                        if(!toBrowse.equals("yes")) browsing = 0;

                    }while(browsing == 1);


                    break;

                case "add book":
                    System.out.println("What is it? (book/document)");
                    String itemToAdd = input.nextLine();
                    System.out.println("What is the title of the book?");
                    String titleBook = input.nextLine();
                    System.out.println("What is the author's name?");
                    String authorBook = input.nextLine();
                    //get publication date here
                    System.out.println("What format is it in? (physical/digital/audio)");
                    String formatBook = input.nextLine();
                    System.out.println("What genre is it?");
                    String genreBook = input.nextLine();
                    addBook(items, itemToAdd, titleBook, authorBook, formatBook, genreBook);

                    for(LibraryItem item : items){
                        System.out.println(item.getTitle() + "; format: " + item.getFormat() + "; copies: " + item.getCopiesAvailable());
                    }
                    break;

                case "leave":
                    terminate = 1;
                    break;

            }

        }




    }


    public static Member findMember(List<Member> members, String name, String id){
        for(Member visitor : members){
            if(visitor.getName().equals(name) && visitor.getCardID().equals(id))
                return visitor;
        }

        return null;
    }

    public static String generateID(){
        String id = "";
        for(int i=0; i<7; i++){
            Random r = new Random();
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

    public static Member register(List<Member> members){
        Scanner input = new Scanner(System.in);
        System.out.println("What is your full name?");
        String name = input.nextLine();
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
    }

    public static void addBook(List<LibraryItem> items, String itemToAdd, String title, String author, String format, String section){
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
                List<String> references = new ArrayList<>();
                Scanner input = new Scanner(System.in);
                System.out.println("Do you want to add a reference? (yes/no)");
                String addRef = input.nextLine();
                while (addRef.equals("yes")){
                    System.out.println("Please type in the reference");
                    String ref = input.nextLine();
                    references.add(ref);
                    System.out.println("Do you want to add another reference? (yes/no)");
                    addRef = input.nextLine();
                }
                newItem = new Document(title, author, null, generateID(), Boolean.TRUE, format, section, 1, 1, 0, references);
                items.add(newItem);
            }
            else {
                System.out.println("Can't recognize type");
            }
        }
    }
}
