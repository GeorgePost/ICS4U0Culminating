import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Title screen displays company logo when game is run 
 * <strong>Course info:</strong>
 * ICS4U0 with V. Krasteva
 * @author: Mitchell Levitt
 * @version: 0.2.8
 * @created May 21
*/
public class TitleScreen{

    /**Created draw to display my drawings */
    Drawing draw = new Drawing();
    /**Varible to hold Game's panel*/
    JPanel myPanel = Game.panel;
    /**
     *Constructor for TitleScreen 
     *Creates drawing and the mouse listener, and set background
     *Calls other methods
   */
    public TitleScreen(){

        myPanel.setBackground(Color.BLACK);
        draw = new Drawing();
        myPanel.addMouseListener(new ClickHandler());
        Game.frame.validate();
        Game.frame.repaint();
        text();
        logo();
    }
    /**
    * Creates and adds a label conatining the text "presents" to the panel
    */
    public void text()
    {
        JLabel label = new JLabel("Presents");
        Font presents = new Font("Serif",Font.ITALIC, 40);
        label.setFont(presents);
        label.setForeground(Color.WHITE);
        label.setBounds(320,275,300,100);
        myPanel.add(label);
    }
    /**
    * draws the company logo onto the panel
    */
    public void logo()
    {

        Image img = new ImageIcon(this.getClass().getResource("/image/WallabyAndCoLogo.png")).getImage();
        JLabel logo = new JLabel("");
        logo.setIcon(new ImageIcon(img));
        JLabel company = new JLabel("Wallaby And Co");
        company.setFont(new Font("Serif",Font.BOLD,16));
        company.setForeground(Color.BLUE);
        draw.setBounds(0,0,150,150);
        logo.setBounds(6,13,200,100);
        company.setBounds(18,65,200,100);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.add(draw,JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(logo,JLayeredPane.PALETTE_LAYER);
        layeredPane.add(company,JLayeredPane.PALETTE_LAYER);
        layeredPane.setBounds(300,150,150,150);
        layeredPane.setOpaque(true);
        layeredPane.setVisible(true);
        myPanel.add(layeredPane);
        Game.frame.repaint();

    }
    /**
     *This inner class handles mouse controls for the TitleScreen class
   */
    class ClickHandler extends MouseAdapter{
         /**
            *Prints the mouse coordinates and changes the scene when mouse is clicked
         */
        public void mouseClicked(MouseEvent e){
            if(Game.sceneNum==1){
               Game.changeScene(2);
            }
        }
    }
      /**
      * Inner class crates a drawing object containg a white circle
      * Added to myPanel
      */
    class Drawing extends JComponent{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.fillOval(0,0,150,150);

        }
    }
}