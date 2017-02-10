import java.rmi.Naming;

/**
 * Created by Bea on 10/02/2017.
 */
public class RemoteClient {
    public static void main(String[] args) throws Exception{
        X x = (X) Naming.lookup("pippo");

        C c=x.m();
        System.out.println("2c: "+c);

        //Punto di synch 1
        System.out.println("3c: "+x.m());
        System.out.println("4c: "+c);
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e){}
        //Punto di synch 2
        C c1 = new C();
        c1.f();
        System.out.println("7c: "+c1);
        C.E.foo1(c1);
        System.out.println("9c: "+c1);
        C.E.foo2(c1, new C());
        System.out.println("11c: "+c1);

        x.k(c1);
        System.out.println("13c: "+c1);

    }
}
