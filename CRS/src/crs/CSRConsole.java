/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crs;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author Zeeshan Mehboob
 */
public class CSRConsole {

    /**
     * @param args the command line arguments
     */
    private static final int MAX_LOGIN_TRIES = 10;
    private static final int MAX_PASSWORD_TRIES = 3;
    static String arg[];
    static Scanner kbd;
    static Date dateFormat;
    static CSR csr = new CSR();;
    static User userLogin;
    static Admin adminlogin;
    static Admin admin;
    public static void main(String[] args) throws ParseException {
      
        kbd = new Scanner(System.in);
        
        System.out.println("Welcome CSR User!\n");
        char c=mainmenu();
        while (c != '0') {
            switch (c) {
                case '1':
                    Admincontrol();
                    break;
                case '2':
                    Otheruser();
                    break;
                default:
                    printError();
                    break;
            }
            System.out.println();
            c = menu();
        }
        System.out.println("Thank you!");
    }
    public static void printError() {
        System.out.println("Invalid choice! Try again!");
    }
     public static void Otheruser() throws ParseException
   {
       char choice = menu();
        while (choice != '0') {
            switch (choice) {
                case '1':
                    signUp("Staff");
                    break;
                case '2':
                    signUp("Volunteer");
                    break;
                case '3':
                    login();
                    break;
                default:
                    printError();
                    break;
            }
            System.out.println();
            choice = menu();
        }
        System.out.println("Thank you!");
   }
   public static void Admincontrol() throws ParseException
   {
        char c = Adminmenu();
        while (c != '0') {
            switch (c) {
                case '1':
                    signUp("Admin");
                    break;
                case '2':
                    adminlogin();
                    break;
                default:
                    printError();
                    break;
            }
            System.out.println();
            c = menu();
        }       
       
   }
   public static char Adminmenu()
   {
       System.out.println(" Welcome to Admin panel of EcoSave");
        System.out.println("1.SignUp");
        System.out.println("2.Signin");
        System.out.println("0. Quit");
        System.out.println();
        System.out.print("Your choice? ");
        return kbd.nextLine().trim().charAt(0);
   }
   public static char mainmenu()
   {
        System.out.println("CSR");
        System.out.println("1.Admin");
        System.out.println("2.Other User");
        System.out.println();
        System.out.println("0. Quit");
        System.out.println();
        System.out.print("Your choice? ");
        return kbd.nextLine().trim().charAt(0);
   }
   public static char menu() {
        System.out.println("CSR");
        System.out.println("1. Sign up as (Staff)");
        System.out.println("2. Sign up as (Volunteer)");
        System.out.println("3. Login");
        System.out.println();
        System.out.println("0. Quit");
        System.out.println();
        System.out.print("Your choice? ");
        return kbd.nextLine().trim().charAt(0);
    }
   public static void signUp(String userType) throws ParseException {
        System.out.println("Create " + userType + " ...");

        String userName = getUserName();
        String password = getPassword();
        String fullName = getFullName();

        if (userType.equalsIgnoreCase("Staff")) {
            long phoneno = 030324;
            String position = "Beginner";
            System.out.println("Enter ExpiaryDate(dd/MM/yyyy)*:");
            String date=kbd.nextLine();
             Date d = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            csr.addStaff(userName, password, fullName, phoneno, position,d);
            System.out.println("New Staff user created successfully!");
        }
        else if (userType.equalsIgnoreCase("Volunteer")) {
            long phoneno = 03;
            int size=csr.addVolunteer(userName, password, fullName,phoneno);
            System.out.println("New Volunteer user created successfully!");
        }
        else if(userType.equalsIgnoreCase("Admin")) {
            admin=new Admin(userName, password, fullName);
            csr.setAdmin(admin);
             System.out.println("this is admin!");
        }
        else
        {
            System.out.println("This type is not related to this EcoSave!");
        }

        System.out.println("New user created successfully!");

        main(arg);
        
    }
    public static void login() throws ParseException {
        userLogin = signedIn();
        if (userLogin != null) {
            if (userLogin instanceof Staff) {
                StaffTasks();
            } else if (userLogin instanceof Volunteer) {
                VolunteerTasks();
            } else {
                adminTasks();
            }
        }
    }
    public static void adminTasks() throws ParseException {
       char ch = adminTasksMenu();
        while (ch != '0') {
            switch (ch) {
                case '1':
                    addTrip();
                    break;
                case '2': 
                    changeTrip();
                    break;
                case '3':
                     deleteTrip();
                     break;
                case '4':
                     ViewDocuments();
                      break;
                 case '5':
                     ViewUsers();
                      break;
                default:
                    printError();
                    break;                    
                   

            }
            ch = adminTasksMenu();
        }
    }
     public static String getUserName() {
        System.out.print("Username: ");
        String userName = kbd.nextLine();
        while (csr.findUser(userName) != null || userName.equals("")) {
            if (userName.equals("")) {
                System.out.println("Username cannot be blank! Please "
                        + "enter username!\n");
            } else {
                System.out.println("Username already exists. "
                        + "Please enter another username!\n");
            }
            System.out.print("Username: ");
            userName = kbd.nextLine();
        }
        return userName;
    }
        public static String getPassword() {
        System.out.print("Password (Min. length: 8): ");
        String password = kbd.nextLine();
        while (password.length() < 8) {
            if (password.equals("")) {
                System.out.println("Password cannot be blank! " + "Please enter password!\n");
            }
            else {
                System.out.println("Password must contain at least " + "8 characters!\n");
            }

            System.out.print("Password (Min. length: 8): ");
            password = kbd.nextLine();
        }
        return password;
    }
    public static String getFullName() {
        System.out.print("Full name: ");
        String fullName = kbd.nextLine().trim();
        while (fullName.equals("")) {
            System.out.println("Full name cannot be blank! " + "Please enter full name!\n");
            System.out.print("Full name: ");
            fullName = kbd.nextLine();
        }
        return fullName;
    }
    public static String getAddress() {
        System.out.print("Address: ");
        String address = kbd.nextLine().trim();
        while (address.equals("")) {
            System.out.println("Address cannot be blank! " + "Please enter Address!\n");
            System.out.print("Address: ");
            address = kbd.nextLine();
        }
        return address;
    }
     public static void adminlogin() throws ParseException
    {
         
       adminlogin=signin();
       if(adminlogin!=null)
       {
           adminTasks();
       }
       else
       {
         System.out.println("No user found of that name!!!");
       }
    }
     
