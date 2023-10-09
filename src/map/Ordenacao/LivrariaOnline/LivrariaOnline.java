package map.Ordenacao.LivrariaOnline;

import map.Ordenacao.AgendaDeEventos.Evento;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livroMap;

    public LivrariaOnline() {
        this.livroMap = new HashMap<>();
    }
    public void adicionarLivro(String link, String titulo, String autor, double preco){
        livroMap.put(link, new Livro(titulo, autor, preco));
    }
    public void exibirLivros() {
        System.out.print(livroMap);
    }
    public void removerLivro(String titulo){
        Livro armazenarValue = null;
        String armazenarKey = null;
        for (Map.Entry<String, Livro> entry : livroMap.entrySet()){
            armazenarValue = entry.getValue();
            if (armazenarValue.getTitulo().equalsIgnoreCase(titulo)){
                armazenarKey = entry.getKey();
                livroMap.remove(armazenarKey);
                break;
            }
        }
    }
    public void exibirLivrosOrdenadosPorPreco(){
        List<Map.Entry<String, Livro>> listaOrdenada = new ArrayList<>(livroMap.entrySet());
        Collections.sort(listaOrdenada, new ComparatorPorPreco());
        for (Map.Entry<String,Livro> entry : listaOrdenada){
            String organizadoKey = entry.getKey();
            Livro organizadoValue = entry.getValue();
            System.out.println("Livro: " + organizadoValue.getTitulo() + "; Autor: " + organizadoValue.getAutor() + "; Valor: "+ organizadoValue.getPreco() + "\nLink: " + organizadoKey);
        }
    }
    public Map<String, Livro> pesquisarLivrosPorAutor(String autor){
        Map<String, Livro> livrosPorAutor = new HashMap<>();
        Livro livroDoAutor = null;
        String linkDoLivroAutor = null;
        for (Map.Entry<String, Livro> entry : livroMap.entrySet()){
            livroDoAutor = entry.getValue();
            if (livroDoAutor.getAutor().equalsIgnoreCase(autor)){
                linkDoLivroAutor = entry.getKey();
                livrosPorAutor.put(linkDoLivroAutor, livroDoAutor);
            }
        }
        return livrosPorAutor;
    }
    public Map<String, Livro> obterLivroMaisCaro(){
        Map<String, Livro> livroMaisCaro = new HashMap<>();
        Livro armazenarLivro = null;
        Livro armazenarLivroMaisCaro = null;
        String armazenarKey = null;
        double maisCaro = Double.MIN_VALUE;
        for (Map.Entry<String, Livro> entry : livroMap.entrySet()){
            armazenarLivro = entry.getValue();
            if (armazenarLivro.getPreco() > maisCaro){
                maisCaro = armazenarLivro.getPreco();
                armazenarLivroMaisCaro = entry.getValue();
                armazenarKey = entry.getKey();
            }
        }
        livroMaisCaro.put(armazenarKey, armazenarLivroMaisCaro);
        return livroMaisCaro;
    }
    public Map<String, Livro> obterLivroMaisBarato(){
        Map<String, Livro> livroMaisBarato = new HashMap<>();
        Livro armazenarLivro = null;
        Livro armazenarLivroMaisBarato = null;
        String armazenarKey = null;
        double maisBarato = Double.MAX_VALUE;
        for (Map.Entry<String, Livro> entry : livroMap.entrySet()){
            armazenarLivro = entry.getValue();
            if (armazenarLivro.getPreco() < maisBarato){
                maisBarato = armazenarLivro.getPreco();
                armazenarLivroMaisBarato = entry.getValue();
                armazenarKey = entry.getKey();
            }
        }
        livroMaisBarato.put(armazenarKey, armazenarLivroMaisBarato);
        return livroMaisBarato;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();
        // Adiciona os livros à livraria online
        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", "1984", "George Orwell", 50d);
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", "A Revolução dos Bichos", "George Orwell", 7.05d);
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", "Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d);
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", "Malorie", "Josh Malerman", 5d);
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", "E Não Sobrou Nenhum", "Agatha Christie", 50d);
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", "Assassinato no Expresso do Oriente", "Agatha Christie", 5d);

        // Exibe todos os livros ordenados por preço
        System.out.println("Livros ordenados por preço: \n");

        livrariaOnline.exibirLivrosOrdenadosPorPreco();

        // Pesquisa livros por autor
        String autorPesquisa = "Josh Malerman";
        System.out.print(livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa));

        // Obtém e exibe o livro mais caro
        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        // Obtém e exibe o livro mais barato
        System.out.println("Livro mais barato: " + livrariaOnline.obterLivroMaisBarato());

        // Remover um livro pelo título
        livrariaOnline.removerLivro("1984");

        livrariaOnline.exibirLivros();
    }
}
