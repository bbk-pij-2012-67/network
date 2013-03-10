import java.rmi.Remote;
import java.rmi.RemoteException;

/**
* Echo Interface
*/
public interface EchoService extends Remote{
	/**
	* Returns the same string passed as parameter
	* @param s a string
	* @return the same string passed as parameter
	*/
	public String echo(String s) throws RemoteException;
}
