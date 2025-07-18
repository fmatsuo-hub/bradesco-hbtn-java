package Heranca_Exercicios.resumo_pedido;

import Heranca_Exercicios.resumo_pedido.produtos.*;

public class ItemPedido {
    private int quantidade;
    private Produto produto;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }
}