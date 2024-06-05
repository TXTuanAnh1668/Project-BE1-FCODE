/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import structure.Author;

/**
 *
 * @author TAN
 */
public class AuthorList {
    public static ArrayList<Author> authors = new ArrayList<>(); 
    public static Author getAuthorByID (String authorID){
        for(Author author : authors){
            if (author.getAuthorID().equals(authorID))
                return author; 
        }
        return null; 
    }
    
    public static Author getAuthorByName (String authorID, String authorName){
        for (Author author :authors){
            if (author.getNameAuthor().equals(authorName))
                if (author.getAuthorID().equals(authorID))
                return author; 
        }
        return null; 
    }
    
    public void loadAuthorInformationFromFile() {
        String fileNameOfBook = "author.dat";
        try {
            File f = new File(fileNameOfBook); //checking the file
            if (!f.exists()) return;
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            Author a;
            while ((a = (Author)fo.readObject()) != null) {                
                authors.add(a);
            }
            fo.close(); fi.close();
        } catch (Exception e) {
        }
    }
    
    public void printAllAuthor() {
        for (Author author : authors) {
            author.printAuthor();
        }
    }
}
