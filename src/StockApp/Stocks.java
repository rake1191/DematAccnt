package StockApp;

public class Stocks{
	
	public String Sharename;
	public double Shareprice;
	public int Availableshares;
	
	Stocks(){
		Sharename = "NAA";
		Shareprice = 0;
		Availableshares = 0;
	}
	
	public Stocks(String Sharename, double Shareprice, int Availableshares) {
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
}