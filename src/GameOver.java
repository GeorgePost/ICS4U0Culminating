import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This is the game over screen for when the user loses
 * <strong>Course info:</strong>
 * ICS4U0 with V. Krasteva
 * @author George Postica
 * @version 1.0.0
 * @since 0.3.3
 * Created on May 21,2024
 * Hours spent creating: 1.5
*/
public class GameOver implements ActionListener{
   /**Drawing to display my drawings */
   private Drawing draw = new Drawing();
   /**Varible to hold Game's panel*/
   private JPanel panel;
   /**Light blue color*/
   private Color lightBlue = new Color(0, 234, 255);
   /**Light grey Color*/
   private Color lightGrey=new Color(238, 238, 238);
   /**dark yellow color used for rounded rect of the slider*/
   private Color darkYellow=new Color(128,128,0);
   /**yellow color used for the circle in the slider*/
   private Color yellow = new Color(238,255,65);
   /**Reference variable to contain Game.frame*/
   JFrame frame= Game.frame;
   /**Layered pane, so that Labels and paint work together*/
   JLayeredPane lp;
   /**The Return to Main Menu button*/
    JButton button1 = new JButton("Return to Main Menu");
   /**Some important labels containing text and images*/
   JLabel line1,line2,line3;
   /**
     *Constructor for GameOver 
     *Creates the labels, adds the labels and draw to a layered pane.
     *Defines the game panel, and add layerPaned to the frame and panel
   */
   public GameOver(){
      lp = new JLayeredPane();
      panel = Game.panel;
      panel.setLayout(null);
      lp.add(draw,JLayeredPane.DEFAULT_LAYER);
      draw.setBounds(0,0,800,500);
      draw.setOpaque(true);
      title();
      button();
      lp.setOpaque(true);
      lp.setVisible(true);
      lp.setBounds(0,0,800,500);
      panel.add(lp);
      panel.setOpaque(true);
      panel.setVisible(true);
  }
  /**
   * Ran inside constructor
   * Title makes the text at the top of the screen
  */
  public void title(){
      JLabel label1 = new JLabel("Level Lost");
      label1.setFont(new Font("Serif", Font.BOLD, 30));
      label1.setForeground(lightBlue);
      label1.setBackground(Color.BLACK);
      label1.setBounds(340, 10, 300, 50);
      lp.add(label1,JLayeredPane.PALETTE_LAYER);
  }
  /**
     * Adjusts the button, so that it is  at the middle of the screen
     * Adds listeners and adds them to panel
     */
    public void button(){
        button1.addActionListener(this);
        button1.setBounds(250,130,300,80);
        button1.setBorder(BorderFactory.createLineBorder(lightBlue, 3));
        button1.setBackground(Color.WHITE);
        button1.setOpaque(true);
        button1.setPreferredSize(new Dimension(300,70));
        button1.setFont(new Font("Arial",Font.BOLD,22));
        lp.add(button1,JLayeredPane.PALETTE_LAYER);
    }
    /**
     *Drawing Class for Game Over
     *Will contain all drawings used in the project 
   */
   class Drawing extends JComponent{
      /**
        *A method to render graphics
        *@param g is the Graphics class, so we can display our graphics
      */
      public void paint(Graphics g){
         g.setColor(Color.BLACK); 
         g.fillRect(0,0,800,500);
         g.setColor(lightGrey);
      }
   }  
   public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            Game.changeScene(2);
        }
    }
}