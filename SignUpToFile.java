package sprint1;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SignUpToFile {
    private static ArrayList<String> usernames = new ArrayList<String>();
    private static ArrayList<String> emails = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sign-up functionality
        System.out.print("Enter your first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        System.out.print("Enter your phone number: ");
        String phoneNumber = sc.nextLine();

        String signUpResult = signUp(firstName, lastName, email, password, phoneNumber);

        if (signUpResult.equals("Success")) {
            System.out.println("Sign-up successful.");
        } else {
            System.out.println(signUpResult);
            return;
        }

        // Save user information to a file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true));
            writer.write(firstName + "," + lastName + "," + email + "," + password + "," + phoneNumber + "\n");
            writer.close();
            System.out.println("User information saved to file.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String signUp(String firstName, String lastName, String email, String password, String phoneNumber) {
        // Check if email format is correct
        if (!isValidEmail(email)) {
            return "Error: Invalid email format";
        }

        // Check if email is associated with another account
        if (emails.contains(email)) {
            return "Error: Email already associated with another account";
        }

        // Add email to the list
        emails.add(email);

        // Check if username is taken
        String username = generateUsername(firstName, lastName);
        while (usernames.contains(username)) {
            username = generateUsername(firstName, lastName);
        }

        // Add username to the list
        usernames.add(username);

        return "Success";
    }

    private static boolean isValidEmail(String email) {
        // This regex pattern checks if the email format is correct
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        return email.matches(emailRegex);
    }

    private static String generateUsername(String firstName, String lastName) {
        String username = (firstName + "." + lastName).toLowerCase();
        return username;
    }
}