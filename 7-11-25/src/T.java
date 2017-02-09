/**
 * Created by Bea on 09/02/2017.
 */
public class T extends Thread {
    Z z;
    public T(Z z){
        this.z = z;
    }

    @Override
    public void run(){
        for (int i=0; i<5; i++){
            z.m();
        }
    }

}
