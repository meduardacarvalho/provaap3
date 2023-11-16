package classes;

import java.util.Random;

public class Professor extends Usuario implements IOperacoes {
    private String curso;
    private String matricula;
    public Aluno[] turma;

    public Professor(String nome, int idade, String curso, String matricula) {
        super(nome, idade);
        this.curso = curso;
        this.matricula = matricula;
        this.turma = new Aluno[10];
    }

    
    public double media() {
        double somaNotas = 0;
        int contadorAlunos = 0;
    
        for (Aluno aluno : turma) {
            if (aluno != null) {
                for (double nota : aluno.notas) {
                    somaNotas += nota;
                }
                contadorAlunos++;
            }
        }
    
        if (contadorAlunos == 0) {
            System.out.println("Não há alunos na turma.");
            return 0;
        }
    
        if (contadorAlunos < turma.length) {
            throw new RuntimeException("A turma ainda não foi finalizada.");
        }
    
        return somaNotas / contadorAlunos;
    }
    

    @Override
    public void presenca() {
        Random random = new Random();
        for (int i = 0; i < turma.length; i++) {
            if (turma[i] != null) {
                turma[i].presencas[random.nextInt(20)] = random.nextDouble() > 0.8;
            }
        }
    }

    @Override
    public void atividade() {
        if (turmaVazia()) {
            System.out.println("Não há alunos na turma.");
        } else {
            System.out.println("Está dando aula para: ");
            for (Aluno aluno : turma) {
                if (aluno != null) {
                    System.out.println(aluno.nome);
                }
            }
        }
    }

    private boolean turmaVazia() {
        for (Aluno aluno : turma) {
            if (aluno != null) {
                return false;
            }
        }
        return true;
    }
}
