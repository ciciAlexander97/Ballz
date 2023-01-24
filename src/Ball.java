import java.awt.*;
public class Ball{
    private int x, y, size;
    private int xSpeed, ySpeed;
    private Color color;
    public Ball(){
        //this.x = 450;
        //this.y = 450;
        x = (int)(Math.random()*500)+200;
        y = (int)(Math.random()*500)+200;
        this.size = (int)((Math.random()*40)+10);
        int randSX = (int)((Math.random()*10)+1);
        int negative1 = (int)(Math.random()*2);
        if(negative1 == 1){
            randSX*= -1;
        }
        this.xSpeed = randSX;
        int randSY = (int)((Math.random()*10)+1);
        int negative2 = (int)(Math.random()*2);
        if(negative2 == 1){
            randSY*= -1;
        }
        this.ySpeed = randSY;
        this.color = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
    }
    public Ball(int x, int y, int size, int xSpeed, int ySpeed, Color inColor){
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        color = inColor;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getSize(){
        return size;
    }
    public Color getColor(){
        return color;
    }
    public int getxSpeed(){ return xSpeed; }
    public int getySpeed(){ return ySpeed; }
    public void setX(int inX){ x=inX; }
    public void setY(int inY){ y=inY; }
    public void setxSpeed(int inXS){ xSpeed = inXS; }
    public void setySpeed(int inYS){ ySpeed = inYS; }
    public void moveX(int inX){
        x += inX;
    }
    public void moveY(int inY){ y += inY; }


}