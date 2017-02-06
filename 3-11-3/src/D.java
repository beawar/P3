/**
 * Created by Bea on 05/02/2017.
 */
public class D extends C {
    public int m(C ref){
        if (ref instanceof C){
            return super.m(ref);
        }
        else {
            return 4;
        }
    }
}
