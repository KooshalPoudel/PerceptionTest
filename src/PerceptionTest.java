/**
 *Making a Perception test for animals and their actions using JOptionPane
 * @author Kushal Poudel 
 *Last Modified: 9/27/2023
 */

import java.util.*;
import javax.swing.*;

public class PerceptionTest {
    
    
    
    public static void main(String[] args) {
       
        //introduction Msg
        ImageIcon introIcon = new ImageIcon("images\\introIcon.png");
        String introduction ="<html><h1>Welcome!!</h1><br>This is a preception"+
                 " test.<br><br>Where you have to guess about:<br>"
                  + "Animals, Actions or Both!</html>";
        
        JOptionPane.showMessageDialog(null,introduction,
        "Welcome to perception test",1,introIcon);
        
        //Instruction Msg
        ImageIcon instructionIcon = new ImageIcon("images\\instruction"
                                                + "Icon.png");
        String instructionMsg= "Instructions for the game:\n1.)First you can "+
                               "choose which test to perform.\n2.)You can sim"+
                               "ply do that by clicking one of the options.\n"+
                               "3.)After that you can select your choices by "+
                               "clicking on the option you like.\n4.)You can "+
                               "choose up to 5 times and one round will be over"
                              +".\n5.)The results will be shown.\n6.)After that"
                              +" you can play another 5 round or you can Quit."
                              +"\n7.)You can make your choice by simply "+
                               "clicking the option.";
        
        JOptionPane.showMessageDialog(null, 
        instructionMsg, 
        "Instructions: ",0,
        instructionIcon);
        
        //Choosing what test to perform
        String[] testType ={"Animals","Actions","Both","Quit"}; 
        String testTypeMessage = "What type of Preception test would you like"
                               + " to perform?";
        ImageIcon guessIcon = new ImageIcon("images\\guessIcon.png");
        int testTypeInt = JOptionPane.showOptionDialog(null,
                testTypeMessage, "Choose the Test type"
               ,0, 0, guessIcon, 
                testType, testType[3]);
        
        if (testTypeInt ==0)
        {
   
           int loopCounter=1;
           int animalScore=0;
           while(true)
           {
                int[] animalTestChoices =animalPreceptionTest();
                if(animalTestChoices[0]==animalTestChoices[1])
                {
                    String animalTestResultMsg="You Perceived "+
                        intToStringAnimalTestConv(animalTestChoices[1])+"\n"+
                        "The animal was "+
                        intToStringAnimalTestConv(animalTestChoices[0])+"\n"+
                        "You are Correct"+"\nGood Perception on Animal!";
                    JOptionPane.showMessageDialog(null,
                        animalTestResultMsg,
                        "Correct Result",1,
                        randomIconGenerator(animalTestChoices[0],
                                randomNumberGenerator(5)));
                    animalScore++;         
                }
                else
                {
                    String animalTestResultMsg="You Perceived "+
                        intToStringAnimalTestConv(animalTestChoices[1])+" \n"+
                        "The animal was "+
                        intToStringAnimalTestConv(animalTestChoices[0])+" \n"+
                        "You are a bit off ";
                    JOptionPane.showMessageDialog(null,
                        animalTestResultMsg,
                        "Incorrect Result",1,
                        randomIconGenerator(animalTestChoices[0],
                        randomNumberGenerator(5)));
                } 
             
                boolean repeatAgain = backDoorBreakAnimalTest(loopCounter,
                                                                   animalScore);
                if (!repeatAgain)
                {
                    break;
                }
            
                loopCounter++;
           }
        }
        
        else if (testTypeInt ==1)
        {
           int loopCounter=1;
           int actionScore=0;
            
            while (true)
            {
                int[] actionTestChoices =actionPreceptionTest();
                if(actionTestChoices[0]==actionTestChoices[1])
                {
                    String animalTestResultMsg="You Perceived "+
                        intToStringActionTestConv(actionTestChoices[1])+"\n"+
                        "The action is "+
                        intToStringActionTestConv(actionTestChoices[0])+"\n"+
                        "You are Correct "+"\nGood Perception on action!";
                    JOptionPane.showMessageDialog(null,
                        animalTestResultMsg,
                        "Correct Result",1,
                        randomIconGenerator(randomNumberGenerator(
                        5),actionTestChoices[0]));
                    actionScore++;                  
                }
                else
                {
                    String animalTestResultMsg="You Perceived "+
                        intToStringActionTestConv(actionTestChoices[1])+"\n"+
                        "The action was "+
                        intToStringActionTestConv(actionTestChoices[0])+"\n"+
                        "You are a bit off";
                    JOptionPane.showMessageDialog(null,
                        animalTestResultMsg,
                        "Incorrect Result",1,
                        randomIconGenerator(randomNumberGenerator(
                        5),actionTestChoices[0]));
                }  
            
                boolean repeatAgain = backDoorBreakActionTest(loopCounter
                                                                 ,actionScore);
                if (!repeatAgain)
                {
                    break;
                }
            
                loopCounter++;
           }
            
        }
        else if (testTypeInt ==2)
        {
            int loopCounter = 1;
            int animalScore=0;
            int actionScore=0;
            int bothScore=0;
            
            while (true)
            {
                int[][] bothTestChoices = bothPreceptionTest();
                      
                if(bothTestChoices[0][0]==bothTestChoices[1][0] &&
                   bothTestChoices[0][1]==bothTestChoices[1][1])
                {
                    String animalTestResultMsg="Animal Perception:\n"+
                        "You Preceived : "+intToStringAnimalTestConv(
                                        bothTestChoices[1][0])+"\n"+
                        "The animal was : "+intToStringAnimalTestConv(
                                        bothTestChoices[0][0])+"\n"+
                        "Good Preception on animal!\n\n";
                    
                    String actionTestResultMsg ="Action Perception:\n"+
                        "You Perceived : "+intToStringActionTestConv(
                                        bothTestChoices[1][1])+"\n"+
                        "The action was : "+intToStringActionTestConv(
                                        bothTestChoices[0][1])+"\n"+
                        "Good Perception on action!\n\n";
                    
                    String bothRightMsg = "You got both animal and actions\n"+
                        "You were very accurate in your perception\n"+
                        "Good job!!";
                
                    JOptionPane.showMessageDialog(null,
                        animalTestResultMsg+actionTestResultMsg+bothRightMsg,
                        "Results:",1,
                        randomIconGenerator(bothTestChoices[0][0],
                                                bothTestChoices[0][1]));
                    bothScore++;
                }
                else if (bothTestChoices[0][0]==bothTestChoices[1][0])
                {
                    String animalTestResultMsg="Animal Perception:\n"+
                       "You Perceived : "+intToStringAnimalTestConv(
                                                bothTestChoices[1][0])+"\n"+
                       "The animal was : "+intToStringAnimalTestConv(
                                                bothTestChoices[0][0])+"\n"+
                       "Good Perception on animal!\n";
                    
                    String actionTestResultMsg ="Action Perception:\n"+
                        "You Perceived : "+intToStringActionTestConv(
                                                bothTestChoices[1][1])+"\n"+
                        "The action was : "+intToStringActionTestConv(
                                                bothTestChoices[0][1])+"\n"+
                        "A bit off on this one!\n\n";
                    
                    JOptionPane.showMessageDialog(null,
                        animalTestResultMsg+actionTestResultMsg,
                        "Results:",1,
                        randomIconGenerator(bothTestChoices[0][0],
                                                bothTestChoices[0][1]));
                    animalScore++;
                }
                else if (bothTestChoices[0][1]== bothTestChoices[1][1])
                {   
                    String animalTestResultMsg="Animal Perception:\n"+
                       "You Perceived : "+intToStringAnimalTestConv(    
                                                bothTestChoices[1][0])+"\n"+
                       "The animal was : "+intToStringAnimalTestConv(
                                                bothTestChoices[0][0])+"\n"+
                       "A bit off on this one!\n";
                    
                    String actionTestResultMsg ="Action Perception:\n"+
                        "You Perceived : "+intToStringActionTestConv(
                                                bothTestChoices[1][1])+"\n"+
                        "The action was : "+intToStringActionTestConv(
                                                bothTestChoices[0][1])+"\n"+
                        "Good Perception on Action!\n";
                    
                    JOptionPane.showMessageDialog(null,
                        animalTestResultMsg+actionTestResultMsg,
                        "Results:",1,
                        randomIconGenerator(bothTestChoices[0][0],
                                                bothTestChoices[0][1]));
                    actionScore++;
                }
                else
                {
                    String animalTestResultMsg="Animal Perception:\n"+
                       "You Perceived : "+intToStringAnimalTestConv(
                                                bothTestChoices[1][0])+"\n"+
                       "The animal was : "+intToStringAnimalTestConv(
                                                bothTestChoices[0][0])+"\n"+
                       "A bit off on this one!\n\n";
                    
                    String actionTestResultMsg ="Action Perception:\n"+
                        "You Perceived : "+intToStringActionTestConv(
                                                bothTestChoices[1][1])+"\n"+
                        "The action was : "+intToStringActionTestConv(
                                                bothTestChoices[0][1])+"\n"+
                        "A bit off on this one!\n\n";
                    
                    JOptionPane.showMessageDialog(null,
                        animalTestResultMsg+actionTestResultMsg,
                        "Results:",1,
                        randomIconGenerator(bothTestChoices[0][0],
                                                bothTestChoices[0][1]));  
                }
                boolean repeatAgain = backDoorBreakBothTest(loopCounter,
                                            animalScore,actionScore,bothScore);
                if (!repeatAgain)
                {
                    break;
                }
            
                loopCounter++;
            }
        }
       
        ImageIcon endIcon = new ImageIcon("images\\endIcon.png");
        String endMsg = "<html>Thanks for Playing<br><h2>Program Termina"+
                "ting!</h2></html>";
        JOptionPane.showMessageDialog(null, 
        endMsg, 
        "Program Terminating!"
                , 0,endIcon);
        
    }
    
