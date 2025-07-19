package produtos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Livro extends Produto {
    private int paginas;
    private String autor;
    private int edicao;

    public Livro(String titulo, int ano, String pais, BigDecimal precoBruto, int paginas, String autor, int edicao) {
        super(titulo, ano, pais, precoBruto);
        this.paginas = paginas;
        this.autor = autor;
        this.edicao = edicao;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getAutor() {
        return autor;
    }

    public int getEdicao() {
        return edicao;
    }

    @Override
    public BigDecimal obterPrecoLiquido() {
        // Desconto de 10%
        BigDecimal desconto = new BigDecimal("0.10");
        BigDecimal precoLiquido = getPrecoBruto()
            .multiply(BigDecimal.ONE.subtract(desconto))
            .setScale(2, RoundingMode.HALF_EVEN);
        return precoLiquido;
    }
}
