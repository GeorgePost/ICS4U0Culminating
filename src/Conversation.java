import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 * <p>
 * This class provides the graphical tools needed to create a conversation scene within the "Not your doordinary adventure" game
 * It contains methods for the creation of drawings as well as editable text boxes.
 * </p>
 * @author Mitchell
 * @version 0.3.1
*/
public abstract class Conversation{
    /**
     * Door drawing to be accessed by scene classes
     */
    protected Door drawDoor;

    /** * Response to be accessed by scene classes */
    protected Response drawRes;
    /**
     * Dialogue option drawings to be accessed by scene classes
     */
    protected Option drawOp1, drawOp2, drawOp3;
    /** * Approval meter drawing */
    protected ApprovalMeter meter;
    /**
     * Panel reference made to contain main Game panel
     */
    protected JPanel myPanel;
    /**
     * Panel reference made to contain main Game panel
     */
    public Font options = new Font("Serif", Font.PLAIN, 15);
    /**darky ellow color used for rounded rect of the slider*/
    private Color darkYellow=new Color(128,128,0);
     /**yellow color used for the circle in the slider*/
   private Color yellow = new Color(238,255,65);
    /**light blue color used for door frame background*/
    public Color lightBlue = new Color (209,224,228);
    /**blue color used for dialogue option outlines*/
    public Color blue = new Color(0, 208, 255);
    /**brown color used for door frame outlines*/
    public Color brown = new Color(110, 80, 55);

