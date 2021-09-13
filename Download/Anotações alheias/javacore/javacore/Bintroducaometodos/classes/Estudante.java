package br.com.abc.javacore.Bintroducaometodos.classes;

public class Estudante {

    //        Atributos
    private String nome;
    private int idade;
    private double[] notas;
    private boolean aprovado;


    //        Métodos
    public void mostrarInformacoes() {
        System.out.println("Nome do aluno: " + this.nome);
        System.out.println("Idade: " + this.idade);
        //Para o caso do aluno não ter alguma nota, imprime somente se tiver
        if (this.notas != null) {
            for (double nota : this.notas) {
                System.out.print("Nota: " + nota + " ");
            }
        }
    }

    public void calcularMedia() {
        //Se o aluno não tiver todas as notas:
        if (this.notas == null) {
            System.out.println("Esse aluno não possui todas as notas");
            return;
        }
        //Se tiver:

        // media começa em 0 só pra ser inicializada
        double media = 0;
        double totalAvaliacoes = notas.length;
        // nota in notas -- "nota" vai mostrar o conteúdo da lista "notas" em determinada posição
        for (double nota : this.notas) {
            //para cada posição exibida, faça o seguinte comando
            media += nota;
        }
        //calcula a media pegando o resultado da soma e dividindo pelo numero de avaliações
        media = media / totalAvaliacoes;
        //Avalia a situação conforme a media
        if (media >= 6.0) {
            this.aprovado = true;
            System.out.println("Status: Aprovado");
            return;
        }
        this.aprovado = false;
        System.out.println("Status: Reprovado");
    }

    /***
     * ENCAPSULAMENTO: tem a intenção de proteger o código
     * não permitindo que as variáveis sejam acessadas facilmente
     *
     * MÉTODO SET:
     * usados para pegar informações de classes privadas
     * nomenclatura padrão seguida a risca
     * Serve para ALTERAR valores  dessa classe
     * em outras classes
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    /***
     * MÉTODO GET:
     * Usado para imprimir informações das classes privadas
     * Serve para BUSCAR valores nessa classe em outras
     * classes
     */
    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public double[] getNotas() {
        return this.notas;
    }

//          É possivel criar um set para que
//          se possa mudar o status do aluno em outra
//          classe, contudo, isso poderia ser manipulação
//          de informações, sendo assim, é melhor
//          não setar a informação
//  public void setAprovado(){
//      this.aprovado = aprovado;
//  }
//    Para valores booleanos, uma forma alternativa
//    de usar get é trocando-o pelo is, pode-se
//    utilizar ambos
    public boolean isAprovado(){
        return this.aprovado;
    }



}






