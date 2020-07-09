package com.jackmccabe.view;

import com.jackmccabe.model.BooksInStore;

public class Interface {

    public void welcomeMessage(){
        System.out.println("Welcome to the Bookshop \n" +
                            "Here is the list of our Books");
        new BooksInStore().displayAllBooks();
        new BooksInStore().addingBookToNewList();
    }
}
