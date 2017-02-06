/**
 * Created by Bea on 05/02/2017.
 */
public class A {
    public void demoDispatch(){
        this.sd();
        this.dd();
    }
    private void sd(){
        System.out.println("A.sd()");
    }
    public void dd(){
        System.out.println("A.dd()");
    }
}
