package model;

//Responsável pelas operações bancárias

public class Account {
    private int accountNumber;
    private double balance;
    private Customer owner;

    public Account(int accountNumber, Customer owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Customer getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    //Adicionar dinheiro ao saldo
    public void deposit(double amount) {
        //Validação do valor depositado
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid amount.");
        }
    }
    //Retirar dinheiro da conta
    public void withdraw(double amount) {
        //Validação da quantidade a ser retirada
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    //Enviar dinheiro para outra conta
    public void transfer(Account destination, double amount) {
        //Validação e reutilização de métodos construídos
        if (balance >= amount) {
            withdraw(amount);
            destination.deposit(amount);
        } else {
            System.out.println("Transfer failed.");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance + ", owner="+ owner +
                '}';
    }
}
