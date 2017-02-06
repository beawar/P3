/**
 * Created by Bea on 06/02/2017.
 */
public abstract class Messaggio {
    private String mittente, destinatario, data, ora;

    public void setMittente(String mittente){
        this.mittente = mittente;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getMittente() {
        return mittente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getData() {
        return data;
    }

    public String getOra() {
        return ora;
    }
}
