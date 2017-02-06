/**
 * Created by Bea on 05/02/2017.
 */
public class C {
    Object[] o;
    public C(){}
    public static void main(String[] args) {
        if (args[0].equals("1")){

            System.out.println(args[0]);
        }
        else if (args[0].equals("2")){
            Object x = new Integer(0);
            System.out.println((String)x);
        }
    }
}
