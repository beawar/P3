/**
 * Created by Bea on 09/02/2017.
 */
public class IImpl implements I {
    private int n;
    IImpl(int n){
        this.n = n;
    }

    public int get() {
        return n;
    }

    public void set(int n) {
        this.n = n;
    }
}
