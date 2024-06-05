/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import input.Tools;
import java.io.Serializable;
import java.util.Scanner;
import manager.BookList;

/**
 *
 * @author TAN
 */
public class Book implements Serializable {
    private String ISBN; 
    private String title; 
    private double price; 
    private Author author; 
    private String bookID; 
    
    

    public Book (){
        ISBN = ""; 
        title = ""; 
        price = 0; 
        author = new Author();
        bookID = ""; 
    }

    public Book(String ISBN, String title, double price, Author author, String bookID) {
        this.ISBN = ISBN;
        this.title = title;
        this.price = price;
        this.author = author;
        this.bookID = bookID;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public Author getAuthor() {
        return author;
    }

    public String getBookID() {
        return bookID;
    }

    

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }    
    
    public void addBook (){
        Scanner sc = new Scanner (System.in); 
        boolean condition = true; 
        do{
            try{
               ISBN = Tools.inputStringISBN("Enter ISBN of the book: "); 
               if (ISBN.equals("") || BookList.getBookByISBN(ISBN) != null)
                   throw new Exception(); 
               condition = false; 
            }catch (Exception e){
                System.out.println ("Book with this ISBN already exist, add another ISBN: "); 
                condition = true; 
            }
        }while (condition);
        
        do{
            try{
                bookID = Tools.inputString("Add the ID book: "); 
                if (bookID.equals("") || BookList.getBookByID(bookID) != null)
                    throw new Exception(); 
                condition = false;
            }catch (Exception e){
             System.out.println ("Book with this ID already exist, add another ID: "); 
             condition = true; 
            }
        }while (condition); 
        
        title = Tools.inputString("Enter the title of the book: ");
        if (title.equals(""))
            getTitle();
        
        do {
            try{
                price = Tools.inputDouble("Enter the price of the book: "); 
                if (price < 0)
                    throw new Exception(); 
                condition = false;
            }catch (Exception e){
                System.out.println("Invalid price, add another price: ");
                condition = true; 
            }
        }while (condition); 
        
        author.printAuthor(); 
    }
    
public void showBook(){
    System.out.println ("ISBN: "+ISBN); 
    System.out.println ("Id Book: "+bookID);      
    System.out.println ("Title: "+title);
    System.out.println ("Price: "+price);
    author.printAuthor(); 
}
    
    
    
}

