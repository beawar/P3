/**
 * Created by Bea on 05/02/2017.
 */
public class C {
    private static int s = 0;
    private int x;
    public C(){
        this(1);
    }
    public C(int n){
        x = n;
        System.out.println(" C(n): x = " + x);
    }
    public int getS(){
        return s;
    }
    public int getX(){
        return x;
    }
}
