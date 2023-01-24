import javax.swing.*;
import java.awt.*;
public class Main{
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        //DrawPanel mainPanel = new DrawPanel();
        BallPanel bPanel = new BallPanel();
        //frame.add(mainPanel);
        frame.add(bPanel);
        frame.setVisible(true);
    }
}