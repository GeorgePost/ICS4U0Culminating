import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Tutorial Class that teaches the user about the game.
 * There is 4 sections for this tutorial teach the user about the game.
 * <strong>Course info:</strong>
 * ICS4U0 with V. Krasteva
 * @author George Postica
 * @version 1.0.0
 * @since 0.1.0
 * Created on May 21,2024
 * Hours spent creating: 20 hours
*/
public class Tutorial{
   /**Created draw to display my drawings */
   private Drawing draw = new Drawing();
   /**Varible to hold Game's panel*/
   private JPanel panel;
   /**Light blue color*/
   private Color lightBlue = new Color(0, 234, 255);
   /**Light grey Color*/
   private Color lightGrey=new Color(238, 238, 238);
   /**Background color used in the draw to make the background*/
   private Color backgroundColor=new Color(32,32,32);
   /**Orange used for You win and you lose and the background of the party values*/
   private Color orange=new Color(255, 171, 64);
   /**darkyellow color used for rounded rect of the slider*/
   private Color darkYellow=new Color(128,128,0);
   /**yellow color used for the circle in the slider*/
   private Color yellow = new Color(238,255,65);
   /**Keeps track of the user's amount of clicks in the scene*/
   private int clickCount;
   /**All the Labels for the slides*/
   private JLabel line1,line2,line3,slide,image,policy1,policy2,policy3,policy4,policy5,policy6,AIimage,logo;
   /**Reference variable for Game.frame*/
   JFrame frame= Game.frame;
   /**Layered pane, so that Labels and paint work together*/
   JLayeredPane lp;
   /**
     *Constructor for Tutorial 
     *Creates the labels, adds the labels and draw to a layered pane.
     *Defines the game panel, and adds layerPane to the frame and panel
   */
   public Tutorial(){
      clickCount=0;
      lp = new JLayeredPane();
      panel = Game.panel;
      panel.setLayout(null);
      panel.addMouseListener(new ClickHandler());
      lp.add(draw,JLayeredPane.DEFAULT_LAYER);
      draw.setBounds(0,0,800,500);
      draw.setOpaque(true);
      title();
      campignManager();
      textBox();
      slideImage();
      logoImage();
      slide2();
      AILimitations();
      lp.setOpaque(true);
      lp.setVisible(true);
      lp.setBounds(0,0,800,500);
      panel.add(lp);
      panel.setOpaque(true);
      panel.setVisible(true);
  }
  /**
   * Runs inside Tutorial
   * Makes the Tutorial text at the top of the screen
  */
  public void title(){
      JLabel label1 = new JLabel("Tutorial");
      label1.setFont(new Font("Serif", Font.BOLD, 30));
      label1.setForeground(lightBlue);
      label1.setBackground(Color.BLACK);
      label1.setBounds(340, 10, 300, 50);
      lp.add(label1,1);
  }
  /**
   * Runs inside Tutorial
   * Campign manager placed in the bottom left of the screen
  */
  public void campignManager(){
      JLabel label=new JLabel("");
      Image img= new ImageIcon(this.getClass().getResource("/image/business-man-hi.png")).getImage();
      label.setIcon(new ImageIcon(img));
      label.setBounds(0,180,400,400);
      panel.setLayout(null);
      lp.add(label,JLayeredPane.PALETTE_LAYER);
  }
  /**
   * Runs inside Tutorial
   * textBox contains all the lines for the dialogue
  */
  public void textBox(){
      line1 =new JLabel("[Click To Continue]");
      line1.setFont(new Font("Serif", Font.PLAIN, 24));
      line1.setForeground(Color.BLACK);
      line1.setBounds(160,310,590,30);
      line1.setOpaque(true);
      lp.add(line1,JLayeredPane.PALETTE_LAYER);
      line2 = new JLabel("");
      line2.setFont(new Font("Serif", Font.PLAIN, 24));
      line2.setForeground(Color.BLACK);
      line2.setBounds(160,340,590,30);
      line2.setOpaque(true);
      lp.add(line2,JLayeredPane.PALETTE_LAYER);
      line3 = new JLabel("");
      line3.setFont(new Font("Serif", Font.PLAIN, 24));
      line3.setForeground(Color.BLACK);
      line3.setBounds(160,370,590,30);
      line3.setOpaque(true);
      lp.add(line3,JLayeredPane.PALETTE_LAYER);
  }
  /**
   * Runs inside Tutorial
   * creates the last image seen, the Wallaby and Co logo.
  */
  public void logoImage(){
      logo=new JLabel("");
      Image img= new ImageIcon(this.getClass().getResource("/image/WallabyAndCoLogo.png")).getImage();
      Image newImage=img.getScaledInstance(256,256,Image.SCALE_SMOOTH);
      logo.setIcon(new ImageIcon(newImage));
      logo.setBounds(320,20,500,280);
      logo.setVisible(false);
      lp.add(logo,JLayeredPane.PALETTE_LAYER);
  }
  /**
   * Runs inside Tutorial
   * creates the first image seen, the Wallaby party logo.
  */
  public void slideImage(){
      slide=new JLabel("");
      Image img= new ImageIcon(this.getClass().getResource("/image/WallabyPartyLogo.png")).getImage();
      Image newImage=img.getScaledInstance(384,384,Image.SCALE_SMOOTH);
      slide.setIcon(new ImageIcon(newImage));
      slide.setBounds(200,44,500,280);
      lp.add(slide,JLayeredPane.PALETTE_LAYER);
  }
  /**
   * Runs inside Tutorial
   * moves the logo to the left side screen.
   * Also, shows the policies of the Wallaby party.
  */
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
   lp.add(image,JLayeredPane.PALETTE_LAYER);
   lp.add(policy1,JLayeredPane.PALETTE_LAYER);
   lp.add(policy2,JLayeredPane.PALETTE_LAYER);
   lp.add(policy3,JLayeredPane.PALETTE_LAYER);
   lp.add(policy4,JLayeredPane.PALETTE_LAYER);
   lp.add(policy5,JLayeredPane.PALETTE_LAYER);
   lp.add(policy6,JLayeredPane.PALETTE_LAYER);
  }
  /**
   * Runs inside Tutorial
   * creates the AI image seen throughout the AI limitations speech
  */
  public void AILimitations(){
      AIimage=new JLabel("");
      Image img= new ImageIcon(this.getClass().getResource("/image/AIteaching.png")).getImage();
      Image newImage=img.getScaledInstance(384,384,Image.SCALE_SMOOTH);
      AIimage.setIcon(new ImageIcon(newImage));
      AIimage.setBounds(200,10,500,280);
      AIimage.setVisible(false);
      lp.add(AIimage,JLayeredPane.PALETTE_LAYER);
  }
  /*
   *ClickHandler for the tutorial class.
   *Runs MouseClicked which activates when a user clicks the mouse
  */
  class ClickHandler extends MouseAdapter{
      /**
       *Mouse Clicked
       *@param e contains the MouseEvent
       *This will call repaint for the layered pane
       *Also updates the text label based on the amount of clicks done.
      */
      public void mouseClicked(MouseEvent e) {
          clickCount++;
          lp.repaint();
          if(Game.sceneNum!=3){
              return;
          }
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
            line1.setText("This program will focus on selling a political party: The ");
            line2.setText("Wallaby Party. The image above shows the parties core");
            line3.setText("values. [Click to Continue]");
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
         }if(clickCount==5){
            image.setVisible(false);
            policy1.setVisible(false);
            policy2.setVisible(false);
            policy3.setVisible(false);
            policy4.setVisible(false);
            policy5.setVisible(false);
            policy6.setVisible(false);
            line1.setText("Here are your conversation boxes. Click on them to");
            line2.setText("to respond to the person. This response will affect");
            line3.setText("your approval meter. [Click to see Approval Meter]");
         }
         if(clickCount==6){
            line1.setText("Here is your approval meter. If you say something a");
            line2.setText("person doesn’t like, the approval meter will decrease.");
            line3.setText("[Click to Continue]");
         }if(clickCount==7){
            line1.setText("The approval meter will increase if you say something a");
            line2.setText("person likes. To complete level 1 your approval meter");
            line3.setText("just needs to be above 0 at the end [Click to Continue]");
         }if(clickCount==8){
            line1.setText("For level 2, your meter needs to be above 50. Also in");
            line2.setText("level 2, if the meter reaches the end, you lose.");
            line3.setText("[Click to Continue]");
         }
         if(clickCount==9){
            AIimage.setVisible(true);
            line1.setText("What AIs like yourself may struggle with is finding when");
            line2.setText("a person is not engaged in the conversation. Make sure");
            line3.setText("to regain their attention [Click to Continue]");
         }if(clickCount==10){
            line1.setText("Another problem AIs run into is when to tell about the");
            line2.setText("party and when to ask the person to vote for the party.");
            line3.setText("[Click to Continue]");
         }if(clickCount==11){
            line1.setText("You should always at the beginning have the person ");
            line2.setText("understand the party and then ask them to vote. ");
            line3.setText("[Click to Continue]");
         }if(clickCount==12){
            line1.setText("Especially in Level 2, always evaluate the person’s views of");
            line2.setText("certain topics.As it is important to give the person what they");
            line3.setText("want.[Click to Continue]");
         }if(clickCount==13){
            AIimage.setVisible(false);  
            logo.setVisible(true);
            line1.setText("If you are telling about a policy they won’t like, they ");
            line2.setText("probably won’t vote for your party. Thanks for ");
            line3.setText("supporting Wallaby and Co [Click for Main Menu]");
         }if(clickCount==14){
            Game.changeScene(2);
         }  
   }
   }
   /**
     *Drawing Class for Tutorial
     *Will contain all drawings used in the project 
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
        *method to make a face with width and state
        *@param x is the x-coordinate of the face
        *@param y is the y coordinate of the face
        *@param width is the width of the face. The face is scalable for every 10 pixels
        *@param state is the state of the face. 0 is sad, 1 is meh, 2 is happy.
        *@param g is the Graphics class, so we can display our face
      */
      public void face(int x,int y, int width, int state, Graphics g){
         Graphics2D h = (Graphics2D) g;
         g.setColor(yellow);
         g.fillOval(x,y,width,width);
         g.setColor(Color.BLACK);
         g.fillOval(x+(width/5),y+(width/10)*3,width/5,width/5);
         g.fillOval(x+(width/5)*3,y+(width/10)*3,width/5,width/5);
         h.setStroke(new BasicStroke(4));
         if(state==2){
            h.drawArc(x+(width/5),y+(width/5)*3,width/5*3,width/5,200,140);
         }else if(state==0){
            h.drawArc(x+(width/5),y+(width/10)*7,width/5*3,width/5,20,140);
         }else{
            g.fillRect(x+(width/5),y+(width/10)*7,width/5*3,5);
         }
      }
      /*
       *the paint method makes the background and the box for the diagolue
       *the paint method also handles the visuals for slide 5-7
      */
      public void paint(Graphics g){
         Graphics2D h = (Graphics2D) g;
         g.setColor(backgroundColor); 
         g.fillRect(0,0,800,500);
         g.setColor(lightGrey);
         g.fillRoundRect(150,300,600,150,20,20);
         if(clickCount==5){
            g.fillRoundRect(450,40,300,75,30,30);
            g.fillRoundRect(450,120,300,50,15,15);
            g.fillRoundRect(450,175,300,50,15,15);
            g.fillRoundRect(450,230,300,50,15,15);
            Font font = new Font("SansSerif", Font.PLAIN,20);
            h.setColor(Color.BLACK);
            h.setFont(font);
            h.drawString("What's the best gaming Company",455,90);
            h.drawString("Ubihard",570,155);
            h.drawString("Big C Studios",540,210);
            h.drawString("Wallaby and Co",535,265);
         }
         if(clickCount>=6 && clickCount<=8){
            slider(50,115,200,25,g);
            face(100,10,100,0,g);
            slider(300,115,200,50,g);
            face(350,10,100,1,g);
            slider(550,115,200,75,g);
            face(600,10,100,2,g);
            h.setColor(orange);
            Font font = new Font("SansSerif", Font.PLAIN,50);
            h.setFont(font);
            h.drawString("You Lose",150,200);
            slider(160,220,200,0,g);
            h.setColor(orange);
            h.drawString("You Win",500,200);
            slider(500,220,200,50,g);
         }
         if(clickCount==13){
            g.fillOval(300,0,300,300);
            Font font = new Font("Serif", Font.PLAIN,30);
            h.setColor(Color.BLUE);
            h.setFont(font);
            h.drawString("Wallay and Co",365,265);
         }
      }
   }
}