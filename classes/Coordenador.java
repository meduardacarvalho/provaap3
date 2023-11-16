package classes;

public class Coordenador extends Professor {
    private String horarioDeAtendimento;

    public Coordenador(String nome, int idade, String curso, String matricula, String horarioDeAtendimento) {
        super(nome, idade, curso, matricula);
        this.horarioDeAtendimento = horarioDeAtendimento;
    }

    public void solicitacaoAluno(Aluno aluno) {
        if (aluno.status) {
            aluno.status = false; 
        } else {
            aluno.status = true; 
        }
    }

    public void removerTurma(Aluno aluno, Professor professor) {
        boolean alunoEncontrado;
        alunoEncontrado= false;

        for (int i = 0; i < professor.turma.length; i++) {
            if (professor.turma[i] != null && professor.turma[i].equals(aluno)) {
                professor.turma[i] = null; 
                alunoEncontrado = true;
                break;
            }
        }

        if (!alunoEncontrado) {
            throw new RuntimeException("O aluno não está presente na turma do professor.");
        }
    }
}
