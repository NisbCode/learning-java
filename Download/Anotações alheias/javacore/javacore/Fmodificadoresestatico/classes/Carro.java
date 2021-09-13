package br.com.abc.javacore.Fmodificadoresestatico.classes;

public class Carro {
    private String nome;
    private double velocidadeMaxima;
    /***
     * OPERADOR ESTÁTICO (STATIC)
     * torna um atributo/método pertencente a uma classe,
     * não apenas a um endereço de memoria
     *REGRA GERAL:
     * "Se você não está acessando um atributo/método de outra classe (criando um objeto, por exemplo),
     * esse atributo pode ser estático"
     */

    private static double velocidadeLimite = 240;

    public Carro(String nome, double velocidadeMaxima) {
        this.nome = nome;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public void imprimeInformacoes(){
        System.out.println("-------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Velocidade máxima: " + this.velocidadeMaxima);
//                                              this é usado apenas ao se lidar com objetos
//                                              e usando atributos estaticos,
//                                              estamos lidando com classes
        System.out.println("Velocidade Limite: " + velocidadeLimite);
    }

    public Carro() {}


    public static void setVelocidadeLimite(double velocidadeLimite){
//        Ao invés de usar o this. por não estarmos lidando com objetos
//      this.velocidadeLimite = velocidadeLimite;
//        Usamos o nome da classe antes do atributo:
        Carro.velocidadeLimite = velocidadeLimite;
    }
    public static double getVelocidadeLimite(){
        return velocidadeLimite;
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

//     Caso o atribudo velocidadeLimite não seja estatico
//    public double getVelocidadeLimite() {
//        return velocidadeLimite;
//    }
//
//    public void setVelocidadeLimite(double velocidadeLimite) {
//        this.velocidadeLimite = velocidadeLimite;
//    }
}

