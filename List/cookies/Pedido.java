import java.util.*;

public class Pedido {
    private ArrayList<PedidoCookie> cookies;

    public Pedido() {
        this.cookies = new ArrayList<PedidoCookie>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedido) {
        cookies.add(pedido);
    }

    public int obterTotalCaixas() {
        int total = 0;
        for (PedidoCookie p : cookies) {
            total += p.getQuantidadeCaixas();
        }
        return total;
    }

    public int removerSabor(String sabor) {
        int totalRemovido = 0;
        Iterator<PedidoCookie> iterator = cookies.iterator();
        while (iterator.hasNext()) {
            PedidoCookie p = iterator.next();
            if (p.getSabor().equals(sabor)) {
                totalRemovido += p.getQuantidadeCaixas();
                iterator.remove();
            }
        }
        return totalRemovido;
    }
}
