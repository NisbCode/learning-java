package br.com.abc.javacore.Minterfaces.classes;

public class Carro implements Tributavel {

   //16- REGRA DO OVERRIDE:
    // ao criar um método sobrescrito
    // de uma classe numa subclasse,
    // o modificador de acesso deve ser
    // obrigatoriamente publico
    // Modificadores(por ordem de restrição):
    // protected > default > protected > public
    @Override
    public void cacularImposto() {

    }
}
