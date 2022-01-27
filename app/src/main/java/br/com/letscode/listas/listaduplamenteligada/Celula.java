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
}
