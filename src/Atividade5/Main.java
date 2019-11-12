/**
 * Faça um programa que possibilite agendar uma tarefa para ser executada
 *     em um horário especı́fico.
 */
package Atividade5;

import javax.swing.JOptionPane;

/**
 *
 * @author rafael
 */
public class Main {
    public static void main(String[] args) {
        Agenda agendar = new Agenda(Integer.parseInt(JOptionPane.showInputDialog("Tempo (s) para agendar tarefa: ")));
    }
}
