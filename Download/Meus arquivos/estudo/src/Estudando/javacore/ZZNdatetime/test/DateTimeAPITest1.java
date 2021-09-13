package Estudando.javacore.ZZNdatetime.test;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by William Suane on 2/15/2017.
 */
public class DateTimeAPITest1 {
    public static void main(String[] args) {

        /**
         * Antigamente a forma de se chamar ou lidar com a criação de datas era longa e só de pegar a data cm visto abaixo
         * davam linhas e linhas de código
         */
//        System.out.println(new Date());
//        System.out.println(Calendar.getInstance());

        LocalDate date = LocalDate.of(2020, Month.DECEMBER, 25);     //Pra criar uma data nova
        System.out.println(date.getYear());                                           //Pegar o ano
        System.out.println(date.getMonth());                                          //Pegar mês
        System.out.println(date.getMonthValue());                                     //Pegar o valor númerico no sistema q equivale ao mês
        System.out.println(date.getDayOfMonth());                                     //Pegar dia do ano
        System.out.println(date.getDayOfWeek());                                      //Pegar dia da semana
        System.out.println(date.lengthOfMonth());                                     //Tamanho do mês
        System.out.println(date.isLeapYear());                                        //Saber se é bissexto ou não
        System.out.println(date.get(ChronoField.YEAR));                               //Também temos como chamar por meio de uma ThemporalField
        System.out.println(date.get(ChronoField.DAY_OF_MONTH));                       // Mesma coisa q o anterior
        LocalDate now = LocalDate.now();                                              //Data atual
        System.out.println(date);                                                     //Imprimir data criada
        System.out.println(now);                                                      //Imprimir data atual
        System.out.println(LocalDate.MAX);                                            //Data máx q vc pode botar
        System.out.println(LocalDate.MIN);                                            //Data min q vc pode botar

        System.out.println("---------LocalTime---------");
        LocalTime time = LocalTime.of(22,2,15);                  //Criar horário
        System.out.println(time.getHour());                                           //Pegar hora
        System.out.println(time.getMinute());                                         //Pegar minuto
        System.out.println(time.getSecond());                                         //Pegar segundo
        System.out.println(LocalTime.MAX);                                            //Saber o tempo máx
        System.out.println(LocalTime.MIN);                                            //Saber o tempo min
        System.out.println(time);                                                     //Pegar tempo criado

        System.out.println("---------Parsing---------");                     //Pegando uma String e transformando num objeto Java
        LocalDate parseDate = LocalDate.parse("2017-02-15");                          //Só passar a String
        LocalTime parseTime = LocalTime.parse("23:25:10");                            //Nesses formatos que eles estarão cm objetos(caso esteja errado terá uma exceção)
        System.out.println(parseDate);                                                //Imprimindo os objetos
        System.out.println(parseTime);                                                //criados

        System.out.println("---------LocalDateTime---------");               //Trabalhando com os dois
        LocalDateTime ldt1 = LocalDateTime.now();                                     //Data de agora
        LocalDateTime ldt2 = LocalDateTime.of(2017,8,6,8,35,33);       //Data criada
        LocalDateTime ldt3 = date.atTime(10,20,20);              //Quando vc quiser trabalhar com uma data e adicionar a hora, vc usa isso q diz "Essa data nesse horário"
        LocalDateTime ldt4 = date.atTime(time);                                       //Adicionar àquele date um time criado
        LocalDateTime ldt5 = time.atDate(LocalDate.now());                            //Adicionando àquele time um date atual
        LocalDateTime ldt6 = time.atDate(date);                                       //Adicionando àquele time um date criado

        System.out.println(ldt1);
        System.out.println(ldt2);
        System.out.println(ldt3);
        System.out.println(ldt4);
        System.out.println(ldt5);
        System.out.println(ldt6);

    }
}
