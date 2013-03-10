import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.net.MalformedURLException;

public class EchoServerLauncher{
	
	public static void main(String[] args){
			EchoServerLauncher esl = new EchoServerLauncher();
			esl.launch();
		}
	
	public void launch(){
		
		
		//1. If there is no security manager, start one.
		if(System.getSecurityManager()==null){
			System.setSecurityManager(new RMISecurityManager());
		}
		try{
			//2. Create the registry if there is not one
			LocateRegistry.createRegistry(1099);
			//3. Create the server object
			EchoServer server = new EchoServer();
			//4. Register (bind) the server object on the registry.
			//   The registry may be on a different machine
			String registryHost = "//192.168.1.105/";
			String serviceName = "echo";
			Naming.rebind(registryHost + serviceName, server);
		}catch(MalformedURLException ex){
			ex.printStackTrace();
		}catch(RemoteException ex){
			ex.printStackTrace();
		}
	}
}	
