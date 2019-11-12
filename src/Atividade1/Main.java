/**
 * Faça um programa que localize o maior valor em um vetor. Divida o
 * programa em tarefas que localizam o maior valor em um segmento do
 * vetor. O programa deve possibilitar especificar o número de tarefas e o
 * número de threads para resolver o problema.
 * */
package Atividade1;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael
 */
public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        //Inicializar vetor
        int tamVet = Integer.parseInt(JOptionPane.showInputDialog("Tamanho do vetor: "));
        int[] vetor = new int[tamVet];

        for (int i = 0; i < tamVet; i++) {
            vetor[i] = random.nextInt(1000);
            System.out.println(vetor[i]);
        }

        //Inicializar matriz
        int sizeX, sizeY;
        sizeX = sizeY = Integer.parseInt(JOptionPane.showInputDialog("Tamanho da Matriz quadrada: "));
        int[][] matriz = new int[sizeY][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                matriz[i][j] = random.nextInt(10000);
            }
        }

        MaiorValor maiorValor = new MaiorValor(vetor, 10);
        maiorValor.procuraMaiorValor();
    }
}
