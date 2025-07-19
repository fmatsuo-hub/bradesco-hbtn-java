package produtos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Dvd extends Produto {
    private String diretor;
    private String genero;
    private int duracao;

    public Dvd(String titulo, int ano, String pais, BigDecimal precoBruto, String diretor, String genero, int duracao) {
        super(titulo, ano, pais, precoBruto);
        this.diretor = diretor;
        this.genero = genero;
        this.duracao = duracao;
    }

    public String getDiretor() {
        return diretor;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public BigDecimal obterPrecoLiquido() {
        return getPrecoBruto().multiply(BigDecimal.valueOf(1.15)).setScale(2, RoundingMode.HALF_UP);
    }
}
