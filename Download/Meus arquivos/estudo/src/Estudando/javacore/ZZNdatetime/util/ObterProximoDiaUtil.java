package Estudando.javacore.ZZNdatetime.util;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * Created by William Suane on 2/21/2017.
 */
public class ObterProximoDiaUtil implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));//Pega os dias da semana
        int proximoDia = 1;                                                       //Faz c q ele sempre pegue o prox dia a esse
        switch (dayOfWeek){
            case FRIDAY: proximoDia = 3;break;                                    //Pula 3 dias se for uma sexta
            case SATURDAY: proximoDia = 2;break;                                  //Pula 2 dias se for sábado
        }
        return temporal.plus(proximoDia, ChronoUnit.DAYS);                        //Retorna o tempo mais quanto for o caso, a unidade é dia
    }
}
