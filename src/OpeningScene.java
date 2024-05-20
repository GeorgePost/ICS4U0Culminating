import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class OpeningScene implements ActionListener{
        Drawing draw = new Drawing();
        int mouseX = 0, mouseY = 0;
        JButton button1 = new JButton("Start");
        JButton button2 = new JButton("Tutorial");
        JPanel panel = new JPanel();
        Color lightBlue = new Color(0, 234, 255);
        public OpeningScene(){
            JFrame frame = new JFrame("Mouse Lines");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            draw.addMouseListener(new ClickHandler());
            frame.add(panel);
            frame.setSize(800,500);
            panel.setLayout(new GridBagLayout());

            buttons();
            title();
            panel.setBackground(Color.BLACK);

            frame.setVisible(true);
        }
        public void title(){
            JLabel label1 = new JLabel("Main Menu");
            label1.setFont(new Font("Serif", Font.BOLD, 30));
            label1.setForeground(lightBlue);
            label1.setBackground(Color.BLACK);
            label1.setBounds(280, 10, 300, 50);
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 0;
            c.insets = new Insets(-120,0,0,0);
            c.anchor = GridBagConstraints.NORTH;
            panel.add(label1,c);
        }
        public void buttons(){
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 0;
            c.insets = new Insets(-30,0,0,0);
            c.anchor = GridBagConstraints.NORTH;
            GridBagConstraints c2 = new GridBagConstraints();
            c2.gridx = 0;
            c2.gridy = 0;
            c2.insets = new Insets(90,0,0,0);
            c2.anchor = GridBagConstraints.NORTH;
            button1.addActionListener(this);
            button1.setBounds(250,130,300,80);
            button2.addActionListener(this);
            button2.setBounds(250,270,300,80);
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
            panel.add(button1,c);
            panel.add(button2,c2);
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
        }
            public static void main(String[] args){
            new OpeningScene();
        }
    }


