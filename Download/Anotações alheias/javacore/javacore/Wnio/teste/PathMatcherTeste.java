package br.com.abc.javacore.Wnio.teste;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/***
 * CLASSE PathMatcher
 * Trabalha em conjunto com a classe FileVisitor,
 * facilitando o trabalho quando se quer fazer uma busca mais
 * poderosa
 */

public class PathMatcherTeste {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("C:/Users/Amanda Porto/IdeaProjects/JavaOnline/pasta/subpasta/subsubpasta/file.bkps");
        Path path2 = Paths.get("file.bkp");
        Path path3 = Paths.get("Amanda-porto");
                                         // Padrão: começar usando glob
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.bkp");
        // Vai retornar false por ter o caminho inteiro passado e isso não
        // se encaixar no padrãp
        System.out.println(matcher.matches(path1));
        // Vai retornar true por se encaixar no padrão estabelecido
        System.out.println(matcher.matches(path2));
        System.out.println("---------------------------------");
        // Chamando o método matches agora
                    // *.: Considera qualquer coisa que não tem separador de diretorio
        matches(path1, "glob:*.bkp");
                    // **: considera qualquer coisa, incluindo separador de diretorio
        matches(path1, "glob:**.bkp");
                    // Outra forma de escrever o anterior
        matches(path1, "glob: **/*.bkp");
                    // Encontrar qualquer coisa
        matches(path1, "glob:*.bkp");
        System.out.println("---------------------------------");

        // Para saber se a extensão tem um determinado número de caracteres
        // Nesse exemplo, 3 caracteres
        System.out.println("Tem 3 caracteres?");
        matches(path1, "glob:*.???");
        matches(path1, "glob:**/*.???");
        matches(path1, "glob:**.???");
        System.out.println("---------------------------------");

        // Pesquisar se tem algo expecífico
        System.out.println("Tem 'Amanda' e 'Porto'?");
        matches(path3, "glob:{amanda*, porto*}");
        matches(path3, "glob:{amanda, porto}*");
        // Caso queira ver se tem um item ou outro
        matches(path3, "glob:{amanda, porto}");
        System.out.println("---------------------------------");

        // Chamando o método FindAllTeste
        System.out.println("Todas as classes Teste criadas até agora");
        Files.walkFileTree(Paths.get("./"), new FindAllTeste());

    }

    // Criando um método abarcando os métodos anteriores para facilitar
    private static void matches(Path path, String glob){
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + matcher.matches(path));
    }

}

/***
 * UM EXERCICIO MAIS REAL:
 * Encontrar todos os arquivos que tenha 'Teste' e ambos
 * tenham as extensões .java ou .class
 */
class FindAllTeste extends SimpleFileVisitor<Path>{
                                                                                    //**/: pegar não importa onde esteja
                                                                                    // /*: Que tenha qualquer coisa seguida de Teste.java ou Teste.class
    private PathMatcher matcherFindAllTeste = FileSystems.getDefault().getPathMatcher("glob:**/*{Teste*}.{java,class}");
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(matcherFindAllTeste.matches(file)){
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}
