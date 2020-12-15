package Estudando.javacore.S_datas;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest {
    public static void main(String[] args) {
        float valor = 212.456f;
        Locale locJP = new Locale("jp");
        Locale locFR = new Locale("fr");
        Locale locIT = new Locale("it");
        NumberFormat[] nfa = new NumberFormat[4];          //<--- Só tem "new" pq é um array
        nfa [0] = NumberFormat.getInstance();              //<--- Pega o número conforme o meu país escreve
        nfa [1] = NumberFormat.getInstance(locIT);         //<--- Pega o número conforme a Itália escreve
        nfa [2] = NumberFormat.getCurrencyInstance();      //<--- Pega o valor(dinheiro) conforme o meu país escreve com símbologia
        nfa [3] = NumberFormat.getCurrencyInstance(locIT); //<--- Pega o valor(dinheiro) conforme a Itália escreve com símbologia
        for(NumberFormat nf : nfa){
            System.out.println(nf.format(valor));
        }
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println(nf.getMaximumFractionDigits()); //<---Mostra o máximo de números dps da vírgula
        nf.setMaximumFractionDigits(1);                    //<---Muda o máximo de dígitos dps da vírgula
        System.out.println(nf.format(valor));
        String valorString = "212,4567";    //<---Os valores da web vem como String(Só avisando, vc usa vírgula aq,pq seu pc tá em pt
        try{
            System.out.println(nf.parse(valorString));     //<---Transforma o valor String no número em si(int/float)
            nf.setParseIntegerOnly(true);                  //<---Desconsidera os valores decimais
            System.out.println(nf.parse(valorString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}