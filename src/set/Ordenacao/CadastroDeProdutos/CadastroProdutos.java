package set.Ordenacao.CadastroDeProdutos;

import set.Pesquisa.ListaDeTarefas.Tarefa;

import java.util.*;

public class CadastroProdutos {
    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }
    public void adicionarProduto(long id, String nome, double preco, int quantidade){
        produtoSet.add(new Produto(id,nome,preco,quantidade));
    }
    public Set<Produto> exibirProdutosPorNome(){
        Set<Produto> organizadosPorNome = new TreeSet<>(produtoSet);
        return organizadosPorNome;
    }
    public Set<Produto> exibirProdutosPorPreco(){
        Set<Produto> organizadosPorPreco = new TreeSet<>(new ComparatorOrganizarPorPreco());
        organizadosPorPreco.addAll(produtoSet);
        return organizadosPorPreco;
    }

    public static void main(String[] args) {
        // Criando uma instância do CadastroProdutos
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        // Adicionando produtos ao cadastro
        cadastroProdutos.adicionarProduto(1L, "Smartphone", 1000d, 10);
        cadastroProdutos.adicionarProduto(2L, "Notebook", 1500d, 5);
        cadastroProdutos.adicionarProduto(1L, "Mouse", 30d, 20);
        cadastroProdutos.adicionarProduto(4L, "Teclado", 50d, 15);

        // Exibindo todos os produtos no cadastro
        System.out.println(cadastroProdutos.produtoSet);

        // Exibindo produtos ordenados por nome
        System.out.println(cadastroProdutos.exibirProdutosPorNome());

        // Exibindo produtos ordenados por preço
        System.out.println(cadastroProdutos.exibirProdutosPorPreco());

    }
}
