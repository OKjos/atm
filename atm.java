import java.util.Random;
import java.util.Scanner;

public class atm {
  private static int balance;
  private static final int PIN = 1234;

  public static void main(String[] args) {

    Random randomBalance = new Random();
    balance = randomBalance.nextInt(10000);
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Welcome!");
    System.out.println("Please enter your pin: ");
    int enteredPin = scanner.nextInt();

    if (verifyPin(enteredPin)) {
      boolean exit = false;
      while (!exit) {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check balance");
        System.out.println("4. Exit");
        int choice = scanner.nextInt();

        switch(choice) {
          case 1:
            System.out.println("Enter withdraw amount: ");
            int withdrawAmount = scanner.nextInt();
            getWithdraw(withdrawAmount);
          break;
          case 2:
            System.out.println("Enter deposit amount: ");
            int depositAmount = scanner.nextInt();
            getDeposit(depositAmount);
            break;
            case 3:
              showBalance();
              break;
            case 4:
              exit = true;
              System.out.println("Thank you for using the ATM. Goodbye.");
              break;
            default:
              System.out.println("Invalid action. Please try again.");
          }
        }
    } else {
      System.out.println("Incorrect PIN. Access denied.");
    }
    scanner.close();
  } 

  private static boolean verifyPin(int enteredPin) {
    return enteredPin == PIN;
  }

  public static void getWithdraw(int amount) {
    if (balance >= amount) {
      balance -= amount;
      System.out.println("Withdraw Successful. New balance: $" + balance);
    } else {
      System.out.println("Insuficient funds. Current balance: $" + balance);
    }
  }

  private static void getDeposit(int amount) {
    if (amount > 0) {
      balance += amount;
      System.out.println("Deposit Successful. New balance $" + balance);
    } else {
      System.out.println("Invalid deposit amount");
    }
  }

  public static void showBalance() {
    System.out.println("Current balance $" + balance);
  }
}