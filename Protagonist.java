package game;

import java.awt.DisplayMode;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;


public class Protagonist {

    int x, y,left, vx,vy,index=0,nx,nx2,dy;
    public Image still;
    
    int check;
    ImageIcon s;
    ImageIcon g;
    ImageIcon p;
    ImageIcon r;
    ImageIcon d;
    ImageIcon t;
    ImageIcon u;
    int ammo=20;
    static ArrayList<Bullet> bullets;
    
    public Protagonist()
    {
       
        bullets=new ArrayList<Bullet>();        
        s = new ImageIcon("C:\\Users\\RG Choukikar\\Documents\\JavaProject\\walk.gif");
        g = new ImageIcon("C:\\Users\\RG Choukikar\\Documents\\JavaProject\\rev.gif");
        p= new ImageIcon("C:\\Users\\RG Choukikar\\Documents\\JavaProject\\l1.png");
        r = new ImageIcon("C:\\Users\\RG Choukikar\\Documents\\JavaProject\\w1.png");
        d= new ImageIcon("C:\\Users\\RG Choukikar\\Documents\\JavaProject\\down.png");
        t=new ImageIcon("C:\\Users\\RG Choukikar\\Documents\\JavaProject\\w4.png");
        u=new ImageIcon("C:\\Users\\RG Choukikar\\Documents\\JavaProject\\w1.png");
        x=800;
        left=150;
        y=600;
        nx2=1000;
        nx=0;
    
        check=0;
    }
    
    public static ArrayList<Bullet> getbullets() {
       
         {
             return bullets;
         }        
        
    }
    
    
    
    public Rectangle getbounds()
    {
        return new Rectangle(left,y,96,45);
    }
 
     public void fire(int p)
     {
         if(ammo>0)
         {
             ammo--;
             Bullet z=new Bullet(left+96,p+50);
             bullets.add(z);
         }
     }
    
     public void move()
    {
        if (vx != -1){
            if (left + vx <= 150)
                left+=vx;
            else{
        x = x + vx;
    
        
        nx2= nx2+vx;
            nx = nx + vx;
    }}
        else
    {
        if (left+vx >0)
        left = left + vx;
    }
    
    
        System.out.println(getX());
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
        return still;
    }

    
    
    public void keyPressed(KeyEvent e)
    {
      
        
      int key=e.getKeyCode();
      
      if (key == KeyEvent.VK_LEFT)
        {        vx = -1;
        still = g.getImage();        }
        
        if (key == KeyEvent.VK_RIGHT)
            {vx = 1;
        still = s.getImage();    
            }
          
      
      if(key==KeyEvent.VK_UP)  
      {
          dy=1;
          still=t.getImage();
      }
      
      if (key == KeyEvent.VK_DOWN)
        {vx = 1;
    still = d.getImage();    
        }
      
      if(key==KeyEvent.VK_SPACE)
      {
          fire(game.getv());
      }
    
    }

    public void KeyReleased(KeyEvent e)
       {
         int key=e.getKeyCode();
         
       if (key == KeyEvent.VK_LEFT)
    {
        vx = 0;
        still = p.getImage();
    }
        

    if (key == KeyEvent.VK_RIGHT)
    {
        vx = 0;
        still=r.getImage();
    
    }
         
      if(key==KeyEvent.VK_UP) 
          {dy=0;
           still=u.getImage();
          }
      if (key == KeyEvent.VK_DOWN)
        {vx = 0;
       still = r.getImage();    
        }
         
     
      
       }
    
    
}