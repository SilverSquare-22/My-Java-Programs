import java.util.Scanner;
public class Number_Guessing_Game {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game (Java Edition)! Follow these instructions to play:");
        System.out.println();
        System.out.println("1. Java will generate a random number which is to be guessed by you.");
        System.out.println("2. Hints will be provided to you each time you make your guess.");
        System.out.println("3. If you want to quit the game, you can do so by typing -1.");
        System.out.println();
        System.out.println("Have fun!");
        System.out.println();
        int n = (int)(Math.random() * 100);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your guess (between 1 & 100): ");
        int m = sc.nextInt();
        do {
            if (m > 0) {
                if (m > n) {
                    if (m - n <= 5) {
                        System.out.println("You are closer to that number!");
                    }
                    else {
                        System.out.println("You number is greater.");
                    }
                }
                if (m < n) {
                    if (m - n >= -5) {
                        System.out.println("You are closer to that number!");
                    }
                    else {
                        System.out.println("Your number is smaller.");
                    }
                }
                System.out.println();
                System.out.print("Enter another guess (between 1 & 100): ");
                m = sc.nextInt();
            }
            if (m == -1) {
                System.out.print("The number was: ");
                System.out.println(n);
                break;
            }
        } while (m != n);
        if (m != -1) {
            System.out.println("Congrats! You guessed the correct number.");
        }
    }
}