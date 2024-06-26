import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Title screen displays company logo and game title when game is run
 * <strong>Course info:</strong>
 * ICS4U0 with V. Krasteva
 * @author Mitchell Levitt
 * @version 1.0.0
 * created May 21
 * Hours spent creating: 2
 */
public class TitleScreen{

    /**Drawing object to hold white circle */
    Drawing draw;
    /**Reference variable to Game.panel*/
    JPanel myPanel = Game.panel;
    /**
     *Constructor 
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
     * Creates and adds all text in the title screen except that of the logo
     */
    public void text()
    {
        JLabel label = new JLabel("Presents");
        Font presents = new Font("Serif",Font.ITALIC, 40);
        label.setFont(presents);
        label.setForeground(Color.WHITE);
        label.setBounds(305,265,300,100);
        myPanel.add(label);
        JLabel title = new JLabel("Not your Doordinary Adventure");
        Font titleFont = new Font("SansSerif",Font.BOLD, 32);
        title.setFont(titleFont);
        title.setForeground(Color.WHITE);
        title.setBounds(120,330,800,100);
        myPanel.add(title);
        JLabel cont = new JLabel("Click to Continue");
        Font contFont = new Font("Dialog",Font.PLAIN, 20);
        cont.setFont(contFont);
        Color blue = new Color (0, 208, 255);
        cont.setForeground(blue);
        cont.setBounds(620,400,200,100);
        myPanel.add(cont);
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
        layeredPane.setBounds(300,130,150,150);
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
         *Changes the scene when mouse is clicked
         */
        public void mouseClicked(MouseEvent e){
            if(Game.sceneNum==1){
                Game.changeScene(2);
            }
        }
    }
    /**
     * Inner class crates a drawing object containing a white circle
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