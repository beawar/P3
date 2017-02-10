/**
 * Created by Bea on 09/02/2017.
 */
public class AlberoVuoto implements Albero {
    public Albero add(String s){
        return new AlberoImpl(s, new AlberoVuoto(), new AlberoVuoto());
    }

    public void stampa(){
        System.out.print("- ");
    }

    @Override
    public boolean presente(String s) {
        return false;
    }

    @Override
    public int nNodi() {
        return 0;
    }
}