     public static Admin signin() throws ParseException
    {
        System.out.println("\nSign in");
        System.out.print("Username: ");
        String inUserName = kbd.nextLine();
        Admin adminlogin  = csr.findadmin(inUserName,admin);
        int maxTries = 1;
        if(adminlogin == null) {
            System.out.println("Username not found!please ensure you signedUp\n");

            if (maxTries++ == MAX_LOGIN_TRIES) {
                return null;
            }

            System.out.print("Username: ");
            inUserName = kbd.nextLine();
             adminlogin = csr.findadmin(inUserName,admin);
        }
        System.out.print("Password: ");
        String inPassword = kbd.nextLine();

        maxTries = 1;
        while (!adminlogin.getpassword().equals(inPassword)) {
            System.out.println("Invalid password!");
            if (maxTries++ == MAX_PASSWORD_TRIES) {
                System.out.println("Please try again later!");
                return null;
            }
            System.out.println();
            System.out.print("Password: ");
            inPassword = kbd.nextLine();
        }
        System.out.println("Sign in successfully!");
      
        return adminlogin;
        
    }
    public static User signedIn() {
        System.out.println("\nSign in");
        System.out.print("Username: ");
        String inUserName = kbd.nextLine();
        User userLogin = csr.findUser(inUserName);
        int maxTries = 1;
        while (userLogin == null) {
            System.out.println("Username not found!\n");

            if (maxTries++ == MAX_LOGIN_TRIES) {
                return null;
            }

            System.out.print("Username: ");
            inUserName = kbd.nextLine();
            userLogin = csr.findUser(inUserName);
        }
        System.out.print("Password: ");
        String inPassword = kbd.nextLine();

        maxTries = 1;
        while (!userLogin.getPassword().equals(inPassword)) {
            System.out.println("Invalid password!");
            if (maxTries++ == MAX_PASSWORD_TRIES) {
                System.out.println("Please try again later!");
                return null;
            }
            System.out.println();
            System.out.print("Password: ");
            inPassword = kbd.nextLine();
        }
        System.out.println("Sign in successfully!");
        return userLogin;
    }
    public static char adminTasksMenu() {
        System.out.println();
        System.out.println("Choose");
        System.out.println("1. Add Trip");
        System.out.println("2. Change Trip");
        System.out.println("3. Delete Trip;");
        System.out.println("4. View Documents History;");
        System.out.println("5. View User Records;");
        System.out.println();
        System.out.println("0. LOGOUT [Back to main menu]");
        System.out.println();
        System.out.print("Your choice: ");
        return kbd.nextLine().charAt(0);
    }

    public static void addTrip() throws ParseException {
        System.out.println("Adding New TripPlan");
        System.out.print("Description: ");
        String description = kbd.nextLine();
        System.out.print("Date(dd/MM/yyyy)*:");
        String date = kbd.nextLine();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        System.out.print("Location: ");
       String  location = kbd.nextLine();
        System.out.print("NumVolunteers: ");
        int numVolunteers= kbd.nextInt();
        kbd.nextLine();
        
       Trip t = new Trip(description,dateFormat,location,numVolunteers);
       t.setTripID();
        csr.addTrips(t);
    }

