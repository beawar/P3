/**
 * Created by Bea on 08/02/2017.
 */
public class Ex {
    private final Stato s;
    private int n = 0;
    private int n_thread;
    Ex(int n_thread){
        s = new Stato();
        this.n_thread = n_thread;
    }

    class Stato{
        private int prox = 0;
        public synchronized boolean isProx(int i){
            return prox==i;
        }
        public synchronized void next(){
            if (prox == n_thread-1){
                System.out.println();
                prox = 0;
            }
            else prox++;
            notifyAll();
        }
    }

    class T extends Thread{
        private int num;
        private String p;
        T(String s){
            num = n++;
            p = s;
        }

        @Override
        public void run() {
            for (int i=0; i<100; i++){
                synchronized (s) {
                    while (!s.isProx(num)) {
                        try {
                            s.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    System.out.print(p);
                    s.next();
                }
            }
        }
    }
    /* Es A
    public static void main(String[] args) {
        Ex e = new Ex(3);
        Ex.T t1 = e.new T("essere");
        Ex.T t2 = e.new T(" o ");
        Ex.T t3 = e.new T("non essere?");
        t1.start(); t2.start(); t3.start();
    }
    */
    /* Es B */
    public static void main(String[] args){
        Ex e = new Ex(3);
        Ex.T t1 = e.new T("essere");
        Ex.T t2 = e.new T(" o ");
        Ex.T t3 = e.new T("non essere?");

        Ex f = new Ex(2);
        Ex.T r1 = f.new T(" poter ");
        Ex.T r2 = f.new T(" non poter ");

        t3.start(); t2.start(); t1.start();
        r2.start(); r1.start();
    }
}
