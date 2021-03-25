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
public class Staff extends User {
    
    private String position;
    private Date datejoined;
    private ArrayList<Trip> alltrips;
    public Staff(String userName, String password, String fullName, long phoneno, String position,Date datejoined){
        super(userName, password, fullName, phoneno);
        setposition(position);
        setjoineddate(datejoined);
        setTrips(new ArrayList<Trip>());
    }

    /**
     * @return the ecoLevel
     */
    public String getposition(){
        return this.position;
    }

    /**
     * @param ecoLevel the eco level to set
     */
    public void setposition(String position){
        this.position = position;
    }

    /**
     * @return the Submission Array List
     */
    public ArrayList<Trip> getTrip(){
	return alltrips;
    }
    public void setjoineddate(Date date)
    {
        this.datejoined=date;
    }
    /**
     * @param Trip the Array List to set
     */
    public void setTrips(ArrayList<Trip> trip){
        this.alltrips = trip;
    }
    public Date getdate()
    {
        return this.datejoined;
    }
    /**
     * @return the toString
     */
    public String toString(){
        super.toString();
        return "Staff [position = " + position + " ]";
    }
}
