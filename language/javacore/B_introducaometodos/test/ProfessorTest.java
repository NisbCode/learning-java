package Estudando.javacore.B_introducaometodos.test;

import Estudando.javacore.B_introducaometodos.classes.Professor;

public class ProfessorTest {
    public static void main(String[] args) {
        Professor prof = new Professor();

        prof.nome = "Marcos";
        prof.matricula = "18395274";
        prof.RG = "38375924";
        prof.CPF = "568.246.227-06";


        Professor prof2 = new Professor();

        prof2.nome = "Ana";
        prof2.matricula = "4002";
        prof2.RG = "308-62";
        prof2.CPF = "698.754.555-06";

        prof.imprime();
        prof2.imprime();
    }
}
