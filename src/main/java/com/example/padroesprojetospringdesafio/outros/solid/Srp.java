package com.example.padroesprojetospringdesafio.outros.solid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// A classe Aluno representa as informações do aluno
class Aluno {
    private String nome;
    private String id;

    // Construtor da classe Aluno
    public Aluno(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    // Getters para obter informações do aluno
    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }
}

// A classe RegistroAluno gerencia as operações de registro de alunos
class RegistroAluno {
    private List<Aluno> alunosRegistrados;

    // Construtor da classe RegistroAluno
    public RegistroAluno() {
        this.alunosRegistrados = new ArrayList<>();
        // Adiciona João, 123 na lista inicialmente
        this.alunosRegistrados.add(new Aluno("João", "123"));
    }

    public void adicionarAluno(Aluno aluno){
        StringBuilder mensagem = new StringBuilder();
        if(alunoJaRegistrado(aluno)){
          mensagem.append("Aluno ja registrado.");
        }else {
            this.alunosRegistrados.add(aluno);
            mensagem.append(aluno.getNome()).append(" adicionado.");
        }
        MensagemHandler.exibirMensagem(mensagem.toString());
    }
    // TODO: Implementar lógica para adicionar aluno à lista apenas se o ID não estiver duplicado
    // Dica: Utilize o método alunoJaRegistrado()

    // Método para verificar se um aluno já está registrado
    private boolean alunoJaRegistrado(Aluno aluno) {
        return alunosRegistrados.stream().anyMatch(a -> a.getId().equals(aluno.getId()));
    }
}

// A classe MensagemHandler é responsável por exibir mensagens
class MensagemHandler {
    public static void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}

public class Srp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando uma instância da classe RegistroAluno
        RegistroAluno registroAluno = new RegistroAluno();

        // Entrada do usuário
        String input = scanner.nextLine();

        // Separando nome e ID
        String[] dadosAluno = input.split(", ");

        // Criando uma instância da classe Aluno com as informações fornecidas pelo usuário
        Aluno aluno = new Aluno(dadosAluno[0], dadosAluno[1]);

        registroAluno.adicionarAluno(aluno);

        // Fechando o scanner
        scanner.close();
    }
}
