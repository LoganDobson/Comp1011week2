package com.example.comp1011week2;

import java.util.Arrays;
import java.util.List;

/**
 * this is our model
 */
public class Book {
    private int bookID;
    private String bookName, author,genre;
    private double price;
    private boolean isAvailable;

    //constructor


    public Book(int bookID, String bookName, String author,String genre ,double price, boolean isAvailable) {
        setBookID(bookID);
        setBookName(bookName);
        setAuthor(author);
        setGenre(genre);
        setPrice(price);
        setAvailable(isAvailable);

    }

    //getters and setters


    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        if (bookID <= 0) {
            throw new IllegalArgumentException("bookID cannot be less than 0");
        }
        else
            this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        if (bookName.isEmpty()){
            throw new IllegalArgumentException("name cannot be null");
        }
        else
            this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author.isEmpty()){
            throw new IllegalArgumentException("author cannot be null");
        }
        else
            this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        List<String> validGenres = Arrays.asList("Drama", "Thriller", "Fantasy", "Crime", "Comedy");
        if (validGenres.contains(genre)){
            this.genre = genre;
        }
        else
            throw new IllegalArgumentException("genre must be in the list " + validGenres);

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 250 && price >= 1 )
            this.price = price;
        else
            throw new IllegalArgumentException("price must be within 1 and 250 dollars");
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return bookID + ": the price of " + bookName + " written by "+ author +
                " is $" + price + ". Availability " + (isAvailable?"yes":"no");
    }
}
