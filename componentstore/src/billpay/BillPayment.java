package billpay;

import java.io.Serializable;

public interface BillPayment extends Serializable{
	
	public void payBill(int amt);
}