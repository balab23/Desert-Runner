package game;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Villain {

    Image img;
    int x,y,vix=3;
    boolean isalive=true;
    
    public Villain(int startx, int starty, String location)

    {
        x=startx;
        y=starty-35;
        vix=2;
        ImageIcon l=new ImageIcon("C:\\Users\\RG Choukikar\\Documents\\JavaProject\\enemy.gif");
        img=l.getImage();
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public boolean alive()
    {
        return isalive;
    }

    public Image getImage()
    {
        return img;
    }
    
    public Rectangle getbounds()
    {
        return new Rectangle(x,y,206,163);
    }

    public void move()
    {
      
    
        x=x-vix;
      
    }
}

