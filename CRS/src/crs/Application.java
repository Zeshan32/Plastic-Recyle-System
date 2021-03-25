/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crs;

import static crs.Trip.tripid;
import java.util.Date;

/**
 *
 * @author Zeeshan Mehboob
 */
public class Application {
    private String stringid;
    private int applicationid=1;
    private Date date;
    private boolean status;
    private String remrks;
    public Application(Date date, boolean status,String remarks)
    {
       setApplicationId();
        this.date=date;
        this.status=status;
        this.remrks=remarks;
    }
      public String gettripID(){
        return stringid;
    }

    /**
     * @param tripID the material ID to set
     */
    public void setApplicationId(){
        this.stringid = String.format("SN%03d", applicationid++);
    }

    /**
     * @return the MaterialName
     */
    public Date getdate(){
        return date;
    }

    /**
     * @para the material name to set
     */
    public void setdate(Date date){
        this.date = date;
    }

    /**
     * @return the description
     */
    public boolean getStatus(){
        return status;
    }

    /**
     * @param description the description to set
     */
    public void setremarks(String remarks){
        this.remrks = remarks;
    }
   
    /**
     * @return the pointsPerKg
     */
    public String getremarks(){
        return this.remrks;
    }

    /**
     * @param  the points per Kg to set
     */
   
    public String toString(){
        return "Application [Application ID = " + stringid + ", Application status = " + status + ", remarks = "
                + this.remrks + ", Application Date = " + date  + " ]";
    }
    
}
