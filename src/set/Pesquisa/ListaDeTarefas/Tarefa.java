package set.Pesquisa.ListaDeTarefas;

import java.util.Objects;

public class Tarefa {
    private String descricao;
    private boolean conluida = false;

    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa tarefa)) return false;
        return Objects.equals(descricao, tarefa.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao);
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConluida() {
        return conluida;
    }

    public void setConluida(boolean conluida) {
        this.conluida = conluida;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "descricao='" + descricao + '\'' +
                ", conluida=" + conluida +
                '}';
    }
}
