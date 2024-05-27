import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainMenu implements ActionListener{
    Drawing draw = new Drawing();
    int mouseX = 0, mouseY = 0;
    JButton button1 = new JButton("Start");
    JButton button2 = new JButton("Tutorial");
    JPanel introPanel = Game.panel;
    Color lightBlue = new Color(0, 234, 255);
    public MainMenu(){
        draw.addMouseListener(new ClickHandler());
        introPanel.setLayout(null);
        buttons();
        title();
        introPanel.setBackground(Color.BLACK);
    }
    public void title(){
        JLabel label1 = new JLabel("Main Menu");
        label1.setFont(new Font("Serif", Font.BOLD, 30));
        label1.setForeground(lightBlue);
        label1.setBackground(Color.BLACK);
        label1.setBounds(280, 10, 300, 50);

        introPanel.add(label1);
    }
    public void buttons(){

        button1.addActionListener(this);
        button1.setBounds(205,130,300,80);
        button2.addActionListener(this);
        button2.setBounds(205,250,300,80);
        button1.setBorder(BorderFactory.createLineBorder(lightBlue, 3));
        button2.setBorder(BorderFactory.createLineBorder(lightBlue, 3));
        button1.setBackground(Color.WHITE);
        button2.setBackground(Color.WHITE);
        button1.setOpaque(true);
        button2.setOpaque(true);
        button1.setPreferredSize(new Dimension(300,70));
        button2.setPreferredSize(new Dimension(300,70));
        button1.setFont(new Font("Arial",Font.BOLD,22));
        button2.setFont(new Font("Arial",Font.BOLD,22));
        button1.setBounds(300,130,300,80);
        button2.setBounds(300,330,300,80);
        introPanel.add(button1);
        introPanel.add(button2);
    }
    class ClickHandler extends MouseAdapter{
        public void mouseClicked(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
            draw.repaint();
        }
    }

    class Drawing extends JComponent{
        public void paint(Graphics g){

        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button2){
            Game.changeScene(3);
        }
    }
    public static void main(String[] args){
        new MainMenu();
    }
}


