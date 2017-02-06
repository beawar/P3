/**
 * Created by Bea on 06/02/2017.
 */
public class ThreadTest extends Thread {
    public ThreadTest(String x){
        super(x);
    }

    @Override
    public void run() {
        for (int k = 0; k <= 5; k++){
            System.out.println("Thread "+getName()+"\tCiclo "+k);
        }
    }

    public static void main(String[] args) {
        new ThreadTest("Antonio").start();
        new ThreadTest(" Berto").start();
        new ThreadTest("  Carlo").start();
        new ThreadTest("   Diego").start();
    }
}
