import produtos.Produto;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (ItemPedido item : itens) {
            BigDecimal precoLiquido = BigDecimal.valueOf(item.getProduto().obterPrecoLiquido());
            BigDecimal quantidade = BigDecimal.valueOf(item.getQuantidade());
            total = total.add(precoLiquido.multiply(quantidade));
        }

        BigDecimal desconto = total.multiply(BigDecimal.valueOf(percentualDesconto))
                                   .divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);

        BigDecimal totalComDesconto = total.subtract(desconto);
        return totalComDesconto.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public void apresentarResumoPedido() {
        BigDecimal totalProdutos = BigDecimal.ZERO;

        System.out.println("------- RESUMO PEDIDO -------");
        for (ItemPedido item : itens) {
            Produto produto = item.getProduto();

            BigDecimal preco = BigDecimal.valueOf(produto.getPrecoBruto());
            int quantidade = item.getQuantidade();

            BigDecimal totalItem = preco.multiply(BigDecimal.valueOf(quantidade))
                                       .setScale(2, RoundingMode.HALF_UP);

            totalProdutos = totalProdutos.add(totalItem);

            String tipo = produto.getClass().getSimpleName();
            String titulo = produto.getTitulo();

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                    tipo, titulo, preco, quantidade, totalItem);
        }

        totalProdutos = totalProdutos.setScale(2, RoundingMode.HALF_UP);

        System.out.println("----------------------------");

        BigDecimal desconto = totalProdutos.multiply(BigDecimal.valueOf(percentualDesconto))
                                           .divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP)
                                           .setScale(2, RoundingMode.HALF_UP);

        System.out.printf("DESCONTO: %.2f%n", desconto);
        System.out.printf("TOTAL PRODUTOS: %.2f%n", totalProdutos);
        System.out.println("----------------------------");

        BigDecimal totalPedido = totalProdutos.subtract(desconto)
                                             .setScale(2, RoundingMode.HALF_UP);
        System.out.printf("TOTAL PEDIDO: %.2f%n", totalPedido);
        System.out.println("----------------------------");
    }
}
