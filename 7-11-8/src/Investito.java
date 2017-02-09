/**
 * Created by Bea on 08/02/2017.
 */
public class Investito extends Exception {
    int chi, cosa;

    Investito(int i, int j){
        chi = i;
        cosa = j;
    }

    void info(){
        System.out.println("INCIDENTE: "+chi+" ha investito "+cosa);
    }
}
