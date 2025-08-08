import java.util.*;

public class Blog {
    private List<Post> postagens = new ArrayList<>();

    public void adicionarPostagem(Post post) {
        if (postagens.contains(post)) {
            throw new RuntimeException("Postagem já existente");
        }
        postagens.add(post);
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post post : postagens) {
            autores.add(post.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new HashMap<>();
        for (Post post : postagens) {
            Categorias cat = post.getCategoria();
            contagem.put(cat, contagem.getOrDefault(cat, 0) + 1);
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> resultado = new TreeSet<>();
        for (Post post : postagens) {
            if (post.getAutor().equals(autor)) {
                resultado.add(post);
            }
        }
        return resultado;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> resultado = new TreeSet<>();
        for (Post post : postagens) {
            if (post.getCategoria() == categoria) {
                resultado.add(post);
            }
        }
        return resultado;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> mapa = new HashMap<>();
        for (Post post : postagens) {
            mapa.computeIfAbsent(post.getCategoria(), k -> new TreeSet<>()).add(post);
        }
        return mapa;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> mapa = new HashMap<>();
        for (Post post : postagens) {
            mapa.computeIfAbsent(post.getAutor(), k -> new TreeSet<>()).add(post);
        }
        return mapa;
    }
}
