package StockApp;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import StockApp.Stocks;

public class genricStockHandler{
	
	public LinkedList<Stocks> stockList;
	
	public genricStockHandler(LinkedList<Stocks> stockList){
		this.stockList = stockList;
	}
	
	public boolean updateSharesInMarket(String Sharename, String TransactionType, int quantity){
		
		for(Stocks stocks : stockList) {
			if(stocks.Sharename==Sharename) {
				if(TransactionType=="Add") {
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
				if(TransactionType=="Remove") {
						stocks.Availableshares = stocks.Availableshares+quantity;
						return true;
				}
			}
		}
		return false;
	}
	
	public void listShares() {
		for(Stocks o : stockList) {
			o.showShareDetails();
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


