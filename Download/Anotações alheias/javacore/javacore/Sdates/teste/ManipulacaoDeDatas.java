package br.com.abc.javacore.Sdates.teste;

import java.util.Calendar;
import java.util.Date;

/***
 * PACOTE TIME
 * Implementado no java 8, mais completo que as classes date
 * e calendar do java, mas algumas funções de ambas ainda
 * são utilizadas
 */

public class ManipulacaoDeDatas {
    public static void main(String[] args) {
        /***
         * CLASSE DATE:
         * Depreciada, complicada demais para uso
         */
        //Selecionar alguma data baseada no código long dela
        //Date data = new Date(1_000_000_000_000L);
        //Unidade: milissegundos

        //Pegar a data atual
        Date data = new Date();
        System.out.println(data);
        //Para saber o código long dela:
        //System.out.println(data.getTime());

        /***
         * CLASSE CALENDAR:
         * Classe abstrata, ou seja, não gera objeto
         */

        //é assim que se cria objeto pra essa classe
        Calendar calendario = Calendar.getInstance();
        //Mudando para a classe date
        //calendario.setTime(data);

        //Para saber o primeiro dia da semana
        if(Calendar.MONDAY == calendario.getFirstDayOfWeek()){
            System.out.println("Segunda é o primeiro dia da semana");
        } else {

        }
        System.out.println(calendario);

        //Para pegar um dia específico de um intervalo de tempo
        System.out.println("Hoje é o " + calendario.get(Calendar.DAY_OF_WEEK) + " dia da semana");
        System.out.println("Hoje é o " + calendario.get(Calendar.DAY_OF_MONTH) + " dia do mês");
        System.out.println("Hoje é o " + calendario.get(Calendar.DAY_OF_YEAR) + " dia do ano");

        //Adicionando hora
        //O field é o campo que você quer mudar (se é dia, hora, mes, ano)
        //o amount é a quantidade que você quer mudar
        calendario.add(Calendar.HOUR,2);

        //Formatando rapidinho a data
        Date data2 = calendario.getTime();

        //Exibindo a data atual e a data daqui a 2 hrs
        System.out.println(" ");
        System.out.println("Data atual: " + data);
        System.out.println("Daqui a 2 horas: " + data2);

        //Para manter o ano adicionando meses que o faça virar (método roll)
        System.out.println(" ");
        calendario.roll(Calendar.MONTH, 15);
        Date data3 = calendario.getTime();
        System.out.println("Demonstração roll:" + data3);
    }

}
