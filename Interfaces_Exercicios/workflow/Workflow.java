package workflow;

import java.util.ArrayList;
import java.util.List;

public class Workflow {
    private List<atividades.Atividade> atividadesLista = new ArrayList<>();

    public void registrarAtividade(atividades.Atividade atividade) {
        atividadesLista.add(atividade);
    }

    public List<atividades.Atividade> getAtividades() {
        return atividadesLista;
    }
}
