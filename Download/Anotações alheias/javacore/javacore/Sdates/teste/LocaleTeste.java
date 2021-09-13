 package br.com.abc.javacore.Sdates.teste;

import br.com.abc.javacore.Gassociacao.Classes.Seminarios.Local;
import sun.util.resources.cldr.ta.CalendarData_ta_IN;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/***
 * INTERNALIZAÇÃO COM A CLASSE LOCALE:
 * A classe locale serve pra criar objetos
 * de locais
 */

public class LocaleTeste {
    public static void main(String[] args) {
        //Parâmetros: língua e país
        //Parâmetro da lingua de acordo com a ISO 639 (Ex: pt BR)
        Locale locale = new Locale("it", "IT");
        Locale locale2 = new Locale("it", "CH");
        Locale localeUK = new Locale("en", "UK");
        Locale localeRU = new Locale("ru", "RU");
        Locale localeCN = new Locale("zn-hans", "CN");


        DateFormat dateFormatIT = DateFormat.getDateInstance(DateFormat.FULL, locale);
        DateFormat dateFormatInglesUK = DateFormat.getDateInstance(DateFormat.LONG, localeUK);
        DateFormat formatoDataRusso = DateFormat.getDateInstance(DateFormat.FULL, localeRU);

        Calendar data = Calendar.getInstance();

        System.out.println("Italia: " + dateFormatIT.format(data.getTime()));
        System.out.println("UK: " + dateFormatInglesUK.format(data.getTime()));
        System.out.println("Russia: " + formatoDataRusso.format(data.getTime()));

        //para mostrar a lingua
        System.out.println(" ");
        System.out.println(locale.getDisplayLanguage());
        System.out.println(localeUK.getDisplayLanguage());
        System.out.println(localeRU.getDisplayLanguage());
        //Nos parametros você pode colocar uma outra lingua pra exibição
        //"russo" vai ser exibido em ingles
        System.out.println(localeRU.getDisplayLanguage(localeUK));


        //Para mostrar o país
        System.out.println(" ");
        System.out.println(localeCN.getDisplayCountry(localeUK));



    }
}
