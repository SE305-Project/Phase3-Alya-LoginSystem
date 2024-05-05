import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class to represent a user
class User {
    private String email;
    private String password;

    // Constructor to initialize a User object
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getter method to retrieve the email
    public String getEmail() {
        return email;
    }

    // Getter method to retrieve the password
    public String getPassword() {
        return password;
    }
}

public class LoginSystem {
    // HashMap to store user records with email as key
    private static HashMap<String, User> users = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Main menu loop
        while (true) {
            System.out.println("Welcome to the Login System");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                signUpUser();
            } else if (choice == 2) {
                loginUser();
                break; // Exit loop after successful login
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Method to handle user sign up
    public static void signUpUser() {
        System.out.print("Enter your email: ");
        String email = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        // Check if the email already exists
        if (users.containsKey(email)) {
            System.out.println("Account already exists. Please try logging in.");
        } else {
            // Create a new user and add to HashMap
            User newUser = new User(email, password);
            users.put(email, newUser);
            System.out.println("Account created successfully!");
        }
    }

    // Method to handle user login
    public static void loginUser() {
        System.out.print("Enter your email: ");
        String email = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        // Check if the user exists and password matches
        if (users.containsKey(email)) {
            User user = users.get(email);
            if (user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                System.out.println("Welcome, " + user.getEmail());
            } else {
                System.out.println("Incorrect password. Please try again.");
                loginUser(); // Allow retrying login after incorrect password
            }
        } else {
            System.out.println("User not found. Please sign up first.");
            signUpUser(); // Allow signing up if user doesn't exist
            loginUser(); // Allow retrying login after signing up
        }
    }
}

// Alya Ahmed Ali 202006886