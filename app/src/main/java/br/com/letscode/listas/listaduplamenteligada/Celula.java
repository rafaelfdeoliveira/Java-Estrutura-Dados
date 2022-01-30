package br.com.letscode.listas.listaduplamenteligada;

import br.com.letscode.dominio.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Celula {
    private Pessoa elemento;
    private Celula proximo;
    private Celula anterior;

    public Celula (Pessoa elemento) {
        this.elemento = elemento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        br.com.letscode.listas.listaligada.listaligada.Celula objeto = (br.com.letscode.listas.listaligada.listaligada.Celula) o;
        return this.elemento.equals(objeto.getElemento());
    }
}
