package br.com.letscode.ordenacao;

public class BubbleSort implements AlgoritmoDeOrdenacao {
    @Override
    public void ordenar(int[] vetor) {
        for (int j = 0; j < vetor.length; j++) {
            for (int i = 0; i < vetor.length - 1 - j; i++) {
                if (vetor[i] > vetor[i+1]) {
                    int aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                }
            }
        }
    }
}
