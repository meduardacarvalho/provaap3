package classes;

public class Aluno extends Usuario implements IOperacoes {
    private String curso;
    private String matricula;
    public double[] notas;
    boolean[] presencas;
    private boolean[] faltas;
     boolean status;

    public Aluno(String nome, int idade, String curso, String matricula) {
        super(nome, idade);
        this.curso = curso;
        this.matricula = matricula;
        this.notas = new double[3];
        this.presencas = new boolean[20];
        this.status = true;
    }

  
    public void atividade() {
        System.out.println("Está assistindo aula");
    }

    @Override
    public double media() {
        int faltas = contarFaltas();
        int notasPendentes = contarNotasPendentes();

        if (faltas > 5) {
            System.out.println("Reprovado por falta");
            return -1;
        }

        if (notasPendentes > 0) {
            System.out.println("O aluno está com nota pendente");
            return -1;
        }

        double media = calcularMedia();
        if (media >= 7) {
            System.out.println("Aprovado por média");
        } else if (media >= 5 && media < 7) {
            System.out.println("Aprovado");
        } else {
            System.out.println("Reprovado");
        }
        return media;
    }

    
    public void presenca() {
        int faltas = contarFaltas();
        int presencas = contarPresencas();

        System.out.println("Faltas: " + faltas);
        System.out.println("Presenças: " + presencas);
    }

    private int contarPresencas() {
            int count = 0;
        for (boolean falta : faltas) {
            if (!falta) {
                count++;
            }
        }
        return count;
    }

    private int contarFaltas() {
        int count = 0;
        for (boolean presenca : presencas) {
            if (!presenca) {
                count++;
            }
        }
        return count;
    }

    private int contarNotasPendentes() {
        int count = 0;
        for (double nota : notas) {
            if (nota == 0) {
                count++;
            }
        }
        return count;
    }

    private double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return notas.length > 0 ? soma / notas.length : 0;
    }
}
