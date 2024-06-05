/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import input.Tools;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import structure.Author;
import structure.Book;

/**
 *
 * @author TAN
 */
public class BookList {
    public static ArrayList<Book> books = new ArrayList<>(); 
    public Scanner scanner = new Scanner (System.in);
    
    public boolean addNewBook (Book informationBook){
        return books.add(informationBook); 
    }
    public static Book getBookByISBN (String ISBN){
        for (Book book : books){
            if (book.getISBN().equals(ISBN)){
             return book;   
            }
        }
        return null;
    }
    public static Book getBookByID (String ID){
        for (Book book : books){
            if (book.getBookID().equals(ID)){
                return book;
            }
        }
        return null;
    }
    
    public void printListofBook (){
        for (Book book : books){
            book.showBook();
        }
    }
    
    public void updateBookByID (String bookID){
        Scanner sc = new Scanner (System.in); 
        Author author = new Author(); 
        boolean condition = true; 
        if (getBookByID(bookID) == null){
            System.out.println ("Book does not exist"); 
        }
        else {
            Book updateBook = getBookByID(bookID); 
            System.out.print ("Update ISBN: "); 
            do{
                try{
                    updateBook.setISBN(sc.nextLine()); 
                    if (updateBook.getISBN().equals("") & getBookByISBN(updateBook.getISBN()) != null)
                        throw new Exception(); 
                    condition = false; 
                }catch (Exception e){
                    System.out.println ("Add another book's ISBN: "); 
                    condition = true; 
                }
            }while (condition);
            
            System.out.print("Update book's ID: ");
            do{
                try{
                    sc = new Scanner (System.in); 
                    updateBook.setBookID(sc.nextLine());
                    if (updateBook.getBookID().equals("") & getBookByID(updateBook.getBookID()) != null)
                        throw new Exception(); 
                    condition = false; 
                }catch (Exception e){
                    System.out.println ("Add another book's ID: "); 
                    condition = true; 
                }
            }while (condition); 
            
            System.out.print ("Update title: "); 
            do{
                try{
                    sc = new Scanner (System.in); 
                    updateBook.setTitle(sc.nextLine());
                    if (updateBook.getTitle().equals(""))
                        throw new Exception(); 
                    condition = false; 
                }catch(Exception e){
                    System.out.println ("Add another title: "); 
                    condition = true;
                }
            }while(condition); 
            
            do{
                try{
                    sc = new Scanner (System.in); 
                    updateBook.setPrice(sc.nextDouble());
                    if (updateBook.getPrice() <= 0)
                        throw new Exception(); 
                    condition = false; 
                }catch (Exception e){
                    System.out.println ("Invalid price, add another price: "); 
                    condition = true; 
                }
            }while (condition); 
            
            System.out.println ("Update Author: "); 
            author.addAuthor();
            updateBook.setAuthor(author);
            System.out.println ("Book's information after updated are: ");
            updateBook.showBook(); 
            System.out.println ("Update success"); 
        }
    }
    
    public int addStatusYesNo(){
        int statusYesNo = 0; 
        boolean condition = true; 
        Scanner sc = new Scanner (System.in); 
        System.out.println ("1. Yes"); 
        System.out.println ("2. No"); 
        System.out.println ("Your Choice: "); 
        do{
            try{
                sc = new Scanner (System.in); 
                statusYesNo = sc.nextInt(); 
                if (statusYesNo != 1 && statusYesNo != 2){
                throw new Exception();
            }
                condition = false; 
            }catch (Exception e){
                System.out.println ("Just choose 1 or 2: "); 
                condition = true; 
            }
        }while (condition); 
        return statusYesNo; 
    }
    
    public boolean deleteBookByID(String bookID) {
        int statusYesNo;
        Book book = getBookByID(bookID);
        
        if (book != null) {
            System.out.println("Found book's ID in list.");
            System.out.println("Are you sure to remove the book with this ID?");
            statusYesNo = addStatusYesNo();
            
            if (statusYesNo == 1) {
                books.remove(book);
            return true;
            } else return false;
        } else return false;
    }
    
    public Book getBookByText(String text) {
        for (Book bookInformation : books) {
            if (bookInformation.getTitle().contains(text))
                return bookInformation;
        } 
        return null;
    }
    
    public void searchAllBookByText(String text) {
        if (getBookByText(text) == null) System.out.println("No book is matched!");
        else {
            System.out.println("Book that have the text are:");
            for (Book book : books) {
                if (book.getTitle().contains(text))
                    book.showBook();
            }
        }
    }
    
    public Book getBookByAuthorName(String text) {
        for (Book bookInformation : books) {
            if (bookInformation.getAuthor().getNameAuthor().equals(text))
                return bookInformation;
        } 
        return null;
    }
    
    public void searchAllBookByAuthorName(String text) {
        if (getBookByAuthorName(text) == null) System.out.println("No book is matched!");
        else {
            System.out.println("Books that have this author name are:");
            for (Book bookInformation : books) {
                if (bookInformation.getAuthor().getNameAuthor().equals(text))
                    bookInformation.showBook();
            }
        }
    }
    
    public boolean checkListEmpty() {
        if (books.isEmpty()) {
            System.out.println("No element!");
        return true;
        } else return false;
    }
    
    public void loadDataFromFile() {
        String fileNameOfBook = "book.dat";
        try {
            File f = new File(fileNameOfBook); //checking the file
            if (!f.exists()) return;
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            Book b;
            while ((b = (Book)fo.readObject()) != null) {                
                addNewBook(b);
            }
            fo.close(); fi.close();
        } catch (Exception e) {
        }
    }
    
    public void storeDataToFile() {
        String fileNameOfBook = "book.dat";
        try {
            FileOutputStream f = new FileOutputStream(fileNameOfBook);
            ObjectOutputStream fo = new ObjectOutputStream(f);
            for (Book bookInformation : books) fo.writeObject(bookInformation);
            fo.close(); f.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Store data to file success!");
    }
    
    public void storeAuthorInformationToFile() {
        String fileNameOfAuthor = "author.dat";
        try {
            FileOutputStream f = new FileOutputStream(fileNameOfAuthor);
            ObjectOutputStream fo = new ObjectOutputStream(f);
            for (Book bookInformation : books) fo.writeObject(bookInformation.getAuthor());
            fo.close(); f.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Store author information to file success!");
    }
    
    public String addId() {
        boolean condition = true;
        String id = "";
        do {
            try {
                id = Tools.inputString("Add ID: ");
                if (id.equals(""))
                    throw new Exception();
                condition = false;
            } catch (Exception e) {
                System.out.print("Add another ID: ");
                condition = true;
            }
        } while (condition);
        return id;
    }
    
    
    
   
    
    
}


