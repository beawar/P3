/**
 * Created by Bea on 05/02/2017.
 */
public class Prova {
    public void finalize(){
        System.out.println("finaliza()");
    }

    public static void main(String[] args) {
        for (int i=0; ; i++){
            new Prova();
            System.out.println(i);
        }
    }
}
