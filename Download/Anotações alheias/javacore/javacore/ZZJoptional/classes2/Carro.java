package br.com.abc.javacore.ZZJoptional.classes2;

import br.com.abc.javacore.ZZJoptional.classes.SeguradoraOptional;

public class Carro {
    private SeguradoraOptional seguradoraOptional;
    private String nome;

    public Carro(SeguradoraOptional seguradoraOptional, String nome) {
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


    public SeguradoraOptional getSeguradoraOptional() {
        return seguradoraOptional;
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
