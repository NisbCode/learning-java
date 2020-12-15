package Estudando.javacore.ZZJoptional.classes;

import java.util.Optional;

public class CarroOptional {
    private SeguradoraOptional seguradoraOptional;
    private String nome;

    public CarroOptional(SeguradoraOptional seguradoraOptional, String nome) {
        this.seguradoraOptional = seguradoraOptional;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "CarroOptional{" +
                "seguradoraOptional=" + seguradoraOptional +
                ", nome='" + nome + '\'' +
                '}';
    }

    // getSeguradoraOptional opcional(optional) porque nem sempre
    // um carro pode ter seguradoraOptional
    public Optional<SeguradoraOptional> getSeguradoraOptional() {
        return Optional.ofNullable(seguradoraOptional);
    }


    public void setSeguradoraOptional(SeguradoraOptional seguradoraOptional) {
        this.seguradoraOptional = seguradoraOptional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
