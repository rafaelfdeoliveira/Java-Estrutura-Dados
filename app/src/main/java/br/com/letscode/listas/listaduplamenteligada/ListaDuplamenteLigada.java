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
            this.ultima.setProximo(nova);
            nova.setAnterior(this.ultima);
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
        Celula celula = this.primeira;
        for (int i = 0; i < totalDeElementos; i++) {
            if (celula.getElemento().getNome().equals(nome)) return celula.getElemento();
            celula = celula.getProximo();
        }
        throw new RuntimeException("Nenhuma pessoa chamada " + nome + " foi encontrada!");
    }

    @Override
    public void remover(Pessoa pessoa) {
        if (this.primeira.getElemento().equals(pessoa) || this.totalDeElementos == 0) {
            removerNoComeco();
            return;
        }
        if (this.ultima.getElemento().equals(pessoa)) {
            removerNoFinal();
            return;
        }
        Celula celula = this.primeira.getProximo();
        for (int i = 1; i < totalDeElementos; i++) {
            if (celula.getElemento().equals(pessoa)) {
                remover(celula);
                return;
            }
            celula = celula.getProximo();
        }
        throw new RuntimeException("Pessoa não encontrada para ser removida da lista!");
    }

    @Override
    public void remover(int index) {
        if (!isValidIndex(index)) throw new RuntimeException("Index inválido!");
        if (index == 0 || this.totalDeElementos == 0) {
            removerNoComeco();
            return;
        }
        if (index == this.totalDeElementos - 1) {
            removerNoFinal();
            return;
        }
        if (index < this.totalDeElementos / 2) {
            Celula celula = this.primeira.getProximo();
            for (int i = 1; i < this.totalDeElementos; i++) {
                if (index == i) {
                    remover(celula);
                    return;
                }
                celula = celula.getProximo();
            }
        } else {
            Celula celula = this.ultima;
            for (int i = this.totalDeElementos - 2; i > 0; i--) {
                if (index == i) {
                    remover(celula);
                    return;
                }
                celula = celula.getAnterior();
            }
        }
    }

    private void remover(Celula celula) {
        celula.getAnterior().setProximo(celula.getProximo());
        celula.getProximo().setAnterior(celula.getAnterior());
        this.totalDeElementos--;
    }

    public boolean isValidIndex(int index) { return index >= 0 && index < this.totalDeElementos;}

    public void removerNoFinal() {
        if (this.totalDeElementos == 0) throw new RuntimeException("Não há pessoas na lista!");
        this.ultima = this.ultima.getAnterior();
        this.totalDeElementos--;
        if (this.totalDeElementos == 0) {
            this.primeira = null;
            return;
        }
        this.ultima.setProximo(null);
    }

    public void removerNoComeco() {
        if (this.totalDeElementos == 0) throw new RuntimeException("Não há pessoas na lista!");
        this.primeira = this.primeira.getProximo();
        this.totalDeElementos--;
        if (this.totalDeElementos == 0) {
            this.ultima = null;
            return;
        }
        this.primeira.setAnterior(null);
    }

    @Override
    public void listarTodos() {
        if (this.totalDeElementos == 0) {
            System.out.println("[]");
            return;
        }
        Celula atual = this.primeira;
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0 ; i < this.totalDeElementos ; i++) {
            builder.append(atual.getElemento());
            builder.append(",");

            atual = atual.getProximo();
        }
        builder.append("]");
        System.out.println(builder);
    }

    @Override
    public Pessoa getPessoa(int index) {
        if (!isValidIndex(index)) throw new RuntimeException("Index inválido!");
        if (index < this.totalDeElementos / 2) {
            Celula celula = this.primeira;
            for (int i = 0; i < this.totalDeElementos; i++) {
                if (index == i) return celula.getElemento();
                celula = celula.getProximo();
            }
        } else {
            Celula celula = this.ultima;
            for (int i = this.totalDeElementos - 1; i >= 0; i--) {
                if (index == i) return celula.getElemento();
                celula = celula.getAnterior();
            }
        }
        return null;
    }
}
