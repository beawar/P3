import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * Created by Bea on 10/02/2017.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        try{
            Albero2 a = (Albero2) Naming.lookup("rmi://localhost/Albero");
            Object lock = new Object();
            class T2 extends Thread{
                private Object o;
                private Albero2 a;
                private String controlla, stampa1, stampa2, stampa3;

                T2(Albero2 a, Object o,String c, String s1, String s2, String s3){
                    this.o = o;
                    this.a = a;
                    controlla = c;
                    stampa1 = s1;
                    stampa2 = s2;
                    stampa3 = s3;
                }

                @Override
                public void run() {
                    try {
                        sleep((int)(Math.random()*15));
                        synchronized (o){
                                if (a.presente(controlla)) {
                                    System.out.println(stampa1);
                                } else {
                                    System.out.println(stampa2);
                                }

                            try{
                                sleep((int)(Math.random()*10));
                            }
                            catch (InterruptedException e){}

                            System.out.println(stampa3);
                        }
                    }
                    catch (RemoteException e){
                        System.out.println("Errore1");
                    }
                    catch (InterruptedException e){
                        System.out.println("Interrupted");
                    }
                }
            }

            T2 t2 = new T2(a, lock, "quo", "BIANCO", "NERO", "ROSSO"),
                    t3 = new T2(a, lock, "qui", "UNO", "DUE", "TRE");

            t2.start(); t3.start();
        }
        catch (ConnectException e){
            System.out.println("Errore di connessione");
        }


    }
}
