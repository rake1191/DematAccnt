package User;


import java.util.LinkedList;

import StockApp.genricStockHandler;
import Transaction.Transaction;
import StockApp.Stocks;

public class User {
       
       public String user;
       public String pass;
       public Double money;
       public String uniqueID;
       public int shares;
       public LinkedList<Transaction> transactionReport;
       public LinkedList<Stocks> userStockList = new LinkedList<Stocks>();
       public genricStockHandler userHandler = new genricStockHandler(userStockList);
       
    public User(String user, String pass, Double money, String uniqueID, int shares) {
          this.user = user;
          this.pass = pass;
          this.money = money;
          this.uniqueID = uniqueID;
          this.shares = shares;
          
    }
    
    @Override
    public String toString() {
          return "User [user=" + user + ", pass=" + pass + ", money=" + money + ", uniqueID=" + uniqueID +", shares=" + shares +"]";
    }


}

