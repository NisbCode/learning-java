package br.com.abc.javacore.Jmodificadorfinal.classes;

public class Carro {
    /***
     * MODIFICADOR FINAL:
     * Possivel utilizar em método, declaração de classe ou atributo
     * Em atributos: transforma o atributo numa const
     * Em delcaração de classes: não deixa a classe ser extendida (raro)
     * Em métodos: não deixa o método ser sobrescrito
     */
    //final usado para que a velocidade limite
    // nunca seja alterada (o mesmo que const
    // no javascript)
    //Note que a nomeação da variável muda
    //deve ser inicializada logo que o método for criado
    private static final double VELOCIDADE_FINAL = 250;
    public final Comprador comprador = new Comprador();
    private String marca;
    private String nome;



//    Se a velocidade limite não fosse um valor estatico
// private final double VELOCIDADE_FINAL;
//    private String marca;
//    private String nome;
//
//    public CarroOptional(){
//        VELOCIDADE_FINAL = 200;
//    }

    @Override
    public String toString() {
        return "CarroOptional{" +
                "marca='" + marca + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

    public final void imprime(){
        System.out.println("Imprimindo");
    }


    public Comprador getComprador() {
        return comprador;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
