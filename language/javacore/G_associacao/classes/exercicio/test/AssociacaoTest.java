package Estudando.javacore.G_associacao.classes.exercicio.test;

import Estudando.javacore.G_associacao.classes.exercicio.classes.Aluno;
import Estudando.javacore.G_associacao.classes.exercicio.classes.Local;
import Estudando.javacore.G_associacao.classes.exercicio.classes.Professor;
import Estudando.javacore.G_associacao.classes.exercicio.classes.Seminario;

public class AssociacaoTest {
    public static void main(String[] args) {

        Aluno aluno = new Aluno("Nathália", 16);
        Aluno aluno2 = new Aluno("Carla", 19);

        Seminario sem = new Seminario("Como ser um baita programador");
        Professor prof = new Professor("Yoda", "Usar a força para programar");
        Local local = new Local("Everygreen", "Springfield");

        aluno.setSeminario(sem);
        aluno2.setSeminario(sem);

//        Se quiser ver o que acontece caso esqueção de digitar o nome de algo, comente (ctrl+/) uma das 3 linhas
//        abaixo(ou as três, vc decide, combine):
        sem.setProfessor(prof);
        sem.setLocal(local);
        sem.setAlunos(new Aluno[]{aluno, aluno2});

        Seminario[] semArray = new Seminario[1];
        semArray[0] = sem;
        prof.setSeminario(semArray);


        sem.print();
        prof.print();
    }
}