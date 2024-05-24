import java.awt.*;
import javax.swing.*;
public class Game
{
    public static JFrame frame;
    public static JPanel panel;
    public static int sceneNum=1;
    public static void main (String[] args)
    {
        frameSetup();
        newScene(1);
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
    }
    public static void changeScene(int sc)
    {
        sceneNum=sc;
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
        newScene(sc);
    }


    public static void newScene(int sc)
    {
        switch (sc){
            case 1:
                new TitleScreen();
                break;
            case 2:
                new MainMenu();
                break;
            case 3:
                new Tutorial();
                break;
        }
    }

}