package Atividade5;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public class Agenda {

    ScheduledExecutorService executor;
    ScheduledFuture scheduleFuture;
    int timeSeconds;
    tThread task;

    public Agenda(int timeSeconds) {
        this.timeSeconds = timeSeconds;
        this.executor = Executors.newScheduledThreadPool(1);
        this.task = new tThread();

        System.out.println("Tarefa Agendada para daqui " + timeSeconds + "s");
        this.scheduleFuture = this.executor.schedule(this.task, timeSeconds, TimeUnit.SECONDS);

        while (!this.scheduleFuture.isDone()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Fim Principal");
        this.executor.shutdown();
    }

}
