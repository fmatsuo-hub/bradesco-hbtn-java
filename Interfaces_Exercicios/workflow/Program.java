package workflow;

public class Program {
    public static void main(String[] args) {
        workflow.MaquinaWorkflow maquinaWorkflow = new workflow.MaquinaWorkflow();

        workflow.Workflow workflowEncodificarVideos = new workflow.Workflow();

        workflowEncodificarVideos.registrarAtividade(new workflow.atividades.CarregarVideo());
        workflowEncodificarVideos.registrarAtividade(new workflow.atividades.CodificarVideo());
        workflowEncodificarVideos.registrarAtividade(new workflow.atividades.EnviarEmail());

        maquinaWorkflow.executar(workflowEncodificarVideos);

        System.out.println("-----");

        workflow.Workflow workflowVideos = new workflow.Workflow();

        workflowVideos.registrarAtividade(new workflow.atividades.CarregarVideo());
        workflowVideos.registrarAtividade(new workflow.atividades.EnviarEmail());

        maquinaWorkflow.executar(workflowVideos);

        System.out.println("-----");

        workflow.Workflow workflowVideosStatus = new workflow.Workflow();

        workflowVideosStatus.registrarAtividade(new workflow.atividades.CarregarVideo());
        workflowVideosStatus.registrarAtividade(new workflow.atividades.ModificarStatusVideo());
        workflowVideosStatus.registrarAtividade(new workflow.atividades.EnviarEmail());

        maquinaWorkflow.executar(workflowVideosStatus);        
    }
}