import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This class acts as a hub to the tutorial and level1, as well as exiting the game
 * <strong>Course info:</strong>
 * ICS4U0 with V. Krasteva
 * @author Mitchell Levitt
 * @version 1.0.0
 * @since 0.2.0
 * Created on May 21, 2024
 * Hours spent creating: 2.5
 */
public class MainMenu implements ActionListener{

    /**The Start button*/
    JButton button1 = new JButton("Start");
    /**The Tutorial button*/
    JButton button2 = new JButton("Tutorial");
    /**The exit button Created by George */
    JButton exit = new JButton("Exit");
    /**The intro panel, which is just the game panel*/
    JPanel introPanel = Game.panel;
    /**The light blue color*/
    Color lightBlue = new Color(0, 234, 255);
    /**The constructor
     * Runs button and title
     */
    public MainMenu(){
        introPanel.setLayout(null);
        buttons();
        title();
        introPanel.setBackground(Color.BLACK);
    }
    /**
     * Places the Title main menu with light blue colour font at the top of the screen
     */
    public void title(){
        JLabel label1 = new JLabel("Main Menu");
        label1.setFont(new Font("Serif", Font.BOLD, 30));
        label1.setForeground(lightBlue);
        label1.setBackground(Color.BLACK);
        label1.setBounds(325, 10, 300, 50);
      
        introPanel.add(label1);
    }
    /**
     * Adjusts the buttons, so that they are at the middle of the screen
     * Adds listeners and adds them to panel
     */
    public void buttons(){
        button1.addActionListener(this);
        button2.addActionListener(this);
        exit.addActionListener(this);
        button1.setBounds(250,80,300,80);
        button2.setBounds(250,200,300,80);
        exit.setBounds(250,320,300,80);
        button1.setBorder(BorderFactory.createLineBorder(lightBlue, 3));
        button2.setBorder(BorderFactory.createLineBorder(lightBlue, 3));
        exit.setBorder(BorderFactory.createLineBorder(lightBlue, 3));
        button1.setBackground(Color.WHITE);
        button2.setBackground(Color.WHITE);
        exit.setBackground(Color.WHITE);
        button1.setOpaque(true);
        button2.setOpaque(true);
        exit.setOpaque(true);
        button1.setPreferredSize(new Dimension(300,70));
        button2.setPreferredSize(new Dimension(300,70));
        exit.setPreferredSize(new Dimension(300,70));
        button1.setFont(new Font("Arial",Font.BOLD,22));
        button2.setFont(new Font("Arial",Font.BOLD,22));
        exit.setFont(new Font("Arial",Font.BOLD,22));
        introPanel.add(button1);
        introPanel.add(button2);
        introPanel.add(exit);
    }
    /**
     * action performed method
     * Checks which button is clicked and changes the scene or exits the game based on that
     * @param e holds the Action event variable.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button2) {
            Game.changeScene(3);
        }
        if (e.getSource() == button1) {
            Game.changeScene(4);
        }if(e.getSource()==exit){
            Game.frame.dispose();
        }
    }
    
}


