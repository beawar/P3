/**
 * Created by Bea on 05/02/2017.
 */
public class D extends C {
    Z x = new Z(5), y = new Z(6);
    D(){
        super();
        x = new Z(7);
    }

    public static void main(String[] args) {
        D d = new D();
        System.out.println("\n" + d.i.z + " " + d.j.z
        + " " + d.x.z + " " + d.y.z);
    }
}
