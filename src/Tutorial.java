import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Tutorial{
        Drawing draw = new Drawing();
        int mouseX = 0, mouseY = 0;
        JPanel panel;
        Color lightBlue = new Color(0, 234, 255);
        Color lightGrey=new Color(238, 238, 238);
       
        int clickCount=0;
        JLabel label2=new JLabel("(Click To Continue)");
        JFrame frame = new JFrame("Mouse Lines");
        public Tutorial(){
            panel = new JPanel();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            draw.addMouseListener(new ClickHandler());
            frame.add(draw);
            frame.setSize(800,500);
            title();
            campignManager();
            textBox();
            panel.setLayout(null);
            panel.setBackground(Color.BLACK);
            frame.add(panel); // Add panel to the center
            frame.add(draw);  // Add draw to the FRAME_CONTENT_LAYER
            
            frame.setVisible(true);
        }
        public void title(){
            JLabel label1 = new JLabel("Tutorial");
            label1.setFont(new Font("Serif", Font.BOLD, 30));
            label1.setForeground(lightBlue);
            label1.setBackground(Color.BLACK);
            label1.setBounds(340, 10, 300, 50);
            panel.add(label1);
        }
        public void campignManager(){
            JLabel label=new JLabel("");
            Image img= new ImageIcon(this.getClass().getResource("/image/business-man-hi.png")).getImage();
            label.setIcon(new ImageIcon(img));
            label.setBounds(0,200,400,400);
            panel.setLayout(null);
            panel.add(label);
        }
        public void textBox(){
            label2.setForeground(Color.BLACK);
            label2.setBackground(lightGrey);
            label2.setFont(new Font("Serif", Font.PLAIN, 24));
            label2.setBounds(150,300,600,150);
            label2.setOpaque(true);
            panel.add(label2);
        }
        class ClickHandler extends MouseAdapter{
            public void mouseClicked(MouseEvent e) {
                System.out.println("Hello");
                System.out.flush();
                             
               }
         }

         class Drawing extends JComponent{
            public void paint(Graphics g){
                  frame.add(panel); 
                }
            }
         public static void main(String[] args){
            new Tutorial();
         }
    }