    public static int randomNumberGenerator(int upperLimitNumber) 
    {
        Random rangen = new Random();
        return rangen.nextInt(upperLimitNumber);
    }
    
    public static ImageIcon randomIconGenerator(int ranNum1,int ranNum2)
    {
        String[] animalStringArray = {"Cow","Dog","Monkey","Cat","Donkey"};
        String[] actionStringArray = {"Eating","Sleeping","Walking","Drinking",
                                      "Dancing"};     
        String randomImage = "images\\"+animalStringArray[ranNum1]+"and"+
                             actionStringArray[ranNum2]+".png";
        ImageIcon randomIcon = new ImageIcon(randomImage);
        
        return randomIcon;
    }
   
    public static int[] animalPreceptionTest()
    {
        int randomAnimalInt =randomNumberGenerator(5);
        String msgAnimalTest ="An animal has been generated. \nWhat "
                                       + "animal would you like to perceive?";
        
        String[] animalStringArray = {"Cow","Dog","Monkey","Cat","Donkey"};
        
        ImageIcon guessIcon = new ImageIcon("Images\\guessIcon.png");
        
        int userAnimalChoice = JOptionPane.showOptionDialog(null,
            msgAnimalTest, 
            "Choose one option", 
            0, 0,guessIcon,
            animalStringArray, animalStringArray[4]);       
        int[] choiceAnimalTest = {randomAnimalInt,userAnimalChoice};
            
        return choiceAnimalTest ;
    }
    
