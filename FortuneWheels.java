package com.company;
import java.util.Scanner;

public class FortuneWheels {

    private String phrase;
    private String guessedLetter;

    public FortuneWheels(String sentence) {
        phrase = sentence;
        guessedLetter = "";
    }

    public void displayPhrase() {

        String tempPhrase = "";
        for(int i = 0; i < phrase.length(); i++) {
            String letterToCheck = phrase.substring(i, i + 1);

            if(letterToCheck.equals(" ")) {
                tempPhrase += " ";
            }
            else if(guessedLetter.indexOf(letterToCheck) != -1) {
                tempPhrase += letterToCheck;
            }
            else {
                tempPhrase += "*";
            }
        }
        System.out.println(tempPhrase);
    }

    public void guessLetter(String guess){
        guessedLetter += guess;
        displayPhrase();
    }

    public static void main(String[] args) {

        String answer = "mathematics";
        Scanner userInput = new Scanner(System.in);
        FortuneWheels game = new FortuneWheels(answer);
        game.displayPhrase();

        String userGuess = "";
        int i = 0;

        while(!userGuess.equals("stop")) {
            System.out.println("Please enter a single letter or guess the full word: ");
            userGuess = userInput.nextLine();
            i++;

                if(answer.equals(userGuess)) {
                    System.out.println("Congrats you won!");
                    break;
                }
                else if(i == 6) {
                    System.out.println("This is your last attempt!");
                    game.guessLetter(userGuess);
                }
                else if(i == 7) {
                    System.out.println("Oh no! You Lose!");
                    System.out.println(answer);
                    break;
                }
                else {
                    System.out.println("You have " + (7 - i) + " attempts remaining!");
                    game.guessLetter(userGuess);
                }
        }
        System.out.println("Thanks for playing!");
    }
}
