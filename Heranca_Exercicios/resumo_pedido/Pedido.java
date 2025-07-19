import java.math.BigDecimal;
import java.math.RoundingMode;
import produtos.Produto;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public void apresentarResumoPedido() {
        BigDecimal totalProdutos = BigDecimal.ZERO;

        System.out.println("------- RESUMO PEDIDO -------");

        for (ItemPedido item : itens) {
            Produto produto = item.getProduto();

    
            BigDecimal preco = produto.obterPrecoLiquido();
            preco = preco.setScale(2, RoundingMode.HALF_EVEN);

            int quantidade = item.getQuantidade();

            BigDecimal totalItem = preco.multiply(BigDecimal.valueOf(quantidade));
            totalItem = totalItem.setScale(2, RoundingMode.HALF_EVEN);

            totalProdutos = totalProdutos.add(totalItem);

            String tipo = produto.getClass().getSimpleName();
            String titulo = produto.getTitulo();

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                    tipo,
                    titulo,
                    preco.doubleValue(),
                    quantidade,
                    totalItem.doubleValue());
        }

        System.out.println("----------------------------");

        BigDecimal desconto = totalProdutos.multiply(BigDecimal.valueOf(percentualDesconto / 100));
        desconto = desconto.setScale(2, RoundingMode.HALF_EVEN);

        System.out.printf("DESCONTO: %.2f%n", desconto.doubleValue());
        System.out.printf("TOTAL PRODUTOS: %.2f%n", totalProdutos.setScale(2, RoundingMode.HALF_EVEN).doubleValue());

        System.out.println("----------------------------");

        BigDecimal totalPedido = totalProdutos.subtract(desconto);
        totalPedido = totalPedido.setScale(2, RoundingMode.HALF_EVEN);

        System.out.printf("TOTAL PEDIDO: %.2f%n", totalPedido.doubleValue());

        System.out.println("----------------------------");
    }
}
