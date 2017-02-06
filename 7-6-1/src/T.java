/**
 * Created by Bea on 06/02/2017.
 */
public class T extends Thread {
    private int num;
    private C c;
    public T(int x, C y){
        num = x;
        c = y;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            c.m();
            System.out.println("Thread "+num+": c.i= "+c.getI());
        }
    }

    public static void main(String[] args) {
        C c = new C();
        T t1 = new T(1, c), t2 = new T(2, c);
        t1.start();
        t2.start();
    }
}
