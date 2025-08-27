import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    private Queue<Integer> fila = new LinkedList<>();
    private int capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
    }

    // Método para adicionar item na fila
    public synchronized void adicionar(int item) throws InterruptedException {
        while (fila.size() == capacidade) {
            wait(); // espera se a fila estiver cheia
        }

        fila.add(item);
        System.out.println("Produtor adicionou: " + item);

        notifyAll(); // Notifica consumidores que agora há item disponível
    }

    // Método para retirar item da fila
    public synchronized int retirar() throws InterruptedException {
        while (fila.isEmpty()) {
            wait(); // espera se a fila estiver vazia
        }

        int item = fila.poll();
        System.out.println("Consumidor retirou: " + item);

        notifyAll(); // Notifica produtores que agora há espaço disponível
        return item;
    }
}
