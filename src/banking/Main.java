package banking;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int response;
        bankApp[] bapp = new bankApp[99];
        int registeredCount = 0;

        do {
            System.out.println("WELCOME TO MY SYSTEM!");
            System.out.println("What do you feel like doing today?");
            System.out.println("1. Banking");
            System.out.println("2. Shopping");
            System.out.println("3. Pay Bills");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.println("3. Exit");
                    System.out.print("Enter Action: ");
                    int action = sc.nextInt();

                    switch (action) {
                        case 1:
                            if (registeredCount >= bapp.length) {
                                System.out.println("Maximum accounts reached. Cannot register more.");
                                break;
                            }
                            bapp[registeredCount] = new bankApp();

                            System.out.print("Enter Account No.: ");
                            int newAccNo = sc.nextInt();
                            System.out.print("Enter Pin No.: ");
                            int newPin = sc.nextInt();

                            bapp[registeredCount].setAccNo(newAccNo);
                            bapp[registeredCount].setPin(newPin);
                            System.out.println("Registered Account No: " + bapp[registeredCount].getAccNo());

                            registeredCount++;
                            break;

                        case 2:
                            System.out.print("Enter Account No.: ");
                            int accn = sc.nextInt();
                            System.out.print("Enter Pin No.: ");
                            int pin = sc.nextInt();

                            int attempts = 3;
                            boolean loggedIn = false;

                            while (attempts > 0 && !loggedIn) {
                             
                                boolean found = false;
                                for (int i = 0; i < registeredCount; i++) {
                                    if (bapp[i].verifyAccount(accn, pin)) {
                                        found = true;
                                        break;
                                    }
                                }

                                if (found) {
                                    System.out.println("LOGIN SUCCESS!");
                                    loggedIn = true;
                                } else {
                                    attempts--;
                                    if (attempts == 0) {
                                        System.out.println("MAX ATTEMPT LIMIT REACHED!");
                                        System.exit(0);
                                    }
                                    System.out.println("Invalid account or PIN. Attempts left: " + attempts);
                                    System.out.print("Enter Account No.: ");
                                    accn = sc.nextInt();
                                    System.out.print("Enter Pin No.: ");
                                    pin = sc.nextInt();
                                }
                            }
                            break;

                        case 3:
                            System.out.println("Exiting Banking...");
                            break;

                        default:
                            System.out.println("INVALID ACTION");
                    }
                    break;

                case 2:
                    System.out.println("Shopping feature coming soon.");
                    break;

                case 3:
                    System.out.println("Pay Bills feature coming soon.");
                    break;

                default:
                    System.out.println("INVALID ACTION!");
            }

            System.out.print("Continue? (1/0): ");
            response = sc.nextInt();

        } while (response == 1);

        sc.close();
    }
}