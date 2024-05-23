import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Tutorial{
        Drawing draw = new Drawing();
        int mouseX = 0, mouseY = 0;
        JPanel panel;
        Color lightBlue = new Color(0, 234, 255);
        Color lightGrey=new Color(238, 238, 238);
       Color backgroundColor=new Color(32,32,32);
        int clickCount=0;
        JLabel box = new JLabel("");
        JLabel line1;
        JLabel line2;
        JLabel line3;
        JFrame frame= Game.frame;
        public Tutorial(){
            panel = Game.panel;
            panel.addMouseListener(new ClickHandler());
            panel.add(draw);
            title();
            campignManager();
            textBox();
            panel.setBackground(backgroundColor);
            frame.add(panel);
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
            label.setBounds(0,180,400,400);
            panel.setLayout(null);
            panel.add(label);
        }
        public void textBox(){
            line1 =new JLabel("[Click To Continue]");
            line1.setFont(new Font("Serif", Font.PLAIN, 24));
            line1.setForeground(Color.BLACK);
            line1.setBounds(155,300,590,30);
            line1.setOpaque(true);
            panel.add(line1);
            line2 = new JLabel("");
            line2.setFont(new Font("Serif", Font.PLAIN, 24));
            line2.setForeground(Color.BLACK);
            line2.setBounds(155,330,590,30);
            line2.setOpaque(true);
            panel.add(line2);
            line3 = new JLabel("");
            line3.setFont(new Font("Serif", Font.PLAIN, 24));
            line3.setForeground(Color.BLACK);
            line3.setBounds(155,360,590,30);
            line3.setOpaque(true);
            panel.add(line3);
            box.setForeground(Color.BLACK);
            box.setBackground(lightGrey);
            box.setBounds(150,300,600,150);
            box.setOpaque(true);
            panel.add(box);
            
        }
        class ClickHandler extends MouseAdapter{
            public void mouseClicked(MouseEvent e) {
               System.out.println("Hello");
                clickCount++;
                if(clickCount==1){
                  line1.setText("Welcome to Wallaby and Co’s AI political door to door");
                  line2.setText("campaign program.[Click to Continue]");
                }
                if(clickCount==2){
                  line1.setText("This program will teach AIs like yourself how to navigate");
                  line2.setText("door to door conversations with a call to action being a ");
                  line3.setText("product or a vote. [Click to Continue]");
               }
               if(clickCount==3){
                  line1.setText("This program will focus on selling a political party the ");
                  line2.setText("wallaby party. [Click to Continue]");
                  line3.setText("");
               }
               if(clickCount==4){
                  line1.setText("The Image above will show the Wallaby party core values.");
                  line2.setText("[Click to Continue]");
               }
               if(clickCount==5){
                  line1.setText("Make sure these are the only platforms you talk about ");
                  line2.setText("during conversation. [Click to Continue]");
               }
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
