import java.util.Random;

/**
 * Created by Bea on 06/02/2017.
 */
public class ContoBancario {
    private  int num;
    private int saldo;
    ContoBancario(int n, int s){
        num = n;
        saldo = s;
    }
    public synchronized int getSaldo(){
        return saldo;
    }

    public synchronized void deposita(int n){
        saldo += n;
    }

    public synchronized void preleva(int n){
        saldo -= n;
    }

    public void trasferisci(int n, ContoBancario dest){
        preleva(n);
        dest.deposita(n);
    }

    public static void main(String[] args) {
        Random random = new Random();
        ContoBancario c1 = new ContoBancario(10000, random.nextInt(100)),
                c2 = new ContoBancario(5000, random.nextInt(100));
        Runnable r1 = () -> {
            c1.preleva(random.nextInt(100));
            System.out.println("C1: " + c1.getSaldo());
            c2.deposita(random.nextInt(1000));
            System.out.println("C2: " + c2.getSaldo());
            c1.trasferisci(150, c2);
            System.out.println("C1: " + c1.getSaldo());
            System.out.println("C2: " + c2.getSaldo());
        };
        Runnable r2 = () -> {
            c2.preleva(random.nextInt(100));
            System.out.println("C2: " + c2.getSaldo());
            c1.deposita(random.nextInt(1000));
            System.out.println("C1: " + c1.getSaldo());
            c2.trasferisci(150, c2);
            System.out.println("C1: " + c1.getSaldo());
            System.out.println("C2: " + c2.getSaldo());
        };
        new Thread(r1).start();
        new Thread(r2).start();


    }
}
