package Login;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.UUID;
import java.io.IOException;


public class LinkedlistUser {
    
    Scanner scan;
    LinkedList<User> userlist;
    String username;
    String password;
    Double money;
    String uniqueID;
    char maincaseno;
    char caseno;
    String option;
    String optionpass;
    String u;
    String p;
    User userdetail;
    int shares;
    
    public void caseStatement() {
          
          scan = new Scanner(System.in);
          System.out.println("Enter 1 to Create an Account");
          System.out.println("Enter 2 to Login to an Account");
          
          caseno = scan.next().charAt(0);
          
          switch (caseno) {
          case '1':
                 addUser();
                 break;
          case '2':
                 authenticate();
                 break;
          default:
        	  	 System.out.println("Invalid Option");
        	  	 caseStatement();
                
                 break;
          }
          
    }
    
    
    void addUser() {
          
          scan = new Scanner(System.in);
          userlist = new LinkedList<User>();
          
          System.out.println("Enter the User Name");
          username = scan.next();
          
          System.out.println("Enter the Password");
          password = scan.next();
          
          System.out.println("Enter the Money to be stored in the account");
          
          if (scan.hasNextDouble()) {
                 money = scan.nextDouble();
          }
          else {
                 System.out.println("Invalid value has been given");
                 System.exit(0);
          }
          shares = 0;
          
          
          
          
          uniqueID = UUID.randomUUID().toString();
                       
          User user1 = new User(username, password, money, uniqueID, shares);
          userlist.add(user1);
          
          System.out.println("Enter 'y' to Login and '0' to exit");
          option = scan.next();
          if(option.equals("y")) {
                 authenticate();
          }
          else if(option.equals("0")){
                 exit();
          }
          
    }
    
    private void exit() {
          System.out.println("You have exited from the account");
          System.exit(0);
    }

    void mainMenuCase() {
        
        scan = new Scanner(System.in);
        
        System.out.println();
        System.out.println("Select the below option to proceed with your transaction");
        System.out.println("0 - Quit");
        System.out.println("1 - Display Demat account details");
        System.out.println("2 - Deposit Money");
        System.out.println("3 - Withdraw Money");
        System.out.println("4 - Buy transaction");
        System.out.println("5 - Sell transaction");
        System.out.println("6 - View transaction report");

        maincaseno = scan.next().charAt(0);
        
        switch (maincaseno) {
        case '0':
               exit();
               break;
        case '1':
               System.out.println("Enter the Display Demat account details");
               break;
        case '2':
               System.out.println("Deposit Money");
               break;
        case '3':
               System.out.println("Withdraw Money");
               break;
        case '4':
               System.out.println("Buy transaction");
               break;
        case '5':
               System.out.println("Sell transaction");
               break;
        case '6':
               System.out.println("View transaction report");
               break;
               
        default:
               System.out.println("Invalid Option");
               break;
        }
        
    }

    
    
    
    void displayUser() {
          System.out.println("User Account Details");
          for(int i=0; i<userlist.size(); i++) {
                 System.out.println(userlist.get(i));
          }
          
          System.out.println();
          
    }
    
    void authenticate() {            
          if(userlist.size()==0) {
                 System.out.println("No user account available.");
          }
          
          else {

          userdetail = userlist.get(0);//one user for now
          System.out.println("Enter the User Name");
          u = scan.next();
          
//        System.out.println(userdetail.user);
          if(u.equals(userdetail.user)) {
                 System.out.println("Enter the Password");
                 p = scan.next();
                 if(p.equals(userdetail.pass)) {
                       System.out.println();
                       System.out.println("Authentication successfull");
                       displayUser();
                 }
                 else {
                       System.out.println("Incorrect Password");
                       System.out.println("Enter 1 to go to Main Menu, 2 to exit");
                       optionpass = scan.next();
                       if(optionpass.equals("1")) {
                              caseStatement();
                       }
                       else if(optionpass.equals("2")){
                              exit();
                       }
                 }
          }
          else {
                 System.out.println("The username is not present, kindly create an account or check the username");
                 System.out.println("Enter 1 to go to Main Menu, 2 to exit");
                 optionpass = scan.next();
                 if(optionpass.equals("1")) {
                       caseStatement();
                 }
                 else if(optionpass.equals("2")){
                       exit();
                 }
                 
                 }
          
          }
    
    }
    
}
