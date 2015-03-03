package game;


import java.awt.*;

import javax.swing.ImageIcon;

public class Bullet {
   int x,y;
   Image img;
   boolean visible;
   
   public boolean getVisible(){
   return visible;
   }
   
   public int getX(){
   return x;
   }
   
   public int getY(){
   return y;
   }
   
   public Image getImage(){
   return img;
   }
           
   public Bullet(int startX,int startY){
     x = startX;
     y = startY;
     ImageIcon newBullet = new ImageIcon("C:\\Users\\RG Choukikar\\Documents\\JavaProject\\bullet.gif");
     img = newBullet.getImage();
     visible = true;
   }
   
   public Rectangle getbounds()
      {
          return new Rectangle(x,y,143,41);
      }
   
   public void move(){
    x = x + 2;
    if(x > 700)
        visible = false;
    
   }
}

    