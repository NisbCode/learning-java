package br.com.abc.javacore.Lclassesabstratas.classes;

    /***
     * CLASSES ABSTRATAS:
     * classes que não podem ser instanciadas
     * (Não pode ter new)
     * Usado quando você quer que essa classe seja
     * referencia, mas não que um objeto dela seja criado
     */
                                    //o nome ta na classe PessoaOptional
public abstract class Funcionario extends Pessoa{

//    É criada uma classe Funcionario, abrigando
//    todos os atributos e métodos em comum
//    a gerente e vendedor
    protected String clt;
    protected double salario;

//    Construtores
    public Funcionario(String nome, String clt, double salario) {
        this.nome = nome;
        this.clt = clt;
        this.salario = salario;
    }
    public Funcionario() {}

//    Métodos
        /***
         * MÉTODO CONCRETO:
         * método no qual ele vai ser utilizado
         * do jeito que tá aqui em todas as clsses
         * filhas
         * O toString é um exemplo
         */
    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", clt='" + clt + '\'' +
                ", salario=" + salario +
                '}';
    }

        /***
         * MÉTODO ABSTRATO: criado para ser usado em
         * outra classe, sendo assim, não pode ter código
         * Se tiver um unico método abstrato na classe,
         * a classe inteira deve se tornar abstrata
         */
    public abstract void calculaSalario();

    //Método trazido do pessoa, sendo assim,
    // ELE NÃO É ABSTRATO E TEM CORPO
    public void imprime(){}

//  Getters e setters
    //Getters em setters não utilizados no momento,
    //mas que podem vir a ser úteis alguna hora
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClt() {
        return clt;
    }

    public void setClt(String clt) {
        this.clt = clt;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}

