package set.OperacoesBasicas.ConjuntoDePalavrasUnicas;

import java.util.Objects;

public class Palavras {
    private String palavra;

    public Palavras(String palavra) {
        this.palavra = palavra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Palavras palavras)) return false;
        return Objects.equals(getPalavra(), palavras.getPalavra());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPalavra());
    }

    public String getPalavra() {
        return palavra;
    }

    @Override
    public String toString() {
        return "{ Palavra= " + palavra + " }";
    }
}
