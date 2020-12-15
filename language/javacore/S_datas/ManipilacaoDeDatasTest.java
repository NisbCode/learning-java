package Estudando.javacore.S_datas;

import java.util.Calendar;
import java.util.Date;

public class ManipilacaoDeDatasTest {
    public static void main(String[] args) {
        Date date = new Date();                                  //<---Classe obsoleta
        date.setTime(date.getTime() + 3_600_000L);
        System.out.println(date);

        Calendar c = Calendar.getInstance();
//        c.setTime(date);
        if(Calendar.SUNDAY == c.getFirstDayOfWeek()){
            System.out.println("Domingo é o 1 dia da semana");   //<---Verifica se o 1 dia da semana é domingo
        }
        System.out.println(c.get(Calendar.DAY_OF_WEEK));      //<---Diz qual é o 1 dia da semana é domingo
        System.out.println(c.get(Calendar.DAY_OF_MONTH));     //<---Diz qual é o 1 dia do mês é domingo
        System.out.println(c.get(Calendar.DAY_OF_YEAR));      //<---Diz qual é o 1 dia do ano é domingo

        c.roll(Calendar.HOUR, 24);  //<---.roll adiciona horas sem mudar o dia
//      c.add(Calendar.MONTH, 24);          //<---.add adiciona hrs
        Date date2 = c. getTime();
        System.out.println(date2);
    }
}
