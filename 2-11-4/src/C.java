/**
 * Created by Bea on 05/02/2017.
 */
public class C {
    public static void F(Object r, Object s){
        Object t = r;
        r = s;
        s = t;
    }

    public static void main(String[] args) {
        Integer x = new Integer(2),
                y = new Integer(3);
        F(x, y);
        System.out.println(x + " " + y);
        String s = new String("pippo");
        F(x, s);
        System.out.println(x + " " + y + " " + s);
    }
}
