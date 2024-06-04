/**
* Extends conversation cals to create the scene for the level one conversation
* @author  Mitchell Levitt
* @since 0.3.5
*/
public class Level1 extends Conversation
{
   /** Matrix of possible responses to player dialogue*/
   String[][] responses;
   /** Matrix of possible player dialogue options*/
   String[][] choices;
   /** Parallel array to choices that stores correct responses*/
   boolean[][] correctChoices;
   /** Stores number of times the player has clicked a dialogue option*/
   int clickNum;

   /**
    * Constructor for Level1 class.
    * Performs basic initialisation of matrices, and calls fillDialogue and startText
    */
   public Level1()
   {
      responses = new String[7][3];
      choices = new String[6][3];
      correctChoices = new boolean[6][3];
      fillDialogue();
      clickNum = 0;
      startText();
   }

   /**
    * Populates the responses, choices, and correctChoices arrays
    * @since 0.3.5
    */
   public void fillDialogue()
   {
      /*responses[0][0] = "What is the greatest game development company of all time?";
      responses[1][0] = "No, asassin's creed sucks. Well can you at least tell me the best animal.";
      responses[1][1] = "That's correct! I assume you will also be able to tell me the best animal";
      responses[1][2] = "Who? I can only assume you meant to speak of the great Walabee And Co. Can you at least tell me the best animal.";
      responses[2][0] = "A giraffe is just a wrong horse! How about you try to guess my favourite color.";
      responses[2][1] = "That's not even an animal, it's a mediocre movie. How about you try to guess my favourite color.";
      responses[2][2] = "Correct, the walabee is by far the best animal. Can you also guess my favourite color?";
      responses[3][0] = "Of course! Blue is a fantastic color.";
      responses[3][1] = "Red, that's even worse than green!";
      responses[3][2] = "green, that's even worse than red!";
      choices[0][0] = "Ubisoft";
      choices[0][1] = "Wallabee And Co.";
      choices[0][2] = "Barnelby And Shmo";
      choices[1][0] = "The Giraffe";
      choices[1][1] = "The Batman";
      choices[1][2] = "The Walabee";
      choices[2][0] = "Blue";
      choices[2][1] = "Red";
      choices[2][2] = "Green";
      correctChoices[0][1] = true;
      correctChoices[1][2] = true;
      correctChoices[2][0] = true;*/
       responses[0][0] = "Opening Dialogue";
       responses[1][0] = "Response to Dialogue Option 0.0";
       responses[1][1] = "Response to Dialogue Option 0.1";
       responses[1][2] = "Response to Dialogue Option 0.2";
       responses[2][0] = "Response to Dialogue Option 1.0";
       responses[2][1] = "Response to Dialogue Option 1.1";
       responses[2][2] = "Response to Dialogue Option 1.2";
       responses[3][0] = "Response to Dialogue Option 2.0";
       responses[3][1] = "Response to Dialogue Option 2.1";
       responses[3][2] = "Response to Dialogue Option 2.2";
       responses[4][0] = "Response to Dialogue Option 3.0";
       responses[4][1] = "Response to Dialogue Option 3.1";
       responses[4][2] = "Response to Dialogue Option 3.2";
       responses[5][0] = "Response to Dialogue Option 4.0";
       responses[5][1] = "Response to Dialogue Option 4.1";
       responses[5][2] = "Response to Dialogue Option 4.2";
       responses[6][0] = "Response to Dialogue Option 5.0";
       responses[6][1] = "Response to Dialogue Option 5.1";
       responses[6][2] = "Response to Dialogue Option 5.2";
       choices[0][0] = "Dialogue option 0.0";
       choices[0][1] = "Dialogue option 0.1";
       choices[0][2] = "Dialogue option 0.2";
       choices[1][0] = "Dialogue option 1.0";
       choices[1][1] = "Dialogue option 1.1";
       choices[1][2] = "Dialogue option 1.2";
       choices[2][0] = "Dialogue option 2.0";
       choices[2][1] = "Dialogue option 2.1";
       choices[2][2] = "Dialogue option 2.2";
       choices[3][0] = "Dialogue option 3.0";
       choices[3][1] = "Dialogue option 3.1";
       choices[3][2] = "Dialogue option 3.2";
       choices[4][0] = "Dialogue option 4.0";
       choices[4][1] = "Dialogue option 4.1";
       choices[4][2] = "Dialogue option 4.2";
       choices[5][0] = "Dialogue option 5.0";
       choices[5][1] = "Dialogue option 5.1";
       choices[5][2] = "Dialogue option 5.2";
       correctChoices[0][0] = true;
       correctChoices[1][0] = true;
       correctChoices[2][0] = true;
       correctChoices[3][0] = true;
       correctChoices[4][0] = true;
       correctChoices[5][0] = true;
   }

   /**
    * Calls the respond method when the user clicks on a dialogue option, and passes which option is pressed
    * @param x the x location of the mouse when clicked
    * @param y the y location of the mouse when clicked
    */
   @Override
   public void mouseClick(int x, int y) {
      if(x>500 && x<730 && clickNum<choices.length-1)
      {
         if(y>200 && y<275)
            respond(0);
         if(y>290 && y<365)
            respond(1);
         if(y>380 && y<455)
            respond(2);
      }
   }

   /**
    * Sets the initial response and dialogue options before user input
    * @since 0.3.5
    */
   public void startText()
   {
      super.drawRes.setMessage(responses[0][0]);
      super.drawOp1.setMessage(choices[0][0]);
      super.drawOp2.setMessage(choices[0][1]);
      super.drawOp3.setMessage(choices[0][2]);
   }

   /**
    * sets response message based on user selected dialogue options
    * generates new dialogue options
    * modifies aproval meter based on dialogue option selected
    * @param i the dialogue option chosen
    */
   public void respond(int i)
   {
      if(correctChoices[clickNum][i]) {
          super.meter.incrValue(25);
          if (meter.getValue() > 100)
              meter.setValue(100);
      }
      else if(!correctChoices[clickNum][i]) {
          super.meter.incrValue(-25);
          if (meter.getValue() < 0)
              meter.setValue(0);
      }
      clickNum++;
      super.drawRes.setMessage(responses[clickNum][i]);
      super.drawOp1.setMessage(choices[clickNum][0]);
      super.drawOp2.setMessage(choices[clickNum][1]);
      super.drawOp3.setMessage(choices[clickNum][2]);

   }
   

}