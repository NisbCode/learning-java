package Estudando.javacore.J_modificadorfinal.classes;

public class Carro {
    public static final double VELOCIDADE_FINAL = 250;
//    Nesse caso vc n coloca static pq o comprador pode mudar
    public final Comprador comprador = new Comprador();
    private String nome;
    private String marca;


    @Override
    public String toString() {
        return "Carro{" +
                "nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }



    public Comprador getComprador() {
        return comprador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