    public static int[] actionPreceptionTest()
    {
        int randomActionInt =randomNumberGenerator(5);
        
        String messageActionPreception ="An action has been generated. \nWhat "
                                       + "type of action would you like to"
                                       + " perceive?";
        
        String[] actionStringArray = {"Eating","Sleeping","Walking","Drinking",
                                   "Dancing"};  
        
        ImageIcon guessIcon = new ImageIcon("Images\\guessIcon.png");
        
        int userActionChoice = JOptionPane.showOptionDialog(null,
            messageActionPreception, 
            "Choose one option", 
            0, 0,guessIcon ,
            actionStringArray, actionStringArray[4]);
        
        int[] choiceActionTest = {randomActionInt,userActionChoice};
        
        return choiceActionTest;
    }
    
    public static int[][] bothPreceptionTest()
    {
        int randomAnimalInt =randomNumberGenerator(5);
        int randomActionInt =randomNumberGenerator(5);
        
        String[] animalStringArray = {"Cow","Dog","Monkey","Cat","Donkey"};
        String[] actionStringArray = {"Eating","Sleeping","Walking","Drinking",
                                   "Dancing"};  
        
        ImageIcon guessIcon = new ImageIcon("Images\\guessIcon.png"); 
        
        int userAnimalChoice = JOptionPane.showOptionDialog(null,
                "An animal has been generated.\nWhat animal would you like to"
              + " perceive?", 
            "Choose one option", 
            0, 0,guessIcon ,
            animalStringArray, animalStringArray[4]);
        
        int userActionChoice = JOptionPane.showOptionDialog(null,
                "An action has been generated for the animal. \nWhat type of"
              + " action would you like to perceive?", 
            "Choose one option", 
            0, 0,guessIcon,
            actionStringArray, actionStringArray[4]);
        
        int[][] bothTestChoice ={{randomAnimalInt,randomActionInt},
                                   {userAnimalChoice,userActionChoice}};
        return bothTestChoice;
    }
    
