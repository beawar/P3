import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Bea on 07/02/2017.
 */
public class NumberRangeB {
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public synchronized void setLower(int i) throws Exception{
        System.out.println("Setting Lower:"+ lower.get());
        if (i>upper.get()) throw new Exception();
        lower.set(i);
        System.out.println("Setted Lower:"+ lower.get());
    }

    public synchronized void setUpper(int i) throws Exception{
        System.out.println("Setting Upper:"+ upper.get());
        if (i<lower.get()) throw new Exception();
        upper.set(i);
        System.out.println("Setted Upper:"+ upper.get());
    }

    public synchronized boolean isInRange(int i){
        System.out.println("Lower:"+ lower.get()+" - Upper:"+ upper.get()+" - i:"+i);
        return (i>=lower.get() && i<=upper.get());
    }
}
