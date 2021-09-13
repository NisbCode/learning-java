package Estudando.javacore.ZZNdatetime.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by William Suane on 2/21/2017.
 */
public class DateTimeAPITest5 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);  //Aperte ctrl+q p ver como q ficaria a formatação
        String s2 = date.format(DateTimeFormatter.ISO_DATE);
        String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        String s4 = "20170221";
        String s5 = "2017-02-21+05:00";
        LocalDate parse1 = LocalDate.parse(s4,DateTimeFormatter.BASIC_ISO_DATE);   //Vc deve passar o tipo pq assim ele pode detectar se aquela string tá correta conforme o tipo q veio e n o prédeterminado
        LocalDate parse2 = LocalDate.parse(s5);  //Nesse caso ele n precisa pq ele já tá na forma prédeterminada
        System.out.println(parse1);
        System.out.println(parse2);

        LocalDateTime dateTime = LocalDateTime.now();
        String s6 = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);              //Passar uma hr de Object p String
        System.out.println(s6);
        LocalDateTime parse = LocalDateTime.parse("2017-02-21T13:07:40.433");      //Passar uma hr de String p Object
        System.out.println(parse);

        //dd/MM/yyyy FORMATAÇÃO BR
        //MM/dd/yyyy FORMATAÇÃO USA
        //yyyy/MM/dd FORMATAÇÃO JP
        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //Para formatar da sua forma
        String formatBR = LocalDate.now().format(formatterBR);
        System.out.println(formatBR);

        String dataBRString = "01/12/2017";
        LocalDate parse3 = LocalDate.parse(dataBRString, formatterBR);  //Retorna ao padrão java para um Objeto
        System.out.println(parse3);

        DateTimeFormatter formatterFR = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.FRANCE); //Vai fazer o mês por extenso em francês
        String formatFR = LocalDate.now().format(formatterFR);
        System.out.println(formatFR);

        LocalDate parse4 = LocalDate.parse("21.février.2017", formatterFR);  //Traz em número em um objeto
        System.out.println(parse4);
    }
}
