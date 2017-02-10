import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Bea on 09/02/2017.
 */
public class IPFinder {
    public static void main(String[] args) {
        String host = "java.sun.com";
        try{
            InetAddress localadd = InetAddress.getLocalHost();
            InetAddress address = InetAddress.getByName(host);
            System.out.println(address+" local: "+localadd);
        }
        catch (UnknownHostException e){
            System.out.println(host+ " sconosciuto");
        }
    }
}
