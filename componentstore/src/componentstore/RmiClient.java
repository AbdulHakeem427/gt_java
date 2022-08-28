package componentstore;

import java.rmi.Naming;

import billpay.BillPayment;
import emailcomponent.Email;
import smscomponent.SMS;

public class RmiClient {
	public static void main(String[] args) throws Exception{
		Business business=(Business)Naming.lookup("rmi://localhost:2020/ghalebstore");
		
		Object obj=business.getGhalebStoresObject();
		
		Email email=(Email)obj;
		
		email.sendEmail();
		
		SMS sms=(SMS)obj;
		
		sms.sendSMS();
		
		BillPayment bp=(BillPayment)obj;
		bp.payBill(100);
		
	}
}
