package BookOfShares;

import java.util.List;
import java.util.stream.Collectors;

public class SharesInPosseion {

	String StockName;
	double StockPrice;
	int StockQty;
	
	public SharesInPosseion(){
		this.StockName = "NA";
		this.StockPrice = 0;
		this.StockQty = 0; 
	}
	public SharesInPosseion(String StockName, double StockPrice, int StockQty){
		this.StockName = StockName;
		this.StockPrice = StockPrice;
		this.StockQty = StockQty; 
	}
	
	
	
	
	
	
	
	@Override
    public String toString() {
          
          StringBuffer buffer = new StringBuffer();
           buffer.append("\n**********Shares In Possesion***************");
          buffer.append("\n Transaction ID:"+StockName);
          buffer.append("\n Transaction Date:"+StockPrice);
          buffer.append("\n Transaction Time:"+StockQty);
          buffer.append("\n*********************************************");
          return buffer.toString();
    }
}
