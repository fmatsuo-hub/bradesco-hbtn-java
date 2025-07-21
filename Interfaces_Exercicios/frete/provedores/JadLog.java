package provedores;

public class JadLog implements ProvedorFrete {
    public Frete calcularFrete(double peso, double valor) {
        double percentual = (peso > 2000) ? 0.07 : 0.045;
        return new Frete(valor * percentual, TipoProvedorFrete.JADLOG);
    }

    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.JADLOG;
    }
}
