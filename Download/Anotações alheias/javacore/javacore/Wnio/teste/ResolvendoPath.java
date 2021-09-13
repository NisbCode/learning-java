package br.com.abc.javacore.Wnio.teste;

import java.nio.file.Path;
import java.nio.file.Paths;

/***
 * RELSOVER PATH:
 * Juntar dois paths
 */

public class ResolvendoPath {
    public static void main(String[] args) {
        Path dir = Paths.get("home\\amanda");
        Path arquivo = Paths.get("dev\\arquivoDev.txt");

        Path resultUniao = dir.resolve(arquivo);
        System.out.println(resultUniao);

    }
}
