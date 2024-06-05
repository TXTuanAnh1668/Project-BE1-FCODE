/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workwithfile;

import chooses.Menu;
import input.Tools;
import java.util.Scanner;
import manager.AuthorList;
import manager.BookList;
import structure.Book;


/**
 *
 * @author TAN
 */
public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean condition = true;
        
        BookList list = new BookList();
        AuthorList list1 = new AuthorList();
        Menu my = new Menu (); 
        list1.loadAuthorInformationFromFile();
        //ListOfAuthor.loadAuthorInformationFromFile();
        do{
            my.newMenu();
            choice = Tools.inputInt("Enter your choice: "); 
            switch (choice){
                case 1:
                    if (list.checkListEmpty()) {
                    } else list.printListofBook();
                    break;
            
                case 2: 
                    int statusYesNo;
                    
                    Book bookInformation = new Book();
                    bookInformation.addBook();
                    
                    if (list.addNewBook(bookInformation)) {
                        System.out.println("Added success!");
                        System.out.println("Continue adding another book?");
                        statusYesNo = list.addStatusYesNo();
                        
                        //Kiểm tra xem người dùng chọn nhập tiếp sách khác hay quay lại menu chính
                        while (statusYesNo == 1) {                            
                            Book bookInformation1 = new Book();
                            bookInformation1.addBook();
                            if (list.addNewBook(bookInformation1)) {
                                System.out.println("Added success!");
                                System.out.println("Continue adding another book?");
                                statusYesNo = list.addStatusYesNo();
                            }
                        }
                    }
                    else System.out.println("Added fail!");
                    break;
                case 3: 
                    int statusYesNo1;
                    
                    if (list.checkListEmpty()) {
                    } else {
                        String IDUpdate = "";

                        System.out.print("Add ID of book that you want to update: ");
                        IDUpdate = list.addId();
                        
                        list.updateBookByID(IDUpdate);
                            
                        System.out.println("Continue updating another book?");
                        statusYesNo1 = list.addStatusYesNo();

                        //Kiểm tra xem người dùng chọn update tiếp sách khác hay quay lại menu chính
                        while (statusYesNo1 == 1) {                            
                            System.out.print("Add ID of book that you want to update: ");
                            IDUpdate = list.addId();

                            list.updateBookByID(IDUpdate);

                            System.out.println("Continue updating another book?");
                            statusYesNo1 = list.addStatusYesNo();
                        }
                    }
                    break;
                case 4: 
                    int statusYesNo2;
                    
                    if (list.checkListEmpty()) {
                    } else {
                        String IDDelete = "";
                        System.out.print("Add ID of book that you want to delete: ");
                        IDDelete = list.addId();
                        
                        if (list.deleteBookByID(IDDelete)) {
                            System.out.println("Deleted success!");
                            
                            System.out.println("Continue deleting another book?");
                            statusYesNo2 =  list.addStatusYesNo();

                            if (list.checkListEmpty()) {
                            } else {
                                while (statusYesNo2 == 1) {                            
                                    System.out.print("Add ID of book that you want to delete: ");
                                    IDDelete = list.addId();

                                    if (list.deleteBookByID(IDDelete)) {
                                        System.out.println("Deleted success!");
                                        System.out.println("Continue deleting another book?");
                                        statusYesNo2 = list.addStatusYesNo();
                                    } else System.out.println("Deleted fail!");
                                }
                            }
                        }
                        else System.out.println("Deleted fail!");
                    }
                    break;
                case 5: 
                     if (list.checkListEmpty()) {
                    } else {
                        String text = "";
                        int statusYesNo3;

                        System.out.print("Add text you want to search from the name of the book that contains: ");
                        do {
                            try {
                                sc = new Scanner(System.in);
                                text = sc.nextLine();
                                if (text.equals(""))
                                    throw new Exception();
                                condition = false;
                            } catch (Exception e) {
                                System.out.print("Add another text: ");
                                condition = true;
                            }
                        } while (condition);

                        list.searchAllBookByText(text);
                        
                        System.out.println("Continue searching another book?");
                        statusYesNo3 = list.addStatusYesNo();
                        
                        while (statusYesNo3  == 1) {                            
                            System.out.print("Add text you want to search from the name of the book that contains: ");
                            do {
                                try {
                                    sc = new Scanner(System.in);
                                    text = sc.nextLine();
                                    if (text.equals(""))
                                        throw new Exception();
                                    condition = false;
                                } catch (Exception e) {
                                    System.out.print("Add another text: ");
                                    condition = true;
                                }
                            } while (condition);

                            list.searchAllBookByText(text);
        
                            System.out.println("Continue searching another book?");
                            statusYesNo3 = list.addStatusYesNo();
                        }
                    }
                    break;
                case 6: 
                     if (list.checkListEmpty()) {
                    } else {
                        list.storeDataToFile();
                    }
                    break;
                case 7: 
                    System.out.println ("Good bye"); 
                    break;
            }
            
        }while (choice > 0 && choice < 8); 
    }
}

        
        