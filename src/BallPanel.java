import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
public class BallPanel extends JPanel{
    public static final Color BACKGROUND = new Color(184, 119, 237);
    //private int x = 80;
    //private int y = 20;
    //private int xSpeed = 3;
    //private int ySpeed = 2;
    //private int xSpeed2 = 4;
    //private int ySpeed2 = 3;

    //static Ball b1 = new Ball(30, 150, 20);

    static ArrayList<Ball> ballz = new ArrayList<Ball>();
    private final Ball silly;

    public BallPanel(){
        setBackground(BACKGROUND);
        for(int i = 0;i<ballz.size();i++){
            ballz.add(new Ball());
        }
        silly = new Ball(100, 100, 100, 10, 10, new Color(112, 194, 105));
        this.setFocusable(true);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

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
            public void keyReleased(KeyEvent e) {}
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                int mX = e.getX();
                int mY = e.getY();
                for(int i=0;i<ballz.size();i++){
                    if(mX>=ballz.get(i).getX() && mX<=ballz.get(i).getX()+ballz.get(i).getSize()
                            && mY>=ballz.get(i).getY() && mY<=ballz.get(i).getY()+ballz.get(i).getSize()){
                        ballz.remove(i);
                    }
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

    }

    public void addBall(){ballz.add(new Ball());}

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //g.setColor(silly.getColor());
        //g.fillOval(silly.getX(), silly.getY(), silly.getSize(), silly.getSize());
        for(int i = 0;i<ballz.size();i++){
            g.setColor(ballz.get(i).getColor());
            g.fillOval(ballz.get(i).getX(), ballz.get(i).getY(), ballz.get(i).getSize(), ballz.get(i).getSize());
            ballz.get(i).moveX(ballz.get(i).getxSpeed());
            ballz.get(i).moveY(ballz.get(i).getySpeed());
            if(ballz.get(i).getX() >= getWidth()-ballz.get(i).getSize() || ballz.get(i).getX()<=0){
                ballz.get(i).setxSpeed(-ballz.get(i).getxSpeed());
                int r = (int)(Math.random()*2);
                if(r==0){
                    ballz.get(i).setySpeed(-(int)(Math.random() * 2 + 1));
                }
                else{
                    ballz.get(i).setySpeed((int)(Math.random() * 2 + 1));
                }
            }
            //if(ballz.get(i).getX()>=getWidth()){
            //    ballz.get(i).setX(-ballz.get(i).getSize());
            //}
            //if(ballz.get(i).getX()<-ballz.get(i).getSize()){
            //    ballz.get(i).setX(getWidth());
            //}
            if(ballz.get(i).getY() >= getHeight()-ballz.get(i).getSize() || ballz.get(i).getY()<=0){
                ballz.get(i).setySpeed(-ballz.get(i).getySpeed());
                int r2 = (int)(Math.random()*2);
                if(r2==0){
                    ballz.get(i).setxSpeed(-(int)(Math.random() * 2 + 1));
                }
                else{
                    ballz.get(i).setxSpeed((int)(Math.random() * 2 + 1));
                }
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
            Thread.sleep(10);
        }
        catch(Exception e){
            System.out.println(e);
        }
        repaint();
    }


}