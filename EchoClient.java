import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;

public class EchoClient{
	
	public static void main(String[] args){
		try{
		Remote service = Naming.lookup("//192.168.1.105/echo");
		EchoService echoService = (EchoService) service;
		
		String receivedEcho = echoService.echo("Hello!");
		
		System.out.println(receivedEcho);
		}catch(NotBoundException ex){
			ex.printStackTrace();
		}catch(MalformedURLException ex){
			ex.printStackTrace();
		}catch(RemoteException ex){
			ex.printStackTrace();
		}
	}
}

