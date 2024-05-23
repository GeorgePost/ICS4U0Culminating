import java.awt.*;
import javax.swing.*;
public class Game
{
   public static JFrame frame;
   public static JPanel panel;
   public static int scene = 1;
public static void main (String[] args)
{
   frameSetup();
   //new GUIGreet();
   new Tutorial();
   frame.repaint();
}
public static void frameSetup()
{
   frame = new JFrame("Not Your Doordinary Campaign");
   frame.setSize(800,500);
   frame.setVisible(true);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   panel = new JPanel();
   panel.setOpaque(true);
   panel.setVisible(true);
   frame.setLayout(new BorderLayout());
   frame.getContentPane().add(panel);
   panel.setLayout(null);
}
public static void changeScene(int sc)
{
   panel.removeAll();
   panel.validate();
   panel.repaint();
}

/*
public static void newScene(int sc)
{
   switch (sc){
   case 1:
      new TitleScreen();
   case 2:
      new GUIGreet2();
      }
}*/
   
}