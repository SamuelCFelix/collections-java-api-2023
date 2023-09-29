package list.Ordenacao.OdenacaoDeNumeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Numeros> numerosList;

    public OrdenacaoNumeros() {
        this.numerosList = new ArrayList<>();
    }
    public void adicionarNumero(int numero){
        numerosList.add(new Numeros(numero));
    }
    public List<Numeros> ordenarAscendente(){
        List<Numeros> numerosOrganizadosAcendente = new ArrayList<>(numerosList);
        Collections.sort(numerosOrganizadosAcendente);
        return numerosOrganizadosAcendente;
    }
    public List<Numeros> ordenarDescendente(){
        List<Numeros> numerosOrganizadosDescendente = new ArrayList<>(numerosList);
        Collections.reverse(numerosOrganizadosDescendente);
        return numerosOrganizadosDescendente;
    }
    public List<Numeros> exibirNumeros(){
        return numerosList;
    }

    public static void main(String[] args) {
        // Criando uma instância da classe OrdenacaoNumeros
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();

        // Adicionando números à lista
        numeros.adicionarNumero(2);
        numeros.adicionarNumero(5);
        numeros.adicionarNumero(4);
        numeros.adicionarNumero(1);
        numeros.adicionarNumero(99);

        // Exibindo a lista de números adicionados
        System.out.println(numeros.exibirNumeros());

        // Ordenando e exibindo em ordem ascendente
        System.out.println(numeros.ordenarAscendente());

        // Ordenando e exibindo em ordem descendente
        System.out.println(numeros.ordenarDescendente());

    }
}
