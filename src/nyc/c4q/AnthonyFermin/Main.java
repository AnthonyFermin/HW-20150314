package nyc.c4q.AnthonyFermin;

import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main {

    //checks current date and returns it in String format ex: January 1, 2015
    public static String getDate(){
        String longDateFormat = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        String numberDate = dateFormat.format(date);

        if(numberDate.charAt(5) == '0' && numberDate.charAt(6) == '1' )
            longDateFormat += "January ";
        else if(numberDate.charAt(5) == '0' && numberDate.charAt(6) == '2' )
            longDateFormat += "February ";
        else if(numberDate.charAt(5) == '0' && numberDate.charAt(6) == '3' )
            longDateFormat += "March ";
        else if(numberDate.charAt(5) == '0' && numberDate.charAt(6) == '4' )
            longDateFormat += "April ";
        else if(numberDate.charAt(5) == '0' && numberDate.charAt(6) == '5' )
            longDateFormat += "May ";
        else if(numberDate.charAt(5) == '0' && numberDate.charAt(6) == '6' )
            longDateFormat += "June ";
        else if(numberDate.charAt(5) == '0' && numberDate.charAt(6) == '7' )
            longDateFormat += "July ";
        else if(numberDate.charAt(5) == '0' && numberDate.charAt(6) == '8' )
            longDateFormat += "August ";
        else if(numberDate.charAt(5) == '0' && numberDate.charAt(6) == '9' )
            longDateFormat += "September ";
        else if(numberDate.charAt(5) == '1' && numberDate.charAt(6) == '0' )
            longDateFormat += "October ";
        else if(numberDate.charAt(5) == '1' && numberDate.charAt(6) == '1' )
            longDateFormat += "November ";
        else if(numberDate.charAt(5) == '1' && numberDate.charAt(6) == '2' )
            longDateFormat += "December ";

        if(numberDate.charAt(8) != '0')
            longDateFormat += numberDate.charAt(8);

        longDateFormat += numberDate.charAt(9) + ", ";
        longDateFormat += numberDate.charAt(0);
        longDateFormat += numberDate.charAt(1);
        longDateFormat += numberDate.charAt(2);
        longDateFormat += numberDate.charAt(3);

        return longDateFormat;
    }

    //method for pausing the program for a certain amount
    public static void sleepTimer(int sleepTime){
        try {
            Thread.sleep(sleepTime);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

    //method for print a select number of spaces
    public static void printSpaces(int numOfSpaces){
        for(int i = 0; i < numOfSpaces; i++){
            System.out.print(" ");
        }
    }

    //takes a string as a parameter and outputs it slowly character by character
    public static void slowPrintString(String text){
        int pauseTime = 20;

        for(int i = 0; i < text.length(); i++){

            System.out.print(text.charAt(i));
            if(i % 8 == 0){
                pauseTime = pauseTime * 2;
            }
            else{
                pauseTime = 20;
            }
            sleepTimer(pauseTime);

        }

    }

    //takes a string as a parameter and outputs it slowly character by character
    //also takes in an int that determines speed of printing
    public static void slowPrintString(String text, int pauseTimeMS){

        int pauseTime = pauseTimeMS;

        for(int i = 0; i < text.length(); i++){

            System.out.print(text.charAt(i));
            if(i % 8 == 0){
                pauseTime = pauseTime * 2;
            }
            else{
                pauseTime = pauseTimeMS;
            }
            sleepTimer(pauseTime);

        }
    }

    //MAIN GAME
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String response = "";
        boolean checkResponse = true;
        boolean stillPlaying = true;

        //Welcome to DREAM STATE!
        char[] animationChars = new char[]{'_', '.', '-', '+', '^', '`', '°', '*', '~', '_'};

        //prints out top border
        for (int i = 0; i < 120; i++) {
            if (i % 60 == 0) {
                System.out.println();
            }
            System.out.print(animationChars[i % 10] + " ");

            //puts the program to sleep for 100 ms!
            sleepTimer(50);
        }
        //prints out side borders and welcome message
        for (int i = 0; i < 6; i++) {
            System.out.println();
            System.out.print("_");
            if (i == 3) {
                printSpaces(48);
                slowPrintString("WELCOME TO DREAM STATE");
                printSpaces(47);
            } else {
                printSpaces(117);
            }
            System.out.print("_");

            sleepTimer(80);
        }

        //prints out bottom border
        for (int i = 0; i < 120; i++) {
            if (i % 60 == 0) {
                System.out.println();
            }
            System.out.print(animationChars[i % 10] + " ");
            sleepTimer(20);
        }
        sleepTimer(2000);
        slowPrintString("\n\n\n\n\n\n\n\n\n\n\n\n", 100);

        //Main Game Loop - always runs it at least once then repeats game if boolean "stillPlaying" is true
        do{
            /*Game Intro*/
            slowPrintString("It is " + getDate() + " and you're working a double at the Post Office...\n\n" +
                    "Paul: Hey newbie, how was your first week at work?........... Don't answer that, I already know it was hectic... always is! \n" +
                    "um...., sorry I'm bad with names. What was your name again?\n\nYou: ");

            String playerName = input.nextLine();

            slowPrintString("\nPaul: Right, right. " + playerName +
                    ", I won't forget! Now get back to work!! There's no way you're getting paid if you just sit around!\n\n");

            slowPrintString("NARRATOR: You walk back to your station in a room full of sorters and continue to move envelopes into their designated bins which feed into conveyor belts.\n" +
                    "Hours pass and the monotony of your day isn't getting any better. While working on the seemingly endless heap of envelopes,\n" +
                    "you realize that there's a red envelope on the floor. You reach over and grab the envelope and through the constant stream of \n" +
                    "sorting sounds and fidgeting paper, you hear a \"PSSSST\"\n\n" +

                    "NARRATOR: You look around... no one else seemed to notice the sound. You hear another \"PSSSST\" coming from the utility closet... What do you do???\n" +
                    "[Ignore] [Tell Security] [Investigate]\n\n ");

            //prompts user for response and checks if its correct.
            do {

                if (response.equalsIgnoreCase("Investigate")) {
                    slowPrintString("NARRATOR: You slowly open the door to the dark utility closet. You look inside and think \"Wow, this is a spacious utility closet\".\n" +
                            "Then you hear breathing... \n\n");
                    checkResponse = true;
                    break;
                } else if (response.equalsIgnoreCase("Ignore")) {
                    slowPrintString("NARRATOR: You ignore the mystery \"PSSSST\" and continue about your business. When you finish your long shift\n" +
                            "you gather your things and go home. You enter your home and look at the couch.\n");
                    checkResponse = false;
                } else if (response.equalsIgnoreCase("Tell Security")) {
                    slowPrintString("NARRATOR: You go directly to security and are about to tell the man at the counter about the strange \"PSSSST\" you keep hearing\n" +
                            "You then realize that you sound ridiculous and decide to ignore the mystery \"PSSSST\" and continue about your business.\n" +
                            "When you finish your long shift, you gather your things and go home. You enter your home and look at the couch.\n \n");
                    checkResponse = false;
                } else {
                    System.err.println("NARRATOR: Please Enter a valid response!! \n\n [Ignore] [Tell Security] [Investigate]\n");
                    checkResponse = true;
                    response = input.nextLine();
                }
            } while (checkResponse);

            //if user selected investigate response, then continues here
            if (checkResponse) {
                slowPrintString("NARRATOR: The breathing gets louder.... then louder\n");
                slowPrintString("Then it gets closer and closer!!! ",80);
                slowPrintString("*COUGH COUGH COUGH*\n");
                slowPrintString("A small man in a black trench coat and sun glasses appears from the shadows and introduces himself\n\n");
                slowPrintString("Rodrick: Hello " + playerName + ", I've been expecting you.... my name  is......Rodrick!\n\n" +
                        "Rodrick: I'm here to offer you a drink. Choose the blue solo cup if you just want to go back to your boring life....\n" +
                        "but choose the red solo cup, and you'll learn the TRUTH of it all.... MUAHAHHahahahahHAHAHa *cough*.... now choose...\n\n");
                slowPrintString("NARRATOR: He holds up a cup in each hand expecting you to choose one. [red] [blue]\n\n");
                response = input.nextLine();
                if(response.equalsIgnoreCase("red")){
                    slowPrintString("NARRATOR: You go for the red cup! Rodrick giggles with excitement as you chug the contents of the cup.\n\n" +
                            "NARRATOR: You then look at Rodrick when your vision suddenly begins to fade into black..............................\n" +
                            "moments later, your vision comes back and you're on your couch....you think to yourself \"Was that a dream?\"\n\n");
                }else if(response.equalsIgnoreCase("blue")){
                    slowPrintString("NARRATOR: You grab the blue solo cup and get ready to drink it.........\n" +
                            "As Rodrick slaps the cup out of your hand he says...\n\n" +
                            "Rodrick: You're no fun! That one's just water ya lunatic!\n\n" +
                            "NARRATOR: He disappears into the shadows never to be heard from again. The little excitement you just had was the pinnacle\n" +
                            "of excitement for your entire life.... and probably the rest of your life. You finish your shift then head home.\n\n");
                }else{
                    slowPrintString("Rodrick: Bahhhh, don't you speak english? Nevermind......\n\n " +
                            "NARRATOR: Disappears into the shadows and you shrug it off. When you're done with your shift you head home for a well deserved nap\n\n");
                }

            }

            //end of game

            String enterDreamState = "After a long day at work, you have no choice but to collapse onto your couch and doze off into the eternal night";
            slowPrintString(enterDreamState);
            slowPrintString(".........\n\n", 400);
            slowPrintString("GAME OVER.............");
            System.out.println("\n\n\n");

            //a do/while loop that asks if the user wants to play again and updates the "stillPlaying" boolean accordingly
            do {
                slowPrintString("Do you want to play again? [yes or no?]\n");
                response = input.nextLine();
                if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y") || response.equalsIgnoreCase("ya")) {
                    stillPlaying = true;
                    checkResponse = false;
                } else if (response.equalsIgnoreCase("no") || response.equalsIgnoreCase("n") || response.equalsIgnoreCase("nah")) {
                    stillPlaying = false;
                    checkResponse = false;
                } else {
                    System.err.println("NARRATOR: Speak English please....\n");
                }
            } while (checkResponse);

        }while(stillPlaying);

        //Good bye message
        slowPrintString("\n\nNARRATOR: Good Bye!!!");

    }
}