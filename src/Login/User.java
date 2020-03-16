package Login;


import Transaction.Transaction;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.UUID;
import java.io.IOException;
import StockApp.Stocks;
import StockApp.genricStockHandler;

public class User{
    
    public String user;
    public String pass;
    public double money;
    String uniqueID;
    int shares;
    LinkedList<Transaction> transactionsMade = new LinkedList<Transaction>();
    LinkedList<Stocks> UsersStocks = new LinkedList<Stocks>();
    public genricStockHandler userHandler = new genricStockHandler(UsersStocks);
    //LinkedList<Stocks> sharesOwned; created Outside
	public LinkedList<Transaction> transactionReport;
	
    
    public User(String user, String pass, double money, String uniqueID, int shares) {
          this.user = user;
          this.pass = pass;
          this.setMoney(money);
          this.uniqueID = uniqueID;
          this.shares = shares;
    }
    
	  public void depositMoney(User user, double amount) {
	        user.setMoney(user.getMoney() + amount);
	  }
		  
	  public boolean withdrawMoney(User user, double amount) {
	        if(user.getMoney() < amount) {
	               System.out.println("Insufficient balance in the account");
	               return false;
	        }
	        else {
	               user.setMoney(user.getMoney() - amount);
	               return true;
	        }
	  }
	  
	  double getBalance(User user) {
	        return user.getMoney();
	  }

  
    @Override
    public String toString() {
          return "UserName - " + user + "\n" 
        		  + "Account Balance - " + getMoney() + "\n" 
        		  + "Account Number - " + uniqueID + "\n"
        		  + "No of transactions - " + transactionsMade.size() + "\n" ;
    }

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
    
}
