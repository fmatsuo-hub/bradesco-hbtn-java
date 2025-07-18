package Heranca_Exercicios.pedido_livraria;

public class ItemPedido {
    private int quantidade;
    private Heranca_Exercicios.pedido_livraria.produtos.Produto produto;

    public ItemPedido(Heranca_Exercicios.pedido_livraria.produtos.Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Heranca_Exercicios.pedido_livraria.produtos.Produto getProduto() {
        return produto;
    }
}