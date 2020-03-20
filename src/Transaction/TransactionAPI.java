package Transaction;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

import StockApp.Stocks;
import StockApp.StockDatabase;
import StockApp.genricStockHandler;
//import User.User;

public class TransactionAPI {
       
       StockDatabase stocksDb = new StockDatabase();
//     StockHandler BSE;
       Stocks bseStock, userStock;
       Login.User user;
       public genricStockHandler BSE,userHandler;
       
       public TransactionAPI(Login.User user,genricStockHandler BSE){
    	   
    	this.user = user;
    	this.BSE = BSE;
        
       }
       
       void depositMoney(Login.User userdetail, double amount) {
             userdetail.money += amount;
       }
       
       boolean withdrawMoney(Login.User userdetail, double amount) {
             if(userdetail.money < amount) {
                    System.out.println("Insufficient balance in the account");
                    return false;
             }
             else {
                    userdetail.money -= amount;
                    System.out.println("Amount has been debitted");
                    return true;
             }
       }
       
       
       public double securityTransferTax(double amount) {
        final double tax = 0.001;
        return amount-(tax*amount);
  }
  
  public double transactionCharge(double amountToBeDebited) {
        final double tax = 0.005;
        double transactionFinal = amountToBeDebited-(tax*amountToBeDebited);
        
        if(transactionFinal<100)
               transactionFinal=100;
        
        return securityTransferTax(transactionFinal);
        
  }
  
  public void buyShares(Login.User userdetail, genricStockHandler BSE) {
       
      int sharesToBuy;
      double amountToBeDebited;
      Scanner in = new Scanner(System.in);
      
      System.out.println("Enter the name of the company:");
      String shareName = in.nextLine();
      if(BSE.checkShare(shareName))
      {
    	  
    	  bseStock = BSE.fetchStocks(shareName);
       	 System.out.println(bseStock);
      }
      else {
//        mainMenu(); //it will go to main menu option to reselect buy option    	  
      }
             
      System.out.println("Enter the number of shares you'd like to buy:");
      sharesToBuy = in.nextInt();
      
      //System.out.println(bseStock);//coming out as null //need to troubleshoot
      
      if(sharesToBuy > bseStock.Availableshares) {
             System.out.println("You cannot buy shares more than the available shares. Please re-try again");
//             mainMenu(); //it will go to main menu option to reselect buy option
      }
      else {
             amountToBeDebited = bseStock.Shareprice*sharesToBuy;
             double finalAmount=transactionCharge(amountToBeDebited);
             System.out.println("Total amount to pay for buying "+sharesToBuy+" shares is \\u20b9"+finalAmount);
             
             if(userdetail.money > finalAmount) {
             if(BSE.updateSharesInMarket(shareName, "Remove", sharesToBuy)) {
                            withdrawMoney(userdetail, finalAmount);
                                   if(userdetail.userHandler.checkShare(shareName)) {
                                  if(userdetail.userHandler.updateSharesInMarket(shareName, "Add", sharesToBuy))
                                         System.out.println("Shares updated to your account");
                            }
                            else {
                                  userdetail.userHandler.stockList.add(new Stocks(shareName,bseStock.Shareprice,sharesToBuy));
                                  System.out.println("Shares added to your account");
                                  userdetail.transactionReport.add(new Transaction(101, "Buy", LocalDate.now(), LocalTime.now(), shareName, bseStock.Shareprice, sharesToBuy, finalAmount));
       //                      mainMenu(); //it will go to main menu option to reselect buy option 
                            }
                           
              }
             else {
            	    System.out.println("Failed");
//                  mainMenu(); //it will go to main menu option to reselect buy option
             }
                                
             }
      }
  }

public void sellShares(Login.User userdetail, genricStockHandler bSE2) {
      
         int sharesToSell;
      double amountToBeCredited;
      Scanner in = new Scanner(System.in);
      
      System.out.println("Enter the name of the company:");
      String shareName = in.next();
      if(userdetail.userHandler.checkShare(shareName))
         userStock = userdetail.userHandler.fetchStocks(shareName);
      else
         System.out.println("Share not available");
//      mainMenu(); //it will go to main menu option to reselect buy option
      System.out.println("Enter the number of shares you'd like to sell:");
      sharesToSell = in.nextInt();
      
      if(sharesToSell > userStock.Availableshares) {
             System.out.println("You cannot sell shares more than the available shares. Please re-try again");
//             mainMenu(); //it will go to main menu option to reselect buy option
      }
      else {
             amountToBeCredited = userStock.Shareprice*sharesToSell;
             double finalAmount=transactionCharge(amountToBeCredited);
             System.out.println("Total amount to be credited for selling "+sharesToSell+" shares is \\u20b9"+finalAmount);
             if(bSE2.updateSharesInMarket(shareName, "Add", sharesToSell) && userdetail.userHandler.updateSharesInMarket(shareName, "Remove", sharesToSell)) {
             depositMoney(userdetail, finalAmount); //calls deposit function to deposit the money to user's wallet
             System.out.println("Shares sold successful");
             userdetail.transactionReport.add(new Transaction(101, "Sell", LocalDate.now(), LocalTime.now(), shareName, bseStock.Shareprice, sharesToSell, finalAmount));
             }
                 
             
      }           
}


  
 public static void viewTransactionReportForDate(LinkedList<Transaction> transactionReport){
       
       Scanner sc =  new Scanner(System.in);
       System.out.println("Enter the start date:");
       System.out.println("Enter the start year:");
       int startYear = sc.nextInt();
             System.out.println("---------------------------------------------");
             System.out.println("          Transaction Report");
             System.out.println("---------------------------------------------");
             for(Transaction t : transactionReport) {
                    System.out.println(t);
             }
}

