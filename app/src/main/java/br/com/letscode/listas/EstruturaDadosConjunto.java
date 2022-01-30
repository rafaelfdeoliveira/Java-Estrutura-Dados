package br.com.letscode.listas;

import br.com.letscode.dominio.Pessoa;

public interface EstruturaDadosConjunto {
    // SET
    void adicionar(Pessoa pessoa);
    Pessoa buscar(String nome);
    void remover(Pessoa pessoa);
    void listarTodos();
}
