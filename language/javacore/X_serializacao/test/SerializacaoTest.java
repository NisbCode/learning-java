package Estudando.javacore.X_serializacao.test;

import Estudando.javacore.X_serializacao.classes.Aluno;
import Estudando.javacore.X_serializacao.classes.Turma;

import java.io.*;

public class SerializacaoTest {
    public static void main(String[] args) {
        gravadorObjeto();
        leitorObjeto();
    }

//    Para Escrever:
    private static void gravadorObjeto() {
        Turma t = new Turma("Maratona Java, só para os campeões");
        Aluno aluno = new Aluno(1L, "Naty Ignácio", "123456789"); //O "L" vem de long
        aluno.setTurma(t);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aluno.txt"))) { //Salva a caracteristica de um objeto p um arquivo
            oos.writeObject(aluno);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    Para Ler:
    private static void leitorObjeto() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aluno.txt"))) {
            Aluno aluno = (Aluno) ois.readObject(); //readObjetct retorna um object, então vc força ele em uma variável
            System.out.println(aluno);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}