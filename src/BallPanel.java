import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallPanel extends JPanel{
    public static final Color BACKGROUND = new Color(184, 119, 237);
    //private int x = 80;
    //private int y = 20;
    //private int xSpeed = 3;
    //private int ySpeed = 2;
    //private int xSpeed2 = 4;
    //private int ySpeed2 = 3;

    //static Ball b1 = new Ball(30, 150, 20);
    static Ball[] ballz = new Ball[50];
    private final Ball silly;

    public BallPanel(){
        setBackground(BACKGROUND);
        for(int i = 0;i<ballz.length;i++){
            ballz[i] = new Ball();
        }
        silly = new Ball(100, 100, 100, 10, 10, new Color(112, 194, 105));
        this.setFocusable(true);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==e.VK_A){
                    silly.moveX(-silly.getxSpeed());
                }
                if(e.getKeyCode()==e.VK_D){
                    silly.moveX(silly.getxSpeed());
                }
                if(e.getKeyCode()==e.VK_S){
                    silly.moveY(silly.getySpeed());
                }
                if(e.getKeyCode()==e.VK_W) {
                    silly.moveY(-silly.getySpeed());
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(silly.getColor());
        g.fillOval(silly.getX(), silly.getY(), silly.getSize(), silly.getSize());
        for(int i = 0;i<ballz.length;i++){
            g.setColor(ballz[i].getColor());
            g.fillOval(ballz[i].getX(), ballz[i].getY(), ballz[i].getSize(), ballz[i].getSize());
            ballz[i].moveX(ballz[i].getxSpeed());
            ballz[i].moveY(ballz[i].getySpeed());
            if(ballz[i].getX() >= getWidth()-ballz[i].getSize() || ballz[i].getX()<=0){
                ballz[i].setxSpeed(ballz[i].getxSpeed()*-1);
            }
            if(ballz[i].getY() >= getHeight()-ballz[i].getSize() || ballz[i].getY()<=0){
                ballz[i].setySpeed(ballz[i].getySpeed()*-1);
            }
        }

        if(silly.getX() > getWidth()+silly.getSize()){
            silly.setX(-silly.getSize());
        }
        if(silly.getX()<-silly.getSize()){
            silly.setX(getWidth()+silly.getSize());
        }
        if(silly.getY()>getHeight()-silly.getSize()){
            silly.setY(getHeight()- silly.getSize());
        }
        if(silly.getY()<0){
            silly.setY(0);
        }

        try{
            Thread.sleep(2);
        }
        catch(Exception e){
            System.out.println(e);
        }
        repaint();
    }


}