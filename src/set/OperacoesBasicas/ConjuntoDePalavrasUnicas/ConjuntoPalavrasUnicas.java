package set.OperacoesBasicas.ConjuntoDePalavrasUnicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<Palavras> palavrasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasSet = new HashSet<>();
    }
    public void adicionarPalavra(String palavra){
        palavrasSet.add(new Palavras(palavra));
    }
    public void removerPalavra(String palavra){
        for (Palavras p : palavrasSet){
            if (p.getPalavra().equalsIgnoreCase(palavra)){
                palavrasSet.remove(p);
                System.out.print("\nA palavra " + p.getPalavra() + " foi removida!\n");
                break;
            }
        }
    }
    public void verificarPalavra(String palavra){
        boolean contem = false;
        for (Palavras p : palavrasSet){
            if (p.getPalavra().equalsIgnoreCase(palavra)){
                System.out.print("Essa palavra está presente no conjunto\n");
                contem = true;
                break;
            }
        }
        if(!contem){
            System.out.print("Essa palavra NÃO está presente no conjunto\n");
        }
    }
    public void exibirPalavrasUnicas(){
        System.out.print(palavrasSet);
    }

    public static void main(String[] args) {
        // Criando uma instância da classe ConjuntoPalavrasUnicas
        ConjuntoPalavrasUnicas conjuntoLinguagens = new ConjuntoPalavrasUnicas();

        // Adicionando linguagens únicas ao conjunto
        conjuntoLinguagens.adicionarPalavra("Java");
        conjuntoLinguagens.adicionarPalavra("Python");
        conjuntoLinguagens.adicionarPalavra("JavaScript");
        conjuntoLinguagens.adicionarPalavra("Python");
        conjuntoLinguagens.adicionarPalavra("C++");
        conjuntoLinguagens.adicionarPalavra("Ruby");

        // Exibindo as linguagens únicas no conjunto
        conjuntoLinguagens.exibirPalavrasUnicas();

        // Removendo uma linguagem do conjunto
        conjuntoLinguagens.removerPalavra("Python");
        conjuntoLinguagens.exibirPalavrasUnicas();

        // Removendo uma linguagem inexistente
        conjuntoLinguagens.removerPalavra("Swift");

        // Verificando se uma linguagem está no conjunto
        System.out.println("\nA linguagem 'Java' está no conjunto? ");
        conjuntoLinguagens.verificarPalavra("Java");
        System.out.println("A linguagem 'Python' está no conjunto? ");
        conjuntoLinguagens.verificarPalavra("Python");

        // Exibindo as linguagens únicas atualizadas no conjunto
        conjuntoLinguagens.exibirPalavrasUnicas();
    }
}
