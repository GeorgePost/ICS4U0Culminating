/**
 * Extends conversation cals to create the scene for the level two conversation
 * @author  Mitchell Levitt
 * @since 0.3.9
 * @version 0.3.9
 */
public class Level2 extends Conversation
{
    /** Matrix of possible responses to player dialogue*/
    String[][] responses;
    /** Matrix of possible player dialogue options*/
    String[][] choices;
    /** Parallel array to choices that stores correct responses*/
    boolean[][] correctChoices;
    /** Stores number of times the player has clicked a dialogue option*/
    int clickNum;
    /** This is used to end the game, so the user can see the final response*/
    boolean endGame = false;
    /**
     * Constructor for Level2 class.
     * Performs basic initialisation of matrices, and calls fillDialogue and startText
     */
    public Level2()
    {
        responses = new String[6][3];
        choices = new String[5][3];
        correctChoices = new boolean[5][3];
        fillDialogue();
        clickNum = 0;
        startText();
    }

    /**
     * Populates the responses, choices, and correctChoices arrays
     * @since 0.3.9
     */
    public void fillDialogue()
    {
        responses[0][0] = "Hello how can I help you?";
        responses[1][0] = "I'm not sure I appreciate you knocking on my door to advertise. Well, let's hear it then.";
        responses[1][1] = "Who are you to tell me who I should vote for? You got anything else to say?";
        responses[1][2] = "Alright, I guess I can spare some time. What did you want to talk about?";
        responses[2][0] = "Yes, I would! Please go ahead.";
        responses[2][1] = "I'll have you know wurms are an essential part of our ecosystem. Tell me, what is your environmental policy?";
        responses[2][2] = "You're the one who knocked on my door! I guess you can tell me about your environmental policy.";
        responses[3][0] = "That's exactly what I've been looking for! But beyond the environment, I'm pretty worried about how expensive housing is getting.";
        responses[3][1] = "Every party says that, it's no reason to vote for you. I'm pretty worried about how expensive housing is getting, do you have a plan to deal with that?";
        responses[3][2] = "I mean I do want our programs to get well funded, but that seems excessive. But beyond the environment, I'm pretty worried about how expensive housing is getting.";
        responses[4][0] = "Obviously I know that, But I work hard to afford this house. Plus, it's not cheap for me either. Alright, I have one last question. Is it just campaigning or does your party intend to expand AI use in other areas?";
        responses[4][1] = "That sounds like a good idea. I have one last question. Is your party's use of an AI to campaign door to door indicative of their future policies?";
        responses[4][2] = "Woah, I don't think we should be getting rid of houses altogether. Alright, I have one last question. Is it just campaigning or does your party intend to expand AI use in other areas?";
        responses[5][0] = "Even I wouldn't go that far. Also, your party needs to figure out where you stand on these issues, you can't just change your mind.";
        responses[5][1] = "I think that's going too far. There are certainly a lot of places in government that artificial intelligence shouldn't be a part of.";
        responses[5][2] = "That seems like a smart approach. It's good to be cautious, but you can't ignore such valuable technology.";
        choices[0][0] = "I am here to advertise a political party";
        choices[0][1] = "You should vote for the Wallaby Party";
        choices[0][2] = "I am here on behalf of the Wallaby party to talk about its platforms";
        choices[1][0] = "I notice you have solar panels on your roof, would you like to hear about our environmental policy.";
        choices[1][1] = "I notice you have your own composter. Wurms suck, am I right?";
        choices[1][2] = "I don't know. What do you want to talk about?";
        choices[2][0] = "We intend to fund current environmental programs, as well as innovate new initiatives to help our planet. This includes a new green energy project.";
        choices[2][1] = "We care about the environment more than any other party. If you care about the environment, vote for us.";
        choices[2][2] = "We are going to spend more taxpayer money than ever before on green initiatives.";
        choices[3][0] = "Consider yourself lucky you own a house. It's tough times.";
        choices[3][1] = "We intend to sponsor the construction of affordable housing units in order to lower both rent and mortgage prices.";
        choices[3][2] = "We want to build affordable high rise condos in place of houses like this one. That should lower the cost of housing.";
        choices[4][0] = "Are you kidding me! AI is a scourge to society. In fact now that you mention it, maybe this whole AI campaigning thing was probably a mistake.";
        choices[4][1] = "Of course! AI is a very powerful tool. We intend to optimize and improve every field of our government using artificial intelligence. We believe that this will bring about great positive change.";
        choices[4][2] = "An excellent question. We at the Wallaby Party intend to carefully expand the use of AI into the administrative areas of government. However, this expansion will be extremely limited as we understand AI is still a very volatile technology.";
        correctChoices[0][2] = true;
        correctChoices[1][0] = true;
        correctChoices[2][0] = true;
        correctChoices[3][1] = true;
        correctChoices[4][2] = true;

    }

    /**
     * Calls the <code>respond</code> method when the user clicks on a dialogue option, and passes which option is pressed
     * @param x the x location of the mouse when clicked
     * @param y the y location of the mouse when clicked
     */
    @Override
    public void mouseClick(int x, int y) {
        if(endGame && Game.sceneNum==5){
            endGame();
        }else if(x>500 && x<730 && clickNum<choices.length && Game.sceneNum==5)
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
     * @since 0.3.9
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
            if (meter.getValue() < 0){
                meter.setValue(0);
                endGame=true;
            }
        }
        if(meter.getValue()>50)
            face.changeFace(2);
        else if(meter.getValue()==50)
            face.changeFace(1);
        else
            face.changeFace(0);
        clickNum++;
        if(endGame){
            super.drawRes.setMessage("Oops I found a lame excuse for why I should leave [Click to Continue]");
            super.drawOp1.setMessage("");
            super.drawOp2.setMessage("");
            super.drawOp3.setMessage("");
        }else{
            super.drawRes.setMessage(responses[clickNum][i]);
            if(clickNum<choices.length) {
               super.drawOp1.setMessage(choices[clickNum][0]);
               super.drawOp2.setMessage(choices[clickNum][1]);
               super.drawOp3.setMessage(choices[clickNum][2]);
            }else{
               endGame=true;
               super.drawRes.setMessage(responses[clickNum][i]+" [Click to Continue]");
            }
      }
    }
   /**
    *This decides whether the person has won the level or lost the level used in the respond method.
    *@author: George Postica
    */
    public void endGame(){
        if(meter.getValue()>50){
            Game.changeScene(7);
        }else{
            Game.changeScene(6);
        }
    }

}