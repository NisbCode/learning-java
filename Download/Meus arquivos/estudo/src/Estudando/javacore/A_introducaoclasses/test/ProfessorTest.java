package Estudando.javacore.A_introducaoclasses.test;

import Estudando.javacore.A_introducaoclasses.classes.Professor;

public class ProfessorTest {
    public static void main(String[] args) {
        Professor prof = new Professor();

        prof.nome = "Augusto Prereira";
        prof.matricula = "02206084";
        prof.RG = "2718293716";
        prof.CPF = "153.678.322-08";

        Professor prof2 = new Professor();

        prof2.nome = "Roberta Santos";
        prof2.matricula = "67892004";
        prof2.RG = "36045882";
        prof2.CPF = "834.947.222-06";


        System.out.println(prof.nome);
        System.out.println(prof.matricula);
        System.out.println(prof.RG);
        System.out.println(prof.CPF);
        System.out.println("----------------------------");
        System.out.println(prof2.nome);
        System.out.println(prof2.matricula);
        System.out.println(prof2.RG);
        System.out.println(prof2.CPF);
    }
}
