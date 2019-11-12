package Atividade1;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public class MaiorValor {

    int[] vetor;
    int numThreads;

    ArrayList<Future<Integer>> tarefas;
    ExecutorService threadPool;

    public MaiorValor(int[] vetor, int numThreads) {
        this.vetor = vetor;
        this.numThreads = numThreads;

        this.tarefas = new ArrayList<>();
        this.threadPool = Executors.newFixedThreadPool(numThreads);

    }

    public void procuraMaiorValor() {
        int first_Posi = 0;
        int last_Posi = this.vetor.length / this.numThreads;

        while (last_Posi <= this.vetor.length) {
            SerachBigger tarefa = new SerachBigger(first_Posi, last_Posi, this.vetor);

            Future<Integer> future = this.threadPool.submit(tarefa);
            this.tarefas.add(future);

            first_Posi = last_Posi;
            last_Posi += last_Posi;
        }

        System.out.println("Executando ...");
        for (Future<Integer> ft : this.tarefas) {
            while (!ft.isDone()) {
                System.out.print(".");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MaiorValor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        int maxValue;
        try {
            maxValue = this.tarefas.get(0).get();
            for (Future<Integer> ft : this.tarefas) {
                if (maxValue < ft.get()) {
                    maxValue = ft.get();
                }
            }
        } catch (InterruptedException | ExecutionException ex) {
            maxValue = -9999999;
            Logger.getLogger(MaiorValor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Maior Valor: " + maxValue);
        this.threadPool.shutdown();
    }

}
