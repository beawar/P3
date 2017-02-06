/**
 * Created by Bea on 06/02/2017.
 */
public class SimpleThread extends Thread {
    private static int threadCount = 0;
    private int threadNumber = ++threadCount;
    private int countDown = 4;
    public SimpleThread(){
        try {
            sleep(1);
        }
        catch (InterruptedException e){
            return;
        }
        System.out.println("Costruzione del thread "+threadNumber);
    }

    @Override
    public void run() {
        System.out.println(currentThread().getName());
        while (countDown > 0) {
            System.out.println("Thread " + threadNumber + " (" + countDown + ")");
            countDown--;
            if (countDown == 0) {
                System.out.println("Thread " + threadNumber + " HA FINITO");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(currentThread().getName());
        for (int i = 0; i < 5; i++){
            new SimpleThread().start();
        }

        System.out.println("Tutti i thread sono vivi");
    }
}
