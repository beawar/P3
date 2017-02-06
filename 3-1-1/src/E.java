/**
 * Created by Bea on 05/02/2017.
 */
public class E {
    private String s;
    public E(String o){
        s=o;
    }

    public static void main(String[] args) {
        E ref1 = new E("Gastone");
        E ref2 = new E("Gastone");
        if (ref1.equals(ref2))
            System.out.println("ref1 equals ref2");
        else
            System.out.println("!(ref1 equals ref2)");

        String s1 = new String("Gastone");
        String s2 = new String("Gastone");
        if (s1.equals(s2))
            System.out.println("s1 equals s2");
        else
            System.out.println("!(s1 equals s2)");
    }
}
