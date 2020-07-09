package com.jackmccabe.model;


public class Book {
    private int bookId;
    private String title;
    private Double priceOfBook;
    private int YearReleased;


    public Book(int bookId, String title, Double priceOfBook, int yearReleased) {
        this.bookId = bookId;
        this.title = title;
        this.priceOfBook = priceOfBook;
        YearReleased = yearReleased;
    }

    public String getTitle() {
        return title;
    }

    public Double getPriceOfBook() {
        return priceOfBook;
    }
    public int getYearReleased() {
        return YearReleased;
    }

    public int getBookId() {
        return bookId;
    }

    @Override
    public String toString() {
        return
                "ID: " + bookId +
                " \tTitle: '" + title + '\'' +
                " Price: £" + String.format("%.2f",priceOfBook) +
                " Published: " + YearReleased;
    }


}
