package br.com.letscode.ordenacao;

public class InsertionSort implements AlgoritmoDeOrdenacao {
    @Override
    public void ordenar(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int aux = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > aux) {
                vetor[j-1] = vetor[j];
                j--;
            }
            vetor[j+1] = aux;
        }
    }
}
