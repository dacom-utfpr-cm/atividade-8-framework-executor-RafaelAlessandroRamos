package Atividade4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author rafael
 */
public class Monitora {

    private final ScheduledExecutorService executor;
    private final ScheduledFuture scheduledFuture;
    private final Thread_CheckInte task;
    private String md5_Check_Old;
    private String md5_Check_New;

    public Monitora(String local) {
        this.executor = Executors.newScheduledThreadPool(1);
        this.task = new Thread_CheckInte(local, this);

        this.scheduledFuture = this.executor.scheduleAtFixedRate(this.task, 3, 2, TimeUnit.SECONDS);
    }

    public String getMd5_Check_New() {
        return md5_Check_New;
    }

    public void setMd5_Check_New(String md5_Check) {
        this.md5_Check_New = md5_Check;
    }

    public String getMd5_Check_Old() {
        return md5_Check_Old;
    }

    public void setMd5_Check_Old(String md5_Check_Old) {
        this.md5_Check_Old = md5_Check_Old;
    }

}
