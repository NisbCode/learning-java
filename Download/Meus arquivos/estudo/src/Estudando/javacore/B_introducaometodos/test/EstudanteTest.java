package Estudando.javacore.B_introducaometodos.test;

import Estudando.javacore.B_introducaometodos.classes.Estudante;

public class EstudanteTest {
    public static void main(String[] args) {
        Estudante estudante = new Estudante();

        //8- Agora que está privado os valores, teremos que pegar os valores aqui
        estudante.setNome("Carla");

        //CASO VOCÊ DELETE O SET DE IDADE, APAGUE ESTA PARTE(IDADE) SE NÃO DARÁ ERRO
        estudante.setIdade(16);
        estudante.setNotas(new double[]{10, 8.5, 8});

        estudante.print();
        estudante.tirarMedia();

        //9- Dps de usar o get para retornar os valores, podemos finalmente imprimir:
        System.out.println(estudante.getNome());
        System.out.println(estudante.getIdade());
        System.out.println(estudante.getNotas());

        //E CHAME ELE DESTA FORMA:
        //        estudante.getIdade();
    }
}
