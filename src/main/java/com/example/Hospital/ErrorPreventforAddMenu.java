package com.example.Hospital;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;

public class ErrorPreventforAddMenu  {
    private static AddButton aButton = new AddButton();
    private static String EURL="jdbc:sqlite:Databases/Patients.db";
    private static String DateQuerry = "SELECT  AppointDate FROM PatientsInfo WHERE AppointDate=?";
    private static String TimeQuerry = "SELECT AppointTime FROM PatientsInfo WHERE AppointTime=? ";
    private String nameFormatter(Object[] storedData) {
        String nameString = storedData[1].toString();
        String[] wordSeparated = nameString.split("\\s+");
        StringBuilder result = new StringBuilder();
    
        for (String word : wordSeparated) {
            if (!word.isEmpty() && !word.isBlank()) {
                String formattedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                result.append(formattedWord).append(" ");
            
            } else {
                break;
            }
        }
    
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

    private boolean isTimeOkey(){
        boolean timeOK= false;
        String timeString = aButton.getTimeFormatter();
        try {
            
            try (Connection conn = DriverManager.getConnection(EURL)) {
    
                try (PreparedStatement TimeStatement = conn.prepareStatement(TimeQuerry)) {


                    TimeStatement.setString(1,timeString);
    
                    try (ResultSet rT = TimeStatement.executeQuery()) {
                        
                        if(rT.next()){
                            return timeOK;
                        }

                        else{
                            timeOK=true;
                            return timeOK;
                        }
                        
                    }
                }
            }
    
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            return timeOK;
        }
    }

    public boolean getTimeOkMethod(){
        return isTimeOkey();
    }

    private void CheckEverything(Object[] id ,Object[] phonenumber ,Object[] date,Object[] name,String time){
            Object Checks[][] = {{false,"ID"},{false,"Phone Number"},{false,"Appointment Date"},{false,"Appointment Time"}};
            Checks[0][0]=(Boolean) IsIdlegit(id);
            Checks[1][0]=(Boolean) IsPhoneLegit(phonenumber);
            Checks[2][0]=(Boolean) isDateAvaliable(date);
            Checks[3][0]=(Boolean) isTimeOkey();
            
            String errMessage="";
            for(int i = 0 ; i <= 3  ;i++){
                if(!(Boolean) Checks[i][0]){
                String currentError= Checks[i][1].toString();
                if(i==0){
                    errMessage += " " +currentError;
                }
                else{
                    errMessage += "-" + currentError;
                }
              
                }
                
            }
            
            if(nameFormatter(name).isEmpty() || nameFormatter(name).isBlank()){
                    errMessage += "-Name";
                }
       
            System.out.println("Invalid"+ errMessage );

          
            
           
            
    }

    public void getCheckMethod(Object[] id ,Object[] phonenumber ,Object[] date,Object[] name ,String time ){
        CheckEverything(id,phonenumber,date,name,time);
    }
    
  
}
