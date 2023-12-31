package com.example.Hospital;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorPreventforAddMenu {
    
    private String nameFormatter(Object[] storedData) {
        String nameString = storedData[1].toString();
        String[] wordSeparated = nameString.split("\\s+");
        StringBuilder result = new StringBuilder();
    
        for (String word : wordSeparated) {
            if (!word.isEmpty() && !word.isBlank()) {
                String formattedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                result.append(formattedWord).append(" ");
            } else {
                System.out.println("Invalid Name");
            }
        }
    
        System.out.println(result.toString().trim());
        return result.toString().trim();
    }
    

    public void getNameFormatter(Object[] Data){
        nameFormatter(Data);
    }
}
  

