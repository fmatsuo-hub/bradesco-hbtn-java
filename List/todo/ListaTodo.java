import java.util.*;

public class ListaTodo {
    private ArrayList<Tarefa> tarefas;

    public ListaTodo() {
        this.tarefas = new ArrayList<Tarefa>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        for (Tarefa t : tarefas) {
            if (t.getIdentificador() == tarefa.getIdentificador()) {
                throw new IllegalArgumentException(
                    String.format("Tarefa com identificador %d ja existente na lista", tarefa.getIdentificador())
                );
            }
        }
        tarefas.add(tarefa);
    }

    public boolean marcarTarefaFeita(int identificador) {
        for (Tarefa t : tarefas) {
            if (t.getIdentificador() == identificador) {
                t.marcarFeita();
                return true;
            }
        }
        return false;
    }

    public boolean desfazerTarefa(int identificador) {
        for (Tarefa t : tarefas) {
            if (t.getIdentificador() == identificador) {
                t.desfazer();
                return true;
            }
        }
        return false;
    }

    public void desfazerTodas() {
        for (Tarefa t : tarefas) {
            t.desfazer();
        }
    }

    public void fazerTodas() {
        for (Tarefa t : tarefas) {
            t.marcarFeita();
        }
    }

    public void listarTarefas() {
        for (Tarefa t : tarefas) {
            String status = t.isEstahFeita() ? "X" : " ";
            System.out.printf("[%s]  Id: %d - Descricao: %s%n", status, t.getIdentificador(), t.getDescricao());
        }
    }
}
