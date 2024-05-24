//written by mitchell levitt
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TitleScreen{
    Drawing draw = new Drawing();
    JPanel myPanel = Game.panel;
    public TitleScreen(){

        myPanel.setBackground(Color.BLACK);
        draw = new Drawing();
        myPanel.addMouseListener(new ClickHandler());
        Game.frame.validate();
        Game.frame.repaint();
        text();
        logo();
    }
    public void text()
    {
        JLabel label = new JLabel("Presents");
        Font presents = new Font("Serif",Font.ITALIC, 40);
        label.setFont(presents);
        label.setForeground(Color.WHITE);
        label.setBounds(320,275,300,100);
        myPanel.add(label);
    }
    public void logo()
    {

        Image img = new ImageIcon(this.getClass().getResource("/image/WallabyAndCoLogo.png")).getImage();
        JLabel logo = new JLabel("");
        logo.setIcon(new ImageIcon(img));
        JLabel company = new JLabel("Wallaby And Co");
        company.setFont(new Font("Serif",Font.BOLD,15));
        company.setForeground(Color.BLUE);
        draw.setBounds(0,0,150,150);
        logo.setBounds(6,13,200,100);
        company.setBounds(10,13,200,100);
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
    class ClickHandler extends MouseAdapter{
        public void mouseClicked(MouseEvent e){
            System.out.println(e.getX()+","+e.getY());
            if(Game.sceneNum==1){
               Game.changeScene(2);
            }
        }
    }

    class Drawing extends JComponent{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.fillOval(0,0,150,150);

        }
    }
    public static void main(String[] args){
        new TitleScreen();
    }
}