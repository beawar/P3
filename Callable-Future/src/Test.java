import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by Bea on 07/02/2017.
 */
public class Test {
    static int max(int[] a){
        int i = a[0];
        for (int j = 1; j < a.length; ++j){
            if (a[j] > i) {
                i = a[j];
            }
        }
        return i;
    }

    static class Max implements Callable<Integer>{
        private int[] a;
        Max(int[] ar){
            a = ar;
        }

        @Override
        public Integer call() throws Exception {
            return max(a);
        }
    }

    public static void main(String[] args) {
        int[] a1 = {20,34,123,84,94,300};
        int[] a2 = {48,87,294,76,9};
        try {
            FutureTask<Integer> fm = new FutureTask<Integer>(new Max(a1));
            Thread t = new Thread(fm);
            t.start();
            int m = max(a2);
            if (m < fm.get()){
                m = fm.get();
            }
            System.out.println("max is "+m);
        }
        catch (Exception e){}
    }

}
