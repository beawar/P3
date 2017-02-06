/**
 * Created by Bea on 05/02/2017.
 */
public class C {
    protected static String s = "2";
    public C(){this(2);}
    public C(int n){
        s= s + n;
        System.out.println(s.length());
    }
    public int m(C ref){
        if (ref instanceof D){
            return 2;
        }
        else {
            return 1;
        }
    }
}
