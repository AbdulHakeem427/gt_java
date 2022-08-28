package smscomponent;

import java.io.Serializable;

public class SMSComponent implements SMS, Serializable{
	public SMSComponent() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void sendSMS() {
		System.out.println("SMS logic executed...");
	}
	
}
