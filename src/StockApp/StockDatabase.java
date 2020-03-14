package StockApp;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import StockApp.Stocks;

public class StockDatabase{
	
	LinkedList<Stocks> stockList = new LinkedList<Stocks>();
	
	public StockDatabase(){
		
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
	}
	
	public boolean updateSharesInMarket(String Sharename, String TransactionType, int quantity){
		
		for(Stocks stocks : stockList) {
			if(stocks.Sharename==Sharename) {
				if(TransactionType=="Buy") {
					if(quantity<=0) {
						System.out.println("**Please Enter Quantity as more than 1**\n");
					}
					else if(stocks.Availableshares>quantity) {
						stocks.Availableshares = stocks.Availableshares-quantity;
						return true;
					}
					else {
						System.out.println("**Requested Number of Shares Not available**\n");
						return false;
					}
				}
				if(TransactionType=="Sell") {
						stocks.Availableshares = stocks.Availableshares+quantity;
						return true;
				}
			}
		}
		return false;
	}
	
	public void listShares() {
		for(Object o : stockList) {
			((Stocks) o).showShareDetails();
		}
	}
	
	public void listSpecificShares(String ShareName) {
		stockList.stream().filter(p-> p.Sharename==ShareName).forEach(share->System.out.println(share.showShareDetails()));
	}
	
	public Stocks fetchStocks(String Name) {
		List<Stocks> filteredProducts = stockList.stream().filter(p-> p.Sharename==Name).collect(Collectors.toList());
		System.out.println(filteredProducts);
		return filteredProducts.get(0);
	}
	
	public boolean checkShare(String Name) {
		List<Stocks> filteredProducts = stockList.stream().filter(p-> p.Sharename==Name).collect(Collectors.toList());
		if(filteredProducts.size()==1) {
			System.out.println("Stock Available");
			return true;
		}else {
			System.out.println("Stock Not Available");
			return false;
		}
		
	}
	
	
}

