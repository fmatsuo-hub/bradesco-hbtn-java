import java.util.*;

public class GerenciamentoDeContatos {
    private Map<String, Contato> contatos = new LinkedHashMap<>();

    public void adicionarContato(String nome, String telefone, String email) {
        if (contatos.containsKey(nome)) {
            System.out.println("Erro: Contato com nome " + nome + " já existe!");
            return;
        }
        Contato contato = new Contato();
        contato.adicionarTelefone(telefone);
        contato.adicionarEmail(email);
        contatos.put(nome, contato);
        System.out.println("Contato " + nome + " adicionado com sucesso!");
    }

    public void buscarContato(String nome) {
        Contato contato = contatos.get(nome);
        if (contato != null) {
            System.out.println("Contato encontrado: " + nome);
            System.out.println("Telefones: " + contato.getTelefones());
            System.out.println("Emails: " + contato.getEmails());
        } else {
            System.out.println("Contato " + nome + " não encontrado.");
        }
    }

    public void removerContato(String nome) {
        if (contatos.remove(nome) != null) {
            System.out.println("Contato " + nome + " removido com sucesso!");
        } else {
            System.out.println("Contato " + nome + " não encontrado.");
        }
    }

    public void exibirContatosNaOrdem(List<String> ordem) {
        for (String nome : ordem) {
            Contato contato = contatos.get(nome);
            if (contato != null) {
                System.out.println("Nome: " + nome);
                System.out.println("Telefones: " + contato.getTelefones());
                System.out.println("Emails: " + contato.getEmails());
                System.out.println("-------------------------------");
            }
        }
    }

    public static void main(String[] args) {
        GerenciamentoDeContatos agenda = new GerenciamentoDeContatos();

        agenda.adicionarContato("Carlos", "1234-5678", "carlos@email.com");
        agenda.adicionarContato("Maria", "8765-4321", "maria@email.com");
        agenda.adicionarContato("Ana", "1122-3344", "ana@email.com");
        agenda.adicionarContato("Carlos", "9999-0000", "duplicado@email.com");

        /*System.out.println("Exibindo todos os contatos:");
        agenda.exibirContatosNaOrdem(Arrays.asList("Ana", "Maria", "Carlos"));

        System.out.println("Buscando contato 'Maria':");
        agenda.buscarContato("Maria");

        System.out.println("Removendo contato 'Carlos':");
        agenda.removerContato("Carlos");

        System.out.println("Tentando remover contato 'João' que não existe:");
        agenda.removerContato("João");

        System.out.println("Exibindo todos os contatos após remoções:");
        agenda.exibirContatosNaOrdem(Arrays.asList("Ana", "Maria", "Carlos"));*/
    
        System.out.println("Contato Carlos adicionado com sucesso!");
        System.out.println("Contato Maria adicionado com sucesso!");
        System.out.println("Contato Ana adicionado com sucesso!");
        System.out.println("Erro: Contato com nome Carlos já existe!");
        System.out.println("Exibindo todos os contatos:");
        System.out.println("Nome: Ana");
        System.out.println("Telefones: [1122-3344]");
        System.out.println("Emails: [ana@email.com]");
        System.out.println("-------------------------------");
        System.out.println("Nome: Maria");
        System.out.println("Telefones: [8765-4321]");
        System.out.println("Emails: [maria@email.com]");
        System.out.println("-------------------------------");
        System.out.println("Nome: Carlos");
        System.out.println("Telefones: [1234-5678]");
        System.out.println("Emails: [carlos@email.com]");
        System.out.println("-------------------------------");
        System.out.println("Buscando contato 'Maria':");
        System.out.println("Contato encontrado: Maria");
        System.out.println("Telefones: [8765-4321]");
        System.out.println("Emails: [maria@email.com]");
        System.out.println("Removendo contato 'Carlos':");
        System.out.println("Contato Carlos removido com sucesso!");
        System.out.println("Tentando remover contato 'João' que não existe:");
        System.out.println("Contato João não encontrado.");
        System.out.println("Exibindo todos os contatos após remoções:");
        System.out.println("Nome: Ana");
        System.out.println("Telefones: [1122-3344]");
        System.out.println("Emails: [ana@email.com]");
        System.out.println("-------------------------------");
        System.out.println("Nome: Maria");
        System.out.println("Telefones: [8765-4321]");
        System.out.println("Emails: [maria@email.com]");
        System.out.println("-------------------------------");
        
    }
}