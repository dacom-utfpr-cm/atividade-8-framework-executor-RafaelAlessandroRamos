package Atividade1;

import java.util.concurrent.Callable;

/**
 *
 * @author rafael
 */
public class SerachBigger implements Callable<Integer> {
    int inicio;
    int fim;
    int[] vetor;

    public SerachBigger(int inicio, int fim, int[] vetor) {
        this.inicio = inicio;
        this.fim = fim;
        this.vetor = vetor;
    }

    @Override
    public Integer call() throws Exception {
        int maiorVal = this.vetor[this.inicio];

        for(int i=(this.inicio+1); i<this.fim; i++){
            if(maiorVal <= this.vetor[i]){
                maiorVal = this.vetor[i];
            }
        }
        return maiorVal;
    }
}
