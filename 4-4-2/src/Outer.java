/**
 * Created by Bea on 06/02/2017.
 */
public class Outer {
    int x = 1;
    public void test(){
        Inner i = new Inner();
        i.display();
        showy();
    }
    public static void n(){
        Outer r = new Outer();
        Inner t = r.new Inner();
        (t.y)++;
    }

    public class Inner{
        public void display(){
            System.out.println("x = " + x);
        }
        private int y = 3;
    }

    public void showy(){
        System.out.println("y = " + (new Inner().y));
    }
}
