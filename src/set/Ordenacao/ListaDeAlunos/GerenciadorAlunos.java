package set.Ordenacao.ListaDeAlunos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Alunos> alunosSet;

    public GerenciadorAlunos() {
        this.alunosSet = new HashSet<>();
    }
    public void adicionarAluno(String nome, Long matricula, double media){
        alunosSet.add(new Alunos(nome, matricula, media));
    }
    public void removerAluno(long matricula){
        for (Alunos a : alunosSet){
            if (a.getMatricula() == matricula){
                alunosSet.remove(a);
                break;
            }
        }
    }
    public Set<Alunos> exibirAlunosPorNome(){
        Set<Alunos> organizadosPorNome = new TreeSet<>(alunosSet);
        return organizadosPorNome;
    }
    public Set<Alunos> exibirAlunosPorNota(){
        Set<Alunos> organizadosPorNota = new TreeSet<>(new ComparatorPorNota());
        organizadosPorNota.addAll(alunosSet);
        return organizadosPorNota;
    }
    public void exibirAlunos(){
        System.out.print(alunosSet);
    }

    public static void main(String[] args) {
        // Criando uma instância do GerenciadorAlunos
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        // Adicionando alunos ao gerenciador
        gerenciadorAlunos.adicionarAluno("João", 123456L, 7.5);
        gerenciadorAlunos.adicionarAluno("Maria", 123457L, 9.0);
        gerenciadorAlunos.adicionarAluno("Carlos", 123458L, 5.0);
        gerenciadorAlunos.adicionarAluno("Ana", 123459L, 6.8);

        // Exibindo todos os alunos no gerenciador
        System.out.println("Alunos no gerenciador:");
        System.out.println(gerenciadorAlunos.alunosSet);

        // Removendo um aluno com matrícula inválida e outro pelo número de matrícula
        gerenciadorAlunos.removerAluno(000L);
        gerenciadorAlunos.removerAluno(123457L);
        System.out.println(gerenciadorAlunos.alunosSet);

        // Exibindo alunos ordenados por nome
        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());

        // Exibindo alunos ordenados por nota
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());
    }
}
