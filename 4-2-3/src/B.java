/**
 * Created by Bea on 06/02/2017.
 */
public class B extends A {
    int k = 1;

    @Override
    public void m() {
        System.out.println("B.m(), k = "+k);
    }

    public B(int x){
        k=x;
        System.out.println("B.B(), k = "+k);
    }
}
