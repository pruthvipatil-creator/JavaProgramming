import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);
Random random = new Random();

char playAgain = 'y';

while (playAgain == 'y' || playAgain == 'Y') 
{
int secretNumber = random.nextInt(100) + 1;

Boolean guessedCorrectly = false;

System.out.println("\nI'm thinking of a number between 1 and 100.");
System.out.println("You have & tries.");

for (int attempt = 1; attempt <= 7; attempt++) {

System.out.print("Attempt " + attempt + " : ");
int guess = sc.nextInt();

if (guess > secretNumber) {
System.out.println("Too High");

if (guess - secretNumber <= 5) {
System.out.println("Close!");
}
else {
System.out.println("Not even close");
}

}
else if (guess < secretNumber) {
System.out.println("Too Low");

if (secretNumber - guess <= 5)  {
System.out.println("Close!");
} else {
System.out.println("Not even close");
} 

} else {
System.out.println("Correct!");
System.out.println("You guessed it in " + attempt + "attempts.");

guessedCorrectly = true;
break;
}
}

if(!guessedCorrectly) 
{
System.out.println("The correct number was: " + secretNumber);
System.out.println("Game Over");
}

System.out.print("Play again? (y/n): ");
playAgain = sc.next().charAt(0);
}
System.out.println("Thanks for playing!");

sc.close();
}
}
