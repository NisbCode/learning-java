package Estudando.javacore.S_datas;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTest {
    public static void main(String[] args) {
//        ISO 639 Define símbolos da lingua e país: pt= portugues - Brasil - ingles, US - Estados Unidos
        Locale locItaly = new Locale("it", "IT");
        Locale locSuica = new Locale("it", "CH");
        Locale locIndia = new Locale("hi", "IN");
        Locale locJapao = new Locale("ja");

        Calendar c = Calendar.getInstance();
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, locItaly);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, locSuica);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, locIndia);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL, locJapao);

        System.out.println("Itália " + df1.format(c.getTime()));
        System.out.println("Suiça " + df2.format(c.getTime()));
        System.out.println("India " + df3.format(c.getTime()));
        System.out.println("Japão " + df4.format(c.getTime()));

        System.out.println(locItaly.getDisplayLanguage(locJapao));
        System.out.println(locJapao.getDisplayLanguage(locItaly));
        System.out.println(locSuica.getDisplayCountry(locItaly));
    }
}
