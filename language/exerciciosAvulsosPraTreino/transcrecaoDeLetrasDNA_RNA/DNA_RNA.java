package Estudando.exerciciosAvulsosPraTreino.transcrecaoDeLetrasDNA_RNA;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class DNA_RNA {
    public static void main(String[] args) {
//        String dna = new String("AATCTGAC");
                List<String> dna = asList("AATCTGAC");


        String[] split = dna.get(0).split("");
        Stream<String> stream = Arrays.stream((String[]) dna.toArray());
        List<String> collect2 = dna.stream().map(p -> p.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
        List<String> umVai = collect2;
        System.out.println(split);
        System.out.println(stream);
        System.out.println(collect2);
        System.out.println(umVai);

        Scanner scanner = new Scanner("AATCTGAC");//Usar um for p rodar a lista por uma sequencia de if q dá um break e escreve aquele valor na lista
        scanner.useDelimiter("\\D");

        while (scanner.hasNext()) {
            if(collect2.equals("A")) {
                umVai = Collections.singletonList(umVai.toArray().toString().concat("A"));
            }
            System.out.println(umVai);


//            dna = dna.replaceFirst("T", "A");
//            dna = dna.replaceFirst("C", "G");
//            dna = dna.replaceFirst("G", "C");
//            System.out.println("Valor do RNA: " + dna);

        }


//
//        List<String> dna = asList("AATCTGAC");
//
//
//        String[] split = dna.get(0).split("");
//        System.out.println(split);
//        Stream<String> stream = Arrays.stream((String[]) dna.toArray());
//        System.out.println(stream);
//        List<String> collect2 = dna.stream().map(p -> p.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
//        System.out.println(collect2);
//
//
////        for (int i = 0; i < collect2.toArray().length; i++) {
//        Pattern padrao = Pattern.compile("A");
//        Matcher maybe = padrao.matcher("A");
//        System.out.println(maybe);
//            if (maybe.find(Integer.parseInt("A")))
//                maybe = Pattern.compile("A").matcher("T");
//            System.out.println(maybe);
////        }
//
//
////        if (collect2.stream().anyMatch("")) {
////            Collections.fill(collect2, "T");
////
////        } else if (collect2.("T")) {
////            collect2.listIterator().set("A");
////
////        } else if (collect2.equals("C")) {
////            collect2.listIterator().set("G");
////
////        } else if (collect2.equals("G")) {
////            collect2.listIterator().set("C");
////        }
////        System.out.println(collect2);
////
////    }
////
////    @Override
////    public int compare(Object o1, Object o2) {
////        return 0;
//    }
    }
}
