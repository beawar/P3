/**
 * Created by Bea on 06/02/2017.
 */
public class Test {
    public static void main(String[] args) {
        Lista l = new Lista();
        l.addTesta("pippo");
        l.addTesta("pluto");
        l.addTesta("topolino");
        l.addCoda("gastone");

        Lista.Iteratore it = l.new Iteratore();
        while (it.hasNext()){
            System.out.println(it.next()+"___");
        }
        System.out.println("FINE");
        l.stampa();
    }
}
