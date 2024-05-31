/**
* Not commented yet, work in progress
*@Author Mitchell Levitt
* @since 
*/
public class Level1 extends Conversation
{
   String[][] responses;
   String[][] choices;
   public Level1()
   {
      responses = new String[3][3];
      choices = new String[2][3];
      fillDialogue();
   }
   public void fillDialogue()
   {
      responses[0][0] = "Hello there, what brings you by today?";
      responses[1][0] = "Response to dialogue 0.0";
      responses[1][1] = "Response to dialogue 0.1";
      responses[1][2] = "Response to dialogue 0.2";
      responses[2][0] = "Response to dialogue 1.0";
      responses[2][1] = "Response to dialogue 1.1";
      responses[2][2] = "Response to dialogue 1.2";
      responses[1][0] = "Response to dialogue 0.0";
      responses[1][1] = "Response to dialogue 0.1";
      responses[1][2] = "Response to dialogue 0.2";
   }
   

}