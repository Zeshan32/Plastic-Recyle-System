/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crs;


import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Zeeshan Mehboob
 */
public class Volunteer extends User {
  public static ArrayList<Document> alldocuments;
    private ArrayList<Application> allApplications;
    
    public Volunteer(String userName, String password, String fullName, long phoneno){
        super(userName, password, fullName, phoneno);
        
        setVolunter(new ArrayList<Document>());
        setSubmission(new ArrayList<Application>());
    }
    public Volunteer(String Document,Date date,Image image)
    {
        alldocuments.add(new Document(Document,date,image,this));
    }
    
    /**
     * @return the Material
     */
    public static ArrayList<Document> getdocuments(){
        return alldocuments;
    }

    /**
     * @param Material the Array List to set
     */
    public void setVolunter(ArrayList<Document> material){
            this.alldocuments = material;
    }

    /**
     * @return the Submission
     */
    public ArrayList<Application> getSubmission(){
        return allApplications;
    }

    /**
     * @param Submission the Array List to set
     */
    public void setSubmission(ArrayList<Application> submission){
        this.allApplications = submission;
    }

     public String toString(){
       return super.toString();
        
    }
}
