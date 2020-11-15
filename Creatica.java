import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;

public class Creatica
{
    static int karmaCount = 0; //Counter to indicate the reaction of the cat dialogue
    static String catName;
    static String userName;

    public static void main(String[] args)
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.WHITE);
        UI.put("Panel.background", Color.WHITE);
        ImageIcon hehe = new ImageIcon(Creatica.class.getResource("defaultNeutral.png"));
        JLabel icon = new JLabel(hehe);
        panel.add(icon,BorderLayout.CENTER);

        //title text code
        JLabel titleTxt = new JLabel("BOMBAY!");
        titleTxt.setFont(new Font("Century Gothic", Font.PLAIN, 100));
        titleTxt.setHorizontalAlignment(JLabel.CENTER);
        titleTxt.setVerticalAlignment(JLabel.CENTER);
        panel.add(titleTxt,BorderLayout.NORTH);
        //panel.add()
        //subtitle text code
        JLabel subTxt = new JLabel("By: Afshana, Penelope, and Jacinda");
        subTxt.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        subTxt.setHorizontalAlignment(JLabel.CENTER);
        subTxt.setVerticalAlignment(JLabel.CENTER);
        panel.add(subTxt,BorderLayout.SOUTH);
        JOptionPane.showMessageDialog(null,panel,"Welcome to our game!",JOptionPane.PLAIN_MESSAGE);


        //Number of dialogues
        int numDia = 5;

        //Creating an array of questions, and inputting the questions
        JLabel[] q = new JLabel[numDia];
        q[0] = new JLabel("How do you feel about cats?");
        q[1] = new JLabel("What about black cats?");
        q[2] = new JLabel("What would you like to do?");
        q[3] = new JLabel("You don’t mind if I ask for some food… do you?");
        q[4] = new JLabel("I've been rambling on forever... do you have anything to ask me?");

        //Creating an array of pictures, and inputting the pictures
        ImageIcon[] p = new ImageIcon[numDia];
        p[0] = new ImageIcon(Creatica.class.getResource("blankNeutral.png"));
        p[1] = new ImageIcon(Creatica.class.getResource("defaultNeutral.png"));
        p[2] = new ImageIcon(Creatica.class.getResource("defaultNeutral.png"));
        p[3] = new ImageIcon(Creatica.class.getResource("defaultNeutral.png"));
        p[4] = new ImageIcon(Creatica.class.getResource("defaultNeutral.png"));


        //2D array of options (rows = represents new set of options) (col = each individual option)
        String[][] o = new String[numDia][3];

        //First set of options
        o[0][0] = "They're so cute!";
        o[0][1] = "I don’t have an opinion.";
        o[0][2] = "I hate them.";

        //Second set of options
        o[1][0] = "I love them!";
        o[1][1] = "I don’t really care.";
        o[1][2] = "They’re evil!";

        //Third set of options
        o[2][0] = "Play with the cat!";
        o[2][1] = "Check your phone.";
        o[2][2] = "Shoo the cat away.";

        //Fourth set of options
        o[3][0] = "Here’s some delicious cat food!";
        o[3][1] = "You can have some of my leftovers.";
        o[3][2] = "Then go outside and hunt.";

        //Fifth set of options
        o[4][0] = "How old are you?";
        o[4][1] = "Where are you from?";
        o[4][2] = "How can you even talk?";

        System.out.println(karmaCount);
        //loops through the dialogue options
        for(int i=0; i<numDia; i++)
        {
            int c = displayChoices(q[i],p[i],o[i]);
            if(i==1) //displays a message after second dialogue
            {
                if(karmaCount>0) //positive
                {
                    displayDialog("Lucky for you, you get your very own black cat.", "defaultHappy.png");
                    displayDialog("\"Hey, I’m your new cat! What’s my name?\"", "defaultHappy.png");
                    catName = displayInput(new JLabel("What do you want to name your new cat?"), new ImageIcon("defaultHappy.png"));
                    displayDialog("\""+catName+"... I love that name!\"", "defaultHappy.png");
                    userName = displayInput(new JLabel("\"What's your name?\""), new ImageIcon("defaultHappy.png"));
                    displayDialog("\"I love the name " + userName + "! It’s pretty, just like you.\"", "defaultHappy.png");
                    displayDialog("\"" + userName + ", thank you for being so sweet. Black cats like me are always treated awfully.\"", "defaultHappy.png");
                }
                else if(karmaCount==0) //neutral
                {
                    displayDialog("Well, I know you don’t really care, but you own a black cat now.", "defaultNeutral.png");
                    displayDialog("\"Hi… Can you name me?\"", "defaultNeutral.png");
                    catName = displayInput(new JLabel("What do you want to name your new cat?"), new ImageIcon("defaultNeutral.png"));
                    displayDialog("\""+catName+"... Not bad.\"", "defaultNeutral.png");
                    userName = displayInput(new JLabel("\"What's your name?\""), new ImageIcon("defaultNeutral.png"));
                    displayDialog("\""+userName+"... That sure is a name.\"", "defaultNeutral.png");
                    displayDialog("\"You're alright, " + userName + ". Not too nice, but not too mean.\"", "defaultNeutral.png");
                }
                else //negative
                {
                    displayDialog("Too bad, you now own a black cat.", "defaultAngry.png");
                    displayDialog("\"I’m not fond of you either, but I still need a name.\"", "defaultAngry.png");
                    catName = displayInput(new JLabel("What do you want to name your new cat?"), new ImageIcon("defaultAngry.png"));
                    displayDialog("\""+catName+"... Whatever.\"", "defaultAngry.png");
                    userName = displayInput(new JLabel("\"What's your name?\""), new ImageIcon("defaultAngry.png"));
                    displayDialog("\""+userName+". Uh, okay.\"", "defaultAngry.png");
                    displayDialog("\"You know, "+userName+", you should be nicer to black cats like myself.", "defaultAngry.png");
                    displayDialog("\"We’ve been through a lot.\"", "defaultAngry.png");
                }
                displayDialog("\"Did you know that some shelters don’t accept black cats during October?\"", "sideAngry.png");
                displayDialog("\"They think we’re bad luck, even though we just want to be cuddled and loved.\"", "sideSad.png"); //sad
                displayDialog("\"Some people are evil and abuse us during Halloween!\"", "sideAngry.png");
                displayDialog("\"I’m sure I’m being annoying… Let me stop.\"", "sideSad.png"); //sad cat
            }
            else if(i==2) //after third choice
            {
                if(c==0)
                {
                    displayDialog("\"Yay!!!\"", "stretchHappy.png"); //prancing happy
                    displayDialog("\"Wow, that made me hungry!\"", "standHappy.png");

                }
                else if(c==1)
                {
                    displayDialog("\"Oh, okay then.\"", "stretchNeutral.png");
                    displayDialog("\"Guess I'll nap.\"", "sleep.png");
                    displayDialog("\"Zzz...\"", "sleep.png");
                    displayDialog("\"Hmm... still doing nothing?\"", "stretchNeutral.png");
                    displayDialog("\"Anyways, I’m kind of hungry.\"", "standNeutral.png");
                }
                else
                {
                    displayDialog("\"Grrrr!\"", "stretchAngry.png");
                    displayDialog("\"Not sure if you care, but I’m kind of hungry.\"", "standAngry.png");
                }
            }
            else if(i==3)
            {
                if(c==0) //positive
                {
                    displayDialog("\"Really? Thank you, thank you, thank you!\"", "stretchHappy.png");
                    displayDialog("\"Om nom nom nom...!\"", "standHappy.png");
                    displayDialog("\"...\"", "fatty.png");
                    displayDialog("\"Oh no! I'm fat!\"", "fatty.png");
                    displayDialog("\"Hmm!\"", "standNeutral.png");
                    displayDialog("\"That was weird!\"", "standHappy.png");
                    displayDialog("\"Now I'm gonna nap it off.\"", "sleep.png");
                }
                else if(c==1) //neutral
                {
                    displayDialog("\"Thank you.\"", "defaultNeutral.png");
                }
                else
                {
                    displayDialog("\"Whatever, I'll get it myself.\"", "defaultAngry.png");
                    displayDialog("\"Like I always do...\"", "defaultSad.png"); //sad
                }
            }
            if(i==4)
            {
                if(c==0) //how old are you
                {
                    karmaCount--; //subtracts bc it added earlier
                    if(karmaCount>0) //positive
                    {
                        displayDialog("\"I'm a million years old!\"", "defaultHappy.png");
                        displayDialog("\"In fact, I'm on my ninth life right now.\"", "defaultHappy.png");
                    }
                    else if(karmaCount==0) //neutral
                    {
                        displayDialog("\"I'm old, that's all you need to know.\"", "defaultNeutral.png");
                    }
                    else
                    {
                        displayDialog("\"Why do you even care?\"", "defaultAngry.png");
                    }
                }
                else if(c==1) //where did you come from
                {
                    if(karmaCount>0) //positive
                    {
                        displayDialog("\"I don't remember where I'm from...\"", "defaultNeutral.png");
                        displayDialog("\"I've never had a home.\"", "defaultSad.png"); //sad
                        displayDialog("\"Until now!\"", "defaultHappy.png");
                    }
                    else if(karmaCount==0) //neutral
                    {
                        displayDialog("\"You wouldn't know the place.\"", "defaultNeutral.png");
                    }
                    else
                    {
                        displayDialog("\"Why do you even care?\"", "defaultAngry.png");
                    }
                }
                else //how can you even talk
                {
                    karmaCount++; //add to cancel out the subtraction
                    if(karmaCount>0) //positive
                    {
                        displayDialog("\"I don't know...\"", "defaultHappy.png");
                        displayDialog("\"But I'm happy to talk to you!\"", "stretchHappy.png");
                    }
                    else if(karmaCount==0) //neutral
                    {
                        displayDialog("\"I just can.\"", "stretchNeutral.png");
                        displayDialog("\"I don't go around asking why you can talk.\"", "stretchAngry.png");
                    }
                    else
                    {
                        displayDialog("\"Why do you even care?\"", "sideAngry.png");
                    }
                }
            }
        }
        System.out.println(karmaCount);

        //Ending scenes:
        if(karmaCount==4) //maxed out karma
        {
            displayDialog("\"You know, you're the best human I've ever met!\"", "defaultHappy.png");
            displayDialog("\"No one has ever been as nice as you.\"", "standHappy.png");
            displayDialog("\"I love you so much, "+userName+"!\"", "stretchHappy.png");
        }
        else if(karmaCount>0) //not maxed out but still positive
        {
            displayDialog("\"Spending time with you has been fun!\"", "defaultHappy.png");
            displayDialog("\"I really enjoyed getting to know you.\"", "standNeutral.png");
            displayDialog("\"We're going to have lots of fun together, "+userName+".\"", "stretchHappy.png");
        }
        else if(karmaCount==0) //neutral
        {
            displayDialog("\"I'm not gonna lie...\"", "defaultNeutral.png");
            displayDialog("\"I don't love you, but I also don't hate you.\"", "standNeutral.png");
            displayDialog("\"I feel like we would both do better with other people though.\"", "standNeutral.png");
            displayDialog("\"It was nice meeting you, "+userName+". I hope we keep in touch.\"", "stretchNeutral.png");
        }
        else if(karmaCount>-4) //not min but still negative
        {
            displayDialog("\"I was hoping we could get along better, but I guess not.\"", "defaultAngry.png");
            displayDialog("\"There was no reason to be so mean!\"", "defaultSad.png"); //sad
            displayDialog("\"I guess I'll be the bigger person, even though I'm a cat.\"", "sideSad.png"); //sad
            displayDialog("\"I'll leave you alone, "+userName+". See you never.\"", "sideAngry.png");
        }
        else //minimum points
        {
            displayDialog("\"Words can’t even begin to describe the amount of hatred I feel for you.\"", "sideangry.png");
            displayDialog("\"You have not once shown me any type of love this entire time.\"", "defaultAngry.png");
            displayDialog("\"You should be ashamed of yourself!\"", "stretchAngry.png");
            displayDialog("\"Usually I'd leave...\"", "standAngry.png");
            displayDialog("\"But I'd rather be annoying.\"", "standAngry.png");
            displayDialog("\"You'll never get rid of me.  \"", "stretchAngry.png");
        }
    }

    public static String displayInput(JLabel q, ImageIcon p)
    {
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        jp.setBackground(Color.WHITE);
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.WHITE);
        UI.put("Panel.background", Color.WHITE);
        jp.add(q,BorderLayout.CENTER);
        q.setFont(new Font("Century Gothic", Font.PLAIN, 30));
        String x = JOptionPane.showInputDialog(null, q, "Bombay", 0);
        return x;
    }

    //display msg
    public static void displayDialog(String str, String str2)
    {
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        jp.setBackground(Color.WHITE);
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.WHITE);
        UI.put("Panel.background", Color.WHITE);
        //jp.add(q,BorderLayout.NORTH);
        
        //NEW CODE
        ImageIcon hehe = new ImageIcon(Creatica.class.getResource(str2));
        JLabel icon = new JLabel(hehe);
        JLabel txt = new JLabel(str);
        jp.add(icon, BorderLayout.CENTER);
        jp.add(txt,BorderLayout.NORTH);
        txt.setFont(new Font("Century Gothic", Font.PLAIN, 30));
        JOptionPane.showMessageDialog(null, txt, "Bombay", 0, hehe);
    }

    //display options
    public static int displayChoices(JLabel q, ImageIcon p, String[] o)
    {
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        jp.setBackground(Color.WHITE);
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.WHITE);
        UI.put("Panel.background", Color.WHITE);
        jp.add(q,BorderLayout.CENTER);
        q.setFont(new Font("Century Gothic", Font.PLAIN, 30));
        int c = JOptionPane.showOptionDialog(null, jp, "Bombay", 0, 0, p, o, null);
        karmaCalc(c); //checks karma count
        return c;
    }

    //Karma calculator
    public static void karmaCalc(int c)
    {
        if(c==0)
            karmaCount++; //add if first choice (positive)
        else if(c==2)
            karmaCount--; //add if second choice (negative)
    }


}