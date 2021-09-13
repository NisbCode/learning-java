package br.com.abc.javacore.Gassociacao.Teste;

import br.com.abc.javacore.Gassociacao.Classes.Seminarios.Aluno;
import br.com.abc.javacore.Gassociacao.Classes.Seminarios.Local;
import br.com.abc.javacore.Gassociacao.Classes.Seminarios.Professor;
import br.com.abc.javacore.Gassociacao.Classes.Seminarios.Seminario;

public class AssociacaoTeste {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Moon Byulyi", 26);
        Aluno aluno2 = new Aluno("Park Jimin", 20);

        Seminario sem = new Seminario("Como fazer um rap foda");
        Professor prof = new Professor("Yoda", "Usar a força para fazer rap");
        Local local = new Local("Rua das araras", "Seul");

        //Associação
        aluno.setSeminario(sem);
        aluno2.setSeminario(sem);

        sem.setProfessor(prof);
        sem.setLocal(local);
        sem.setAlunos(new Aluno[]{aluno, aluno2});

        Seminario[] semArray = new Seminario[1];
        semArray[0] = sem;
        prof.setSeminario(semArray);

        aluno.imprime();
        sem.imprime();
        prof.imprime();
        local.imprime();

    }
}
