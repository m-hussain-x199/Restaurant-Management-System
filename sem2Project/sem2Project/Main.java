package sem2Project;

import GetOrder.GetOrder;
import sem2Project.Menu.Menu;
import sem2Project.TableAssignment.TableAssignment;
import java.util.*;

import sem2Project.CalculatePrice.CalculatePrice;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to our Resturant.....\nSelect an option\n1. Dine In\n2. Take away\n");
        int choice1, totalMenuItems, order[];
        float price;
        choice1 = sc.nextInt();
        // Dine In //
        if (choice1 == 1) {
            int customerNumber = 1 + random.nextInt(49);
            System.out.print("Enter Number of Guest for table assignment: ");
            int numberOfGuests = sc.nextInt();

            if (TableAssignment.getTable(numberOfGuests, customerNumber) == 1) {
                System.exit(1);
            }

            System.out.println("\nSelect options\n1.Show Menu\n0.Exit");
            choice1 = sc.nextInt();
            if (choice1 == 1) {
                totalMenuItems = Menu.displayMenu();
                order = GetOrder.GetOrder(totalMenuItems);
                 price = CalculatePrice.CalculatePrice(order);
                System.out.println();
                for (int i = 0; i < order.length; i++) {
                    System.out.println(order[i]);
                }
            } else if (choice1 == 0) {
                System.exit(0);
            } else {
                System.out.println("Wrong Input...");
            }
            // Take Away //
        } else if (choice1 == 2) {
            totalMenuItems = Menu.displayMenu();
            order = GetOrder.GetOrder(totalMenuItems);
            System.out.println();
            for (int i = 0; i < order.length; i++) {
                System.out.println(order[i]);
            }
        } else {
            System.out.println("Wrong Choice");
            System.exit(1);
        }
    }
}
