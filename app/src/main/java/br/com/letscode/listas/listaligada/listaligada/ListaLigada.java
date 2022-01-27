package br.com.letscode.listas.listaligada.listaligada;

import br.com.letscode.dominio.Pessoa;
import br.com.letscode.ed.EstruturaDados;

public class ListaLigada implements EstruturaDados {

    private Celula primeiro;
    private Celula ultimo;
    private int totalDeElementos = 0;

    @Override
    public void adicionar(Pessoa pessoa) {
        if (this.totalDeElementos == 0) {
            adicionarNoComeco(pessoa);
        } else {
            Celula novaCelula = new Celula();
            novaCelula.setElemento(pessoa);
            novaCelula.setProximo(null);

            this.ultimo.setProximo(novaCelula);
            this.ultimo = novaCelula;
            this.totalDeElementos++;
        }
    }

    public void adicionar(Pessoa pessoa, int index) {
        if (this.totalDeElementos == 0) {
            adicionarNoComeco(pessoa);
            return;
        }
        if (!posicaoValida(index)) throw new RuntimeException("Posicao invalida");
        Celula novaCelula = new Celula();
        novaCelula.setElemento(pessoa);
        Celula celulaAnterior = getCelula(index - 1);
        novaCelula.setProximo(celulaAnterior.getProximo());
        celulaAnterior.setProximo(novaCelula);
        this.totalDeElementos++;
    }

    public void adicionarNoComeco(Pessoa pessoa) {
        Celula nova = new Celula();
        nova.setElemento(pessoa);
        nova.setProximo(primeiro);

        this.primeiro = nova;

        if (totalDeElementos == 0) {
            this.ultimo = primeiro;
        }
        this.totalDeElementos++;
    }

    private Celula getCelula(int posicao) {
        if (!posicaoValida(posicao)) throw new RuntimeException("Posicao invalida");
        Celula celula = primeiro;
        for (int i = 0; i <= posicao; i++) {
            celula = celula.getProximo();
        }
        return celula;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao < totalDeElementos;
    }

    @Override
    public Pessoa buscar(String nome) {
        if (totalDeElementos == 0) throw new RuntimeException("Nao ha pessoas na lista");
        Celula celula = primeiro;
        Celula celulaEncontrada = new Celula();
        for (int i = 0; i < totalDeElementos; i++) {
            if (celula.getElemento().getNome().equals(nome)) {
                celulaEncontrada = celula;
                break;
            }
            celula = celula.getProximo();
        }
        if (celula == null) throw new RuntimeException("Pessoa nao encontrada");
        return celulaEncontrada.getElemento();
    }

    @Override
    public void remover(Pessoa pessoa) {
        if (totalDeElementos == 0) throw new RuntimeException("Nao ha pessoas na Lista");
        Celula celula = primeiro;
        Celula celulaAnterior = null;
        for (int i = 0; i < totalDeElementos; i++) {
            if (celula.getElemento().equals(pessoa)) {
                if (i == 0) {
                    this.primeiro = celula.getProximo();
                } else {
                    celulaAnterior.setProximo(celula.getProximo());
                }
                this.totalDeElementos--;
                break;
            }
            celulaAnterior = celula;
            celula = celula.getProximo();
        }
        if (celula == null) throw new RuntimeException("Pessoa nao encontrada");
    }

    @Override
    public void remover(int posicao) {
        if (!posicaoValida(posicao)) throw new RuntimeException("Posicao invalida");
        if (posicao == 0) {
            this.primeiro = this.primeiro.getProximo();
        } else if (posicao == this.totalDeElementos - 1) {
            Celula penultimo = getCelula(posicao - 1);
            penultimo.setProximo(null);
            this.ultimo = penultimo;
        } else {
            Celula anterior = getCelula(posicao - 1);
            Celula atual = anterior.getProximo();
            Celula proximo = atual.getProximo();
            anterior.setProximo(proximo);
        }
        this.totalDeElementos--;
    }

    @Override
    public void listarTodos() {
        if (totalDeElementos == 0) {
            System.out.println("[]");
        } else {
            Celula atual = primeiro;
            StringBuilder builder = new StringBuilder("[");
            for (int i = 0 ; i < totalDeElementos ; i++) {
                builder.append(atual.getElemento());
                builder.append(",");

                atual = atual.getProximo();
            }
            builder.append("]");
            System.out.println(builder);
        }
    }

    @Override
    public Pessoa getPessoa(int index) {
        Celula celula = getCelula(index);
        return celula.getElemento();
    }
}
