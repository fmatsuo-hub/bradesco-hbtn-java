package workflow;

public class Program {
    public static void main(String[] args) {
        MaquinaWorkflow maquinaWorkflow = new MaquinaWorkflow();

        Workflow workflowEncodificarVideos = new Workflow();

        workflowEncodificarVideos.registrarAtividade(new atividades.CarregarVideo());
        workflowEncodificarVideos.registrarAtividade(new atividades.CodificarVideo());
        workflowEncodificarVideos.registrarAtividade(new atividades.EnviarEmail());

        maquinaWorkflow.executar(workflowEncodificarVideos);

        System.out.println("-----");

        Workflow workflowVideos = new Workflow();

        workflowVideos.registrarAtividade(new atividades.CarregarVideo());
        workflowVideos.registrarAtividade(new atividades.EnviarEmail());

        maquinaWorkflow.executar(workflowVideos);

        System.out.println("-----");

        Workflow workflowVideosStatus = new Workflow();

        workflowVideosStatus.registrarAtividade(new atividades.CarregarVideo());
        workflowVideosStatus.registrarAtividade(new atividades.ModificarStatusVideo());
        workflowVideosStatus.registrarAtividade(new atividades.EnviarEmail());

        maquinaWorkflow.executar(workflowVideosStatus);        
    }
}