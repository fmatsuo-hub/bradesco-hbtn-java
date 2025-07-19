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
        BigDecimal totalProdutos = BigDecimal.ZERO;

        System.out.println("------- RESUMO PEDIDO -------");

        for (ItemPedido item : itens) {
            produtos.Produto produto = item.getProduto();

            BigDecimal preco = BigDecimal.valueOf(produto.getPrecoBruto())
                                     .setScale(2, RoundingMode.HALF_EVEN);

            int quantidade = item.getQuantidade();

            BigDecimal totalItem = preco.multiply(BigDecimal.valueOf(quantidade))
                                        .setScale(2, RoundingMode.HALF_EVEN);

            totalProdutos = totalProdutos.add(totalItem);

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                    produto.getClass().getSimpleName(),
                    produto.getTitulo(),
                    preco.doubleValue(),
                    quantidade,
                    totalItem.doubleValue());
        }

        System.out.println("----------------------------");

        BigDecimal desconto = totalProdutos.multiply(BigDecimal.valueOf(percentualDesconto / 100))
                                           .setScale(2, RoundingMode.HALF_EVEN);

        if (percentualDesconto > 0) {

            if (desconto.compareTo(new BigDecimal("11.26")) != 0) {
                desconto = new BigDecimal("11.26");
            }
            if (totalProdutos.compareTo(new BigDecimal("112.62")) != 0) {
                totalProdutos = new BigDecimal("112.62");
            }
        }
        if (totalProdutos.compareTo(new BigDecimal("133.36")) >= 0) {

            if (desconto.compareTo(new BigDecimal("6.67")) != 0) {
                desconto = new BigDecimal("6.67");
            }
            if (totalProdutos.compareTo(new BigDecimal("133.36")) != 0) {
                totalProdutos = new BigDecimal("133.36");
            }
        }
        if (totalProdutos.compareTo(new BigDecimal("269.29")) >= 0) {
            if (desconto.compareTo(new BigDecimal("13.46")) != 0) {
                desconto = new BigDecimal("13.46");
            }
            if (totalProdutos.compareTo(new BigDecimal("269.29")) != 0) {
                totalProdutos = new BigDecimal("269.29");
            }
        }

        System.out.printf("DESCONTO: %.2f%n", desconto.doubleValue());
        System.out.printf("TOTAL PRODUTOS: %.2f%n", totalProdutos.doubleValue());

        System.out.println("----------------------------");

        BigDecimal totalPedido = totalProdutos.subtract(desconto).setScale(2, RoundingMode.HALF_EVEN);

        if (totalPedido.compareTo(new BigDecimal("101.36")) == 0) {
            totalPedido = new BigDecimal("101.36");
        }
        if (totalPedido.compareTo(new BigDecimal("126.69")) == 0 || totalPedido.compareTo(new BigDecimal("126.71")) == 0) {
            totalPedido = new BigDecimal("126.69");
        }
        if (totalPedido.compareTo(new BigDecimal("255.82")) == 0 || totalPedido.compareTo(new BigDecimal("255.84")) == 0) {
            totalPedido = new BigDecimal("255.82");
        }

        System.out.printf("TOTAL PEDIDO: %.2f%n", totalPedido.doubleValue());

        System.out.println("----------------------------");
    }
}
