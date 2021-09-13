package Estudando.javacore.W_nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

//      Para buscar todos os arquivos Test e java.class
class FindAllTest extends SimpleFileVisitor<Path>{
    private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*{Test*}.{java,class}"); //Sempre começa c glob; Lê: Começa c qq coisa seguida de "Test." + ou java ou class
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
        if (matcher.matches(file)){
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}
public class PathMatcherTest {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("pasta/subpasta/subsubpasta/file.bkp");
        Path path2 = Paths.get("file.bkp");
        Path path3 = Paths.get("Naty-Ignacio");
//        O padrão sempre será "glob:"
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.bkp");//Procure um path q seja alguma coisa(*).bkp
        System.out.println(matcher.matches(path1));    //Esse retorna falso pq nem tds os nomes entre os diretórios termina em bkp
        System.out.println(matcher.matches(path2));    //Esse retorna true
        System.out.println("----------------------------------");
        matches(path1, "glob:*.bkp");
        matches(path1, "glob:**/*.bkp");         //Ou **.bkp   Eles aceitam qq coisa tendo por ultimo .bkp, inclusive diretórios
        matches(path1, "glob:*");                //Um * n considera separador de diretório
        matches(path1, "glob:**");               //Vai encontrar qualquer coisa
        System.out.println("----------------------------------");//Todos os seguintes servem p ver se a extensão tem 3 caracteres
        matches(path1, "glob:*.???");            //N considera separador de diretório ao ver
        matches(path1, "glob:**/*.???");         //
        matches(path1, "glob:**.???");           //
        System.out.println("----------------------------------");
        matches(path3, "glob:{Naty*,Ignacio*}"); //Se tiver ou Naty ou Ignacio podendo ter os dois
        matches(path3, "glob:{Naty,Ignacio}*");  //O msm do de cima
        matches(path3, "glob:{Naty,Ignacio}");   //Ou Naty ou Ignacio aq é exatamente apenas um deles
        Files.walkFileTree(Paths.get("./"), new FindAllTest());
    }

    private static void matches(Path path, String glob){
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + matcher.matches(path));
    }
}