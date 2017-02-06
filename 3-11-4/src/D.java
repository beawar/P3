/**
 * Created by Bea on 05/02/2017.
 */
public class D extends C {
    private int y;
    public D(){
        y = getS();
        System.out.println(" D: y = " + y);
    }
    public static int m(C ref){
        if (ref instanceof D){
            System.out.println(" ISIO x,y,s =" +ref.getX()+((D) ref).y+ref.getS());
            return ref.getX() + ((D) ref).y;
        }
        else {
            System.out.println(" INIO x,s =" +ref.getX()+ref.getS());
            return ref.getS();
        }
    }

    public static void main(String[] args) {
        C c = new C(2);
        D d = new D();
        C cd = new D();
        //c.m(c) //Non compila
        System.out.println(d.m(c)+" "+d.m(d)+" "+d.m(cd));
        //cd.m(c) Non compila
    }
}
