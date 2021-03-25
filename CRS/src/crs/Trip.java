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
public class Trip {
    static int tripid = 1;
    private String stringid;
    private String description;
    private Date tripdate;
    private String location;
    private int numvolunteers;
    public CSR csr;
    public static ArrayList<Application>  submissionlist;
    public Trip(String description, Date tripdate, String location,int numvolunteers){
        setTripID();
        setdescription(description);
        setDate(tripdate);
        setLocation(location);
        setNumVolunteers(numvolunteers);
    }
    
    public Trip(){
        this("not set",null, "not set", 0);
    }

    /**
     * @return the materialID
     */
    public String gettripID(){
        return stringid;
    }

    /**
     * @param tripID the material ID to set
     */
    public void setTripID(){
        this.stringid = String.format("SN%03d", tripid++);
    }

    /**
     * @return the MaterialName
     */
    public String getdescription(){
        return description;
    }

    /**
     * @param MaterialName the material name to set
     */
    public void setdescription(String description){
        this.description = description;
    }

    /**
     * @return the description
     */
    public String getLocation(){
        return location;
    }

    /**
     * @param description the description to set
     */
    public void setLocation(String location){
        this.location = location;
    }
   
    /**
     * @return the pointsPerKg
     */
    public Date  getdate(){
        return tripdate;
    }

    /**
     * @param  the points per Kg to set
     */
    public void setDate(Date date){
        this.tripdate = date;
    }
    public void setNumVolunteers(int no)
    {
        this.numvolunteers=no;
    }
    public int getNumVolunteers()
    {
        return this.numvolunteers;
    }
    public String toString(){
        return "Trip [Trip ID = " + stringid + ", Trip location = " + location + ", description = "
                + description + ", Trip Date = " + tripdate +", NumVolunteers = " + this.numvolunteers + " ]";
    }
    
}
