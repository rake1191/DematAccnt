package Login;

import BookOfShares.SharesInPosseion;
import Transaction.Transaction;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.UUID;
import java.io.IOException;
import StockApp.Stocks;
import StockApp.genricStockHandler;

public class User{
    
    String user;
    String pass;
    double money;
    String uniqueID;
    int shares;
    LinkedList<Transaction> transactionsMade;
    public genricStockHandler UserStock;
    //LinkedList<Stocks> sharesOwned; created Outside
    
    
    public User(String user, String pass, double money, String uniqueID, int shares) {
          this.user = user;
          this.pass = pass;
          this.money = money;
          this.uniqueID = uniqueID;
          this.shares = shares;
    }
    
	  void depositMoney(User user, double amount) {
	        user.money += amount;
	  }
		  
	  boolean withdrawMoney(User user, double amount) {
	        if(user.money < amount) {
	               System.out.println("Insufficient balance in the account");
	               return false;
	        }
	        else {
	               user.money -= amount;
	               System.out.println("Amount has been debitted");
	               return true;
	        }
	  }
	  
	  double getBalance(User user) {
	        return user.money;
	  }

  
    @Override
    public String toString() {
          return "User [user=" + user + ", money=" + money + ", uniqueID=" + uniqueID +", shares=" + shares +"]";
    }
    
}
