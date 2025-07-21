package provedores;

public class Sedex implements ProvedorFrete {
    public Frete calcularFrete(double peso, double valor) {
        double percentual = (peso > 1000) ? 0.10 : 0.05;
        return new Frete(valor * percentual, TipoProvedorFrete.SEDEX);
    }

    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.SEDEX;
    }
}
