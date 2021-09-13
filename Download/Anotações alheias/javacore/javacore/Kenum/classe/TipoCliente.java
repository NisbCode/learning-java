package br.com.abc.javacore.Kenum.classe;

public enum TipoCliente {
    //ANTES N É PERMITIDO
    //private int tipo; (ERRADO)
                                                //Para fazer a condição
                                                //específica, deve-se abrir
                                                // chaves depois da variavel enum selecionada
    PESSOA_FISICA(1, "PessoaOptional Física"), PESSOA_JURIDICA(2, "PessoaOptional Jurídica"){
      public String getId(){
          return "B";
      }
    };

    //è possível ter atribudos no enum
    private int tipo;
    private String nome;

    //O construtor de uma enum se chama sozinho,
    // ou seja, dizer se é publico ou privado é
    // redundante

    //O 1 e o 2 em PESSOA_FISICA(1) e
    // PESSOA_JURIDICA(2) são os tipos,
    // a declaração
    TipoCliente(int tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    /***
     * CONSTANT SPECIFIC CLASS BODY
     * Uma condição especifica para apenas um
     * dos enums
     */
    public String getId(){
        return "A";
    }

    public int getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }
}
