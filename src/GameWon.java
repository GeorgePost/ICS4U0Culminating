import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This is the game over screen for when the user wins
 * <strong>Course info:</strong>
 * ICS4U0 with V. Krasteva
 * @author:George Postica
 * @since 0.3.3
 * @version 1.0.0
 * Created on May 21,2024
*/
public class GameWon implements ActionListener{
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
   /**Reference variable for Game.frame*/
   JFrame frame= Game.frame;
   /**Layered pane, so that Labels and paint work together*/
   JLayeredPane lp;
   /**The Return to Main Menu button*/
   JButton button;
   /**Some important labels containing text and images*/
   JLabel line1,line2,line3;
   /**Scene num to use for the logic of the button"*/
   int sn;
   /**used for the title label, so we can set the string in constructor*/
   String title;
   /**used for the extra text after the player wins*/
   boolean gameCompleted=false;
   /**
     *Constructor 
     *Creates the labels, adds the labels and draw to a layered pane.
     *Defines the game panel, and add layerPaned to the frame and panel
   */
   public GameWon(int sceneNum){
      lp = new JLayeredPane();
      panel = Game.panel;
      panel.setLayout(null);
      lp.add(draw,JLayeredPane.DEFAULT_LAYER);
      draw.setBounds(0,0,800,500);
      draw.setOpaque(true);
      sn=sceneNum;
      if(sn==4){
         button = new JButton("Continue to Level 2");
         title="Level Complete";
      }if(sn==5){
         button = new JButton("Return to Main Menu");
         title="Completed Game";
         gameCompleted=true;
      }
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
   * Runs inside constructor
   * makes the title text at the top of the screen
  */
  public void title(){
      JLabel label1 = new JLabel(title);
      label1.setFont(new Font("Serif", Font.BOLD, 30));
      label1.setForeground(lightBlue);
      label1.setBackground(Color.BLACK);
      if(gameCompleted)
         label1.setBounds(270, 10, 300, 50);
      else 
         label1.setBounds(275, 10, 300, 50);
      lp.add(label1,JLayeredPane.PALETTE_LAYER);
  }
    /**
     * Adjusts the button, so that it is  at the middle of the screen
     * Adds listeners and adds them to panel
     */
    public void button(){
        button.addActionListener(this);
        button.setBounds(230,300,300,80);
        button.setBorder(BorderFactory.createLineBorder(lightBlue, 3));
        button.setBackground(Color.WHITE);
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(300,70));
        button.setFont(new Font("Arial",Font.BOLD,22));
        lp.add(button,JLayeredPane.PALETTE_LAYER);
    }
    /**
     *Drawing Class for GameWon
     *contains all drawings used int the project 
   */
   class Drawing extends JComponent{
      /**
        *A method to make a slider with a certain width and value
        *@param x is the x-coordinate of the slider
        *@param y is the y coordinate of the slider
        *@param value is a value between 0-100, which decides where the circle is
        *@param g is the Graphics class, so we can display our slider
      */
      public void slider(int x,int y, int width, int value, Graphics g){
         g.setColor(darkYellow);
         g.fillRoundRect(x,y,width,10,10,10);
         g.setColor(yellow);
         int movement=(int)((value/100.0)*width);
         g.fillOval(x+movement-7,y-2,15,15);
      }
      /**
        *A method to render graphics
        *@param g is the Graphics class, so we can display our graphics
      */
      public void paint(Graphics g){
         g.setColor(Color.BLACK); 
         g.fillRect(0,0,800,500);
         g.setColor(lightGrey);
         if(gameCompleted){
            Graphics2D h= (Graphics2D) g;
            Font font = new Font("SansSerif", Font.PLAIN,30);
            h.setColor(Color.WHITE);
            h.setFont(font);
            h.drawString("Well Done, You have completed",170,105);
            h.drawString("Wallaby and Co's very own ",200,155);
            h.drawString("Not your Doordinary Campaign",170,205);
            h.drawString("Thank you and Great Job",200,255);
         }
      }
   }  
   /**
     *A method to detect button presses
     *the scene change will be decided by the previous scene
   */
   public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            if(sn==4){
               Game.changeScene(5);
            }else if(sn==5){
               Game.changeScene(2);
            }
        }
    }
}