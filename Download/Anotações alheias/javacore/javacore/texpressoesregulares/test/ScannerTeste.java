package br.com.abc.javacore.texpressoesregulares.test;

import java.util.Scanner;

/***
 * CLASSE SCANNER:
 * Funciona da mesma forma que os tokens, mas
 * é feita uma conversão automatica dos dados para
 * String
 */

public class ScannerTeste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("1 true 100 oi");

        //O mesmo que fizemos na classe de Token, mas automatizado
        // com métodos:
        //"Enquanto o scanner tiver algum próximo item,...
        while (scanner.hasNext()) {
            //...imprima o próximo item"
            System.out.println(scanner.next());
        }

        System.out.println("####################################");
        Scanner scanner2 = new Scanner("1 true 100 oi");
        while (scanner2.hasNext()) {
            if (scanner2.hasNextInt()) {
                int numero = scanner2.nextInt();
                System.out.println("int " + numero);
            } else if (scanner2.hasNextBoolean()) {
                boolean b = scanner2.nextBoolean();
                System.out.println(b);
            } else {
                System.out.println(scanner2.next());
            }

            // Por padrão o delimitador da classe Scanner é o espaço,
            // para trocar, é só usar o seguinte método:
//        scanner.useDelimiter();
        }
    }
}
