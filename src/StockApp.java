import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Stocks{
	
	String Sharename;
	double Shareprice;
	int Availableshares;
	
	Stocks(){
		Sharename = "NA";
		Shareprice = 0;
		Availableshares = 0;
	}
	
	Stocks(String Sharename, double Shareprice, int Availableshares) {
		this.Sharename = Sharename;
		this.Shareprice = Shareprice;
		this.Availableshares = Availableshares;
	}
	
	void updateShares(String Sharename,int quantity){
		this.Availableshares = quantity;
	}
	
	boolean showShareDetails() {
		System.out.println("######## "+Sharename+" ########\n");
		System.out.println("Shareprice: \u20b9"+Shareprice);
		System.out.println("Availableshares: "+Availableshares+" Availableshares");
		System.out.println("########################"+"\n");
		return false;
	}
	
//	@Override
//	public String toString() {
//		return "######## "+Sharename+" ########\n"+
//		"Shareprice: "+Shareprice+"\n"+
//		"Availableshares: "+Availableshares+"\n"+
//		"########################"+"\n";
//	}
}

class StockDatabase{
	
	LinkedList<Stocks> stockList = new LinkedList<Stocks>();
	
	StockDatabase(){
		
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
	
	String updateSharesInMarket(String Sharename, String TransactionType, int quantity){
		
		for(Stocks stocks : stockList) {
			if(stocks.Sharename==Sharename) {
				if(TransactionType=="Buy") {
					if(quantity<=0) {
						System.out.println("**Please Enter Quantity as more than 1**\n");
					}
					else if(stocks.Availableshares>quantity) {
						stocks.Availableshares = stocks.Availableshares-quantity;
						return "Success";
					}
					else {
						System.out.println("**Requested Number of Shares Not available**\n");
						return "Shares Not available";
					}
				}
				if(TransactionType=="Sell") {
						stocks.Availableshares = stocks.Availableshares+quantity;
						return "Success";
				}
			}
		}
		return "Operation Failed";
	}
	
	void listShares() {
		for(Object o : stockList) {
			((Stocks) o).showShareDetails();
		}
	}
	
	void listSpecificShares(String ShareName) {
		stockList.stream().filter(p-> p.Sharename==ShareName).forEach(share->System.out.println(share.showShareDetails()));
	}
	
	Stocks fetchStocks(String Name) {
		List<Stocks> filteredProducts = stockList.stream().filter(p-> p.Sharename==Name).collect(Collectors.toList());
		System.out.println(filteredProducts);
		return filteredProducts.get(0);
	}
	
	boolean checkShare(String Name) {
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


public class StockApp {

	public static void main(String[] args) {
		
		StockDatabase BSE = new StockDatabase();
		BSE.listShares();
		
		BSE.updateSharesInMarket("Flipkart","Buy",-10);
		BSE.updateSharesInMarket("Flipkart","Buy",510);
		BSE.updateSharesInMarket("Flipkart","Sell",20);
		
		if(BSE.updateSharesInMarket("Flipkart2","Sell",20) == "Operation Failed") {
			System.out.println("**Invalid stock Name**\n");
		}
		
		BSE.listSpecificShares("Flipkart");
		BSE.checkShare("Flipkart");
		BSE.checkShare("Flipkart2");
		System.out.println(BSE.fetchStocks("Flipkart").Sharename);
		
	}
}
