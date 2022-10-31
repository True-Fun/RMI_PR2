import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

interface Addition extends Remote
{
 public int add(int a, int b) throws RemoteException;
}

class AdditionImpl implements Addition
{
 @Override
 public int add(int a, int b) throws RemoteException
 {
  int result=a+b;
  return result;
 }
}
public class AdditionServer {
   public static final String UNIQUE_BINDING_NAME = "server.addition";
   
   public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {

       final AdditionImpl server = new AdditionImpl();
       System.out.println("AdditionServer запущен успешно.");
       final Registry registry = LocateRegistry.createRegistry(2022);
       Remote stub = UnicastRemoteObject.exportObject(server, 0);
       registry.bind(UNIQUE_BINDING_NAME, stub);
       Thread.sleep(Integer.MAX_VALUE);

   } 
}
