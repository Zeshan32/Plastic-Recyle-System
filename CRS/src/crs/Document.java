/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crs;
import java.awt.Image;
import java.util.*;

/**
 *
 * @author Zeeshan Mehboob
 */
public class Document {
    private String documenttype;
    private Date expiary_date;
    private Image image;
    private Volunteer volunteer;
    public Document(String documenttype,Date expirydate,Image image ,Volunteer v)
    {
        this.documenttype=documenttype;
        this.expiary_date= expirydate;
        this.image=image;
        setvolunteer(v);
    }
    public void setvolunteer(Volunteer v){this.volunteer=v;}
    public void setdocumenttype(String dcumenttype)
    {
        this.documenttype=dcumenttype;
    }
    public void setexpirydate(Date date)
    {
        this.expiary_date=date;
    }
    public void setimage(Image image)
    {
        this.image=image;
    }
    public String getdocumenttype()
    {
        return this.documenttype;
    }
    public Date getdate()
    {
        return expiary_date;
    }
    public Image getimage()
    {
        return this.image;
    }
    public Volunteer getvolunteer()
    {
        return this.volunteer;
    }
}
