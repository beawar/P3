/**
 * Created by Bea on 05/02/2017.
 */
public class E extends D {
    public E(){
        Integer i = new Integer(s);
        System.out.println(i.intValue());
    }
    public int m(D ref){
        return 5;
    }

    public static void main(String[] args) {
        C r = new C(5);
        C s = new D();
        D t = new E();
        E u = new E();
        System.out.println(r.m(t)+" "+s.m(r)+" "+t.m(s)+" "+u.m(t));
    }
}
