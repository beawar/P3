/**
 * Created by Bea on 09/02/2017.
 */
public interface Albero {
    Albero add(String s); //ritorna l'albero con un nodo in pi' con s nel campo info
    void stampa(); //stampa inline dell'albero
    boolean presente(String s); //ritorna true se e' presente in un nodo
    int nNodi(); //numero di nodi, cioe' di stringhe, contenuti nell'albero
}
