/**
 * Created by Bea on 07/02/2017.
 */
public class MainB {
    public static void main(String[] args) {
        NumberRangeB n2 = new NumberRangeB();
        Thread t3 = new Thread(() -> {

            try {
                n2.setUpper(170);
                n2.setLower(11);
            }catch (Exception e){
                System.out.println("Eccezione");
            }
            System.out.println("T3: "+n2.isInRange(150));
        });

        Thread t4 = new Thread(() -> {

            try {
                n2.setUpper(260);
                n2.setLower(250);
            }catch (Exception e){
                System.out.println("Eccezione");
            }
            System.out.println("T4: "+ n2.isInRange(255));
        });

        t3.start(); t4.start();
    }
}
