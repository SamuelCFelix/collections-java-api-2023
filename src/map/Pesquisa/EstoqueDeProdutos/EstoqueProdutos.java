package map.Pesquisa.EstoqueDeProdutos;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }
    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoqueProdutosMap.put(cod, new Produto(nome, quantidade, preco));
    }
    public void exibirProdutos(){
        System.out.print(estoqueProdutosMap);
    }
    public double calcularValorTotalEstoque(){
        double valorTotal = 0d;
        for (Produto p : estoqueProdutosMap.values()){
            valorTotal += p.getPreco() * p.getQuantidade();
        }
        return valorTotal;
    }
    public Produto obterProdutoMaisCaro(){
        double maiorValor = Double.MIN_VALUE;
        Produto produtoMaisCaro = null;
        for (Produto p : estoqueProdutosMap.values()){
            if (p.getPreco() > maiorValor){
                maiorValor = p.getPreco();
                produtoMaisCaro = p;
            }
        }
        return produtoMaisCaro;
    }
    public Produto obterProdutoMaisBarato(){
        double menorValor = Double.MAX_VALUE;
        Produto produtoMaisBarato = null;
        for (Produto p : estoqueProdutosMap.values()){
            if (p.getPreco() < menorValor){
                menorValor = p.getPreco();
                produtoMaisBarato = p;
            }
        }
        return produtoMaisBarato;
    }
    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        int maiorQuantidade = Integer.MIN_VALUE;
        double maiorValor = Double.MIN_VALUE;
        double valorTotal = 0d;
        Produto maiorQuantidadeValor = null;
        for (Produto p : estoqueProdutosMap.values()){
            valorTotal = p.getPreco() * p.getQuantidade();
            if (p.getQuantidade() > maiorQuantidade && valorTotal > maiorValor){
                maiorQuantidade = p.getQuantidade();
                maiorValor = valorTotal;
                maiorQuantidadeValor = p;
            }
        }
        return maiorQuantidadeValor;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();

        // Exibe o estoque vazio
        estoque.exibirProdutos();

        // Adiciona produtos ao estoque
        estoque.adicionarProduto(1L, "Notebook", 1, 1500.0);
        estoque.adicionarProduto(2L, "Mouse", 5, 25.0);
        estoque.adicionarProduto(3L, "Monitor", 10, 400.0);
        estoque.adicionarProduto(4L, "Teclado", 2, 40.0);

        // Exibe os produtos no estoque
        estoque.exibirProdutos();

        // Calcula e exibe o valor total do estoque
        System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());

        // Obtém e exibe o produto mais caro
        Produto produtoMaisCaro = estoque.obterProdutoMaisCaro();
        System.out.println("Produto mais caro: " + produtoMaisCaro);

        // Obtém e exibe o produto mais barato
        Produto produtoMaisBarato = estoque.obterProdutoMaisBarato();
        System.out.println("Produto mais barato: " + produtoMaisBarato);

        // Obtém e exibe o produto com a maior quantidade em valor no estoque
        Produto produtoMaiorQuantidadeValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
        System.out.println("Produto com maior quantidade em valor no estoque: " + produtoMaiorQuantidadeValorTotal);
    }
}
