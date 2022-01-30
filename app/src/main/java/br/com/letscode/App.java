/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package br.com.letscode;

import br.com.letscode.dominio.Pessoa;
import br.com.letscode.listas.listaligada.listaligada.ListaLigada;

public class App {
    public static void main(String[] args) {

//        ArrayList<>

        ListaLigada lista = new ListaLigada();

        lista.adicionar(new Pessoa("Jorge"));
        lista.listarTodos();

        Pessoa maria = new Pessoa("Maria");
        lista.adicionar(maria);
        lista.listarTodos();

        lista.adicionarNoComeco(new Pessoa("Carlos"));
        lista.listarTodos();

        lista.adicionar(new Pessoa("Rafael"));
        lista.listarTodos();

        lista.remover(maria);
        lista.listarTodos();

    }
}
