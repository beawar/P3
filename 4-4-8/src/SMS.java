/**
 * Created by Bea on 06/02/2017.
 */
public class SMS extends Messaggio{
    private String messaggio;

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public boolean aggiungi(char c){
        setMessaggio(getMessaggio() + c);
        return true;
    }

    public String toString(){
        int lung = 0;
        String sms = "";
        while (lung < messaggio.length()) {
            sms += messaggio.substring(lung, lung + 24) + "\n";
            lung += 25;
        }
        return sms;
    }
}
