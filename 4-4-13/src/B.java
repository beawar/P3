/**
 * Created by Bea on 06/02/2017.
 */
public class B extends A {
    private String s;

    @Override
    public void m() {
        System.out.println(s);
    }
    public B(String s){
        this.s = s;
    }
}
