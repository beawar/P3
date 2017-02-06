/**
 * Created by Bea on 06/02/2017.
 */
public class SMSNormale extends SMS {
    private static final int limit = 160;

    @Override
    public boolean aggiungi(char c) {
        return getMessaggio().length() < limit && super.aggiungi(c);
    }

    public SMSNormale[] spezza(SMS sms){
        int lung = 0;
        String mess = sms.getMessaggio();
        int pezzi = mess.length();
        if (mess.length()%160 > 0)
            ++pezzi;
        SMSNormale[] array = new SMSNormale[pezzi];
        for(int i = 0; i<pezzi; ++i){
            array[i] = new SMSNormale();
            array[i].setMessaggio(mess.substring(160*i, 160*(i+1)));
            array[i].setMittente(sms.getMittente());
            array[i].setDestinatario(sms.getDestinatario());
            array[i].setData(sms.getData());
            array[i].setOra(sms.getOra());
        }
        return array;
    }
}
