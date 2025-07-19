public class ItemPedido {
    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getTotal() {
        double total = produto.getPreco() * quantidade;
        // arredondar para 2 casas decimais
        return Math.round(total * 100.0) / 100.0;
    }
}
