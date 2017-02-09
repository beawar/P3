/**
 * Created by Bea on 07/02/2017.
 */
public class T extends Thread {
    Object o1, o2;
    T(Object o1, Object o2){
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        while(true){
            synchronized (o1){
                System.out.println("T preso o1");
                synchronized (o2){
                    System.out.println("T preso o2");
                    try {
                        o2.wait();
                        wait();
                        o2.notify();
                    }
                    catch (InterruptedException e){
                        System.out.println("T");
                    }
                }
                System.out.println("T fine o2");
            }
            System.out.println("T fine o1");
        }
    }
}
