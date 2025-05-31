package sem2Project.Payment;
import java.util.*;

public class Payment {

    public static void Payment() {
        Scanner sc = new Scanner(System.in);
        String input;

        // take input //
        do {
            System.out.print("Enter Card Number: ");
            input = sc.nextLine();
        } while (input.length() < 1);

        String originalInput = input;
        int firstSum = 0, secondSum = 0, sum = 0;
        int n = 1;

        
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            int remainder = c - '0';

            if (n % 2 == 0) {
                int doubled = remainder * 2;
                if (doubled < 10) {
                    firstSum += doubled;
                } else {
                    firstSum += (doubled % 10) + (doubled / 10); 
                }
            } else {
                secondSum += remainder;
            }
            n++;
        }

        sum = firstSum + secondSum;

        
        if (sum % 10 != 0) {
            System.out.println("INVALID Card We only accept American Express, Mastercard or VISA!");
            return;
        }

        // lenth of input //
        int length = input.length();

        int startingDigits = Integer.parseInt(input.substring(0, Math.min(2, length)));

        // finding card types
        if ((startingDigits == 34 || startingDigits == 37) && length == 15) {
            System.out.println("AMEX Card Accepted");
        } else if ((startingDigits >= 51 && startingDigits <= 55) && length == 16) {
            System.out.println("MASTERCARD Card Accepted");
        } else if ((startingDigits / 10 == 4) && (length == 13 || length == 16)) {
            System.out.println("VISA Card Accepted");
        } else {
            System.out.println("INVALID Card\nWe only accept American Express, Mastercard or VISA!");
        }
    }
}
