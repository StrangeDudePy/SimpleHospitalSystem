package com.example.Hospital;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;

public class ErrorPreventforAddMenu {
    private  static String EURL="jdbc:sqlite:Databases/Patients.db";
    private static String DateQuerry = "SELECT  AppointDate FROM PatientsInfo WHERE AppointDate=?";
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

    private boolean isNumeric(String str) {
        
        return str.matches("\\d+");
    }

    private boolean IsIdlegit(Object[] dataID){
        boolean idvalid = false;
        String idString = dataID[0].toString();
        String trimmedString = idString.trim();
        if(trimmedString.length()== 8 && isNumeric(idString)) {
            idvalid = true;
            return idvalid;
        }

        else {
            return idvalid;
        }


    }

    

    public boolean getIdMethod(Object[] Data){
        return IsIdlegit(Data);
        
    }

    private boolean IsPhoneLegit(Object[] DataP){
        boolean pvalid = false;
        String pString = DataP[2].toString();
        String trimmedpString = pString.trim();
        if(trimmedpString.length()== 12 && isNumeric(pString)) {
            pvalid = true;
            return pvalid;
        }

        else {
            return pvalid;
        }
    }

    public boolean getPhoneMethod(Object[] DataP_){
        return IsPhoneLegit(DataP_);
    }



    private boolean isDateAvaliable(Object[] D_Data){
        boolean dateOK= false;
        String DateString = D_Data[3].toString();
        try {
            
            try (Connection connection = DriverManager.getConnection(EURL)) {
    
                try (PreparedStatement DateStatement = connection.prepareStatement(DateQuerry)) {


                    DateStatement.setString(1,DateString);
    
                    try (ResultSet rD = DateStatement.executeQuery()) {
                        
                        if(rD.next()){
                            return dateOK;
                        }

                        else{
                            dateOK=true;
                            return dateOK;
                        }
                        
                    }
                }
            }
    
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            return dateOK;
        }
        
    }

    public boolean getDateOkMethod(Object[] date_data){
        return isDateAvaliable(date_data);
    }

  
}
