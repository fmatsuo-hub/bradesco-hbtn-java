import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class Pessoa implements Comparable<Pessoa> {
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
    }

    public int getCodigo() { 
        return codigo; 
    }
    
    public String getNome() { 
        return nome; 
    }
    
    public String getCargo() { 
        return cargo; 
    }
    
    public int getIdade() { 
        return idade; 
    }
    
    public double getSalario() { 
        return salario; 
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        nf.setGroupingUsed(false);
        nf.setMinimumFractionDigits(6);
        nf.setMaximumFractionDigits(6);

        return String.format("[%d] %s %s %d R$ %s",
                codigo, nome, cargo, idade, nf.format(salario));
    }

    @Override
    public int compareTo(Pessoa outra) {
        return this.nome.compareTo(outra.nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return codigo == pessoa.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
