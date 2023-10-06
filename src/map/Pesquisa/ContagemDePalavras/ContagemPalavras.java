package map.Pesquisa.ContagemDePalavras;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> contagemPalavrasMap;

    public ContagemPalavras() {
        this.contagemPalavrasMap = new HashMap<>();
    }
    public void adicionarPalavra(String palavra, Integer contagem){
        contagemPalavrasMap.put(palavra, contagem);
    }
    public void removerPalavra(String palavra){
        contagemPalavrasMap.remove(palavra);
    }
    public void exibirContagemPalavras(){
        System.out.print(contagemPalavrasMap);
    }
    public String encontrarPalavraMaisFrequente(){
        String maisFrequente = null;
        int quantidadeMaior = Integer.MIN_VALUE;
        for (String palavra : contagemPalavrasMap.keySet()){
            int quantidade = contagemPalavrasMap.get(palavra);
            if (quantidade > quantidadeMaior){
                quantidadeMaior = quantidade;
                maisFrequente = palavra;
            }
        }
        return maisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemLinguagens = new ContagemPalavras();

        // Adiciona linguagens e suas contagens
        contagemLinguagens.adicionarPalavra("Java", 2);
        contagemLinguagens.adicionarPalavra("Python", 8);
        contagemLinguagens.adicionarPalavra("JavaScript", 1);
        contagemLinguagens.adicionarPalavra("C#", 6);

        // Exibe a contagem total de linguagens
        contagemLinguagens.exibirContagemPalavras();

        // Encontra e exibe a linguagem mais frequente
        String linguagemMaisFrequente = contagemLinguagens.encontrarPalavraMaisFrequente();
        System.out.println("A linguagem mais frequente é: " + linguagemMaisFrequente);
    }
}
