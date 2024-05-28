import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Conversation{
    Door drawDoor;
    Option drawOp1;
    Option drawOp2;
    Option drawOp3;
    Response drawRes;
    int mouseX = 0, mouseY = 0;
    JPanel myPanel;
    Font options = new Font("Serif", Font.PLAIN, 15);
    Color lightBlue = new Color (209,224,228);
    Color blue = new Color(0, 208, 255);
    Color lightGrey=new Color(238, 238, 238);
    Color brown = new Color(110, 80, 55);
    public Conversation(){
        myPanel = Game.panel;
        myPanel.setBackground(Color.BLACK);
        drawDoor = new Door();
        myPanel.addMouseListener(new ClickHandler());
        drawOp1 = new Option();
        drawOp1.setBounds(500,200,300,100);
        drawOp2 = new Option();
        drawOp2.setBounds(500,290,300,100);
        drawOp3 = new Option();
        drawOp3.setBounds(500,380,300,100);
        drawRes = new Response();
        drawRes.setBounds(500,70,300,200);
        drawDoor.setBounds(0,0,800,500);
        myPanel.add(drawDoor);
        myPanel.add(drawOp1);
        myPanel.add(drawOp2);
        myPanel.add(drawOp3);
        myPanel.add(drawRes);
        drawOp1.setMessage(textFormat("How are you doing today. I am doing great. What is your favourite color?",10));
        Game.frame.validate();
        Game.frame.repaint();
    }
    public ArrayList<String> textFormat(String message, int numChars)
    {
        ArrayList<String> lines = new ArrayList<String>();
        lines.add("");
        while(message.indexOf(" ")>=0)
        {
            int wordLen = message.indexOf(" ");
            if(lines.get(lines.size()-1).length()+wordLen >= numChars)
                lines.add("");
            if(lines.get(lines.size()-1).length()+wordLen <= numChars) {
                lines.set(lines.size() - 1, lines.get(lines.size() - 1) + message.substring(0, message.indexOf(" ")) + " ");
                message = message.substring(message.indexOf(" ")+1);
            }
        }
        return lines;
    }
    class ClickHandler extends MouseAdapter{
        public void mouseClicked(MouseEvent e) {
            System.out.println(e.getX()+","+e.getY());
        }
    }
    class Door extends JComponent{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D h = (Graphics2D) g;
            h.setStroke(new BasicStroke(5));
            g.setColor(lightBlue);
            g.fillRect(160,85,200,300);
            g.setColor(brown);
            g.drawRect(160,85,200,300);
            int[] x1 = {45,160,160,45};
            int[] y1 = {55,85,385,415};
            g.fillPolygon(x1, y1, 4);
        }
    }
    class Option extends JComponent{
            ArrayList<String> message = new ArrayList<String>(4);
            public Option(){
            message.add("");
            message.add("");
            message.add("");
            message.add("");}
        public void setMessage(ArrayList<String> str)
        {
            for(int i = 0; i<4; i++)
            message.set(i,str.get(i));
            drawOp1.repaint();
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D h = (Graphics2D) g;
            h.setStroke(new BasicStroke(3));
            g.setColor(Color.WHITE);
            g.fillRoundRect(0,0,230,70,20,20);
            g.setColor(blue);
            g.drawRoundRect(0,0,230,70,20,20);
            g.setFont(options);
            g.setColor(Color.BLACK);
            g.drawString(message.get(0),5,17);
            g.drawString(message.get(1),5,32);
            g.drawString(message.get(2),5,47);
            g.drawString(message.get(3),5,62);
        }
    }
        
    class Response extends JComponent {
    
         ArrayList<String> message = new ArrayList<String>(4);
            public Response(){
            message.add("");
            message.add("");
            message.add("");
            message.add("");
            }
         public void setMessage(ArrayList<String> str)
        {
            for(int i = 0; i<4; i++)
            message.set(i,str.get(i));
            drawOp1.repaint();
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D h = (Graphics2D) g;
            h.setStroke(new BasicStroke(3));
            g.setColor(Color.WHITE);
            g.fillRoundRect(0,0,230,115,20,20);
            g.setColor(Color.ORANGE);
            g.drawRoundRect(0,0,230,115,20,20);
            g.setFont(options);
            g.setColor(Color.BLACK);
            g.drawString(message.get(0),5,17);
            g.drawString(message.get(1),5,32);
            g.drawString(message.get(2),5,47);
            g.drawString(message.get(3),5,62);
        }

    }
}
