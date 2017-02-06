/**
 * Created by Bea on 06/02/2017.
 */
public class E {
    public class Interna1{
        private int i = 5;
        public int value(){
            return i;
        }
    }
    public class Interna2{
        private String s;
        Interna2(String z){
            s = z;
        }
        String get(){
            return s;
        }
    }
    public Interna1 i1() {
        return new Interna1();
    }

    public Interna2 i2(String z){
        return new Interna2(z);
    }

    public void m(String z){
        Interna1 p = i1();
        Interna2 q = i2(z);
        System.out.println(q.get());
    }

    public static void main(String[] args) {
        E e1 = new E(), e2 = new E();
        e1.m("pippo");
        E.Interna1 x = e2.i1();
        E.Interna2 y = e2.i2("pluto");
        System.out.println("x value = "+x.value());
        System.out.println("y value = "+y.get());

    }
}
