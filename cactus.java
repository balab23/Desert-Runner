package game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class cactus {
    
    Image img;
    int x,y,vix;
   
    public cactus(int startx, int starty, String location)

    {
        x=startx;
        y=starty;
        vix=1;
        ImageIcon l=new ImageIcon(location);
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

   

    public Image getImage()
    {
        return img;
    }
    
    public void move (int dx)
    {
        x= x - dx;
        
    }
    
   
    
    public Rectangle getbounds()
    {
        return new Rectangle(x,y,35,45);
    }
    
    

}
