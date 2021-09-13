package br.com.abc.javacore.Sdates.teste;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/***
 * CLASSE DATE FORMAT
 * 6 formas diferentes de formatar uma data
 */

public class DateFormatTeste {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        DateFormat[] formasDeFormatacao = new DateFormat[6];
        //18/01/19 19:53
        formasDeFormatacao[0] = DateFormat.getInstance();
        //18-Jan-2019
        formasDeFormatacao[1] = DateFormat.getDateInstance();
        //Estilos do item anterior
        //18/01/19
        formasDeFormatacao[2] = DateFormat.getDateInstance(DateFormat.SHORT);
        //18-Jan-2019
        formasDeFormatacao[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        //18 January 2019
        formasDeFormatacao[4] = DateFormat.getDateInstance(DateFormat.LONG);
        //Friday, 18 January 2019
        formasDeFormatacao[5] = DateFormat.getDateInstance(DateFormat.FULL);

        for(DateFormat item : formasDeFormatacao){
            //método format permite formatar a data
            System.out.println(item.format(calendar.getTime()));
        }

    }
}
