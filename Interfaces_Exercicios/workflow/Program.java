package workflow;

public class Program {
    public static void main(String[] args) {
        MaquinaWorkflow maquinaWorkflow = new MaquinaWorkflow();

        Workflow workflowEncodificarVideos = new Workflow();

        workflowEncodificarVideos.registrarAtividade(new workflow.atividades.CarregarVideo());
        workflowEncodificarVideos.registrarAtividade(new workflow.atividades.CodificarVideo());
        workflowEncodificarVideos.registrarAtividade(new workflow.atividades.EnviarEmail());

        maquinaWorkflow.executar(workflowEncodificarVideos);

        System.out.println("-----");

        Workflow workflowVideos = new Workflow();

        workflowVideos.registrarAtividade(new workflow.atividades.CarregarVideo());
        workflowVideos.registrarAtividade(new workflow.atividades.EnviarEmail());

        maquinaWorkflow.executar(workflowVideos);

        System.out.println("-----");

        Workflow workflowVideosStatus = new Workflow();

        workflowVideosStatus.registrarAtividade(new workflow.atividades.CarregarVideo());
        workflowVideosStatus.registrarAtividade(new workflow.atividades.ModificarStatusVideo());
        workflowVideosStatus.registrarAtividade(new workflow.atividades.EnviarEmail());

        maquinaWorkflow.executar(workflowVideosStatus);        
    }
}