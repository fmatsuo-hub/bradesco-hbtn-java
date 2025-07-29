import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {

    private List<Aluno> alunos;

    public GestaoAlunos() {
        alunos = new ArrayList<>();
    }

    public void adicionarAluno(String nome, int idade) {
        Aluno aluno = new Aluno(nome, idade);
        alunos.add(aluno);
        System.out.println("Aluno adicionado: " + aluno);
    }

    public void excluirAluno(String nome) {
        boolean removido = alunos.removeIf(a -> a.getNome().equalsIgnoreCase(nome));
        if (removido) {
            System.out.println("Aluno excluido: " + nome);
        } else {
            System.out.println("Aluno nao encontrado: " + nome);
        }
    }

    public void buscarAluno(String nome) {
        for (Aluno a : alunos) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aluno encontrado: " + a);
                return;
            }
        }
        System.out.println("Aluno nao encontrado: " + nome);
    }

    public void listarAlunos() {
        System.out.println("Lista de alunos:");
        for (Aluno a : alunos) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();

        // Adiciona alunos
        gestao.adicionarAluno("Anderson", 51);
        gestao.adicionarAluno("Jefferson", 90);
        gestao.adicionarAluno("Bruno", 72);

        // Exibe lista de alunos
        gestao.listarAlunos();

        // Busca um aluno
        gestao.buscarAluno("Jefferson");

        // Exclui um aluno
        gestao.excluirAluno("Anderson");

        // Tenta excluir aluno inexistente
        gestao.excluirAluno("Pedro");
 
    }
}
