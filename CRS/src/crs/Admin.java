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
public class Admin {
     private String username;
    private String password;
    private String fullname;
    public static ArrayList<User> userlist;
    private  ArrayList<Trip> Trip_list;
    public Admin(String username, String password,String fullname)
    {
        this.setusername(username);
        this.setpassword(password);
        this.setfullname(fullname);
    }
    public void setfullname(String fullname)
    {
        this.fullname=fullname;
    }
    public void setusername(String username)
    {
        this.username=username;
    }
    public void setpassword(String password)
    {
         this.password=password;
    }
    public String getusername()
    {
        return this.username;
    }
    public String getpassword()
    {
        return this.password;
    }
    public void Adduserlist(User user )
    {
        userlist.add(user);
    }
    public void Addmaterial(Trip trip)
    {
        Trip_list.add(trip);
    }
    
}
