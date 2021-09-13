package br.com.abc.javacore.Wnio.teste;

import java.nio.file.Path;
import java.nio.file.Paths;

/***
 * RELATIVIZAR PATHS:
 * Quando você quer eliminar o que tem em comum
 * entre no caminho entre dois paths
 * "Tô no caminho 1, me mostre como chegar ao caminho 2"
 */

public class RelativizarTeste {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/william");
        Path classe = Paths.get("/home/william/java/PessoaOptional.java");
        Path pathToClase = dir.relativize(classe);
        System.out.println("A diferença entre ambos os caminhos é: " + pathToClase);

    }
}
