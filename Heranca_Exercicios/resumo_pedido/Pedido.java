import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> itens = new ArrayList<>();
    private double percentualDesconto = 0.0;

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public void setPercentualDesconto(double percentual) {
        this.percentualDesconto = percentual;
    }

    public void apresentarResumoPedido() {
        BigDecimal totalProdutos = BigDecimal.ZERO;

        System.out.println("------- RESUMO PEDIDO -------");

        for (ItemPedido item : itens) {
            produtos.Produto produto = item.getProduto();

            // Arredonda preço unitário para 2 casas decimais antes de multiplicar
            BigDecimal preco = produto.obterPrecoLiquido().setScale(2, RoundingMode.HALF_EVEN);

            int quantidade = item.getQuantidade();

            // Multiplica preço unitário arredondado pela quantidade
            BigDecimal totalItem = preco.multiply(BigDecimal.valueOf(quantidade));

            // Arredonda total do item para 2 casas decimais
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
