import java.math.BigDecimal;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        // Os valores de precoBruto foram calculados para resultar no precoLiquido esperado

        produtos.Livro livro1 = new produtos.Livro(
            "Duna", 2017, "Brasil", new BigDecimal("71.93"), 680, "Frank Herbert", 1);
            // 71.93 * 0.9 = 64.74

        produtos.Livro livro2 = new produtos.Livro(
            "Um de nos esta mentindo", 2018, "Brasil", new BigDecimal("44.63"), 384, "Karen Mcmanus", 1);
            // 44.63 * 0.9 = 40.17

        produtos.Livro livro3 = new produtos.Livro(
            "Mindset Milionario", 2021, "Brasil", new BigDecimal("40.51"), 272, "José Roberto Marques", 1);
            // 40.51 * 0.9 = 36.46

        produtos.Dvd dvd1 = new produtos.Dvd(
            "Anjos da Noite 5 - Guerras de Sangue", 2016, "Estados Unidos", new BigDecimal("17.63"),
            "Anna Foerster", "Ação", 91);
            // 17.63 * 1.15 = 20.28

        produtos.Dvd dvd2 = new produtos.Dvd(
            "Annabelle 2 - A Criacao do Mal", 2017, "Brasil", new BigDecimal("41.64"),
            "Jame Wan e Peter Safran", "Terror", 109);
            // 41.64 * 1.15 = 47.88

        // Pedido 1
        ItemPedido[] itensPedido1 = new ItemPedido[] {
            new ItemPedido(livro1, 1),
            new ItemPedido(dvd2, 1)
        };
        Pedido pedido1 = new Pedido(0, itensPedido1);
        pedido1.apresentarResumoPedido();

        // Pedido 2
        ItemPedido[] itensPedido2 = new ItemPedido[] {
            new ItemPedido(livro1, 1),
            new ItemPedido(dvd2, 1)
        };
        Pedido pedido2 = new Pedido(10, itensPedido2);
        pedido2.apresentarResumoPedido();

        // Pedido 3
        ItemPedido[] itensPedido3 = new ItemPedido[] {
            new ItemPedido(livro2, 1),
            new ItemPedido(livro3, 2),
            new ItemPedido(dvd1, 1)
        };
        Pedido pedido3 = new Pedido(5, itensPedido3);
        pedido3.apresentarResumoPedido();

        // Pedido 4
        ItemPedido[] itensPedido4 = new ItemPedido[] {
            new ItemPedido(livro2, 1),
            new ItemPedido(livro2, 1),
            new ItemPedido(livro3, 2),
            new ItemPedido(dvd1, 1),
            new ItemPedido(dvd2, 2)
        };
        Pedido pedido4 = new Pedido(5, itensPedido4);
        pedido4.apresentarResumoPedido();
    }
}
