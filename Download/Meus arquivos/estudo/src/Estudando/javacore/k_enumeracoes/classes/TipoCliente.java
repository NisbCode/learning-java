package Estudando.javacore.k_enumeracoes.classes;

public enum TipoCliente {
    PESSOA_FISICA(1, "Pessoa Física"), PESSOA_JURIDICA(2, "Pessoa Jurídica") {
        public String getId() {
            return "B";
        }
    };
    private int tipo;
    private String nome;

    TipoCliente(int tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }


//    constant specific class body
//    corpo de classe específico constante

    public String getId() {
        return "A";
    }


    public int getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }
}
