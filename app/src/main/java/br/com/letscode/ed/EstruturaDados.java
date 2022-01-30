package br.com.letscode.ed;

import br.com.letscode.dominio.Pessoa;

public interface EstruturaDados {
    // LIST
    void adicionar(Pessoa pessoa);
    Pessoa buscar(String nome);
    void remover(Pessoa pessoa);
    void remover(int index);
    void listarTodos();
    Pessoa getPessoa(int index);
}
