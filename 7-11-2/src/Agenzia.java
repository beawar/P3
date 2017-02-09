/**
 * Created by Bea on 07/02/2017.
 */
public class Agenzia {
    public static void main(String[] args) {
        Viaggio v = new Viaggio("Namibia", 4);
        Viaggio v2 = new Viaggio("America", 2);
        Persona p1 = new Persona("Alice", v);
        Persona p2 = new Persona("Bob", v2);
        Persona p3 = new Persona("Carl", v);
        Persona p4 = new Persona("Doug", v2);
        Persona p5 = new Persona("Eric", v);
        Persona p6 = new Persona("Frank", v2);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();

        try {
            Thread.sleep(200);
        }
        catch (Exception e){}

        v.chiudi();
        v2.chiudi();
    }
}
