import java.io.Serializable;

/**
 * Created by Bea on 06/02/2017.
 */
public class Main implements Serializable, Comparable{
    public static boolean F(Object r){
        if (r instanceof String)
            return true;
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("1: " + F("s"));
        System.out.println("2 - Object: " + F(new Object()));
        Object o = "s";
        System.out.println("3: " + F(o));
        System.out.println("4: " + F(new Main()));
    }
}
