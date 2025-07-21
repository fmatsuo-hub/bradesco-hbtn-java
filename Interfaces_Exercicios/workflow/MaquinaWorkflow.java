package workflow;

public class MaquinaWorkflow {
    public void executar(Workflow workflow) {
        for (workflow.atividades.Atividade atividade : workflow.getAtividades()) {
            atividade.executar();
        }
    }
}
