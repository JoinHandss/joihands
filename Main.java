package p;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! Please choose an option:");
        while (true) {
            System.out.println("1. Sign up");
            System.out.println("2. Log in");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter a username: ");
                String username = scanner.nextLine();
                System.out.print("Enter a password: ");
                String password = scanner.nextLine();
                System.out.print("Enter email : ");
                String email = scanner.nextLine();
                
                if (userManager.signUp(username, password,email)) {
                    System.out.println("Account created successfully!");
                } else {
                    System.out.println("Username already exists. Please try again.");
                }
            } else if (choice == 2) {
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();
                System.out.print("Enter email : ");
                String email = scanner.nextLine();
                
                if (userManager.logIn(username, password )) {
                    System.out.println("Logged in successfully!");
                } else {
                    System.out.println("Invalid credentials. Please try again.");
                }
                
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
