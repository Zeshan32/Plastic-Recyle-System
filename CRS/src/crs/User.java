/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crs;

/**
 *
 * @author Zeeshan Mehboob
 */public abstract class User {
    private String userName;
    private String password;
    private String fullName;
    private long  phoneno;
    
    public User(String userName, String password, String fullName, long phoneno){
        setUserName(userName);
        setPassword(password);
        setFullName(fullName);
        setPhoneno(phoneno);
    }

    public User(){
        this("not set", "not set", "not set", 0);
    }

    /**
     * @return the userName
     */
    public String getUserName(){
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName){
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword(){
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * @return the full name
     */
    public String getFullName(){
        return fullName;
    }

    /**
     * @param fullName the full name to set
     */
    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    /**
     * @return the totalPoints
     */
    public long getPhoneno(){
        return  phoneno;
    }

    /**
     * @param totalPoints the total points to set
     */
    public void setPhoneno(long  phoneno){
        this.phoneno =  phoneno;
    }
    
    public String toString(){
        return "UserName:"+getUserName() +"Password:"+ " (" + getPassword() + ")" + "FullName:" + getFullName() + "Phoneno:"+" (" + getPhoneno() + " )"; 
    }
    
}
