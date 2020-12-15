package Estudando.javacore.ZZNdatetime.test;


import Estudando.javacore.ZZNdatetime.util.ObterProximoDiaUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by William Suane on 2/21/2017.
 */
public class DateTimeAPITest4 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));   //Pega a proxima terça, mas se vc tiver em uma, ele pega hj
        System.out.println(date);                                            //Pega a data
        System.out.println(date.getDayOfWeek());                             //Pega o dia da semana

        date = date.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));         //Pega a próxima sexta ignorando se hj for uma
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.previous(DayOfWeek.TUESDAY));     //Pega a terça anterior ignorando se hj for
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.firstDayOfMonth());               //Pega 1 dia do mês
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.lastDayOfMonth());               //Pega ultimo dia do mês
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.firstDayOfNextYear());           //Pega 1 dia do prox ano
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        /**
         * Caso queira apenas os dias uteis, TU Q CRIE A CLASSE, vai lá em ObterProximoDiaUtil, criado manualmente p ver cm faz
         */

        date = date.with(new ObterProximoDiaUtil());
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.plusDays(4);
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(new ObterProximoDiaUtil());
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

    }
}
