import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdditionClient {
    public static final String UNIQUE_BINDING_NAME = "server.addition";

   public static void main(String[] args) throws RemoteException, NotBoundException {

       final Registry registry = LocateRegistry.getRegistry(2022);

       Addition addition = (Addition) registry.lookup(UNIQUE_BINDING_NAME);

       int result = addition.add(40,24);

       System.out.println(result);
   }
}
