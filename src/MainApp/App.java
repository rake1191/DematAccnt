package MainApp;
import MainApp.getInputs;
import StockApp.Stocks;

import Transaction.Transaction;
import Login.User;
import Login.LinkedlistUser;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

import StockApp.StockDatabase;
import StockApp.Stocks;
import StockApp.genricStockHandler;

public class App {

	public static void main(String[] args) {
		
		
		// creating a list of stocks to be enlisted in BSE Stock exchange
		
		getInputs entryPoint = new getInputs();
		entryPoint.mainMenu();
		//System.out.println(entryPoint.userlist);
		
//		
//		// creating a sample user
//		User newuser = new User("rakeshc", "password", 10000.0, "22222", 0);
//		
//		//creating a list of stock which will hold the stocks the user has bought
//		LinkedList<Stocks> stockList2 = new LinkedList<Stocks>();
//		//populating user stock list
//		stockList2.add(s5);
//		stockList2.add(s6);
//		stockList2.add(s7);
//		
//		genricStockHandler BSE = new genricStockHandler(stockList); //handler for BSE Stock operations
//		newuser.UserStock = new genricStockHandler(stockList2); //handler for Customer Stock wallet
//		
//		
//		BSE.listShares();
//		System.out.println("***\n");
//		System.out.println("***\n");
//		newuser.UserStock.listShares();
//		
//		BSE.updateSharesInMarket("Flipkart","Add",-10);
//		BSE.updateSharesInMarket("Flipkart","Add",510);
//		BSE.updateSharesInMarket("Flipkart","Remove",20);
//		
//		if(!BSE.updateSharesInMarket("Flipkart2","Sell",20) ) {
//			System.out.println("**Invalid stock Name**\n");
//		}
//		
//		BSE.listSpecificShares("Flipkart");
//		BSE.checkShare("Flipkart");
//		BSE.checkShare("Flipkart2");
//		System.out.println(BSE.fetchStocks("Flipkart").Sharename);
//
//		
//	    LinkedList<Transaction> transactionReport = new LinkedList<Transaction>();
//	    
//	    Transaction t1 = new Transaction(101, "Buy", LocalDate.of(2019, 12, 12), LocalTime.of(03, 35),"Flipkart",90,20,0);
////        Transaction t2 = new Transaction(102, "Buy", LocalDate.of(2019, 12, 20), LocalTime.of(04, 20),"Flipkart",90,20,0,20,1800);
////        Transaction t3 = new Transaction(103, "Sell", LocalDate.of(2020, 01, 15), LocalTime.of(9, 40),"Flipkart",90,20,0,20,1800);
////        Transaction t4 = new Transaction(104, "Buy", LocalDate.of(2020, 02, 12), LocalTime.of(02, 15),"Flipkart",90,20,0,20,1800);
//        
//        transactionReport.add(t1);
//        //genricStockHandler UsersShares = new genricStockHandler(stockList);
		
	}

}
