/**
 * Created by Bea on 06/02/2017.
 */
public class A {
    public void  print (String s){
        System.out.println(s + " ");
    }

    public void m1(){
        print("A.m1");
        m2();
    }

    public void m2(){
        print("A.m2");
    }
}
