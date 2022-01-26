/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package br.com.letscode;

import br.com.letscode.dominio.Pessoa;
import br.com.letscode.listas.listaligada.listaligada.ListaLigada;

public class App {
    public static void main(String[] args) {

        ListaLigada lista = new ListaLigada();

        lista.adicionar(new Pessoa("Jorge"));
        lista.listarTodos();

        lista.adicionar(new Pessoa("Maria"));
        lista.listarTodos();

        lista.adicionarNoComeco(new Pessoa("Carlos"));
        lista.listarTodos();

    }
}
