/**
 * Created by Bea on 09/02/2017.
 */
public class AlberoImpl implements Albero {
    private String info;
    private Albero figlioSin;
    private Albero figlioDx;

    AlberoImpl(String s){
        info = s;
        figlioSin = new AlberoVuoto();
        figlioDx = new AlberoVuoto();
    }
    public AlberoImpl(String s, Albero fs, Albero fd) {
        info = s;
        figlioSin = fs;
        figlioDx = fd;
    }

    @Override
    public int nNodi() {
        return figlioSin.nNodi() + figlioDx.nNodi() + 1;
    }

    @Override
    public Albero add(String s) {
        int ns = figlioSin.nNodi();
        int nd = figlioDx.nNodi();
        if (ns > nd){
            figlioDx = figlioDx.add(s);
        }
        else {
            figlioSin = figlioSin.add(s);
        }
        return this;
    }

    @Override
    public void stampa() {
        figlioSin.stampa();
        System.out.print(info+ " ");
        figlioDx.stampa();
    }

    @Override
    public boolean presente(String s) {
        return (s.equals(info) || figlioSin.presente(s) || figlioDx.presente(s));
    }


    class IteratoreSinistra implements Iteratore{
        private AlberoImpl current;

        IteratoreSinistra(){
            current = AlberoImpl.this;
        }

        @Override
        public boolean hasNext() {
        if (figlioSin instanceof AlberoVuoto){
            return false;
        }
        else return true;
    }

        @Override
        public String next() {
            if (hasNext()){
                current = (AlberoImpl)figlioSin;
                figlioSin = current.figlioSin;
                figlioDx = current.figlioDx;
                return current.info;
            }
            return null;
        }
    }

    public Iteratore itera(){
        Iteratore i = new IteratoreSinistra();
        if ((info = i.next())!= null)
            return i;
        else return null;
    }

    public static void main(String[] args) {
        Albero a = new AlberoImpl("pippo");
        a.add("pluto").add("paperino").add("minnie").
                add("topolino").add("gastone").add("paperone");
        a.stampa(); //- minnie - pluto - gastone - pippo - topolino - paperino -paperone -


        //*****************************
        //*          Punto A          *
        //*****************************

        class T1 extends Thread{
            private Albero a;

            T1(Albero a){
                this.a = a;
            }

            @Override
            public void run() {
                synchronized (a){
                    a.add("qui");
                }
                try {
                    sleep((int)(Math.random()*10));
                }
                catch (InterruptedException e){}
                synchronized (a){
                    a.add("quo");
                    a.stampa();
                }
            }
        }

        class T2 extends Thread{
            private Object o;
            private Albero a;
            private String controlla, stampa1, stampa2, stampa3;

            T2(Albero a, Object o,String c, String s1, String s2, String s3){
                this.o = o;
                this.a = a;
                controlla = c;
                stampa1 = s1;
                stampa2 = s2;
                stampa3 = s3;
            }

            @Override
            public void run() {
                synchronized (o){
                    synchronized (a) {
                        if (a.presente(controlla)) {
                            System.out.println(stampa1);
                        } else {
                            System.out.println(stampa2);
                        }
                    }
                    try{
                        sleep((int)(Math.random()*10));
                    }
                    catch (InterruptedException e){}

                    System.out.println(stampa3);
                }
            }
        }

        Object lock = new Object();
        T1 t1 = new T1(a);
        T2 t2 = new T2(a, lock, "quo", "BIANCO", "NERO", "ROSSO"),
                t3 = new T2(a, lock, "qui", "UNO", "DUE", "TRE");

        t1.start(); t2.start(); t3.start();


        //*****************************
        //*          Punto B          *
        //*****************************
        try {
            t1.join();
            t2.join();
            t3.join();
        }
        catch (InterruptedException e){}
        AlberoImpl aa = (AlberoImpl)a;
        System.out.print(aa.info);
        while (aa.itera() != null){
            System.out.print(" "+aa.info);
        }
    }
}
