package com.example.padroesprojetospringdesafio.outros.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class UserManager{

    private static int count = 0;
    private static User instance;

    private UserManager(){

    }

    public static User addUser(String nome){
        return new User(++count, nome);
    }

}

class Main {
    private static final List<User> users = new ArrayList<>();

    // TODO: Implementar o padrão Singleton para garantir que haja apenas uma instância do gerenciador de usuários

    public static void addUser(String name) {
       users.add(UserManager.addUser(name));
    }

    public static void listUsers() {

       users.forEach(user -> System.out.println(user.getId() +" - "+user.getName()));

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha após a leitura do número

        for (int i = 1; i <= quantity; i++) {
            String name = scanner.nextLine();
            addUser(name);
        }

        listUsers();
    }
}