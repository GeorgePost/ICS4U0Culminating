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
   Color orange=new Color(255, 171, 64);
   int clickCount=0;
   JLabel box = new JLabel("");
   JLabel line1,line2,line3,slide,image,policy1,policy2,policy3,policy4,policy5,policy6;
   JFrame frame= Game.frame;
   public Tutorial(){
      panel = Game.panel;
      panel.addMouseListener(new ClickHandler());
      panel.add(draw);
      title();
      campignManager();
      textBox();
      slideImage();
      slide2();
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
  public void slideImage(){
      slide=new JLabel("");
      Image img= new ImageIcon(this.getClass().getResource("/image/WallabyPartyLogo.png")).getImage();
      Image newImage=img.getScaledInstance(384,384,Image.SCALE_SMOOTH);
      slide.setIcon(new ImageIcon(newImage));
      slide.setBounds(200,44,500,280);
      panel.add(slide);
  }
  public void slide2(){
   image= new JLabel("");
   //image of Wallaby Party
   Image img= new ImageIcon(this.getClass().getResource("/image/WallabyPartyLogo.png")).getImage();
   Image newImage=img.getScaledInstance(384,384,Image.SCALE_SMOOTH);
   image.setIcon(new ImageIcon(newImage));
   image.setBounds(10,44,500,280);
   //policy 1
   policy1=new JLabel("             Middle Class Tax Cuts");
   policy1.setFont(new Font("Serif", Font.PLAIN, 20));
   policy1.setBackground(orange);
   policy1.setBounds(450,100,300,25);
   policy1.setOpaque(true);
   //policy 2
   policy2=new JLabel("                  Curbing Inflation");
   policy2.setFont(new Font("Serif", Font.PLAIN, 20));
   policy2.setBackground(orange);
   policy2.setBounds(450,125,300,25);
    policy2.setOpaque(true);
   //policy 3
   policy3=new JLabel("           Expand use of AI in Gov");
   policy3.setFont(new Font("Serif", Font.PLAIN, 20));
   policy3.setBackground(orange);
   policy3.setBounds(450,150,300,25);
   policy3.setOpaque(true);
   //policy 4
   policy4=new JLabel("  Green Initiatives: Composting, etc");
   policy4.setFont(new Font("Serif", Font.PLAIN, 20));
   policy4.setBackground(orange);
   policy4.setBounds(450,175,300,25);
   policy4.setOpaque(true);
   //policy 5
   policy5=new JLabel("      Raising Tech Teacher Salaries");
   policy5.setFont(new Font("Serif", Font.PLAIN, 20));
   policy5.setBackground(orange);
   policy5.setBounds(450,200,300,25);
   policy5.setOpaque(true);
   //policy 6
   policy6=new JLabel("             Affordable Housing");
   policy6.setFont(new Font("Serif", Font.PLAIN, 20));
   policy6.setBackground(orange);
   policy6.setBounds(450,225,300,25);
   policy6.setOpaque(true);
   //hiding the labels
   image.setVisible(false);
   policy1.setVisible(false);
   policy2.setVisible(false);
   policy3.setVisible(false);
   policy4.setVisible(false);
   policy5.setVisible(false);
   policy6.setVisible(false);
   //adding to panel
   panel.add(image);
   panel.add(policy1);
   panel.add(policy2);
   panel.add(policy3);
   panel.add(policy4);
   panel.add(policy5);
   panel.add(policy6);
  }
  class ClickHandler extends MouseAdapter{
      public void mouseClicked(MouseEvent e) {
      System.out.println(e.getX()+","+e.getY());
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
            line2.setText("wallaby party. The image above shows the parties core values.");
            line3.setText("[Click to Continue]");
            slide.setVisible(false);
            image.setVisible(true);
            policy1.setVisible(true);
            policy2.setVisible(true);
            policy3.setVisible(true);
            policy4.setVisible(true);
            policy5.setVisible(true);
            policy6.setVisible(true);
         }
         if(clickCount==4){
            line1.setText("Make sure these are the only platforms you talk about ");
            line2.setText("during conversation. [Click to Continue]");
            line3.setText("");
         }
   }
   }
   class Drawing extends JComponent{
      public void paint(Graphics g){
             frame.add(panel); 
          }
   }
}
