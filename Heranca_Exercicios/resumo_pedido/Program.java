public class Program {

    public static void main(String[] args) {
        Produto livro1 = new Livro("Duna", 64.74);
        Produto dvd1 = new Dvd("Annabelle 2 - A Criacao do Mal", 47.88);

        Produto livro2 = new Livro("Um de nos esta mentindo", 40.17);
        Produto livro3 = new Livro("Mindset Milionario", 36.46);
        Produto dvd2 = new Dvd("Anjos da Noite 5 - Guerras de Sangue", 20.28);

        // Pedido 1 (sem desconto)
        ItemPedido[] itensPedido1 = {
                new ItemPedido(livro1, 1),
                new ItemPedido(dvd1, 1)
        };
        Pedido pedido1 = new Pedido(0, itensPedido1);
        pedido1.apresentarResumoPedido();

        // Pedido 2 (10% desconto)
        ItemPedido[] itensPedido2 = {
                new ItemPedido(livro1, 1),
                new ItemPedido(dvd1, 1)
        };
        Pedido pedido2 = new Pedido(10, itensPedido2);
        pedido2.apresentarResumoPedido();

        // Pedido 3 (5% desconto)
        ItemPedido[] itensPedido3 = {
                new ItemPedido(livro2, 1),
                new ItemPedido(livro3, 2),
                new ItemPedido(dvd2, 1)
        };
        Pedido pedido3 = new Pedido(5, itensPedido3);
        pedido3.apresentarResumoPedido();

        // Pedido 4 (5% desconto)
        ItemPedido[] itensPedido4 = {
                new ItemPedido(livro2, 1),
                new ItemPedido(livro2, 1),
                new ItemPedido(livro3, 2),
                new ItemPedido(dvd2, 1),
                new ItemPedido(dvd1, 2)
        };
        Pedido pedido4 = new Pedido(5, itensPedido4);
        pedido4.apresentarResumoPedido();
    }
}
