import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Bea on 08/02/2017.
 */
public class GUI extends JFrame {
    private JButton avvia = new JButton("Avvia");
    private JButton pausa = new JButton("Pausa");
    private JButton stop = new JButton("Stop");
    private final Object lock = new Object();
    private boolean attesa = false;
    private Background t;

    class Background extends Thread{
        boolean ecc = false;
        @Override
        public void run() {
            while (!isInterrupted() && !ecc){
                try {
                    synchronized (lock) {
                        while (attesa) {
                            lock.wait();
                        }
                        Random color = new Random();
                        getContentPane().setBackground(new Color(color.nextInt(256),
                                color.nextInt(256),
                                color.nextInt(256)));
                        sleep(30);
                    }

                }
                catch (InterruptedException e){
                    ecc = true;
                    interrupt();
                }
            }
        }
    };

   class Avvia implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            synchronized (lock){
                if (t == null){
                    t = new Background();
                    t.start();
                    attesa = false;
                }
                if (!t.isInterrupted()){
                    attesa = false;
                    lock.notifyAll();
                    //pausa.setEnabled(true);
                    //avvia.setEnabled(false);
                }
            }
        }
    }

    class Pausa implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            synchronized (lock){
                if (!t.isInterrupted()){
                   // pausa.setEnabled(false);
                   // avvia.setEnabled(true);
                    attesa = true;
                }
            }
        }
    }

    class Stop implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            synchronized (lock){
                if (!t.isInterrupted()){
                    t.interrupt();
                    //avvia.setEnabled(false);
                   // pausa.setEnabled(false);
                }
            }
        }
    }

    GUI(){
        super("GUI cambia colore");
        setLayout(new FlowLayout());
        avvia.addActionListener(new Avvia());
        add(avvia);
        pausa.addActionListener(new Pausa());
        add(pausa);
        stop.addActionListener(new Stop());
        add(stop);

        setSize(500, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
