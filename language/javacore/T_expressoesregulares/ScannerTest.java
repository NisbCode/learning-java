package Estudando.javacore.T_expressoesregulares;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("1 true 100 oi");
//        Diferentemente da classe Token, a Scanner tem delimitador padrão o uso de espaços, vc pode alterar chamando um método:
//        scanner.useDelimiter("\\d")
        while (scanner.hasNext()) {   //Aq ele tá vendo se tem algo a frente p pegar usando o delimitador espaço branco
            System.out.println(scanner.next());  //N se preocupa q ele vai pegar o valor e transformar numa String
        }
        System.out.println("#############################");
        Scanner scanner2 = new Scanner("1 true 100 oi");
        while (scanner2.hasNext()) {     //Aq ele vê se tem um proximo
            if (scanner2.hasNextInt()) {   //Aq ele vê se o proximo é um tipo int(Tem vários tipos primitivos além desse)
                int i = scanner2.nextInt();
                System.out.println(i);
            } else if (scanner2.hasNextBoolean()) {
                boolean b = scanner2.nextBoolean();  //Aq ele vê se o proximo é um tipo boolean
                System.out.println(b);
            } else {
                System.out.println(scanner2.next());  //Aq ele vê se o proximo n é nenhum dos anteriores
            }
        }
    }
}