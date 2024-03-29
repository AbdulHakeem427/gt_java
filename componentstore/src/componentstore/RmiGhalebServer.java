package componentstore;

import java.io.FileInputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Enumeration;
import java.util.Properties;

import emailcomponent.Email;
import emailcomponent.EmailComponent;
import smscomponent.SMS;
import smscomponent.SMSComponent;

public class RmiGhalebServer extends UnicastRemoteObject implements Business{
	public RmiGhalebServer() throws RemoteException{
		// TODO Auto-generated constructor stub
	}
	
//	 @Override
//	 public Object getGhalebStoresObject() throws RemoteException { 
//	//  TODO Auto-generated method stub
//	 System.out.println("get ghaleb store object method called..."); 
//  try { Object  
//	 obj=Proxy.newProxyInstance(new MyApp().getClass().getClassLoader(), new Class[] {
//	  Email.class,SMS.class
//			  }, new MyInvocationHandler(new Object[] {new
//	 MyApp(),new EmailComponent(),new SMSComponent()})); return obj;
//	 }catch(Exception e) { e.printStackTrace(); return null; }
//	  
//	  }
 
	@Override
	public Object getGhalebStoresObject() throws RemoteException {
			int count=0;
				try {
					Properties prop=new Properties();
					prop.load(new FileInputStream("service-config.properties"));
					Enumeration counten=prop.elements();
					int noofservices=0;
					while(counten.hasMoreElements()) {
						noofservices=noofservices+1;
						System.out.println(counten.nextElement());
					}
					System.out.println("No of services...:"+noofservices);
					Class c[]=new Class[noofservices];
					Object o[]=new Object[noofservices];
					Enumeration en=prop.elements();
					while(en.hasMoreElements()) {
						String serviceConfigFile=(String)en.nextElement();
						System.out.println("service files...:"+serviceConfigFile);
						Properties servicesProp=new Properties();
						servicesProp.load(new FileInputStream(serviceConfigFile));
						String interfaceimpl=servicesProp.getProperty("interfaceimpl");
						String interfacename=servicesProp.getProperty("interfacename");
						o[count]=Class.forName(interfaceimpl).getConstructor(null).newInstance(null);
						c[count]=Class.forName(interfacename);
						//list.add(Class.forName(interfacename));
						//list.add(interfacename);
						++count;
						}
					
					Object obj=Proxy.newProxyInstance(new MyApp().getClass().getClassLoader(), 
							c,new MyInvocationHandler(o));
					//System.out.println("The object...:"+obj);
					return obj;
				}catch(Exception e) {
					e.printStackTrace();
					return null;
				}
	}
	
	public static void main(String[] args)throws Exception {
		RmiGhalebServer ghalebServer=new RmiGhalebServer();
		
		LocateRegistry.createRegistry(2020);
		
		Naming.bind("rmi://localhost:2020/ghalebstore", ghalebServer);
		System.out.println("Server Ready...");
	}
}
class MyInvocationHandler implements InvocationHandler,Serializable{
	Object o[];
	public MyInvocationHandler(Object o[]) {
		this.o=o;
	}
	Object r=null;
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		for(Object obj:o) {
			try {
				r=method.invoke(obj, args);
			}catch(Exception e) {}
		}
		return r;
	}
}
class MyApp implements Serializable{}