// Guess.java
// Kevin Duong
// keduong
// Guess.java
// generates random # 1-10, user has 3 attempts to guess the value

import java.util.Scanner;
class Guess{

  public static void main (String[] args){
  
  int guessNumber;
  
  guessNumber = (int) Math.floor(Math.random() * 10)+1;
// System.out.println("Your random number is: " +guessNumber+".\n"); // debugging purposes
 
  Scanner scan = new Scanner(System.in);
  int guess, guess2, guess3; // Maximum of 3 trials, each guess assigned respectively
  
  System.out.println("I'm thinking of an integer in the range 1 to 10. You have three guesses.\n");
  System.out.print("Enter your first guess: ");
  guess = scan.nextInt();
  

  if (guess == guessNumber){ //used for guess trials
     System.out.println("You win!\n");
     System.exit(0);}
  else if (guess < guessNumber)
     System.out.println("Your guess is too low.\n");
  else if (guess > guessNumber)
     System.out.println("Your guess is too high.\n");
   
  if (guess != guessNumber)
     System.out.print("Enter your second guess: ");
     guess2 = scan.nextInt();
  
  if (guess2 == guessNumber){
     System.out.println("You win!\n");
     System.exit(0);}
  else if (guess2 < guessNumber)
     System.out.println("Your guess is too low.\n");
  else if (guess2 > guessNumber)
     System.out.println("Your guess is too high.\n");
   
  if (guess2 != guessNumber)
     System.out.print("Enter your third guess: ");
     guess3 = scan.nextInt();
 
  if (guess3 == guessNumber){
     System.out.println("You win!\n");
     System.exit(0);}
  else if (guess3 < guessNumber){
     System.out.println("Your guess is too low.\n");
     System.out.println("You lose. The number was " +guessNumber+ ".\n");
     }
  else if (guess3 > guessNumber){
     System.out.println("Your guess is too high.\n");
     System.out.println("You lose. The number was " +guessNumber+ ".\n");
     }  
  }
}

