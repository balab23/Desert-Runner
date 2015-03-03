package game;

import java.awt.*;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;


public class game extends JPanel implements ActionListener, Runnable {
    
    Protagonist p;
    Villain vi;
    Villain vi2;
    cactus c1,c2,c3,c4,c5,c6;
    Bullet b; 
    Image img;
    Timer time;
    
    Thread animator;
    int cx1=600,cx2=900,cx3=1000,cx4=300,cx5=400,cx6=660, vx=1000, vx2=1800,scorecount=0;
    int cx4check=0, cx5check=0, cx6check=0;
    static int v=600;
    boolean pdead=false;
    static Font font=new Font("SanSerif",Font.BOLD,24);
    static Font font2=new Font("SanSerif",Font.BOLD,24);
    
    
    public game()
    {
         
        
        p=new Protagonist();
        
        vi= new Villain(vx,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\enemy.gif");
        vi2= new Villain(vx2,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\enemy.gif");
        
         
        c1= new cactus(cx1,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
          
        
        c2= new cactus(cx2,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
      
        
        c3= new cactus(cx3 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
      
        c4= new cactus(cx4 +40 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
        
       c5= new cactus(cx5 + 200 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
        
        c6= new cactus(cx6 + 20 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
        
        
     
        
      
        addKeyListener(new AL());
        setFocusable(true); 
        
        ImageIcon i=new ImageIcon("C:\\Users\\RG Choukikar\\Documents\\JavaProject\\land.jpg");
        img=i.getImage();
        time=new Timer(5,this);
        time.start();
    }

    
    public void run()
    {
        long beforetime,timediff,sleep;
        
        beforetime=System.currentTimeMillis();
        
        while(done==false)
        {
            cycle();
            timediff=System.currentTimeMillis()-beforetime;
            sleep=10-timediff;
            
            if(sleep<0) sleep=2;
        
            try{
                Thread.sleep(sleep);
            }catch(Exception e){}
        
        
            beforetime=System.currentTimeMillis();
        }
    
        done=false;
        h=false;
        k=false;
        
    }
    
    boolean h=false;
    boolean done= false;
    
    public void cycle()
    {
        if(h==false)
            {
              v=v-2;
              System.out.println("h is false yes!!");
            }
        
        if(v==350)//look here
            {
              h=true;
              
            }
         
        if(h==true && v<=600)
            
      {
            v++;
        
            if(v==600) 
              {
                  done=true;
              }
      }
    
 }    
    
    public static int getv()
    {
        return v;
    }
    public void actionPerformed(ActionEvent e)
    {
    
      ArrayList bullets=Protagonist.getbullets();
        for(int w=0;w<bullets.size();w++ )
         {
             Bullet m = (Bullet) bullets.get(w);
             if(m.getVisible() == true)
                 m.move();
             else
                bullets.remove(w); 
         }

        
      
      p.move();
    
      if (p.x>1600)
      {
         vi.move(); 
         vi2.move();
      }
      
      
      
      
      if(p.x>800 && p.vx==1 && p.left==150)
      {  
          c1.move(p.vx);
          c2.move(p.vx);
          c3.move(p.vx);
          c4.move(p.vx);
          c5.move(p.vx);
          c6.move(p.vx);
          
      }
      
      checkcollisions();
     
      repaint();    
      
      
    }

    public void checkcollisions()
    {
         
          
        Rectangle d=p.getbounds();
          Rectangle r1=c1.getbounds();
          Rectangle r2= c2.getbounds();
          Rectangle r3= c3.getbounds();
          Rectangle r4= c4.getbounds();
          Rectangle r5= c5.getbounds();
          Rectangle r6= c6.getbounds();
          Rectangle v1=vi.getbounds();
          Rectangle v2=vi2.getbounds();
          
        ArrayList bullets=Protagonist.getbullets();
        for(int w=0;w<bullets.size();w++ )
         {
             Bullet m = (Bullet) bullets.get(w);
              Rectangle bu=m.getbounds();
              
              if(v1.intersects(bu) && vi.alive())
              {
                  vi.isalive=false;
                  m.visible=false;
                  
              }
                  
              else if(v2.intersects(bu) && vi2.alive())
              {
                  vi2.isalive=false;
                  m.visible=false;
                  
              }
         }

        
          
          
          
          if( (d.intersects(v1) && vi.alive())||( d.intersects(v2) && vi2.alive()))
          {
              
              if(v>=600)
              {
            System.out.println("YESVILLAIN");
            Score();
              pdead=true;
              }
          }
          
          if(d.intersects(r1)  || d.intersects(r2) || d.intersects(r3))
          {
              if(v>=500)
            {
              System.out.println("YES1");
              Score();
              pdead=true;
          
            }
              
              
          }
          
          if(d.intersects(r4) && cx4check==1 || d.intersects(r5)  && cx5check==1 || d.intersects(r6) && cx6check==1)
          {
              if(v>=550)
            {
              System.out.println("YES1");
              Score();
              pdead=true;
          
            }
              
              
          } 
          
          
           else
         {
             pdead=false;
             ++scorecount;
         }
          
          
         
    }

    
    
    int count=0;
    
    
    boolean k=false;
    
    public void paint (Graphics g)
    {
        
        System.out.println("C1X IS" + cx1 + "C2X IS" + cx2 + "C3X IS" + cx3);
        
        
        if(pdead)
            System.exit(0);
        System.out.println("COUNT IS" + count);
        
        if(p.dy==1  && k==false)
        {
            k=true;
            animator=new Thread(this);        
            animator.start();
        }
        
        super.paint(g);
        
        Graphics2D g2d= (Graphics2D)g;
         
        
        

        
        
      if ((p.getX() - 720) % 2400 == 0) 
              p.nx = 0;
      if ((p.getX() - 2050) % 2400 == 0) 
              p.nx2 = 0;

      g2d.drawImage(img,1000-p.nx2, 0, null);
      if (p.getX() > 720) {
              g2d.drawImage(img, 1300-p.nx, 0, null);
      }
      
    
   
      g2d.drawImage(p.getImage(), p.left, v, null);

      if (p.vx == -1) {
              
              g2d.drawImage(p.getImage(), p.left, v, null);
     
      }
              
         
       
       
        
        
       if(p.x<2200)            
        {
        
            if(p.x>800)
            {
              g2d.drawImage(c1.getImage(),c1.getX() ,c1.getY(),null);
              System.out.println("POSITION OF 1ST CACTUS" + (c1.getX()));
              
            }
        
            if(p.x>1000)
              g2d.drawImage(c2.getImage(),c2.getX(),c2.getY(),null);
        
            if (p.x>900)
              g2d.drawImage(c3.getImage(),c3.getX(),c3.getY(),null);
        
        }
        
       
        if(p.x==2200)
        {
            
            cx4check=0; cx5check=0; cx6check=0;
            c1= new cactus(cx1 +100 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c2= new cactus(cx2 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c3= new cactus(cx3 +200,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
       
        
        }
        
        
        if(2200<p.x && p.x<3600)            
        {

        
                
            
            if(p.x>800)
            {
              g2d.drawImage(c1.getImage(),c1.getX() ,c1.getY(),null);
              System.out.println("POSITION OF 1ST CACTUS " + (c1.getX()));
            }
        
            if(p.x>1000)
              g2d.drawImage(c2.getImage(),c2.getX(),c2.getY(),null);
        
            if (p.x>900)
              g2d.drawImage(c3.getImage(),c3.getX(),c3.getY(),null);
        
        }
        
        
        if(p.x==3600)
        {
        
            cx4check=1; cx5check=1;cx6check=0;
            c1= new cactus(cx1 +100 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c2= new cactus(cx2 -100,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c3= new cactus(cx3 +400 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c4= new cactus(cx3 +40 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c5= new cactus(cx3 + 200 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            
        
        }
        
        
        if(3600<p.x && p.x<5000)            
        {

        
                
            
            if(p.x>800)
            {
              g2d.drawImage(c1.getImage(),c1.getX() ,c1.getY(),null);
              System.out.println("POSITION OF 1ST CACTUS " + (c1.getX()));
            }
        
            if(p.x>1000)
              g2d.drawImage(c2.getImage(),c2.getX(),c2.getY(),null);
        
            if (p.x>900)
              g2d.drawImage(c3.getImage(),c3.getX(),c3.getY(),null);
        
            if(p.x>1200)
                 g2d.drawImage(c4.getImage(),c4.getX(),c4.getY(),null);
            
            if(p.x>1400)
                g2d.drawImage(c5.getImage(),c5.getX(),c5.getY(),null);
            
        
        
        }
        
        
        if(p.x==5000)
        {   cx4check=1;cx5check=0; cx6check=0;
            c1= new cactus(cx1  ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c2= new cactus(cx2 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c3= new cactus(cx3 +400 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c4= new cactus(cx3 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            
        
        }
        
        
        if(5000<p.x && p.x<6600)            
        {

        
                
            
            if(p.x>800)
            {
              g2d.drawImage(c1.getImage(),c1.getX() ,c1.getY(),null);
              System.out.println("POSITION OF 1ST CACTUS " + (c1.getX()));
            }
        
            if(p.x>1000)
              g2d.drawImage(c2.getImage(),c2.getX(),c2.getY(),null);
        
            if (p.x>900)
              g2d.drawImage(c3.getImage(),c3.getX(),c3.getY(),null);
        
            if(p.x>1200)
                 g2d.drawImage(c4.getImage(),c4.getX(),c4.getY(),null);
            
            
        
        }
         
        if(p.x==6600)
        {
            
            cx4check=1; cx5check=1; cx6check=1;
            c1= new cactus(cx1 + 100 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c2= new cactus(cx2 + 200,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c3= new cactus(cx3 +400 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c4= new cactus(cx4 + 200,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c5= new cactus(cx5 + 100 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c6= new cactus(cx6 -100,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            
        
        }
        
        
        if(6600<p.x && p.x<8000)            
        {

        
                
            
            if(p.x>800)
            {
              g2d.drawImage(c1.getImage(),c1.getX() ,c1.getY(),null);
              System.out.println("POSITION OF 1ST CACTUS " + (c1.getX()));
            }
        
            if(p.x>1000)
              g2d.drawImage(c2.getImage(),c2.getX(),c2.getY(),null);
        
            if (p.x>900)
              g2d.drawImage(c3.getImage(),c3.getX(),c3.getY(),null);
        
            if(p.x>1200)
                 g2d.drawImage(c4.getImage(),c4.getX(),c4.getY(),null);
            
            if(p.x>1600)
                g2d.drawImage(c5.getImage(),c4.getX(),c4.getY(),null);
        
            if(p.x>1600)
                   g2d.drawImage(c6.getImage(),c4.getX(),c4.getY(),null);
        }   
        
        
        if(p.x==8000)
        {
            
            cx4check=1; cx5check=1; cx6check=1;
            c1= new cactus(cx1 -120 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c2= new cactus(cx2 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c3= new cactus(cx3 +400 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c4= new cactus(cx4 + 100,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c5= new cactus(cx5 + 300 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            c6= new cactus(cx6 ,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\Cactus.gif");
            
        
        }
        
        
        if(8000<p.x && p.x<9200)            
        {
          
        
                
            
            if(p.x>800)
            {
              g2d.drawImage(c1.getImage(),c1.getX() ,c1.getY(),null);
              System.out.println("POSITION OF 1ST CACTUS " + (c1.getX()));
            }
        
            if(p.x>1000)
              g2d.drawImage(c2.getImage(),c2.getX(),c2.getY(),null);
        
            if (p.x>900)
              g2d.drawImage(c3.getImage(),c3.getX(),c3.getY(),null);
        
            if(p.x>1200)
                 g2d.drawImage(c4.getImage(),c4.getX(),c4.getY(),null);
            
            if(p.x>1600)
                g2d.drawImage(c5.getImage(),c4.getX(),c4.getY(),null);
        
            if(p.x>1600)
                   g2d.drawImage(c6.getImage(),c4.getX(),c4.getY(),null);
        }   
        
        if(p.x>1600 && vi.alive())
            
            g2d.drawImage(vi.getImage(),vi.getX(),vi.getY(),null);
        
        if(p.x>1700 && vi2.alive())
            g2d.drawImage(vi2.getImage(),vi2.getX(),vi2.getY(),null);
        
        
        if(p.x==2100)
        {
            vi= new Villain(vx+200,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\enemy.gif");
            vi2= new Villain(vx2+400,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\enemy.gif");
        }
        
        if(p.x>2100)
        {
            if(p.x>1600 && vi.alive())
                g2d.drawImage(vi.getImage(),vi.getX(),vi.getY(),null);
            
            if(p.x>1700 && vi2.alive())
                g2d.drawImage(vi2.getImage(),vi2.getX(),vi2.getY(),null);
            
                
        }
        
        if(p.x==4000)
        {
            vi= new Villain(vx-100,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\enemy.gif");
            vi2= new Villain(vx2+200,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\enemy.gif");
            
        }
        
        if(p.x>4000)
        {
            if(p.x>1600 && vi.alive())
                g2d.drawImage(vi.getImage(),vi.getX(),vi.getY(),null);
            
            if(p.x>1700 && vi2.alive())
                g2d.drawImage(vi2.getImage(),vi2.getX(),vi2.getY(),null);
            
                
        }
        
        if(p.x==6000)
        {
            vi= new Villain(vx,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\enemy.gif");
            vi2= new Villain(vx2+200,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\enemy.gif");
        }
        
        if(p.x>6000)
        {
            if(p.x>1600 && vi.alive())
                g2d.drawImage(vi.getImage(),vi.getX(),vi.getY(),null);
            
            if(p.x>1700 && vi2.alive())
                g2d.drawImage(vi2.getImage(),vi2.getX(),vi2.getY(),null);
            
                
        }
        
        if(p.x==6300)
        {
            vi= new Villain(vx-400,p.getY(),"C:\\Users\\RG Choukikar\\Documents\\JavaProject\\enemy.gif");
               
        }
        
        if(p.x>6300)
        {
            if(p.x>1600 && vi.alive())
                g2d.drawImage(vi.getImage(),vi.getX(),vi.getY(),null);
            
        }
        
       
        ArrayList  bullets;
        bullets = Protagonist.getbullets();
        for(int w=0;w<bullets.size();w++)
        {
            Bullet m=(Bullet)bullets.get(w);
            g2d.drawImage(m.getImage(),m.getX(),m.getY(),null);
        }
        
        g2d.setFont(font);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Score:" +(p.getX()-800),1000,100);
        
        
        g2d.setFont(font2);
        g2d.setColor(Color.WHITE);
        g2d.drawString("Ammo Left:" + p.ammo,500,100);
        
        
        
        
        
        
        System.out.println( done);
        System.out.println( h);
        System.out.println( k);
        
        if((p.getX()-801)==8500)
        win();
        
    }
    
    public void Score()
    {
    JFrame frame=new JFrame();
    
    frame.setFont(new Font("broadway",Font.BOLD,24));
    JOptionPane.showMessageDialog(null," PLAYER DEAD ! GAME OVER!");
    JOptionPane.showMessageDialog(null,"SCORE:" +(p.getX()-801));
    
    frame.setSize(1200,1200);
    frame.setVisible(true);
    frame.setBackground(Color.CYAN);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    System.exit(0);
  
   }
   public void win()
    {
     JFrame frame=new JFrame();
    
    frame.setFont(new Font("broadway",Font.BOLD,24));
    JOptionPane.showMessageDialog(null,"GAME OVER! YOU HAVE SUCCESSFULLY COMPLETED THE GAME");
    
    
    frame.setSize(1200,1200);
    frame.setVisible(true);
    frame.setBackground(Color.CYAN);
    System.exit(0);
  
   }
  
  

    private class AL extends KeyAdapter
    {
        public void keyReleased(KeyEvent e)
        {
            p.KeyReleased(e);
        }
    
        public void keyPressed(KeyEvent e)
        {
            p.keyPressed(e);
            int key = e.getKeyCode();

        if (key == KeyEvent.VK_ESCAPE)
        {
            Score();
        }
        }
    }
}
