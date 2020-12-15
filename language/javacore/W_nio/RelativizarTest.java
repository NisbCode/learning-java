package Estudando.javacore.W_nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizarTest {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/Naty");
        Path classe = Paths.get("/home/Naty/java/Pessoa.java");
        Path pathToClasse = dir.relativize(classe); //através do dir vc quer saber cm chegar no Pessoa.java pela var. classe
        System.out.println(pathToClasse);

        Path absoluto1 = Paths.get("/home/Naty");
        Path absoluto2 = Paths.get("/usr/local");
        Path absoluto3 = Paths.get("/home/Naty/java/Pessoa.java");
        Path relativo1 = Paths.get("temp");
        Path relativo2 = Paths.get("temp/Funcionario.java");

//        Se lê assim: do caminho 1 para chegar no caminho 3 é indo java/Pessoa.java
//        E do 3 p o 1 é voltando dois diretórios
//        De 1 p 2 vc tem q voltar 2 caminhos (o caminho inteiro feito pelo 1) e ir para o caminho 2
        System.out.println("1: " + absoluto1.relativize(absoluto3));
        System.out.println("2: " + absoluto3.relativize(absoluto1));
        System.out.println("3: " + absoluto1.relativize(absoluto2));

//        Só ir dois para frente
        System.out.println("4: " + relativo1.relativize(relativo2));
//        Aq vai dar um erro em tempo de execução pq o java n sabe ir de absoluto p relativo, já q relativo pode estar em qq
//        lugar (relativo é basicamente uma pasta solta q vc n tá escrevendo de onde veio "C:" essas coisas base
//        System.out.println("5: " + absoluto1.relativize(relativo1));
    }
}
