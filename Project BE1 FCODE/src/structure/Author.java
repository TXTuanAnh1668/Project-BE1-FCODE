/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import input.Tools;
import java.io.Serializable;
import manager.AuthorList;

/**
 *
 * @author TAN
 */
public class Author implements Serializable {
    private String nameAuthor; 
    private String authorID; 
    
    public Author(){
        this.nameAuthor = "";
        this.authorID = "";
    }

    public Author(String name, String authorID) {
        this.nameAuthor = name;
        this.authorID = authorID;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }
    
    public void addAuthor (){
        boolean condition = true; 
        do{
            try{
                authorID = Tools.inputString("Enter the ID of Author: "); 
                if (authorID.equals("") || AuthorList.getAuthorByID(authorID) != null)
                    throw new Exception(); 
                condition = false; 
            }catch (Exception e){
                System.out.println ("ID of author already exist, add another ID: ");
                condition = true; 
            }
        }while (condition); 
        
        do {
            try{
                nameAuthor = Tools.inputString("Enter the name of author: ");
                if (nameAuthor.equals("") || AuthorList.getAuthorByName(authorID, nameAuthor) != null)
                    throw new Exception(); 
                condition = false; 
            }catch (Exception e){
                System.out.println("Author already exist add another author: "); 
                condition = true;
            }
        }while (condition); 
    }
    
    public void printAuthor(){
        System.out.println ("Author ID:  "+authorID); 
        System.out.println ("Author name: "+nameAuthor); 
    }
    
}
