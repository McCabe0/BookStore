package com.jackmccabe.model;

import com.jackmccabe.model.Book;
import com.jackmccabe.model.BooksInStore;

import java.util.ArrayList;

public class BusinessLogic {

    //Method to get the price of a given list of Books
    public double getPriceOfAListOfBooks(ArrayList<Book> books, int discountOverPrice, double discountAmount){
        double totalPrice = 0;
       for (Book book: books){
           totalPrice = totalPrice + applyDiscountToBooks(book, 0.90, 2000);
       }
       if (totalPrice > discountOverPrice){
           totalPrice = totalPrice * discountAmount;
       }
        return Math.floor(totalPrice * 100.00) / 100.00; //Rounds to two decimal places down
    }

    //Apply the Discount with the ability to change the amount and publish year
    private double applyDiscountToBooks(Book book, double discount, int publishYear){
        double discountPrice = book.getPriceOfBook();
        if (book.getYearReleased() > publishYear){
            return book.getPriceOfBook() * discount;
        }
        return discountPrice;
    }



}
