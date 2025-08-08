package BankingSystem;

import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankingClass banking = new BankingClass();

        System.out.println("HELLO WELCOME TO PAUL BANKING SYSTEM");
        System.out.println("What can I do for you today?");
        System.out.println("1. Banking");
        System.out.println("2. Doctor's Appointment");
        System.out.println("3. Shopping");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                int attempts = 0;
                boolean success = false;

                while (attempts < 3 && !success) {
                    System.out.print("\nEnter your Account No: ");
                    int accNo = sc.nextInt();

                    System.out.print("Enter your Pin: ");
                    int pin = sc.nextInt();

                    if (banking.verifyAccount(accNo, pin)) {
                        System.out.println("\nLOGIN SUCCESSFULLY! You are now logged in.");
                        success = true;
                    } else {
                        attempts++;
                        System.out.println("INVALID ACCOUNT or PIN! Attempt " + attempts + " of 3");
                    }
                }

                if (!success) {
                    System.out.println("\nAccount locked. Too many failed attempts.");
                }
                break;

            case 2:
                System.out.println("Doctor's Appointment feature coming soon.");
                break;

            case 3:
                System.out.println("Shopping feature coming soon.");
                break;

            default:
                System.out.println("Invalid Selection!");
        }

        sc.close();
    }
}
