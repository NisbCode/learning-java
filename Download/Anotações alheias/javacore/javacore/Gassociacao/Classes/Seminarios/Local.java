package br.com.abc.javacore.Gassociacao.Classes.Seminarios;

public class Local {
    //Atributos da classe
    private String rua;
    private String bairro;

    //Construtores
    public Local(String rua, String bairro){
        this.rua = rua;
        this.bairro = bairro;
    }

    public Local(){}

    //Getters e Setters
    public void setRua(String rua){
        this.rua = rua;
    }
    public String getRua(){
        return rua;
    }

    public void setBairro(String bairro){
        this.bairro = bairro;
    }
    public String getBairro(){
        return bairro;
    }

    //Método print
    public void imprime(){
        System.out.println("----- Ficha do local -----");
        System.out.println("Endereço: " + this.rua + ", " + this.bairro);
    }

}
