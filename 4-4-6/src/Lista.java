/**
 * Created by Bea on 06/02/2017.
 */
public class Lista {
    private static class Nodo{
        private Object info;
        private Lista coda;

        Nodo(Object o){
            info = o;
            coda = new Lista();
        }
        Nodo(Object o, Lista n){
            info = o;
            coda = n;
        }
        Object getInfo(){
            return info;
        }
        Lista getCoda(){
            return coda;
        }
    }

    public class Iteratore{
        private Nodo prossimo;

        public Iteratore(){
            prossimo = testa;
        }
        public boolean hasNext(){
            return prossimo != null;
        }
        public Object next(){
            Object o = prossimo.info;
            prossimo = prossimo.coda.testa;
            return o;
        }
    }

    private Nodo testa;

    Lista(){
        testa = null;
    }

    Lista(Object e){
        testa = new Nodo(e);
    }

    public boolean isEmpty(){
        return testa == null;
    }

    private Object getTesta(){
        return testa.getInfo();
    }

    private Lista getCoda(){
        return testa.getCoda();
    }

    public void stampa(){
        if (isEmpty()){
            System.out.println("FINE");
            return;
        }
        System.out.println(getTesta() + "-->");
        getCoda().stampa();
    }

    public void addCoda(Object e){
        if (isEmpty()){
            testa = new Nodo(e);
        }
        else {
            getCoda().addCoda(e);
        }
    }

    private Lista(Lista l){
        testa = l.testa;
    }

    public void addTesta(Object e){
        Lista backup = new Lista(this);
        testa = new Nodo(e, backup);
    }
}
