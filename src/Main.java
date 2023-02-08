import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        //DrawPanel mainPanel = new DrawPanel();
        BallPanel bPanel = new BallPanel();

        JButton b = new JButton("Add Ball");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bPanel.addBall();
            }
        });

        bPanel.add(b);
        //frame.add(mainPanel);
        frame.add(bPanel);
        frame.setVisible(true);
    }
}