/**
 * Created by Bea on 06/02/2017.
 */
public class A {
    public void g(Y y){
        System.out.println("pluto");
        y.fun();
    }

    public X m(){
        return (int i) -> System.out.println("paperino");
    }

    public void f(){
        g(new Y() {
            @Override
            public void fun() {
                X x = m();
                x.fun(1);
            }

            @Override
            public void fun(int i) {

            }
        });
    }

    public static void main(String[] args) {
        A a = new A();
        a.f();
    }
}