 public static void viewTransactionReportForShare(LinkedList<Transaction> transactionReport){
       
       Scanner sc =  new Scanner(System.in);
       System.out.println("Enter the start date:");
       System.out.println("Enter the start year:");
       int startYear = sc.nextInt();
             System.out.println("---------------------------------------------");
             System.out.println("          Transaction Report");
             System.out.println("---------------------------------------------");
             for(Transaction t : transactionReport) {
                    System.out.println(t);
             }
}

 public static void viewTransactionReport(LinkedList<Transaction> transactionReport){
       
       Scanner sc =  new Scanner(System.in);
       System.out.println("Enter the start date:");
       System.out.println("Enter the start year:");
       int startYear = sc.nextInt();
             System.out.println("---------------------------------------------");
             System.out.println("          Transaction Report");
             System.out.println("---------------------------------------------");
             for(Transaction t : transactionReport) {
                    System.out.println(t);
             }
}

//       public static void main(String[] args)throws Exception {
//             
//             LinkedList<Transaction> transactionReport = new LinkedList<Transaction>();
//             
//             
//             
////           Transaction t1 = new Transaction(101, "Buy", LocalDate.of(2019, 12, 12), LocalTime.of(03, 35));
////           Transaction t2 = new Transaction(102, "Buy", LocalDate.of(2019, 12, 20), LocalTime.of(04, 20));
////           Transaction t3 = new Transaction(103, "Sell", LocalDate.of(2020, 01, 15), LocalTime.of(9, 40));
////           Transaction t4 = new Transaction(104, "Buy", LocalDate.of(2020, 02, 12), LocalTime.of(02, 15));
////           
////           transactionReport.add(t1);
////           transactionReport.add(t2);
////           transactionReport.add(t3);
////           transactionReport.add(t4);
////           
////           TransactionAPI.viewTransactionReport(transactionReport);
//             
//             Stocks s1 = new Stocks("Amazon",100,500);
//             Stocks s2 = new Stocks("Flipkart",90,500);
//             Stocks s3 = new Stocks("Walmart",80,500);
//             Stocks s4 = new Stocks("Jabong",70,500);
//             Stocks s5 = new Stocks("Myntra",60,500);
//             Stocks s6 = new Stocks("koovs",50,500);
//             Stocks s7 = new Stocks("nike",40,500);
//        
//        LinkedList<Stocks> stockDBList = new LinkedList<Stocks>();
//        stockDBList.add(s1);
//        stockDBList.add(s2);
//        stockDBList.add(s3);
//        stockDBList.add(s4);
//        stockDBList.add(s5);
//        stockDBList.add(s6);
//        stockDBList.add(s7);
//        
//        genricStockHandler BSE = new genricStockHandler(stockDBList);
//        BSE.checkShare("Amazon");
//
//        
//        
//
//             
//         String sDate1="31/12/1998";  
//         Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
//         System.out.println(sDate1+"\t"+date1);
//       }
       

}

