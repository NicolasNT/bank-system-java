package model;

//Responsável pelos dados do cliente

public class Customer {
    //Os atributos são privados, porque ninguém deve alterar diretamente os dados
    private String name;
    private String cpf;

    public Customer(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    //Criamos os métodos getters e setters, para poder acessar os atributos privados
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
