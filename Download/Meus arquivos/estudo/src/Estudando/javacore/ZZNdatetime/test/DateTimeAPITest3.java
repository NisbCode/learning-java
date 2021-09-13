package Estudando.javacore.ZZNdatetime.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * Created by William Suane on 2/17/2017.
 */
public class DateTimeAPITest3 {
    public static void main(String[] args) {


        /**
         * FORMAS DE MODIFICAR AS DATAS DURNATE O PROJETO
         */

        LocalDate localDate = LocalDate.of(2017, Month.FEBRUARY,25);  //Data em questão
        System.out.println(localDate);
        localDate = localDate.withYear(2020);                                          //Sim, orbigatório ele criar outra variável
        System.out.println(localDate);
        localDate = localDate.withMonth(Month.AUGUST.getValue());                      //Ele precisa q pegue o valor pq ele n entende só a instancia do mês
        System.out.println(localDate);
        localDate = localDate.withDayOfMonth(20);
        System.out.println(localDate);
        localDate = localDate.with(ChronoField.DAY_OF_MONTH, 15);            //Tome cuidado ao usar essa forma pois nem sempre suporta, pode ter uma exception
        System.out.println(localDate);

        /**
         * FORMAS DE SOMAR AS MODIFICAÇÕES DAS DATAS DURNATE O PROJETO
         */

        localDate = localDate.plusMonths(5);                             //Soma 5 meses
        System.out.println(localDate);
        localDate = localDate.plus(2, ChronoUnit.MONTHS);   //Cuidado aq, a sintaxe troca quando se adiciona, 1 a quantidade
        System.out.println(localDate);
        localDate = localDate.plusMonths(2).minusDays(20);               //Somou 2 meses e tira 20 dias
        System.out.println(localDate);


        //MESMA COISA DO ANTERIOR
        LocalTime time = LocalTime.now();
        System.out.println(time);
        time = time.withHour(10);
        System.out.println(time);
        time = time.plusHours(15);
        System.out.println(time);
        time = time.plusHours(5).minusMinutes(30);
        System.out.println(time);

    }
}
