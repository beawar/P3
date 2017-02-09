import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Bea on 07/02/2017.
 */
public class Counter2 extends JFrame {
    private class T extends Thread{
        private int count = 0;
        private boolean runFlag = true;
        T(){
            start();
        }

        void invertiFlag (){
            runFlag = !runFlag;
        }

        @Override
        public void run() {
            while (true){
                try{
                    sleep(100);
                }
                catch (InterruptedException e){
                    System.err.println("Interrupted");
                }
                synchronized (this){
                    if (runFlag){
                        tf.setText(Integer.toString(count++));
                    }
                    else {
                        try {
                            wait();
                        }
                        catch(InterruptedException i){}
                    }
                }
            }
        }
    }

    private T t = null;
    private JTextField tf = new JTextField(10);
    private JButton start = new JButton("Start");
    private JButton pausa = new JButton("Pausa");
    private JButton ferma = new JButton("Ferma");
    private JButton reset = new JButton("Reset");

    class Lstart implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (t == null){
                t = new T();
            }
        }
    }

    class Lpausa implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            synchronized (t){
                if (t != null){
                    if (!t.runFlag){
                        t.notify();
                    }
                    t.invertiFlag();
                }
            }
        }
    }

    class Lferma implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            synchronized (this){
                if (t != null){
                    t.runFlag = false;
                    t.interrupt();
                }
            }
        }
    }

    class Lreset implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (t != null){
                t.count = 0;

            }
        }
    }

    public Counter2() {
        super("MultiThread GUI");
        setLayout(new FlowLayout());
        add(tf);
        start.addActionListener(new Lstart());
        add(start);
        pausa.addActionListener(new Lpausa());
        add(pausa);
        ferma.addActionListener(new Lferma());
        add(ferma);
        reset.addActionListener(new Lreset());
        add(reset);
        setSize(600, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        Counter2 r = new Counter2();
    }
}
