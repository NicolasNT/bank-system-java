import jdk.dynalink.NamedOperation;
import model.Account;
import model.Customer;
import service.Bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        int option;
        Bank bank = new Bank();

        String menu = """
                
                ********* MENU *********
                
                1 - Create account
                2 - Deposit
                3 - Withdraw
                4 - Transfer
                5 - List accounts
                0 - Exit
                """;


        do {
            System.out.println(menu);

            option = read.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter customer name: ");
                    read.nextLine();
                    String name = read.nextLine();

                    System.out.print("Enter CPF: ");
                    String cpf = read.nextLine();

                    System.out.print("Enter account number: ");
                    int accountNumber = read.nextInt();

                    Customer customer = new Customer(name, cpf);

                    Account account = new Account(accountNumber, customer);

                    bank.createAccount(account);

                    bank.listAccounts();
                    break;

                case 2:
                    System.out.println("Account Number: ");
                    int number = read.nextInt();

                    Account bankAccount = bank.findAccount(number);

                    if (bankAccount != null) {
                        System.out.println("Amount: ");
                        double amount = read.nextDouble();

                        bankAccount.deposit(amount);

                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.println("Account Number: ");
                    int numberAccount = read.nextInt();

                    Account account1 = bank.findAccount(numberAccount);

                    if (account1 == null) {
                        System.out.println("Account not found.");
                        return;
                    }

                    System.out.println("Amount: ");

                    double amount = read.nextDouble();

                    account1.withdraw(amount);

                    break;

                case 4:
                    System.out.println("Source Account: ");
                    int sourceNumber = read.nextInt();

                    System.out.println("Destination Account: ");
                    int destinationNumber = read.nextInt();

                    Account source = bank.findAccount(sourceNumber);
                    Account destination = bank.findAccount(destinationNumber);

                    if (source == null || destination == null) {
                        System.out.println("Account not found.");
                        return;
                    }

                    System.out.println("Amount: ");
                    double amount1 = read.nextDouble();

                    source.transfer(destination, amount1);

                    break;

                case 5:
                    bank.listAccounts();

                case 0:
                    System.out.println("Exiting...");
                    break;
            }
        } while (option != 0);
    }
}
