import java.io.*;
import java.util.*;

public class GuessGame {    
    public static void main(String arg[]) {
        int randomNumber = (int)(Math.random() * 100) + 1;  
        Scanner sc = new Scanner(System.in);    

        int attempt = 0;  
        int guess = 0;   

        System.out.println("Enter your guess between 1 to 100):");
        guess = sc.nextInt();   

        while (guess != randomNumber) {
            if (guess > randomNumber) {
                System.out.println("Too high! Try again:");
            } else {
                System.out.println("Too low! Try again:");
            }
            attempt++;
            guess = sc.nextInt();   
        }

        attempt++;  
        System.out.println("Your guess is correct!!");
        System.out.println("You solved it in " + attempt + " attempts.");

        sc.close(); 
    }
}
