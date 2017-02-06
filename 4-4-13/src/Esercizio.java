/**
 * Created by Bea on 06/02/2017.
 */
public class Esercizio {
    public static void Fun(I ref){
        if (ref instanceof C){
            ((C) ref).n();
        }
        else if (ref instanceof B){
            ref.m();
        }

    }

    public static void main(String[] args) {
        I r1 = new B("pluto"), r2 = new C();
        Fun(r1);
        Fun(r2);
    }
}
