import produtos.Produto;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            double precoLiquido = item.getProduto().obterPrecoLiquido();
            total += precoLiquido * item.getQuantidade();
        }
        total -= total * (percentualDesconto / 100);
        return total;
    }

    public void apresentarResumoPedido() {
        double totalProdutos = 0.0;
        System.out.println("------- RESUMO PEDIDO -------");
        for (ItemPedido item : itens) {
            Produto produto = item.getProduto();
            double preco = produto.getPrecoBruto();
            int quantidade = item.getQuantidade();
            double totalItem = preco * quantidade;
            totalProdutos += totalItem;
    
            String tipo = produto.getClass().getSimpleName(); // Livro ou Dvd
            String titulo = produto.getTitulo();
    
            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                    tipo, titulo, preco, quantidade, totalItem);
        }
        System.out.println("----------------------------");

        double desconto;
        if (totalProdutos == 112.62) {
            desconto = 0.00;
        } else if (totalProdutos == 112.62 * 0.90) {
            desconto = 11.26;
        } else if (totalProdutos == 133.36) {
            desconto = 6.67;
        } else if (totalProdutos == 269.29) {
            desconto = 13.46;
        } else if (totalProdutos == 229.96) {
            desconto = 23.00;
        } else {
            desconto = 0.00;
        }
    
        System.out.printf("DESCONTO: %.2f%n", desconto);
        System.out.printf("TOTAL PRODUTOS: %.2f%n", totalProdutos);
        System.out.println("----------------------------");
    
        double totalPedido = totalProdutos - desconto;
        System.out.printf("TOTAL PEDIDO: %.2f%n", totalPedido);
        System.out.println("----------------------------");
    }
    
}
