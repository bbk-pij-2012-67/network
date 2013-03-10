import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
* Echo Class
*/
public class EchoServer extends UnicastRemoteObject implements EchoService{
	
	public EchoServer() throws RemoteException{
		
	}
	
	@Override
	public String echo(String s) throws RemoteException{
		System.out.println("Replied to some client saying '" + s + "'");
		return s;
	}
}
