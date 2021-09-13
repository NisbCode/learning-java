package br.com.abc.javacore.Minterfaces.classes;

/***
 * 1- INTERFACES:
 * Como contratos, você define o que a classe obrigatoriamente
 * tem que fazer, mas não define como fazer
 * classes totalmente abstratas, sem métodos concretos
 * Regra geral: "TEM QUE TER ESSE MÉTODO, não importa o que
 * vá dentro dele, mas TEM QUE TER ESSE MÉTODO"
 */

            //5- Uso do implements pra implementar
            // uma interface (OBRIGATORIO IMPLEMENTAR
            // OS MÉTODOS DA INTERFACE POR ELA SER ABSTRATA)

            //7- É possível implementar mais de uma
            // interface separando por vírgula
public class Produto implements Tributavel, Transportavel{
    private String nome;
    private double peso;
    private double preco;
    private double precoFinal;
    private double valorFrete;

    //6- Implementação dos métodos de Tributável
    @Override
    public void cacularImposto() {
        //13- Criação do codigo para calculo do imposto
        precoFinal = this.preco + (this.preco * IMPOSTO);
    }

    //8- Implementação dos métodos de Transportável
    @Override
    public void calculaFrete() {
        //14- Criação do codigo para calculo do frete
        this.valorFrete = this.preco * peso*0.1;
    }


    //11- adição do construtor
    public Produto(String nome, double peso, double preco) {
        this.nome = nome;
        this.peso = peso;
        this.preco = preco;
    }

    //10- sobrescrita do toString
    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", peso=" + peso +
                ", preco=" + preco +
                ", precoFinal com imposto=" + precoFinal +
                ", valorFrete=" + valorFrete +
                '}';
    }

    //9- Getters e Setters de peso, preço e nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    //12- Getters de precoFinal e valorFrete
    public double getPrecoFinal() {
        return precoFinal;
    }

    public double getValorFrete() {
        return valorFrete;
    }
}
