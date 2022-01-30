package br.com.letscode.listas.Conjunto;


import br.com.letscode.dominio.Pessoa;

public class TesteConjunto {

    public static void main(String[] args) {
        ConjuntoDePessoas conjunto = new ConjuntoDePessoas();
        Pessoa jorge = new Pessoa("Jorge");

        conjunto.adicionar(jorge);

    }
}
