package br.com.abc.javacore.Aintroducaoclasses.Testes;

import br.com.abc.javacore.Aintroducaoclasses.classe.Professor;

public class ProfessorTeste {
    public static void main(String[] args) {

//      "ProfessorParametroReference" é uma variavel de referencia
        Professor cintia = new Professor();
        cintia.nome = "Cíntia";
        cintia.matricula = "12345678";
        cintia.rg = 293657895;
        cintia.cpf = 18296548965L;

        System.out.println("Nome: " + cintia.nome);
        System.out.println("Matrícula: " + cintia.matricula);
        System.out.println("Identidade: " + cintia.rg);
        System.out.println("CPF: " + cintia.cpf);
    }

    /***
     * Caso outro objeto seja criado e "cintia"
     * seja igualado a variavel de instancia desse
     * novo objeto, os dados de cíntia serão
     * substituidos pelos do novo professor
     */
}