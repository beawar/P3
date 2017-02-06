/**
 * Created by Bea on 05/02/2017.
 */
public class B extends A {
    private void sd(){
        System.out.println("B.sd()");
    }

    @Override
    public void dd() {
        System.out.println("B.dd()");
    }

    public static void main(String[] args) {
        B b = new B();
        A a = new B();
        b.demoDispatch();
        a.demoDispatch();
    }
}
