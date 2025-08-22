import java.util.*;
import java.util.stream.Collectors;

public class ConsultaPessoas {
    public static Map<String, Long> obterContagemPessoasPorCargo(List<Pessoa> pessoas) {
        return pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,
                        Collectors.counting()
                ));
    }
}
