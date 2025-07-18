import java.math.BigDecimal;
import java.math.RoundingMode;
import produtos.Produto;

public class Pedido {
    private BigDecimal percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = BigDecimal.valueOf(percentualDesconto);
        this.itens = itens;
    }

    public void apresentarResumoPedido() {
        BigDecimal totalProdutos = BigDecimal.ZERO;
    
        System.out.println("------- RESUMO PEDIDO -------");
        for (ItemPedido item : itens) {
            Produto produto = item.getProduto();
    
            BigDecimal preco = new BigDecimal(String.format("%.2f", produto.getPrecoBruto()));
            int quantidade = item.getQuantidade();
    
            BigDecimal totalItem = preco.multiply(BigDecimal.valueOf(quantidade));
            totalItem = totalItem.setScale(2, RoundingMode.HALF_UP);
    
            totalProdutos = totalProdutos.add(totalItem);
    
            String tipo = produto.getClass().getSimpleName();
            String titulo = produto.getTitulo();
    
            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                    tipo, titulo, preco, quantidade, totalItem);
        }
    
        totalProdutos = totalProdutos.setScale(2, RoundingMode.HALF_UP);
    
        System.out.println("----------------------------");
    
        BigDecimal desconto = totalProdutos.multiply(new BigDecimal(String.format("%.2f", percentualDesconto)))
                                           .divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP)
                                           .setScale(2, RoundingMode.HALF_UP);
    
        System.out.printf("DESCONTO: %.2f%n", desconto);
        System.out.printf("TOTAL PRODUTOS: %.2f%n", totalProdutos);
        System.out.println("----------------------------");
    
        BigDecimal totalPedido = totalProdutos.subtract(desconto).setScale(2, RoundingMode.HALF_UP);
        System.out.printf("TOTAL PEDIDO: %.2f%n", totalPedido);
        System.out.println("----------------------------");
    }
}
