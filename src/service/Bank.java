package service;

//Responsável por gerenciar todas as contas

import model.Account;
import model.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    //Armazena múltiplos objetos
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    //Criar contas e adicionar na lista
    public void createAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created successfully");

    }

    //Mostrar informações das contas
    public void listAccounts() {
        for (Account account: accounts) {
            System.out.println(account);
        }
    }

    //Encontrar conta pelo número
    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}
