/**
 * Created by Bea on 06/02/2017.
 */
abstract class A {
    public abstract void m();
    public A(){
        System.out.println("In A() prima di m()");
        m();
        System.out.println("In A() dopo di m()");
    }
}
