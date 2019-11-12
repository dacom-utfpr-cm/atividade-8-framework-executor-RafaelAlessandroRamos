package Atividade3;

import java.util.concurrent.Callable;

/**
 *
 * @author rafael
 */
public class MultiMatriz implements Callable<Integer> {

    int[][] matriz01;
    int[][] matriz02;
    int i;
    int j;
    int size;

    public MultiMatriz(int[][] matriz01, int[][] matriz02, int i, int j, int size) {
        this.matriz01 = matriz01;
        this.matriz02 = matriz02;
        this.i = i;
        this.j = j;
        this.size = size;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;

        for (int k = 0; k < this.size; k++) {
            sum += (this.matriz01[this.i][k] * this.matriz02[k][j]);
        }

        return sum;
    }
}
