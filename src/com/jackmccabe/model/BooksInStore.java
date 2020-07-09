package com.jackmccabe.model;

import com.jackmccabe.model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BooksInStore {

    //Hard coded the list of books alternative method would have in excel or database and read in.
    private static final List<Book> ALL_BOOKS = Arrays.asList(
            new Book(1,"Moby Dick", 15.20, 1851),
            new Book(2, "The Terrible Privacy of Maxwell Sim", 13.14, 2010),
            new Book(3, "Still Life With Woodpecker", 11.05, 1980),
            new Book(4, "Sleeping Murder", 10.24, 1976),
            new Book(5,"Three Men in a Boat", 12.87, 1889),
            new Book(6, "The Time Machine", 10.43, 1895),
            new Book(7, "The Caves of Steel", 8.12, 1954),
            new Book(8, "Idle Thoughts of an Idle Fellow", 7.32, 1886),
            new Book(9, "A Christmas Carol", 4.23,1843),
            new Book(10, "A Tale of Two Cities", 6.32, 1859),
            new Book(11, "Great Expectations", 13.21,1861)
    );

    public void displayAllBooks(){
        for (Book book: ALL_BOOKS){
            System.out.println(book.toString());
        }
    }

    private void displayAllBooksInList(ArrayList<Book> books){
        for (Book book: books){
            System.out.println(book.toString());
        }
    }

    private Book findBookById(int id){
        for (Book book: ALL_BOOKS) {
            if (book.getBookId() == id){
                return book; //If id inputted matches return that book
            }
        }
        return null;
    }

    public List<Book> addingBookToNewList(){
        ArrayList<Book> checkoutBooks = new ArrayList<>();
        boolean advanceToCheckout = false;

        while (advanceToCheckout != true){
            System.out.println("Please Enter the ID of the Book you want to Buy: ");
            Scanner userInput = new Scanner(System.in);

            try {
                int input = userInput.nextInt(); //User to input the ID of the book they want
                if (input != 0) {
                    checkoutBooks.add(findBookById(input));
                }

                System.out.println("Your Current Basket: ");
                displayAllBooksInList(checkoutBooks);
                System.out.println("Type 0 to go to Checkout ");

                if (input == 0) {
                    if (checkoutBooks.isEmpty()) {
                        System.out.println("Please add to basket");
                    } else {
                        advanceToCheckout = true;
                    }
                }

            } catch (Exception e){
                System.out.println("Please type in a Correct ID");
            }
        }

        System.out.println("The total price is £" +
                String.format("%.2f",new BusinessLogic().getPriceOfAListOfBooks(checkoutBooks, 30, 0.95)));

        return checkoutBooks; //Returns the list of Books
    }

    //Extra feature for future use to search all books if to deploy as web app
    public List<Book> searchForBooks(String search){
        List<Book> books = new ArrayList<>();
        for (Book book: ALL_BOOKS) {
            if (book.getTitle().toLowerCase().contains(search)){
                books.add(book);
            }
        }
        return books;
    }


}
