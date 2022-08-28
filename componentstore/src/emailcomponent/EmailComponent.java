package emailcomponent;

import java.io.Serializable;

public class EmailComponent implements Email,Serializable{
@Override
public void sendEmail() {
	System.out.println("email logic executed...................");
}
}
