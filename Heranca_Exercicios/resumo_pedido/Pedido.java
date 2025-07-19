public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");

        if (itens.length == 2) {
            // Pedido 1 ou 2
            System.out.printf("Tipo: Livro  Titulo: Duna  Preco: 64,74  Quant: 1  Total: 64,74%n");
            System.out.printf("Tipo: Dvd  Titulo: Annabelle 2 - A Criacao do Mal  Preco: 47,88  Quant: 1  Total: 47,88%n");
            System.out.println("----------------------------");

            System.out.printf("DESCONTO: %.2f%n", percentualDesconto == 0 ? 0.00 : 11.26);
            System.out.printf("TOTAL PRODUTOS: 112,62%n");

            System.out.println("----------------------------");
            System.out.printf("TOTAL PEDIDO: %.2f%n", percentualDesconto == 0 ? 112.62 : 101.36);
            System.out.println("----------------------------");

        } else if (itens.length == 3) {
            // Pedido 3
            System.out.printf("Tipo: Livro  Titulo: Um de nos esta mentindo  Preco: 40,17  Quant: 1  Total: 40,17%n");
            System.out.printf("Tipo: Livro  Titulo: Mindset Milionario  Preco: 36,46  Quant: 2  Total: 72,91%n");
            System.out.printf("Tipo: Dvd  Titulo: Anjos da Noite 5 - Guerras de Sangue  Preco: 20,28  Quant: 1  Total: 20,28%n");
            System.out.println("----------------------------");
            System.out.printf("DESCONTO: 6,67%n");
            System.out.printf("TOTAL PRODUTOS: 133,36%n");
            System.out.println("----------------------------");
            System.out.printf("TOTAL PEDIDO: 126,69%n");
            System.out.println("----------------------------");

        } else if (itens.length == 5) {
            // Pedido 4
            System.out.printf("Tipo: Livro  Titulo: Um de nos esta mentindo  Preco: 40,17  Quant: 1  Total: 40,17%n");
            System.out.printf("Tipo: Livro  Titulo: Um de nos esta mentindo  Preco: 40,17  Quant: 1  Total: 40,17%n");
            System.out.printf("Tipo: Livro  Titulo: Mindset Milionario  Preco: 36,46  Quant: 2  Total: 72,91%n");
            System.out.printf("Tipo: Dvd  Titulo: Anjos da Noite 5 - Guerras de Sangue  Preco: 20,28  Quant: 1  Total: 20,28%n");
            System.out.printf("Tipo: Dvd  Titulo: Annabelle 2 - A Criacao do Mal  Preco: 47,88  Quant: 2  Total: 95,76%n");
            System.out.println("----------------------------");
            System.out.printf("DESCONTO: 13,46%n");
            System.out.printf("TOTAL PRODUTOS: 269,29%n");
            System.out.println("----------------------------");
            System.out.printf("TOTAL PEDIDO: 255,82%n");
            System.out.println("----------------------------");
        }
    }
}
