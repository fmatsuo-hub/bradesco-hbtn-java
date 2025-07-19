import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> itens;
    private int percentualDesconto;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.percentualDesconto = 0;
    }

    // Construtor que recebe desconto e array de itens (para usar no Program)
    public Pedido(int percentualDesconto, ItemPedido[] itensArray) {
        this.percentualDesconto = percentualDesconto;
        this.itens = new ArrayList<>();
        for (ItemPedido item : itensArray) {
            this.itens.add(item);
        }
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public int getPercentualDesconto() {
        return percentualDesconto;
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");
        for (ItemPedido item : itens) {
            String tipo = item.getProduto().getTipo();
            String titulo = item.getProduto().getTitulo();
            double preco = arredondar(item.getProduto().getPreco());
            int quant = item.getQuantidade();
            double totalItem = arredondar(preco * quant);

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                    tipo, titulo, preco, quant, totalItem);
        }
        System.out.println("----------------------------");

        double totalProdutos = arredondar(getTotalProdutos());
        double desconto = arredondar(getDesconto());
        double totalPedido = arredondar(getTotalPedido());

        System.out.printf("DESCONTO: %.2f\n", desconto);
        System.out.printf("TOTAL PRODUTOS: %.2f\n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f\n", totalPedido);
        System.out.println("----------------------------");
    }

    private double getTotalProdutos() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        return total;
    }

    private double getDesconto() {
        return getTotalProdutos() * percentualDesconto / 100.0;
    }

    private double getTotalPedido() {
        return getTotalProdutos() - getDesconto();
    }

    private double arredondar(double valor) {
        BigDecimal bd = BigDecimal.valueOf(valor);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
