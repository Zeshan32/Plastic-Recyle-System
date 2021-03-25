/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crs;

import java.util.*;

/**
 *
 * @author Zeeshan Mehboob
 */
public class CSR {
    private ArrayList<User> allUsers;
    private ArrayList<Trip> allTrips;
    public ArrayList<Document> documents;
    public  ArrayList<Application> Application;
    public  ArrayList<Volunteer> Volunteers;
     public  ArrayList<Staff> staff;
    Admin admin;
    public CSR() {
        setUser(new ArrayList<User>());
        setTrips(new ArrayList<Trip>());
        this.Volunteers=new ArrayList<Volunteer>();
        this.documents=new ArrayList<Document>();
        this.Application=new ArrayList<Application>();
         this.staff=new ArrayList<Staff>();
    }
    
    public void setAdmin(Admin admin)
    {
        this.admin=admin;
    }
    public Admin getadmin()
    {
        return this.admin;
    }
    public CSR(Admin admin)
    {
        setAdmin(admin);
    }
    public void addAdmin(String name, String password,String Fullname)
    {
       this.admin=new Admin(name,password,Fullname);
    }
    public Admin findadmin(String name,Admin admin )
    {
        if(admin!=null)
        {
            if(admin.getusername().equalsIgnoreCase(name))
            {
                return admin;   
            }
        }
       return null;
    }
    /**
     * @return the Material
     */ 
    public int noOfTrip() {

        return getTrips().size();
    }

    /**
     * @return the User
     */
    public ArrayList<User> getUser() {
        return allUsers;
    }
   
    /**
     * @param User the Array List to set
     */
    public void setUser(ArrayList<User> user) {
        this.allUsers = user;
    }
    
    /**
     * @return the allMaterials
     */
    public ArrayList<Trip> getTrips() {
        return allTrips;
    }

    /**
     * @param Trips the Array List to set
     */
    public void setTrips(ArrayList<Trip> trips) {
        this.allTrips = trips;
    }
    public void printTrips()
    {
        for (Trip t : getTrips())
        {
            System.out.println(t.toString());
        }
    }
    public void printUsers()
    {
        for (User u : getUser())
        {
            System.out.println(u.toString());
        }
    }
     public void printDocuments()
    {
        for (Document d : documents)
        {
            System.out.println(d.toString());
        }
    }
    public void printApplications()
    {
        for (Application a : Application)
        {
            System.out.println(a.toString());
        }
    }
     public int addVolunteer(String userName, String password, String fullName, long phoneno){
         Volunteers.add(new Volunteer(userName, password, fullName, phoneno));
         getUser().add(new Volunteer(userName, password, fullName, phoneno));
          return getUser().size();
    }
    
    /**
     * Method to add Material
     */
    public void addTrips(Trip trip) {
         this.allTrips.add(trip);
    }
     public void destructor(Trip t)
    {
        t=null;
    }
    /**
     * Method to find material
     */
    public Trip findTrip(String tripID) {
        for (Trip t : getTrips()) {
            if (t.gettripID().equalsIgnoreCase(tripID)) {
                return t;
            }
        }
        return null;
    }

    /**
     * Method to add staff
     */
    public boolean addStaff(String userName, String password, String fullName, long phoneno, String position,Date datejoined){
        staff.add(new Staff(userName, password, fullName, phoneno, position,datejoined));
        return getUser().add(new Staff(userName, password, fullName, phoneno, position,datejoined));
    }
    
    /** 
     * Method to find User
     */
    public User findUser(String userName){
        for (User user : getUser()){
            if (user.getUserName().equalsIgnoreCase(userName)) {
                return user;
            }
        }
        return null;
    }
     public Volunteer findVUser(String userName){
        for (Volunteer V : Volunteers){
            if (V.getUserName().equalsIgnoreCase(userName)) {
                return V;
            }
        }
        return null;
    }
    
}
