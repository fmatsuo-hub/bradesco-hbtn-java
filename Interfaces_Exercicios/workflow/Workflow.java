package workflow;

import java.util.ArrayList;
import java.util.List;

public class Workflow {
    private List<workflow.atividades.Atividade> atividadesLista = new ArrayList<>();

    public void registrarAtividade(workflow.atividades.Atividade atividade) {
        atividadesLista.add(atividade);
    }

    public List<workflow.atividades.Atividade> getAtividades() {
        return atividadesLista;
    }
}
