/**
 * This handles all the other classes in the game
 * This class holds the main frame and panel.
 * It also contains the scene number the user is on to not confuse classes
 * <strong>Course info:</strong>
 * ICS4U0 with V. Krasteva
 * @author: Mitchell Levitt
 * @version: 1.0.0
 * Created on May 21, 2024
 * Hours spent creating: 3
 */
import java.awt.*;
import javax.swing.*;
public class Game
{
    /**this the JFrame that holds all the other classes. These other classes may reference this frame*/
    public static JFrame frame;
    /**This the panel used for displaying. Other classes add components to this panel*/
    public static JPanel panel;
    /**An Integer that keeps track of which scene number we are on, so that other classes click methods don't trigger*/
    public static int sceneNum=1;
    /**
     * Main loop method
     * Will set up the frame and panel. Start at Scene 1 and repaint the frame after every iteration.
     */
    public static void main (String[] args)
    {
        frameSetup();
        newScene(1);
        frame.repaint();
    }
    /**
     * frame setup method
     * Will set up the frame and panel. Used in the main method.
     */
    public static void frameSetup()
    {
        frame = new JFrame("Not Your Doordinary Campaign");
        frame.setSize(800,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setOpaque(true);
        panel.setVisible(true);
        panel.setLayout(null);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(panel);

    }
    /**
     * Will switch scenes by removing all components in panel and repainting.
     * It also calls the new scene method.
     * @param sc an integer that indicates the scene number to switch to.
     */
    public static void changeScene(int sc)
    {   
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
        newScene(sc);
        sceneNum=sc;
    }

    /**
     *method which creates an instance of a scene
     *Used in the change scene method.
     *@param sc an integer that dictates which scene to instantiate
     */
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
            case 4:
                new Level1();
                break;
            case 5:
                new Level2();
                break;
            case 6:
                new GameOver();
                break;
            case 7:
               new GameWon(sceneNum);
               break;
        }
    }

}
