package Estudando.javacore.S_datas;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        String mascara = "'Atlanta, ' dd 'de' MMMM 'de' yyyy"; //<---Td q tiver entre aspas simples ele n vai converter
        SimpleDateFormat formatador = new SimpleDateFormat(mascara);
        System.out.println(formatador.format(c.getTime()));
    }
}