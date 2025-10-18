import java.io.*;
import java.util.*;

public class Estoque {
    private List<Produto> produtos;
    private String arquivo;
    private int proximoId;

    public Estoque(String arquivo) {
        this.arquivo = arquivo;
        this.produtos = new ArrayList<>();
        this.proximoId = 1;
        carregarEstoque();
    }

    public void carregarEstoque() {
        produtos.clear();
        
        File file = new File(arquivo);
        if (!file.exists()) {
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean primeiraLinha = true;
            
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue; // Pula o cabeçalho
                }
                
                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    try {
                        int id = Integer.parseInt(dados[0].trim());
                        String nome = dados[1].trim();
                        int quantidade = Integer.parseInt(dados[2].trim());
                        double preco = Double.parseDouble(dados[3].trim());
                        
                        produtos.add(new Produto(id, nome, quantidade, preco));
                        
                        if (id >= proximoId) {
                            proximoId = id + 1;
                        }
                    } catch (NumberFormatException e) {
                        //
                    }
                }
            }
        } catch (IOException e) {
            //
        }
    }

    public void salvarEstoque() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            // Escreve o cabeçalho
            writer.write("ID,Nome,Quantidade,Preco");
            writer.newLine();
            
            // Ordena por ID
            produtos.sort(Comparator.comparingInt(Produto::getId));
            
            // Escreve os produtos
            for (Produto produto : produtos) {
                writer.write(produto.toCsv());
                writer.newLine();
            }
        } catch (IOException e) {
            //
        }
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        if (quantidade < 0 || preco < 0) {
            return;
        }
        
        // Encontra o próximo ID
        int novoId = proximoId;
        boolean idExistente;
        do {
            idExistente = false;
            for (Produto p : produtos) {
                if (p.getId() == novoId) {
                    idExistente = true;
                    novoId++;
                    break;
                }
            }
        } while (idExistente);
        
        Produto novoProduto = new Produto(novoId, nome, quantidade, preco);
        produtos.add(novoProduto);
        proximoId = novoId + 1;
        salvarEstoque();
    }

    public void excluirProduto(int id) {
        boolean removido = produtos.removeIf(produto -> produto.getId() == id);
        if (removido) {
            salvarEstoque();
        }
    }

    public void exibirEstoque() {
        // Ordena por ID
        produtos.sort(Comparator.comparingInt(Produto::getId));
        
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        if (novaQuantidade < 0) {
            return;
        }
        
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.setQuantidade(novaQuantidade);
                salvarEstoque();
                return;
            }
        }
    }
}