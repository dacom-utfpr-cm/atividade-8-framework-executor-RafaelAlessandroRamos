/**
 * Faça um programa que periodicamente monitore mudanças em um
 *     conjunto de arquivos especificados. Se ocorreram mudanças, o programa
 *     deve registrá-las em um arquivo de log.
 */
package Atividade4;

/**
 *
 * @author rafael
 */
public class Main {

    public static void main(String[] args) {
        Monitora monitora = new Monitora("src/Atividade4/arquivo.txt");
    }
}
