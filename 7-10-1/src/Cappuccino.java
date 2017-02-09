import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Bea on 07/02/2017.
 */
public class Cappuccino {
    private static String macina(String s){
        System.out.println("Inizia a macinare");
        try {
            Thread.sleep((int)(Math.random()*10));
        }
        catch (InterruptedException e){}
        System.out.println("Macinati i grani");
        if (s.equals("caffè"))
            return "macinato";
        else
            return "bad coffee";
    }

    private static Integer bollire(){
        System.out.println("Scaldo l'acqua");
        try {
            Thread.sleep((int)(Math.random()*160));
        }
        catch (InterruptedException e){}
        System.out.println("Acqua bollente");
        return 100;
    }

    private static String faiCaffe(String g, Integer a){
        System.out.println("Inizio a fare il caffè");
        try {
            Thread.sleep((int)(Math.random()*100));
        }
        catch (InterruptedException e){}
        System.out.println("Faccio il caffè con "+g+" e acqua a "+a+" gradi");
        return "caffè";
    }

    private static String faiSchiuma(String l){
        System.out.println("Inizio a fare la schiuma");
        try {
            Thread.sleep((int)(Math.random()*160));
        }
        catch (InterruptedException e){}
        System.out.println("Fatta schiuma di "+l);
        return "schiuma";
    }

    private static String mescola(String c, String l){
        try {
            Thread.sleep((int)(Math.random()*100));
        }
        catch (InterruptedException e){}
        System.out.println("Aggiungo "+l+" sopra "+c);
        return "cappuccino";
    }

    private static Callable<String> macinaC(final String s){
        return () -> {return macina(s);};
    }

    private static Callable<Integer> bollireC(){
        return () -> {return bollire();};
    }

    private static Callable<String> faiCaffeC(final Future<String> g,
                                              final Future<Integer> a){
        return () -> {return faiCaffe(g.get(), a.get());};
    }

    private static Callable<String> faiSchiumaC (final String l){
        return () -> {return faiSchiuma(l);};
    }

    static void cappuccinoSeq(){
        String s = macina("caffè");
        int i = bollire();
        String c = faiCaffe(s, i);
        String l = faiSchiuma("latte");
        String p = mescola(c, l);
        System.out.println("Pronto il "+p);
    }

    static void cappuccinoPar(){
        ExecutorService pool = Executors.newCachedThreadPool();

        Future<String> s = pool.submit(macinaC("caffè"));
        Future<Integer> i = pool.submit(bollireC());
        Future<String> c = pool.submit(faiCaffeC(s, i));
        Future<String> l = pool.submit(faiSchiumaC("latte"));
        try {
            String p = mescola(c.get(), l.get());
            System.out.println("Pronto il "+p);
        }
        catch (Exception e){}
    }

    public static void main(String[] args) {
        cappuccinoPar();
        System.out.println();
        cappuccinoSeq();
    }
}
