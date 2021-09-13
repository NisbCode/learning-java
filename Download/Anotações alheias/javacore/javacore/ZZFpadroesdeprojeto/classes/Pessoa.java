package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

/**
 * PADRÕES DE PROJETO
 * Servem para que o desenvolvedor organize seus projetos de forma
 * melhor
 */

public class Pessoa {
    /**
     * PADRÃO BUILDER:
     * Usado para que os parâmetros do construtor possam ser vistos,
     * util quando você tem vários parâmetros
     */

    private String nome;
    private String ultimoNome;
    private String nomeDoMeio;
    private String apelido;
    private String nomeDaMae;



    // 2- Construtor privado
    private Pessoa(String nome, String ultimoNome, String nomeDoMeio, String apelido, String nomeDaMae) {
        this.nome = nome;
        this.ultimoNome = ultimoNome;
        this.nomeDoMeio = nomeDoMeio;
        this.apelido = apelido;
        this.nomeDaMae = nomeDaMae;
    }

    @Override
    public String toString() {
        return "PessoaBuilder{" +
                "nome='" + nome + '\'' +
                ", ultimoNome='" + ultimoNome + '\'' +
                ", nomeDoMeio='" + nomeDoMeio + '\'' +
                ", apelido='" + apelido + '\'' +
                ", nomeDaMae='" + nomeDaMae + '\'' +
                '}';
    }

    // 1- Classe interna
    public static class PessoaBuilder{
        private String nome;
        private String ultimoNome;
        private String nomeDoMeio;
        private String apelido;
        private String nomeDaMae;


        // 4- para tornar algum atributo obrigatório
        public PessoaBuilder(String nome){
            this.nome = nome;
        }

        public PessoaBuilder nome(String nome){
            this.nome = nome;
            return this;
        }
        public PessoaBuilder ultimoNome(String ultimoNome){
            this.ultimoNome= ultimoNome;
            return this;
        }
        public PessoaBuilder nomeDoMeio(String nomeDoMeio){
            this.nomeDoMeio = nomeDoMeio;
            return this;
        }
        public PessoaBuilder apelido(String apelido){
            this.apelido = apelido;
            return this;
        }
        public PessoaBuilder nomeDaMae(String nomeDaMae){
            this.nomeDaMae = nomeDaMae;
            return this;
        }

        // 3- Construtor a ser usado, baseado no constutor privado (é padrão ser chamado de build)
        public Pessoa build(){
            return new Pessoa(nome, ultimoNome, nomeDoMeio, apelido, nomeDaMae);
        }
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getNomeDoMeio() {
        return nomeDoMeio;
    }

    public void setNomeDoMeio(String nomeDoMeio) {
        this.nomeDoMeio = nomeDoMeio;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }
}
