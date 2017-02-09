/**
 * Created by Bea on 09/02/2017.
 */
public class Z {
    String s = new String("XXX");
    synchronized void m(){
        if (s.equals("XXX")){
            s = "YYY";
            System.out.print("Ping");
        }
        else{
            s = "XXX";
            System.out.print("Pong ");
            System.out.println();
        }
    }
}
