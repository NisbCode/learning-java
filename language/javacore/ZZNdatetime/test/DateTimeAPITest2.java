package Estudando.javacore.ZZNdatetime.test;


import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by William Suane on 2/15/2017.
 */
public class DateTimeAPITest2 {
    public static void main(String[] args) {
        Instant instant = Instant.now();                                                        //Criando objeto
        System.out.println(instant);                                                            //Trabalha com o tempo do UTC ou seja, universal
        System.out.println(LocalDateTime.now());                                                //Trabalha com o tempo do seu pc
        System.out.println(instant.getEpochSecond());                                           //Para dividir e não pesar o trabalho de memória de uma data longa, ele dividiu em dois, esse método pega os segundos
        System.out.println(instant.getNano());                                                  //E esse pega os nano segundos tendo como maior valor 999.999.999
        System.out.println(Instant.ofEpochSecond(3));                                           //Adiciona 3 segundos ao valor do limite inicial da contagem
        System.out.println(Instant.ofEpochSecond(3,0));              //Também possui ajuste de nano segundos
        System.out.println(Instant.ofEpochSecond(2,1_000_000_000));  //Nesse caso isso equivale a 1 seg
        System.out.println(Instant.ofEpochSecond(4,-1_000_000_000)); //E também aceita diminuir

        System.out.println("----------DURATION------------");  //Serve p intervalos de tempo
        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = LocalDateTime.of(2017,1,1,23,0,0);
        LocalTime time1 = LocalTime.now();
        LocalTime time2 = LocalTime.of(5,0,0);
        /**
         *Não pode usar LocalDate
         * Não pode misturar LocalDateTime com LocalTime
         */
        Duration d1 = Duration.between(dt1,dt2);
        Duration d2 = Duration.between(time1,time2);
        Duration d3 = Duration.between(Instant.now(),Instant.now().plusSeconds(1000));
//        Duration d4 = Duration.between(dt2,time2);                                       //VAI DAR UMA EXCEPTION
//        Duration d5 = Duration.between(LocalDate.now(), LocalDate.now().plusDays(20));
        Duration d6 = Duration.between(dt2,time2.atDate(dt2.toLocalDate()));               //Essa é a unica forma de usar ambos, criando uma data c aquela hr
        Duration d7 = Duration.ofMinutes(3);                                               //Converte valores p minutos vendo suas durações dessa forma, mas NÃO É RECOMENDADO PQ NEM TD ELE SUPORTA
        Duration d8 = Duration.ofDays(10);                                                 //Dias e demais tb é possível converter


        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d6);
        System.out.println(d7);
        System.out.println(d8);

        System.out.println("----------PERIOD------------");  //Serve p intervalos entre datas
        Period p1 = Period.between(dt1.toLocalDate(), dt2.toLocalDate());   //Tempo entre esses valores
        Period p2 = Period.ofDays(10);                                      //Tempo em dias q equivale esses dias
        Period p3 = Period.ofWeeks(58);                                     //Tempo em dias q equivale essas semanas
        Period p4 = Period.ofYears(3);                                      //Tempo em meses q equivale esses anos
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

//        System.out.println(Period.between(LocalDate.now(), LocalDate.now().plusDays(p3.getDays())));  //Supondo q vc queira
//        semanas em meses por ex, Só q ele n é uma boa escolha já q se torna meio complexo p isso

        LocalDateTime now = LocalDateTime.now();                                      //LocalDateTime se torna mais apropriada p isso
        System.out.println(now.until(now.plusDays(p3.getDays()),ChronoUnit.MONTHS));

        System.out.println("----------CHRONOUNIT------------");    //Ou até memso o uso dessa classe se torna mais útil nessas hrs
        LocalDateTime aniversario = LocalDateTime.of(1975,8,23,12,0,0);
        System.out.println(ChronoUnit.DAYS.between(aniversario,now));
        System.out.println(ChronoUnit.MONTHS.between(aniversario,now));
        System.out.println(ChronoUnit.WEEKS.between(aniversario,now));
        System.out.println(ChronoUnit.YEARS.between(aniversario,now));



        LocalDateTime estudoJava = LocalDateTime.of(2019,3,13,0,0,0);
        LocalDateTime estudoJavaF = LocalDateTime.now();
        System.out.println("O tempo de estudo total de Java foi: " + Period.between(estudoJava.toLocalDate(), estudoJavaF.toLocalDate()));

        LocalDateTime estudoProgramar = LocalDateTime.of(2019,2,22,0,0,0);
        LocalDateTime estudoProgramarF = LocalDateTime.now();
        System.out.println("O tempo de estudo total de programação foi: " + Period.between(estudoProgramar.toLocalDate(), estudoProgramarF.toLocalDate()));



    }
}
