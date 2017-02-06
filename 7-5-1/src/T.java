/**
 * Created by Bea on 06/02/2017.
 */
public class T extends Thread {
    private int num;
    private boolean runFlag = false;
    public boolean isRunning(){
        return runFlag;
    }
    public T(int x) {
        num = x;
    }

    @Override
    public void run() {
        runFlag = true;
        for (int i = 0; i<100000; i++);
        System.out.println("Thread num "+num+" terminato");

    }
}
