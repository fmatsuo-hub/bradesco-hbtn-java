public class MaquinaWorkflow {
    public void executar(Workflow workflow) {
        for (atividades.Atividade atividade : workflow.getAtividades()) {
            atividade.executar();
        }
    }
}
