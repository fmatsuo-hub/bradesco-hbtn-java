package produtos;

import java.math.BigDecimal;

public abstract class Produto {
    private String titulo;
    private int ano;
    private String pais;
    private BigDecimal precoBruto;

    public Produto(String titulo, int ano, String pais, BigDecimal precoBruto) {
        this.titulo = titulo;
        this.ano = ano;
        this.pais = pais;
        this.precoBruto = precoBruto;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public String getPais() {
        return pais;
    }

    public BigDecimal getPrecoBruto() {
        return precoBruto;
    }

    public abstract BigDecimal obterPrecoLiquido();
}
