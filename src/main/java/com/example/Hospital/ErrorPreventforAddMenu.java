package com.example.Hospital;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ErrorPreventforAddMenu  {
    private static AddButton aButton = new AddButton();
    private static String EURL="jdbc:sqlite:Databases/Patients.db";
    private static String DateQuerry = "SELECT  AppointDate,AppointTime FROM PatientsInfo WHERE AppointDate=? AND AppointTime=?";
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

  
    

    public String getNameFormatter(Object[] Data){
        return nameFormatter(Data);
    }

    private  boolean isNumeric(String str) {
        
        return str.matches("\\d+");
    }

    public static boolean containsNumeric(String input) {
        return input.matches(".*\\d.*");
    }


    private boolean isNameLegit(Object[] nameData){
        boolean namelegit=false;
        if (containsNumeric(nameFormatter(nameData))){
            return namelegit;
        }

        else if(containsNumeric(nameFormatter(nameData))==false) {
            namelegit=true;
            return namelegit;
        }

        else{
            System.out.println("Unknown Error");
            return namelegit;
        }
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


    public boolean getNameLegitMethod(Object[] name_data){
        return isNameLegit(name_data);
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



   private boolean isDateAvaliable(Object[] D_Data) {
    boolean dateOK = false;
    String dateString = D_Data[3].toString();
    String timeString = aButton.getTimeFormatter();

    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = dateFormat.parse(dateString);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        try (Connection connection = DriverManager.getConnection(EURL)) {

            try (PreparedStatement DateStatement = connection.prepareStatement(DateQuerry)) {
                DateStatement.setDate(1, sqlDate);
                DateStatement.setString(2, timeString);

                try (ResultSet rD = DateStatement.executeQuery()) {
                    if (rD.next()) {
                        // Date and time are already in the database
                        return dateOK;
                    } else {
                        // Date and time are available
                        dateOK = true;
                        return dateOK;
                    }
                }
            }
        }
    } catch (ParseException | SQLException e) {
        System.out.println("Exception: " + e.getMessage());
        return dateOK;
    }
}


    public boolean getDateOkMethod(Object[] date_data){
        return isDateAvaliable(date_data);
    }

   

    private boolean CheckEverything(Object[] id ,Object[] phonenumber ,Object[] date,Object[] name){
            Object Checks[][] = {{false,"ID(Must be 8 numerical digits)"},{false,"Phone Number(Must be 12 numerical digits)"},{false,"Appointment Date-Time(The selected date already booked)"},{false,",ID Already Exist"}};
            Checks[0][0]=(Boolean) IsIdlegit(id);
            Checks[1][0]=(Boolean) IsPhoneLegit(phonenumber);
            Checks[2][0]=(Boolean) isDateAvaliable(date);
            Checks[3][0] =(Boolean) isIdExist(id);
            boolean everythingfine=true;
            
            String errMessage="<html>";
            int numberoferrors=0;
            for(int i = 0 ; i <= 3  ;i++){
                if(!(Boolean) Checks[i][0]){
                String currentError= Checks[i][1].toString();
                numberoferrors++;
                errMessage += "Invalid " +  currentError + "<br>" ;
                
    
                
            }
            
             }
            if(nameFormatter(name).isEmpty() || nameFormatter(name).isBlank()|| isNameLegit(name)==false){
                    errMessage += "Invalid Name(Name not entered and can't contain any numerical character)";
                    numberoferrors++;
                    everythingfine =false;
                    
                }

            if(numberoferrors!=0){
                JFrame alertfFrame = new JFrame();
                JOptionPane.showMessageDialog(alertfFrame, errMessage+"<br>"+ "(Also Check whitespaces)" + "</html>");
                everythingfine=false;
            }
            
            else if (numberoferrors==0){
                everythingfine = true;
                return everythingfine;
            }

           
            return everythingfine;

            

          
            
           
            
   

    }
    public void getCheckMethod(Object[] id ,Object[] phonenumber ,Object[] date,Object[] name ){
       CheckEverything(id,phonenumber,date,name);
    }

    public boolean returnCheckMethod(Object[] id ,Object[] phonenumber ,Object[] date,Object[] name ){
         return  CheckEverything(id,phonenumber,date,name);
    }


    private boolean isIdExist(Object[] Data){
        boolean idavaliable=true;
        try (Connection connection = DriverManager.getConnection(EURL)) {
            String idmatchquerry = "SELECT ID FROM PatientsInfo WHERE ID = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(idmatchquerry)) {
                preparedStatement.setString(1, Data[0].toString());

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        idavaliable=false;
                        
                    } else {
                        idavaliable=true;
                    
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idavaliable;
    }
    
  
}
