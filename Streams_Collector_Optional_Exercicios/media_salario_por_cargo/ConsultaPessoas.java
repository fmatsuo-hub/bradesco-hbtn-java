import java.util.*;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    public static Map<String, Double> obterMediaSalarioPorCargo(List<Pessoa> pessoas) {
        return pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,
                        Collectors.averagingDouble(Pessoa::getSalario)
                ));
    }
}
