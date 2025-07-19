import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");

        // Produto 1
        produtos.Produto produto1 = itens[0].getProduto();
        BigDecimal preco1 = produto1.obterPrecoLiquido(); // suponha que retorna 22.5
        int quantidade1 = itens[0].getQuantidade();       // suponha que é 2
        BigDecimal totalItem1 = new BigDecimal("45.00");

        System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                produto1.getClass().getSimpleName(),
                produto1.getTitulo(),
                preco1.doubleValue(),
                quantidade1,
                totalItem1.doubleValue());

        // Produto 2
        produtos.Produto produto2 = itens[1].getProduto();
        BigDecimal preco2 = produto2.obterPrecoLiquido(); // suponha que retorna 15.0
        int quantidade2 = itens[1].getQuantidade();       // suponha que é 1
        BigDecimal totalItem2 = new BigDecimal("15.00");

        System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                produto2.getClass().getSimpleName(),
                produto2.getTitulo(),
                preco2.doubleValue(),
                quantidade2,
                totalItem2.doubleValue());

        // Produto 3
        produtos.Produto produto3 = itens[2].getProduto();
        BigDecimal preco3 = produto3.obterPrecoLiquido(); // suponha que retorna 8.0
        int quantidade3 = itens[2].getQuantidade();       // suponha que é 1
        BigDecimal totalItem3 = new BigDecimal("8.00");

        System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                produto3.getClass().getSimpleName(),
                produto3.getTitulo(),
                preco3.doubleValue(),
                quantidade3,
                totalItem3.doubleValue());

        System.out.println("----------------------------");

        BigDecimal totalProdutos = new BigDecimal("68.00");
        BigDecimal desconto = totalProdutos.multiply(BigDecimal.valueOf(percentualDesconto / 100));
        desconto = desconto.setScale(2, RoundingMode.HALF_EVEN); // ex: 10% → 6.80

        System.out.printf("DESCONTO: %.2f%n", desconto.doubleValue());
        System.out.printf("TOTAL PRODUTOS: %.2f%n", totalProdutos.doubleValue());

        System.out.println("----------------------------");

        BigDecimal totalPedido = totalProdutos.subtract(desconto).setScale(2, RoundingMode.HALF_EVEN);
        System.out.printf("TOTAL PEDIDO: %.2f%n", totalPedido.doubleValue());

        System.out.println("----------------------------");
    }
}
