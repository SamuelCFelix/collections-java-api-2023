package list.Pesquisa.CatálogoDeLivros;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livroList;

    public CatalogoLivros() {
        this.livroList = livroList = new ArrayList<>();
    }
    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        livroList.add(new Livro(titulo, autor, anoPublicacao));
    }
    public List<Livro> pesquisarPorAutor(String autor){
        List<Livro> livrosDoAutor = new ArrayList<>();
        boolean possuiEsseAutor = false;
        for (Livro livro : livroList){
            if (livro.getAutor().equalsIgnoreCase(autor)){
                livrosDoAutor.add(livro);
                possuiEsseAutor = true;
            }
        }
        if (possuiEsseAutor){
            return livrosDoAutor;
        } else
            System.out.print("\n Você não possui nenhum livro com esse autor\n");
        return livrosDoAutor = null;
    }
    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
        List<Livro> livrosEntreAnos = new ArrayList<>();
        boolean contemLivrosEntreAnos = false;
        for (Livro livro : livroList){
            if (livro.getAno() >= anoInicial && livro.getAno() <= anoFinal){
                livrosEntreAnos.add(livro);
                contemLivrosEntreAnos = true;
            }
        }
        if (contemLivrosEntreAnos){
            return livrosEntreAnos;
        } else
            System.out.print("\n Você não possui nenhum livro entre esses anos\n");
        return livrosEntreAnos = null;
    }
    public Livro pesquisarPorTitulo(String titulo){
        Livro pesquisadoPorTitulo = null;
        boolean pesquisaTitulo = false;
        for (Livro livro : livroList){
            if (livro.getTitulo().equalsIgnoreCase(titulo)){
                pesquisadoPorTitulo = livro;
                pesquisaTitulo = true;
                break;
            }
        }
        if (pesquisaTitulo){
            return pesquisadoPorTitulo;
        } else
            System.out.print("\n Você não possui nenhum livro com esse título\n");
        return pesquisadoPorTitulo;
    }

    public static void main(String[] args) {
        // Criando uma instância do catálogo de livros
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        // Adicionando livros ao catálogo
        catalogoLivros.adicionarLivro("Microsserviços Prontos Para a Produção", "Susan J. Fowler", 2017);
        catalogoLivros.adicionarLivro("Java Guia do Programador", "Peter Jandl Junior", 2021);
        catalogoLivros.adicionarLivro("Código Limpo", "Robert C. Martin", 2009);
        catalogoLivros.adicionarLivro("O Codificador Limpo", "Robert C. Martin", 2012);

        // Exibindo livros pelo mesmo autor
        System.out.println(catalogoLivros.pesquisarPorAutor("Robert C. Martin"));

        // Exibindo livros pelo mesmo autor (caso em que não há livros de um autor específico)
        System.out.println(catalogoLivros.pesquisarPorAutor("Autor Inexistente"));

        // Exibindo livros dentro de um intervalo de anos
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2010, 2022));

        // Exibindo livros dentro de um intervalo de anos (caso em que não há livros no intervalo)
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2025, 2030));

        // Exibindo livros por título
        System.out.println(catalogoLivros.pesquisarPorTitulo("Java Guia do Programador"));

        // Exibindo livros por título (caso em que não há livros com o título especificado)
        System.out.println(catalogoLivros.pesquisarPorTitulo("Título Inexistente"));
    }
}