    public static String intToStringAnimalTestConv(int number)
    {
        String[] animalStringArray = {"Cow","Dog","Monkey","Cat","Donkey"};
        return animalStringArray[number];
    }
    
    public static String intToStringActionTestConv(int number)
    {
        String[] actionStringArray = {"Eating","Sleeping","Walking","Drinking",
                                      "Dancing"};  
        return actionStringArray[number];
    }
    
    public static boolean backDoorBreakAnimalTest(int loopCounter,
                                                  int animalScore)
    {
        if ((loopCounter%5)==0)
        {   
            String message = "You have entered "+(loopCounter)+" perceptions"
                           + "\nYour Animal score is: "+animalScore;
            
            String[] playAgnChoices={"Quit","Another 5 trials"};
            
            ImageIcon playAgnIcon = new ImageIcon("images//resultsSoFar"
                                     + "Icon.png");
            
            int playAgnIndex= JOptionPane.showOptionDialog(null,
                     message, "Results so Far!", 
                    1, 1, playAgnIcon, 
                     playAgnChoices,playAgnChoices[0]);
                    
            return (playAgnIndex != 0);
        }
        else
        {
          return true;
        }
    }
   
    public static boolean backDoorBreakActionTest(int loopCounter,
                                                  int actionScore)
    {
        if ((loopCounter%5)==0)
        { 
            String message = "You have entered "+(loopCounter)+" perceptions"
                           + "\nYour Action  score is: "+actionScore;
            
            String[] playAgnChoices={"Quit","Another 5 trials"};
            
            ImageIcon playAgnIcon = new ImageIcon("images//resultsSoFar"
                                  + "Icon.png");
            
            int playAgnIndex= JOptionPane.showOptionDialog(null,
                     message, "Results so Far!", 
                    1, 1, playAgnIcon, 
                     playAgnChoices,playAgnChoices[0]);
                    
            return (playAgnIndex != 0);
        }
        else
        {
          return true;
        }
    }
    
    public static boolean backDoorBreakBothTest(int loopCounter,int animalScore
                                                ,int actionScore,int bothScore)
    {
        if ((loopCounter%5)==0)
        {
            String message = "You have entered "+(loopCounter)+" perceptions"
                         + "\nYour Animal score is: "+animalScore+
                         "\nYour Action  score is: "+actionScore+"\nYou got bo"
                       +"th correct "+bothScore+" times";
            
            String[] playAgnChoices={"Quit","Another 5 trials"};
            
            ImageIcon playAgnIcon = new ImageIcon("images//resultsSoFar"
                                  + "Icon.png");
            
            int playAgnIndex= JOptionPane.showOptionDialog(null,
                     message, "Results so Far!", 
                    1, 1, playAgnIcon, 
                     playAgnChoices,playAgnChoices[0]);
            
            return playAgnIndex != 0;
        }
        else
        {
          return true;
        }
    }   
}
