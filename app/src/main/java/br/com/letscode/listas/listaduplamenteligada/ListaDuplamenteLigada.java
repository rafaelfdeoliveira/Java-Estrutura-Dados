package br.com.letscode.listas.listaduplamenteligada;

import br.com.letscode.dominio.Pessoa;
import br.com.letscode.ed.EstruturaDados;

public class ListaDuplamenteLigada implements EstruturaDados {

    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos = 0;

    @Override
    public void adicionar(Pessoa pessoa) {
        Celula nova = new Celula(pessoa);
        if (this.totalDeElementos == 0) {
            adicionarNoComeco(pessoa);
        } else {
            Celula ultimaCelula = this.ultima;
            ultimaCelula.setProximo(nova);
            nova.setAnterior(ultimaCelula);
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }

    public void adicionarNoComeco(Pessoa pessoa) {
        Celula nova = new Celula(pessoa);
        nova.setProximo(primeira);
        if (this.totalDeElementos == 0) {
            this.primeira.setAnterior(nova);
            this.primeira = nova;
        } else {
            this.primeira = nova;
            this.ultima = nova;
        }
        this.totalDeElementos++;
    }

    @Override
    public Pessoa buscar(String nome) {
        return null;
    }

    @Override
    public void remover(Pessoa pessoa) {

    }

    @Override
    public void remover(int index) {

    }

    @Override
    public void listarTodos() {
        if (this.totalDeElementos == 0) {
            System.out.println("[]");
            return;
        }

    }

    @Override
    public Pessoa getPessoa(int index) {
        return null;
    }
}
