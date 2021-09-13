package Estudando.javacore.ZZJoptional.teste;



import java.util.Optional;

/**
 * CLASSE OPTIONAL
 * Veio no java 8 para auxiliar contra NullPointerExceptions,
 * uma alternativa a encapsular codigos a varios if (variavel != null){}
 */

public class OptionalTeste1 {
    private String nomeNaoNulo = "Maria";
    private String nome;

    public static void main(String[] args) {
        OptionalTeste1 optionalTeste = new OptionalTeste1();

        // Encapsulando variavel em Optional caso o desenvolvedor tenha certeza
        // de que a variavel utilizada é não-nula (utilizar o método of())
        Optional<String> optionalCertezaNaoNulo = Optional.of(optionalTeste.nomeNaoNulo);

        // Também é possivel utilizar um Optional vazio
        Optional<String> optionalVazio = Optional.empty();

        // E também tem pro caso do desenvolvedor não saber se a variavel
        // utilizada é ou não nula. Se for, vai retornar Optional.empty();
        Optional<String> optionalIncerto = Optional.ofNullable(optionalTeste.nomeNaoNulo);





        System.out.println(optionalCertezaNaoNulo);
        System.out.println(optionalVazio);
        System.out.println(optionalIncerto);
    }
}
