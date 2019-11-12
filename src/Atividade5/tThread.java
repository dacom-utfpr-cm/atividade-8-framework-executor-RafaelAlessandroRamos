package Atividade5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class tThread implements Runnable{

    @Override
    public void run() {
        int aux = 0;
        int max = 5;

        while (aux<max){
            System.out.println("Do nothing...");
            aux++;
            sleep(1000);
        }

        System.out.println("Fim Tarefa!");

    }

    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(tThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
