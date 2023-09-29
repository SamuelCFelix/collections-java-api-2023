package list.OperacoesBasicas.CarrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> carrinho;

    public CarrinhoDeCompras(){
        this.carrinho = new ArrayList<>();
    }
    public void adicionarItem(String nome, double preco, int quantidade){
        carrinho.add(new Item(nome,preco,quantidade));
    }
    public void removerItem(String nome){
        List<Item> removerEssesItens = new ArrayList<>();
        if(carrinho.isEmpty()){
            System.out.println("O carrinho está vazio!");
        }else{
            for (Item item : carrinho){
                if (item.getNome().equalsIgnoreCase(nome)){
                    removerEssesItens.add(item);
                }
            }
            carrinho.removeAll(removerEssesItens);
        }
    }
    public void calcularValorTotal(){
        double somarTotal = 0;
        for (Item item : carrinho){
            double valor = item.getPreco() * item.getQuantidade();
            somarTotal = somarTotal + valor;
        }
        System.out.println("O valor no carrinho de compra é de R$ " + somarTotal);
    }
    private int quantidadeDeItens(){
        return carrinho.size();
    }
    public void exibirItens(){
        int contador = 0;
        for (Item item : carrinho){
            contador++;
            System.out.println("Item " + contador + "\n" + item.toString() + "\n");
        }
        System.out.println("\nTotal de Itens: " + quantidadeDeItens() + "\n\n");
    }

    public static void main(String[] args) {
        // Criando uma instância do carrinho de compras
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        // Adicionando itens ao carrinho
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Caderno", 35d, 1);
        carrinhoDeCompras.adicionarItem("Borracha", 2d, 2);

        // Exibindo os itens no carrinho
        carrinhoDeCompras.exibirItens();

        // Removendo um item do carrinho
        carrinhoDeCompras.removerItem("Lápis");

        // Exibindo os itens atualizados no carrinho
        carrinhoDeCompras.exibirItens();

        // Calculando e exibindo o valor total da compra
        carrinhoDeCompras.calcularValorTotal();
    }
}
