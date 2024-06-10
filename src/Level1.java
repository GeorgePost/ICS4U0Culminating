/**
 * Extends conversation to create the scene for the level one conversation
 * @author  Mitchell Levitt
 * @since 0.3.5
 * @version 1.0.0
 * Hours spent creating: 6.5
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
    /** Weather or not this instance of Level1 has been completed */
    private boolean complete = false;
    /** This is used to end the game, so the user can see the final response*/
    boolean endGame = false;
    /**
     * Constructor for Level1 class.
     * Performs basic initialisation of matrices, and calls fillDialogue and startText
     * Also sets starting values of clickNum and endGame
     */
    public Level1()
    {
        responses = new String[6][3];
        choices = new String[5][3];
        correctChoices = new boolean[5][3];
        fillDialogue();
        clickNum = 0;
        startText();
        endGame = false;
    }

    /**
     * Populates the responses, choices, and correctChoices arrays
     * @since 0.3.5
     */
    public void fillDialogue()
    {
        responses[0][0] = "What brings you here today, traveller?";
        responses[1][0] = "But ...you knocked on my door. I see your wallaby party pin, what is your tax policy?";
        responses[1][1] = "Umm...I see your wallaby party pin. What is your tax policy? ... Please don't kill me.";
        responses[1][2] = "Oh, I see. I've never heard of them before. What's your tax policy like?";
        responses[2][0] = "That sounds great! But if you plan on cutting taxes, what is your environmental policy.";
        responses[2][1] = "I guess that's a good thing. Do you have an environmental policy?";
        responses[2][2] = "How are you working in government? Never mind, can you at least tell me about your environmental policy.";
        responses[3][0] = "That's horrible! Even environmental issues aside, can you even handle economic issues like inflation?";
        responses[3][1] = "That sounds like a great idea. What are your thoughts on inflation?";
        responses[3][2] = "I guess I'll just look it up on your website later. Can you tell me about how you plan to handle inflation?";
        responses[4][0] = "Yeah, what are you doing in terms of education";
        responses[4][1] = "Makes sense. What are your thoughts on the education system.";
        responses[4][2] = "I just ... can't even begin to explain what was wrong with that statement. Do you at least have a plan for education?";
        responses[5][0] = "That is the greatest idea I have ever heard. I'm all for it. [Click to Finish]";
        responses[5][1] = "I'd like to imagine that's not true.[Click to Finish]";
        responses[5][2] = "What, no. Please don't do that.[Click to Finish]";
        choices[0][0] = "That's a good question. I was hoping you would know.";
        choices[0][1] = "To kill you squire.";
        choices[0][2] = "I want to tell you about the Wallaby Party.";
        choices[1][0] = "We want to support middle class tax cuts for people like you.";
        choices[1][1] = "We certainly plan to continue them.";
        choices[1][2] = "What are taxes?";
        choices[2][0] = "Burn the forests and animals. Who needs em'.";
        choices[2][1] = "We want to reduce emissions via the investment in clean energy sources like hydro and nuclear.";
        choices[2][2] = "We certainly have one.";
        choices[3][0] = "It is what it is. People need to learn to work through adversity.";
        choices[3][1] = "We want to curb inflation by carefully manipulating interest rates.";
        choices[3][2] = "We are staunch supporters of inflation. The more balloons, the better.";
        choices[4][0] = "We plan to increase computer science teachers' salaries.";
        choices[4][1] = "Why teach children, when AIs like myself will one day consume the workforce.";
        choices[4][2] = "Might as well demolish a few schools. We need room for condos.";
        correctChoices[0][2] = true;
        correctChoices[1][0] = true;
        correctChoices[2][1] = true;
        correctChoices[3][1] = true;
        correctChoices[4][0] = true;

    }

    /**
     * Calls the <code>respond</code> method or ends the level when the user clicks on a dialogue option, and passes which option is pressed
     * @param x the x location of the mouse when clicked
     * @param y the y location of the mouse when clicked
     * @author George and Mitchell
     */
    @Override
    public void mouseClick(int x, int y) {
        if(!complete) {
            if (x > 500 && x < 730 && clickNum < choices.length && Game.sceneNum == 4) {
                if (y > 200 && y < 275)
                    respond(0);
                if (y > 290 && y < 365)
                    respond(1);
                if (y > 380 && y < 455)
                    respond(2);
            } else if (endGame && Game.sceneNum == 4) {
                complete = true;
                endGame();
            }
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
     * modifies approval meter based on dialogue option selected
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
        if(meter.getValue()>50)
            face.changeFace(2);
        else if(meter.getValue()==50)
            face.changeFace(1);
        else
            face.changeFace(0);
        clickNum++;
        super.drawRes.setMessage(responses[clickNum][i]);
        if(clickNum<choices.length) {
            super.drawOp1.setMessage(choices[clickNum][0]);
            super.drawOp2.setMessage(choices[clickNum][1]);
            super.drawOp3.setMessage(choices[clickNum][2]);
        }else{
            endGame=true;
            super.drawOp1.setMessage("");
            super.drawOp2.setMessage("");
            super.drawOp3.setMessage("");
        }
    }
    /**
    *This decides whether the person has won the level or lost the level used in the respond method.
    *@author George Postica
    */
    public void endGame(){
        if(meter.getValue()>0){
            Game.changeScene(7);
        }else{
            Game.changeScene(6);
        }
    }
}