package Atividade6;

import java.util.concurrent.Callable;

/**
 *
 * @author rafael
 */
public class OrderByBubble implements Callable<DVetor> {

    int[] v;
    DVetor dadosVetor;

    public OrderByBubble(int[] vet) {
        this.v = vet;
        this.dadosVetor = new DVetor();
    }

    @Override
    public DVetor call() throws Exception {

        for (int i = v.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (v[j - 1] > v[j]) {
                    int aux = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = aux;
                }
            }
        }

        this.dadosVetor.setNomeFunc("BubbleSort");
        this.dadosVetor.setVet(this.v);
        return this.dadosVetor;
    }
}
