/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import structure.Book;

/**
 *
 * @author TAN
 */
public class Tools {
    
    public static int inputInt (String mess){
        Scanner sc = new Scanner (System.in);
        int result; 
        System.out.println(mess); 
        result = sc.nextInt(); 
        return result;
    }
    
    public static long inputLong (String mens){
        Scanner sc = new Scanner (System.in); 
        long result; 
        System.out.println (mens); 
        result = sc.nextLong(); 
        return result; 
    }
    
    public static float inputFloat (String mess){
        Scanner sc = new Scanner (System.in); 
        float result; 
        System.out.println (mess); 
        result = sc.nextFloat(); 
        return result; 
    }
    
    public static double inputDouble (String mess){
        Scanner sc = new Scanner (System.in); 
        System.out.println (mess); 
        double result = sc.nextDouble(); 
        return result; 
    }
    
    public static String inputString (String mens){
        String result = ""; 
        Scanner sc = new Scanner (System.in); 
        System.out.println(mens); 
        result = sc.nextLine(); 
        return result; 
    }
   
    
    
    public static String inputStringISBN (String mens) {
        String s; 
        Scanner sc = new Scanner (System.in);            
                String result = "[I][S][B][N] (97(8|9))?\\d{10}";
                System.out.println(mens); 
                s = sc.nextLine(); 
                if (!s.matches(result))
                     System.out.println ("Invalid ISBN format");
        return s; 
    }
    
    
    
    
}
