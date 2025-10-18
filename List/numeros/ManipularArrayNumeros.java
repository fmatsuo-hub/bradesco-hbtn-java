import java.util.*;

public class ManipularArrayNumeros {

    public static int buscarPosicaoNumero(List<Integer> numeros, int numero) {
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) == numero) {
                return i;
            }
        }
        return -1;
    }

    public static void adicionarNumero(List<Integer> numeros, int numero) {
        int posicao = buscarPosicaoNumero(numeros, numero);
        if (posicao != -1) {
            throw new IllegalArgumentException("Numero jah contido na lista");
        }
        numeros.add(numero);
    }

    public static void removerNumero(List<Integer> numeros, int numero) {
        int posicao = buscarPosicaoNumero(numeros, numero);
        if (posicao == -1) {
            throw new IllegalArgumentException("Numero nao encontrado na lista");
        }
        numeros.remove(posicao);
    }

    public static void substituirNumero(List<Integer> numeros, int numeroSubstituir, int numeroSubstituto) {
        int posicao = buscarPosicaoNumero(numeros, numeroSubstituir);
        if (posicao == -1) {
            numeros.add(numeroSubstituto);
        } else {
            numeros.set(posicao, numeroSubstituto);
        }
    }
}
