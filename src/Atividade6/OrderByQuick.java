package Atividade6;

import java.util.concurrent.Callable;

/**
 *
 * @author rafael
 */
public class OrderByQuick implements Callable<DVetor> {

    int[] vet;
    int ini;
    int fim;
    DVetor dadosVetor;

    public OrderByQuick(int[] v) {
        this.vet = v;
        this.ini = 0;
        this.fim = this.vet.length - 1;
        this.dadosVetor = new DVetor();
    }

    @Override
    public DVetor call() throws Exception {
        quickSort(this.vet, this.ini, this.fim);

        this.dadosVetor.setNomeFunc("QuickSort");
        this.dadosVetor.setVet(this.vet);
        return dadosVetor;
    }

    private static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
    }

    private static int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo) {
                i++;
            } else if (pivo < vetor[f]) {
                f--;
            } else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }
}
