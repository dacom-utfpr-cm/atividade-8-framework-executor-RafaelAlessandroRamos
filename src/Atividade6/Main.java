/**
 * Faça um programa que execute três algoritmos de ordenação para um
 *     conjunto de valores e exiba o resultado apenas do algoritmo que finalizar
 *     primeiro (use invokeAny ).
 */
package Atividade6;

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
        
        Ordenacao ordenacao = new Ordenacao(vetor);
        ordenacao.init();
    }
}
