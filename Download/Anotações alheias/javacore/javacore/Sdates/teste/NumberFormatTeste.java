package br.com.abc.javacore.Sdates.teste;

import java.text.NumberFormat;
import java.util.Locale;

/***
 * CLASSE NUMBERFORMAT
 */

public class NumberFormatTeste {
    public static void main(String[] args) {
        float valor = 12.555555559f;
        Locale locJP = new Locale("jp");
        Locale locBR = new Locale("pt", "BR");
        NumberFormat[] numberFormatArray = new NumberFormat[4];
        numberFormatArray[0] = NumberFormat.getInstance();
        numberFormatArray[1] = NumberFormat.getInstance(locBR);
        numberFormatArray[2] = NumberFormat.getCurrencyInstance();
        numberFormatArray[3] = NumberFormat.getCurrencyInstance(locBR);
        for (NumberFormat numberFormat : numberFormatArray) {
            //para cada item impresso desse array, imprima
            //ele com as configurações do item do momento
            System.out.println(numberFormat.format(valor));
        }

        //Para mudar a quantidade de numeros decimais exibidos
        NumberFormat mudandoCasasDecimais = NumberFormat.getInstance();
        mudandoCasasDecimais.setMaximumFractionDigits(1);
        System.out.println(mudandoCasasDecimais.format(valor));

        

    }
}
