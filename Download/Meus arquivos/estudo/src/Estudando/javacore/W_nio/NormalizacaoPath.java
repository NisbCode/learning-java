package Estudando.javacore.W_nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizacaoPath {
    public static void main(String[] args) {
        String diretorioProjeto = "JavaOnline.estudo\\home\\Naty\\dev";
        String arquivoTxt = "..\\..\\arquivo.txt";
        Path p1 = Paths.get(diretorioProjeto, arquivoTxt);
        System.out.println(p1);
        System.out.println(p1.normalize());       //ignora os pontos e as barras mostrando o diretório q vc deve seguir
        Path p2 = Paths.get("a/./b/./c");    //E ele funciona independentemente se o arquivo funciona ou n
        System.out.println(p2);
        System.out.println(p2.normalize());
    }
}