    public static void changeTrip() throws ParseException {
        if (csr.noOfTrip() == 0) {
            System.out.println("No Trip");
        }
        else {
            System.out.println("All Trips in the system:");
            csr.printTrips();
            System.out.println("change Trip information");
            System.out.print("Enter Trip id: ");
            String id = kbd.nextLine();
            Trip trip = csr.findTrip(id);
            if(trip!=null)
            {
                System.out.println("What you want to change");
                System.out.println("1. Trip Description");
                System.out.println("2. Trip Location");
                System.out.println("3. Trip Date");
                System.out.println("4. Trip NumVolunteers");
                 System.out.println("0.Quit");
                System.out.print("Your choice: ");
                char choice= kbd.nextLine().charAt(0);
                while (choice != '0') {
                switch (choice) {
                case '1':
                {System.out.println("Enter new description");
                     String description=kbd.nextLine();
                     trip.setdescription(description);
                     break;}
                case '2':
                {System.out.println("Enter new Location of Trip");
                     String location=kbd.nextLine();
                     trip.setLocation(location);
                    break;}
                case '3':
                {System.out.println("Enter new Date of TripDate(dd/MM/yyyy)*:");
                    String date = kbd.nextLine();
                    Date datef = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                    trip.setDate(datef);
                    break;}
                case '4':
                {System.out.println("Enter new num of volunteer of Trip");
                    int no = kbd.nextInt();
                    trip.setNumVolunteers(no);
                    break;}
                default:
                    printError();
                    break;
            }
                choice= kbd.nextLine().charAt(0);
            
        }
         
              System.out.println("Desired Trip is Successfully Updated!!!");     
            }
            else
            {
                System.out.println("Desired Trip is nt found!!!");
            }
        }
    }
    public static void deleteTrip() {
        if (csr.noOfTrip() == 0) {
            System.out.println("No Trip is present");
        }
        else {
            System.out.println("All Trips in the system:");
            csr.printTrips();
            System.out.println("delete Trip information");
            System.out.print("Enter Trip id: ");
            String id = kbd.nextLine();
            Trip t = csr.findTrip(id);
            if(t!=null)
            {
                
              csr.destructor(t);
              System.out.println("Trip delete Successfully!!!");
        
            }
            else
            {
                System.out.println("No object is found!!!!");
            }
        }
    }
    public static char StaffTasksMenu() {
        System.out.println();
        System.out.println("Choose");
        System.out.println("1. See Trips");
        System.out.println();
        System.out.println("0. LOGOUT [Back to main menu]");
        System.out.println();
        System.out.print("Your choice: ");
        return kbd.nextLine().charAt(0);
    }
     public static void StaffTasks() {
        char ch = StaffTasksMenu();
        while (ch != '0') {
            switch (ch) {
                case '1':
                    seeTrips();
                    break;
                default:
                    printError();
                    break;
            }
            ch = StaffTasksMenu();
        }
     }
     
    public static void seeTrips()
    {
         System.out.println("All Trips in the system:");
         csr.printTrips();
    }
     public static char VolunteerTasksMenu() {
        System.out.println();
        System.out.println("Choose");
        System.out.println("1. Submits Applicaions");
        System.out.println("2. Submits Documents");
        System.out.println("3. See Applications");
        System.out.println();
        System.out.println("0. LOGOUT [Back to main menu]");
        System.out.println();
        System.out.print("Your choice: ");
        return kbd.nextLine().charAt(0);
    }
     public static void VolunteerTasks() throws ParseException {
        char ch = VolunteerTasksMenu();
        while (ch != '0') {
            switch (ch) {
                case '1':
                    submitsApplication();
                    break;
                case '2':
                    submitsDocuments();
                    break;
                case '3':
                    seeApplications();
                    break;
                default:
                    printError();
                    break;
            }
            ch = VolunteerTasksMenu();
        }
     }
     
    public static void seeDocuments()
    {
         System.out.println("All Documents in the system:");
         csr.printDocuments();
    }
    public static void  ViewUsers()
    {
        csr.printUsers();
    }
    public static void submitsApplication() throws ParseException
    {
        System.out.println("Enter Date(dd/MM/yyyy)*:");
        String date=kbd.nextLine();
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse(date);
         System.out.println("Enter Remarks:");
                 String remarks=kbd.nextLine();
          boolean status=false;
        csr.Application.add(new Application(d,status,remarks));
        System.out.println("Application Submit Succesfully!!!!");
    }
     public static void submitsDocuments() throws ParseException
    {
        System.out.println("Enter Your Username:");
        String username=kbd.nextLine();
        System.out.println("Enter Documenttype:");
        String doc_type=kbd.nextLine();
        System.out.println("Enter ExpiaryDate(dd/MM/yyyy)*:");
        String date=kbd.nextLine();
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        Image image=null;
        Volunteer v=csr.findVUser(username);
        csr.documents.add(new Document(doc_type,d,image,v));
        System.out.println("Document added Succesfully!!!!");
    }
    public static void seeApplications()      
    {
        System.out.println("Application are:");
        csr.printApplications();
    }
     public static void ViewDocuments()      
    {
        System.out.println("Documents  are:");
        csr.printDocuments();
    }
}
