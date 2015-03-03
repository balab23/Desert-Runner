package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu 
{

public static void main(String args[])
{
     JFrame frame=new JFrame();
     
     frame.setTitle("MENU");
     frame.setSize(600,600);
     frame.setVisible(true);
    
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    
    JPanel panel=new JPanel(new GridBagLayout());
     panel.setBackground(Color.BLUE);
    frame.getContentPane().add(panel,BorderLayout.CENTER);
    GridBagConstraints c=new GridBagConstraints();
    JLabel label = new JLabel("DESERT RUN");
    label.setFont(new Font("broadway", Font.BOLD, 60));
    label.setForeground(Color.GREEN);
    c.gridx=0;
    c.gridy=0;
    c.insets=new Insets(50,20,20,20);
    panel.add(label,c);
    JButton button=new JButton();
    button.setIcon(new ImageIcon("C:\\Users\\RG Choukikar\\Documents\\JavaProject\\play.png"));
    c.gridx=0;
    c.gridy=1;
    panel.add(button,c);
    JButton button1=new JButton();
    button1.setIcon(new ImageIcon("C:\\Users\\RG Choukikar\\Documents\\JavaProject\\help.png"));
    c.gridx=0;
    c.gridy=2;
    panel.add(button1,c);
    JButton button2=new JButton();
    button2.setIcon(new ImageIcon("C:\\Users\\RG Choukikar\\Documents\\JavaProject\\exit.png"));
    c.gridx=0;
    c.gridy=3;
    panel.add(button2,c);
    
 
    button2.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(1);
        }
    });
     button.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            JFrame frame=new JFrame("2D GAME");
        
        frame.add(new game());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,1200);
        frame.setVisible(true);
    }

    });
        button1.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
     JFrame f=new JFrame("HELP");
     JPanel p=new JPanel(new GridBagLayout());
    f.getContentPane().add(p,BorderLayout.CENTER);
    GridBagConstraints c=new GridBagConstraints();
    JLabel label = new JLabel("HELP");
    label.setFont(new Font("broadway", Font.BOLD, 50));
    label.setForeground(Color.GREEN);
        JLabel myLabel;  
    String myString =   
        "<html><p>1.USE THE ARROW KEYS TO MOVE THE PLAYER.</p>  " +   
        "<p>2.JUMP OVER CACTUSES AND THE ENEMY TO EARN POINTS.</p>  " +  
        "<p>3.PRESS SPACEBAR TO USE THE AMMUNITIONS TO KILL THE ENEMY </p> " +  
        "<p>4.PRESS ESCAPE IF YOU WANT TO END THE GAME MIDWAY.</p>"+ 
          "<p>5.RUN A CERTAIN DISTANCE TO COMPLETE THE GAME.</p>" +
            "<p><b>GO PLAY THE GAME.</p></b></html>"; 
           myLabel = new JLabel(myString);  
        myLabel.setFont(new Font("ariel", Font.BOLD, 20));
        
    myLabel.setForeground(Color.WHITE);
     c.gridx=0;
    c.gridy=1;
    p.add(myLabel,c);
 
    
    
    p.setBackground(Color.BLUE);
    p.add(label);
    f.add(p);
    f.setSize(800,800);
    f.setVisible(true);
        }
    });
    
   
}

}