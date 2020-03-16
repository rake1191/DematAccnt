package MainApp;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.UUID;
import java.time.LocalDate;
import java.time.LocalTime;


import Login.User;
import StockApp.Stocks;
import StockApp.genricStockHandler;
import Transaction.TransactionAPI;
import Transaction.Transaction;

public class getInputs {
	
	// begins the programs 
	// asks for input
	// creates user if input is 1 #addUser()
	// checks credentials and logs user in if option is 2  #authenticate()
	
	char caseno;
	Scanner scan;
	LinkedList<User> userlist = new LinkedList<User>();
	TransactionAPI trasactV1;
	genricStockHandler BSE;
	
	getInputs(){
		LinkedList<Stocks> stockList = new LinkedList<Stocks>();
   		Stocks s1 = new Stocks("Amazon",100,500);
   		Stocks s2 = new Stocks("Flipkart",90,500);
   		Stocks s3 = new Stocks("Walmart",80,500);
   		Stocks s4 = new Stocks("Jabong",70,500);
   		Stocks s5 = new Stocks("Myntra",60,500);
   		Stocks s6 = new Stocks("koovs",50,500);
   		Stocks s7 = new Stocks("nike",40,500);
   		
   		stockList.add(s1);
   		stockList.add(s2);
   		stockList.add(s3);
   		stockList.add(s4);
   		stockList.add(s5);
   		stockList.add(s6);
   		stockList.add(s7);
   		
   		BSE = new genricStockHandler(stockList);
	}
	
	public void mainMenu() {
        
        System.out.println("Enter 1 to Create an Account");
        System.out.println("Enter 2 to Login to an Account");
        
        scan = new Scanner(System.in);
        
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
      	  	 mainMenu();
              
               break;
        }
        
  }
	
	void addUser() {
		
		int shares = 0;
        double money = 0;
        
        scan = new Scanner(System.in);
        
        
        System.out.println("Enter the User Name");
        String username = scan.next();
        
        System.out.println("Enter the Password");
        String password = scan.next();
        
        System.out.println("Enter the Money to be stored in the account");
        
        if (scan.hasNextDouble()) {
        	money = scan.nextDouble();
        }
        else {
               System.out.println("Invalid value has been given");
               System.exit(0);
        }
        
        String uniqueID = UUID.randomUUID().toString();
        
		User user1 = new User(username, password, money, uniqueID, shares);
        userlist.add(user1);
        
        System.out.println("Enter 'y' to Login and '0' to exit");
        String option = scan.next();
        if(option.equals("y")) {
               authenticate();
        }
        else if(option.equals("0")){
               //exit();
        }
        
  }
	
	void authenticate() {            
        if(userlist.isEmpty()) {
               System.out.println("No user has been created yet!");
               mainMenu();
        }
        
        else {

	        User userdetail = userlist.get(0);//one user for now
	        System.out.println("Enter the User Name");
	        String username = scan.next();
	        
	        String optionpass;
			//      System.out.println(userdetail.user);
	        if(username.equals(userdetail.user)) {
	               System.out.println("Enter the Password");
	               String passwd = scan.next();
	               if(passwd.equals(userdetail.pass)) {
	                     System.out.println();
	                     System.out.println("Authentication successfull");
	                     displayUser(userdetail);
	               }
           else {
                 System.out.println("Incorrect Password");
                 System.out.println("Enter 1 to go to Main Menu, 2 to exit");
                 optionpass = scan.next();
                 if(optionpass.equals("1")) {
                        mainMenu();
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
                     mainMenu();
               }
               else if(optionpass.equals("2")){
                     exit();
               }
               
               }
        
        }
  
	}
	
	void displayUser(User userdetail) {
        System.out.println("Welcome "+userdetail.user+"!");
        System.out.println();
        trasactV1 = new TransactionAPI(userdetail,BSE);
        LoginMenu(userdetail,trasactV1);
        
	}
	
	private void exit() {
		//Save Details Here to data can persist when a new session is opened
        System.out.println("You have exited from the account");
        System.exit(0);
	}
	
	void LoginMenu(User userdetail, TransactionAPI trasactV1) {
        
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
        System.out.println("7 - LogOut");

        char maincaseno = scan.next().charAt(0);
        
        switch (maincaseno) {
        case '0':
               exit();
               break;
        case '1':
               System.out.println("Below are your account details \n");
               System.out.println(userdetail);
               
               LoginMenu(userdetail, trasactV1);
               break;
        case '2':
        		System.out.println("Enter the Money to be stored in the account");
        		double depMoney = 0;
	            if (scan.hasNextDouble()) {
	            	depMoney = scan.nextDouble();
	            }
	            else {
	                   System.out.println("Invalid value has been given");
	                   LoginMenu(userdetail, trasactV1);
	            }
               userdetail.depositMoney(userdetail, depMoney);
               System.out.println("Money Deposited succesfully. Updated Balance is - "+userdetail.getMoney());
               LoginMenu(userdetail, trasactV1);
               break;
        case '3':
	        	System.out.println("Enter the Money you would like to withdraw");
	    		double withdrawMoney = 0;
	            if (scan.hasNextDouble()) {
	            	withdrawMoney = scan.nextDouble();
	            }
	            else {
	                   System.out.println("Invalid value has been given");
	                   LoginMenu(userdetail, trasactV1);
	           }
	           if(userdetail.withdrawMoney(userdetail, withdrawMoney)) {
	        	   System.out.println("Money Withdrawal succesfull. Updated Balance is - "+userdetail.getMoney());
	           }
	           LoginMenu(userdetail, trasactV1);
               break;
        case '4':
               System.out.println("--** Stock List **--\n");
               trasactV1.BSE.listShares();
               trasactV1.buyShares(userdetail,BSE);
               
               //Transaction t1 = new Transaction(101, "Buy", LocalDate.of(2019, 12, 12), LocalTime.of(03, 35));
               LoginMenu(userdetail, trasactV1);
               
               break;
        case '5':
               System.out.println("Sell transaction");
               trasactV1.BSE.listShares();
               trasactV1.sellShares(userdetail,BSE);
               LoginMenu(userdetail, trasactV1);
               break;
        case '6':
               System.out.println("View transaction report");
               LoginMenu(userdetail, trasactV1);
               break;
        case '7':
            System.out.println("Succesfully Logged Out");
            mainMenu();
            break;
            
        default:
               System.out.println("Invalid Option");
               LoginMenu(userdetail, trasactV1);
               break;
        }
        
  }

  

}
