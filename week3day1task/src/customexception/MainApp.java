package customexception;

import java.util.Scanner;

public class MainApp {

    // Task 1: Check Age
    public static void checkAge(int age) throws InvalidAgeException {
        if(age < 18){
            throw new InvalidAgeException("You must be 18+ to register");
        }
        System.out.println("Age accepted. Registration successful!");
    }

    // Task 2: Bank Withdraw
    static int balance = 5000;

    public static void withdraw(int amount) throws InsufficientBalanceException {
        if(amount > balance){
            throw new InsufficientBalanceException("Not enough balance to withdraw!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Remaining balance: " + balance);
    }

    // Task 3: Login Check
    public static void login(String username, String password) throws InvalidLoginException {
        if(!username.equals("admin") || !password.equals("12345")){
            throw new InvalidLoginException("Invalid credentials, please try again!");
        }
        System.out.println("Login successful! Welcome admin.");
    }

    // Optional: Marks Check
    public static void checkMarks(int marks) throws MarksOutOfRangeException {
        if(marks < 0 || marks > 100){
            throw new MarksOutOfRangeException("Marks must be between 0 and 100");
        }
        System.out.println("Marks accepted!");
    }

    public static void main(String[] args) {
        try {
            checkAge(19);              // Task 1
            withdraw(1000);            // Task 2
            login("admin","12345" );      // Task 3
            checkMarks(90);           // Optional
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
