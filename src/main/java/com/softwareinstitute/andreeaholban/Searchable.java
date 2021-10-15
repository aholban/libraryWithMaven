package com.softwareinstitute.andreeaholban;

import java.util.ArrayList;
import java.util.List;

public interface Searchable {

    default List<LibraryItem> search(List<LibraryItem> items, String title, String author, String section){
        List<LibraryItem> itemsFound = new ArrayList<LibraryItem>();
        for(LibraryItem item : items){
            if(!title.equals("") && author.equals("") && section.equals("")){
                if(item.getTitle().equals(title)) itemsFound.add(item);
            }
            else if(!title.equals("") && !author.equals("")){
                if(item.getTitle().equals(title) && item.getAuthor().equals(author)) itemsFound.add(item);
            }
            else if(title.equals("") && !author.equals("")){
                if(item.getAuthor().equals(author)) itemsFound.add(item);
            }
            else if(title.equals("") && author.equals("") && !section.equals("")) {
                if(item.getSection().equals(section)) itemsFound.add(item);
            }
        }

        return itemsFound;
    };
}
