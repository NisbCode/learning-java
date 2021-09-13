package Estudando.javacore.F_modificadorestatico.classes;

public class Carro {

    //Se existir uma lei que o carro n pode passar 240km/h
    private String nome;
    private double velocidadeMaxima;
    public static double velocidadeLimite = 240;


    public Carro() {
    }


    public static void setVelocidadeLimite(double velocidadeLimite){
        //Como é um fazAlgumaCoisa static não pode usar i "this." como de costume, então usamos a classe
        Carro.velocidadeLimite = velocidadeLimite;

    }

    public static double getVelocidadeLimite(){
        return velocidadeLimite;
    }

    public Carro(String nome, double velocidadeMaxima) {
        this.nome = nome;
        this.velocidadeMaxima = velocidadeMaxima;
    }


    public void imprime() {
        System.out.println("----------------------------------");
        System.out.println(this.nome);
        System.out.println("Velocidade Máxima: " + this.velocidadeMaxima);
        System.out.println("Velocidade Limite: " + velocidadeLimite);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }
}
