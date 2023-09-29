package list.OperacoesBasicas.ListaDeTarefas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    private List<Tarefa> tarefaList;

    public ListaTarefas() {
        this.tarefaList = new ArrayList<>();
    }
    public void adicionarTarefa(String descricao){
        tarefaList.add(new Tarefa(descricao));
    }
    public void removerTarefa(String descricao){
        List<Tarefa> removerEssasTarefas = new ArrayList<>();
        boolean removido = false;
        if(!tarefaList.isEmpty()){
            for (Tarefa tarefa : tarefaList){
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)){
                    removerEssasTarefas.add(tarefa);
                    removido = true;
                }
            }
            if (removido){
                tarefaList.removeAll(removerEssasTarefas);
                System.out.print("\nTarefas Removidas\n");
            } else
                System.out.print("\nEssa Tarefa não está na sua Lista\n");
        } else
            System.out.print("\nA Lista de Tarefas está vazia\n");
    }
    public int obterNumeroTotalTarefas(){
        return tarefaList.size();
    }
    public void obterDescricoesTarefas(){
        int contador = 0;
        if (!tarefaList.isEmpty()){
            for (Tarefa tarefa : tarefaList){
                contador++;
                System.out.print("\nTarefa " + contador + " " + tarefa.toString());
            }
        } else
            System.out.print("\nA Lista de Tarefas está vazia\n");
    }

    public static void main(String[] args) {
        // Criando uma instância da classe ListaTarefa
        ListaTarefas listaTarefas = new ListaTarefas();

        // Adicionando tarefas à lista
        listaTarefas.adicionarTarefa("Comprar leite");
        listaTarefas.adicionarTarefa("Estudar para o exame");
        listaTarefas.adicionarTarefa("Fazer exercícios");

        // Exibindo o número total de tarefas na lista
        System.out.println("Você tem " + listaTarefas.obterNumeroTotalTarefas() + " tarefas na lista:");

        // Exibindo as descrições das tarefas na lista
        listaTarefas.obterDescricoesTarefas();

        // Removendo uma tarefa da lista
        listaTarefas.removerTarefa("Trabalhar");

        // Exibindo o número total de tarefas na lista após a remoção
        System.out.println("Agora você tem " + listaTarefas.obterNumeroTotalTarefas() + " tarefas na lista:");

        // Exibindo as descrições das tarefas atualizadas na lista
        listaTarefas.obterDescricoesTarefas();

        // Removendo uma tarefa da lista quando a lista está vazia
        listaTarefas.removerTarefa("Estudar para o exame");

        // Exibindo o número total de tarefas na lista após tentar remover de uma lista vazia
        System.out.println("Agora você tem " + listaTarefas.obterNumeroTotalTarefas() + " tarefas na lista:");
    }
}
