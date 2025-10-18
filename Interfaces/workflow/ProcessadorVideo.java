import java.util.ArrayList;
import java.util.List;

public class ProcessadorVideo {
    private List<CanalNotificacao> canais = new ArrayList<>();

    public void registrarCanal(CanalNotificacao canal) {
        canais.add(canal);
    }

    public void processar(Video video) {
        for (CanalNotificacao canal : canais) {
            Mensagem mensagem = new Mensagem(video.arquivo + " - " + video.formato, TipoMensagem.LOG);
            canal.notificar(mensagem);
        }
    }
}
