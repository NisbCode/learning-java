package br.com.abc.javacore.Bintroducaometodos.teste;

import br.com.abc.javacore.Bintroducaometodos.classes.Estudante;

public class EstudanteTeste {
    public static void main(String[] args) {

        Estudante moonbyul = new Estudante();

        moonbyul.setNome("Moonbyul");
        moonbyul.setIdade(-1);
        moonbyul.setNotas(new double[]{3,6,9});

//          Seria desse jeito se os atributos fossem publicos, mas eles são privados
//        moonbyul.nome = "Moonbyul";
//        moonbyul.idade = 17;
//        moonbyul.notas =  new double[]{3,6,9};

        moonbyul.mostrarInformacoes();
        moonbyul.calcularMedia();
        System.out.println("Aprovado?: " + moonbyul.isAprovado());

//        moonbyul.mostrarInformacoes();
//        moonbyul.calcularMedia();
    }
}
