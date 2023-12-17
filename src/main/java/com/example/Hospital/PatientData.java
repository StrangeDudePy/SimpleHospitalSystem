package com.example.Hospital;
import java.util.Date;

public class PatientData {
    protected String id,patientname;
    protected int patientno;
    protected Date appointmentDate ;
       PatientData(String  id,String patientname,int patientno,Date appointdate){
        this.id = id;
        this.patientname = patientname;
        this.patientno = patientno;
        this.appointmentDate = appointdate;

    }
}
