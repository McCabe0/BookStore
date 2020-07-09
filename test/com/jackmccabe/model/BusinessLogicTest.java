package com.jackmccabe.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BusinessLogicTest {

    private BusinessLogic businessLogic;
    private Book book;

    @BeforeEach
    void setUp() {

        businessLogic = new BusinessLogic();


    }
    @Test
    public void checkIfDiscountIsDisplayedToBooksPost2000(){
        book = new Book(2, "The Terrible Privacy of Maxwell Sim", 13.14, 2010);
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(book);

        double totalPrice = businessLogic.getPriceOfAListOfBooks(listOfBooks, 30, 0.95);
        double expected = Math.floor(book.getPriceOfBook() * 0.90 * 100.00) / 100.00;
        assertEquals(expected, totalPrice);

    }

    @Test
    public void checkIfDiscountIsNotAppliedToBooksPre2000(){
        book = new Book(3, "Still Life With Woodpecker", 11.05, 1980);
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(book);

        double totalPrice = businessLogic.getPriceOfAListOfBooks(listOfBooks, 30, 0.95);
        assertEquals(11.05, totalPrice);
    }

    @Test
    public void checkingIfPriceIsRightForTestCaseOne(){
        book = new Book(2, "The Terrible Privacy of Maxwell Sim", 13.14, 2010);
        Book bookTwo = new Book(5,"Three Men in a Boat", 12.87, 1889);

        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(book);
        listOfBooks.add(bookTwo);

        double totalPrice = businessLogic.getPriceOfAListOfBooks(listOfBooks, 30, 0.95);

        assertEquals(24.69, totalPrice);
    }

    @Test
    public void checkingIfPriceIsRightForTestCaseTwo(){
        book = new Book(3, "Still Life With Woodpecker", 11.05, 1980);
        Book bookTwo = new Book(5,"Three Men in a Boat", 12.87, 1889);
        Book bookThree = new Book(11, "Great Expectations", 13.21,1861);

        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(book);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);

        double totalPrice = businessLogic.getPriceOfAListOfBooks(listOfBooks, 30, 0.95);

        assertEquals(35.27, totalPrice);
    }
    @Test
    public void checkingIfPriceIsRightForTestCaseThree(){
        book = new Book(2, "The Terrible Privacy of Maxwell Sim", 13.14, 2010);
        Book bookTwo = new Book(5,"Three Men in a Boat", 12.87, 1889);
        Book bookThree = new Book(11, "Great Expectations", 13.21,1861);

        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(book);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);

        double totalPrice = businessLogic.getPriceOfAListOfBooks(listOfBooks, 30, 0.95);

        assertEquals(36.01, totalPrice);
    }



}