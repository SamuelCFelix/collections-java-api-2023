package set.Ordenacao.ListaDeAlunos;

import java.util.Comparator;
import java.util.Objects;

public class Alunos implements Comparable<Alunos>{
    private String nome;
    private Long matricula;
    private double nota;

    public Alunos(String nome, Long matricula, double nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
    }
    @Override
    public int compareTo(Alunos a) {
        return nome.compareToIgnoreCase(a.getNome());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alunos alunos)) return false;
        return Objects.equals(matricula, alunos.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    public String getNome() {
        return nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Alunos{" +
                "nome='" + nome + '\'' +
                ", matricula=" + matricula +
                ", nota=" + nota +
                '}';
    }

}
class ComparatorPorNota implements Comparator<Alunos>{

    @Override
    public int compare(Alunos a1, Alunos a2) {
        return Double.compare(a1.getNota(), a2.getNota());
    }
}