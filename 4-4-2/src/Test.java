/**
 * Created by Bea on 06/02/2017.
 */
public class Test {
    public static void main(String[] args) {
        Outer o = new Outer();
        o.test();
        Outer.Inner i = o.new Inner();
        i.display();
    }
}
