package Atividade6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public class Ordenacao {

    Collection<Callable<DVetor>> listTarefas;

    ExecutorService threadPool;
    int[] vet;

    public Ordenacao(int[] vetorInt) {
        this.listTarefas = new ArrayList<>();
        this.threadPool = Executors.newFixedThreadPool(3);
        this.vet = vetorInt;
    }

    public void init() {
        OrderByBubble bubble = new OrderByBubble(this.vet);
        OrderByHeap heap = new OrderByHeap(this.vet);
        OrderByQuick quick = new OrderByQuick(this.vet);

//        Future<Integer[]> future01 = this.threadPool.submit(bubb);
//        Future<Integer[]> future02 = this.threadPool.submit(heap);
//        Future<Integer[]> future03 = this.threadPool.submit(quick);
//
        this.listTarefas.add(bubble);
        this.listTarefas.add(heap);
        this.listTarefas.add(quick);

        DVetor dados = null;

        while (dados == null) {
            try {
                dados = this.threadPool.invokeAny(this.listTarefas);
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(Ordenacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Uma Tarefa Concluida!");
        System.out.println("Tipo da Busca: " + dados.getNomeFunc());

        for (int i = 0; i < dados.getVet().length; i++) {
            System.out.print(" " + dados.getVet()[i]);
        }

        this.threadPool.shutdown();
    }
}