    /**
     * <p>
     *     The default constructor for the Conversation class.
     *     It initialises and positions various elements into a default layout.
     * </p>
     */
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
        meter = new ApprovalMeter();
        JLabel label = new JLabel("Approval Meter");
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setBounds(555,-35,300,100);
        label.setForeground(Color.WHITE);
        myPanel.add(label);
        meter.setBounds(515,20,250,200);
        myPanel.add(meter);
        Game.frame.validate();
        Game.frame.repaint();
    }
    /**
     * <p>
     *     Breaks up a String argument into an array list.
     *     This is done in a way such that each element contains a maximum pixel length text.
     * </p>
     * @param message the string argument to be broken up
     * @param pixLength the maximum length in pixels that a given element can contain
     * @param object the object (either Option or Response) the text is to be placed in. It's font settings are used in the calculations.
     * @return an array list of string elements equal to the message argument broken up in order, with no element being over the maximum pixel length
     */
    public ArrayList<String> textFormat(String message, int pixLength, JComponent object)
    {
        message+=" ";
        if(object instanceof Option) {
            Option op = (Option) object;
            ArrayList<String> lines = new ArrayList<>();
            lines.add("");
            while (message.indexOf(" ") >= 0) {
                int wordLen = op.m.stringWidth(message.substring(0, message.indexOf(" ")));
                if (op.m.stringWidth(lines.get(lines.size() - 1)) + wordLen >= pixLength)
                    lines.add("");
                //if (op.m.stringWidth(lines.get(lines.size() - 1)) + wordLen <= pixLength) {
                    lines.set(lines.size() - 1, lines.get(lines.size() - 1) + message.substring(0, message.indexOf(" ")) + " ");
                    message = message.substring(message.indexOf(" ") + 1);
                //}
            }
            return lines;
        }
        else if(object instanceof Response)
        {
            Response res = (Response) object;
            ArrayList<String> lines = new ArrayList<>();
            lines.add("");
            while (message.indexOf(" ") >= 0) {
                int wordLen = res.m.stringWidth(message.substring(0, message.indexOf(" ")));
                if (res.m.stringWidth(lines.get(lines.size() - 1)) + wordLen >= pixLength)
                    lines.add("");
                if (res.m.stringWidth(lines.get(lines.size() - 1)) + wordLen <= pixLength) {
                    lines.set(lines.size() - 1, lines.get(lines.size() - 1) + message.substring(0, message.indexOf(" ")) + " ");
                    message = message.substring(message.indexOf(" ") + 1);
                }
            }
            return lines;
        }
        else {
            System.out.println("Wrong object, try again - Sincerely, textFormat method");
            return null;
        }
    }
    public abstract void mouseClick(int x, int y);

    /**
     * <p>
     *     This embedded class provides the Conversation class with a mouse listener, and is used for debugging
     * </p>
     */
        class ClickHandler extends MouseAdapter{
        public void mouseClicked(MouseEvent e) {
            System.out.println(e.getX()+","+e.getY());
            mouseClick(e.getX(),e.getY());
        }
    }
    /**
     * <p>
     * This embedded class draws a brown door graphic when called by the main Option class
     * </p>
     * @since 0.2.3
     * @author Mitchell
     * @version 0.3.1
     */
    class Door extends JComponent{
        /**
         * <p>
         *     paints the door
         * </p>
         * @param g the graphics object being painted on
         */
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
    /**
     * <p>
     * This embedded class creates a text box meant to contain player dialogue choices for the conversation class
     * </p>
     * @author Mitchell
     * @since 0.2.7
     * @version 0.3.1
     */
    class Option extends JComponent{
        /** contains font information from this object, used in textFormat
         * @see Conversation
         * */
            public FontMetrics m;
        /**
         * Contains the 4 lines of text in the text box
         */
        ArrayList<String> message = new ArrayList<String>(4);

        /**
         * fills message with 4 empty lines, and initialises m
         */
            public Option(){
            message.add("");
            message.add("");
            message.add("");
            message.add("");
            m = getFontMetrics(options);
            }

        /**
         * calls the textFormat method in the main class to create an arraylist and passes it to the second setMessage method
         * @param str the text being passed to formatText
         */
        public void setMessage(String str)
        {
            setMessage(textFormat(str, 370, this));
        }

        /**
         * assigns the elements of the message array list to be equal to th first 3 elements of str
         * @param str the array list being assigned to message elements
         */
        public void setMessage(ArrayList<String> str)
        {
            for(int i = 0; i<3; i++)
                message.set(i,"");
            for(int i = 0; i<3 && i<str.size(); i++)
                message.set(i,str.get(i));
            this.repaint();
            System.out.println(str);
        }
        /**
         *paints the text box, and draws out the lines of the message array
         * @param g the graphics object being painted on
         */
        public void paintComponent(Graphics g){
            super.paintComponent(g);
           //  m = g.getFontMetrics(options);
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
    /**
     * <p>
     * This embedded class creates a text box meant to contain npc responses for the conversation class
     * </p>
     * @author Mitchell
     * @since 0.2.3
     * @version 0.3.1
     */
    class Response extends JComponent {
        /** contains font information from this object, used in textFormat
         * @see Conversation
          */
        public FontMetrics m;
        /**
         * Contains the 4 lines of text in the text box
         */
         ArrayList<String> message = new ArrayList<String>(4);
        /**
         * fills message with 4 empty lines, and initialises m
         */
            public Response(){
            message.add("");
            message.add("");
            message.add("");
            message.add("");
                m = getFontMetrics(options);
            }
        /**
         * assigns the elements of the message array list to be equal to th first 4 elements of str
         * @param str the array list being assigned to message elements
         */
         public void setMessage(ArrayList<String> str)
        {
            for(int i = 0; i<4; i++)
                message.set(i,"");
            for(int i = 0; i<4 && i<str.size(); i++)
                message.set(i,str.get(i));
            this.repaint();
        }
        /**
         * calls the textFormat method in the main class to create an arraylist and passes it to the first setMessage method
         * @param str the text being passed to formatText
         */
        public void setMessage(String str)
        {
            setMessage(textFormat(str, 220, this));
            this.repaint();
        }
        /**
         *paints the text box, and draws out the lines of the message array
         * @param g the graphics object being painted on
         */
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
    /**
     * <p>
     * This embedded class creates an approval meter to be used in the Conversation class
     * </p>
     * @author Mitchell
     * @since 0.3.1
     * @version 0.3.1
     */
    class ApprovalMeter extends JComponent {
        int value = 50;
        /**
         * @param g the graphics object being painted on
         * calls drawMeter method with default dimensions
         */
     public void paintComponent(Graphics g){
            super.paintComponent(g);
            drawMeter(0,10,200,g);
          }

        /**
         * @param x the horizontal location of the meter
         * @param y the vertical location of the meter
         * @param width the width of the meter
         * @param g the graphics object being painted on
         */
     public void drawMeter(int x, int y, int width, Graphics g){
            Color slider = new Color((int)(200-2*value),(int)(2*value),0);
            g.setColor(slider);
            g.fillRoundRect(x,y,width,10,10,10);
            Color ball = new Color((int)(255-2.55*value),(int)(2.55*value),0);
            g.setColor(ball);
            int movement=(int)((value/100.0)*width);
            g.fillOval(x+movement-7,y-2,15,15);

       }

        /**
         * sets the value of the meter
         * @param v the changed value of v
         */
       public void setValue(int v)
       {
           value = v;
           repaint();
       }

        /**
         * Accessor method for the value variable
         * @return the integer value of the value variable
         */
       public int getValue()
       {
           return value;
       }
        /**
         * increases the value of the meter
         * @param v the integer being added to value
         */
        public void incrValue(int v)
        {
            value += v;
            repaint();
        }
   }
}
