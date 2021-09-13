package Estudando.javacore.ZZNdatetime.test;

import java.time.*;
import java.time.chrono.JapaneseDate;
import java.util.Map;

/**
 * Created by William Suane on 2/27/2017.
 */
public class DateTimeAPITest6 {
    public static void main(String[] args) {
        for(Map.Entry<String, String> zonas : ZoneId.SHORT_IDS.entrySet()){  //Para saber a lista de zonas disponível p q vc trabalhe
            System.out.println(zonas.getKey() + " "+zonas.getValue());       //Pegar tanto seu valor quanto sua chave
        }

        System.out.println("-------------");
        System.out.println(ZoneId.systemDefault());                          //Saber em qual zona eu tô de padrão
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");                          //Saber a zona deste local
        System.out.println(tokyoZone);
        LocalDateTime dateTime = LocalDateTime.now();                        //Meu horário agr
        System.out.println(dateTime);
        ZonedDateTime zonedDateTime = dateTime.atZone(tokyoZone);            //Meu horário + a diferença p a de tokyo e mostra de onde vem
        System.out.println(zonedDateTime);

        /**
         * Também é possível ver essa mudança usando o Instant, e ele aind apor cima já vai a soma do horário
         */

        Instant instant = Instant.now();
        System.out.println(instant);                                          //Horário da UTC(Meridiano de Greenwich
        ZonedDateTime zonedDateTime2 = instant.atZone(tokyoZone);             //Horário da UTC + O local(Já somado)
        System.out.println(zonedDateTime2);

        /**
         * Caso vc tenha q trabalhar c a formatação de um local q n tenha na lista vc usa o ZoneOffset
         * Vc só vai precisar saber a diferença de fuso do local q vc quer
         */

        System.out.println(ZoneOffset.MIN);                                   //Aqui vc vê o minimo q vc pode subtrair
        System.out.println(ZoneOffset.MAX);                                   //AE o max q pode somar

        ZoneOffset manausOffset = ZoneOffset.of("-04:00");
        LocalDateTime dateTime2= LocalDateTime.now();
        OffsetDateTime offsetDateTime = OffsetDateTime.of(dateTime2, manausOffset);      //TEM DUAS FORMAS DE CHAMAR, ASSIM
        System.out.println(offsetDateTime);
        OffsetDateTime offsetDateTime2 = dateTime2.atOffset(manausOffset);               //OU ASSIM, AMBAS DÃO NO MSM
        System.out.println(offsetDateTime2);

        Instant instant2 = Instant.now();
        System.out.println(instant2.atOffset(manausOffset));  //Também podendo trabalhar c Instant p ter o horário logo somado de lá

        /**
         * Trabalhando c calendários diferentes
         */

        JapaneseDate japaneseDate = JapaneseDate.from(LocalDate.now());     //Retorna a ERA atual segundo o calendário japonês
        System.out.println(japaneseDate);
        LocalDate antigamente = LocalDate.of(1900, 2, 1); //Retorna a ERA quando foi essa data segundo o calendário japonês
        System.out.println(JapaneseDate.from(antigamente));

    }
}
