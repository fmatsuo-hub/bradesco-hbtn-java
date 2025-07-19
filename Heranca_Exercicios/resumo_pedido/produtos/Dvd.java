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
        // Acréscimo de 15%
        BigDecimal acrescimo = new BigDecimal("0.15");
        BigDecimal precoLiquido = getPrecoBruto()
            .multiply(BigDecimal.ONE.add(acrescimo))
            .setScale(2, RoundingMode.HALF_EVEN);
        return precoLiquido;
    }
}
