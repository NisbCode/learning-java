package br.com.abc.javacore.Fmodificadoresestatico.teste;

import br.com.abc.javacore.Fmodificadoresestatico.classes.Carro;

public class CarroTeste {
        public static void main(String[] args) {
            Carro.setVelocidadeLimite(500);

            Carro bmw = new Carro("BMW", 280);
            Carro audi = new Carro("Audi", 275);
            Carro mercedes = new Carro("Mercedes", 290);

            bmw.imprimeInformacoes();
            audi.imprimeInformacoes();
            mercedes.imprimeInformacoes();

            System.out.println("##################");

//            Sem o operador static, apenas a velocidade limite da
//            bmw mudaria, pois estaria vinculada apenas ao endereço de memoria dela
//            bmw.setVelocidadeLimite(220);


            bmw.imprimeInformacoes();
            audi.imprimeInformacoes();
            mercedes.imprimeInformacoes();

//            Contudo, as boas práticas dizem que não é assim
//            que se deve mudar um valor, chamando por um objeto
//            Deve se chamar a classe:



        }
}
