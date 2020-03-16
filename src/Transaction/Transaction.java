package Transaction;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
       
       public int transactionID;
       public String transactionType;
       LocalDate transactionDate;
       LocalTime transactionTime;
       String shareName;
       double sharePricePerUnit;
       int numberOfShares;
       double transactionAmount;

       public Transaction(int transactionID, String transactionType, LocalDate transactionDate, LocalTime transactionTime,
                    String shareName, double sharePricePerUnit, int numberOfShares, double transactionAmount) {
             super();
             this.transactionID = transactionID;
             this.transactionType = transactionType;
             this.transactionDate = transactionDate;
             this.transactionTime = transactionTime;
             this.shareName = shareName;
             this.sharePricePerUnit = sharePricePerUnit;
             this.numberOfShares = numberOfShares;
             this.transactionAmount = transactionAmount;
       }

       @Override
       public String toString() {
             
             StringBuffer buffer = new StringBuffer();
              buffer.append("\n*********************************************");
             buffer.append("\n Transaction ID:"+transactionID);
             buffer.append("\n Transaction Date:"+transactionDate);
             buffer.append("\n Transaction Time:"+transactionTime);
             buffer.append("\n Transaction Type:"+transactionType);
             buffer.append("\n Share Name:"+shareName);
             buffer.append("\n Price of Share per unit:"+sharePricePerUnit);
             buffer.append("\n Number of shares transacted:"+numberOfShares);
             buffer.append("\n Transaction Amount:"+transactionAmount);
              buffer.append("\n*********************************************");
             return buffer.toString();
       }
       

}

