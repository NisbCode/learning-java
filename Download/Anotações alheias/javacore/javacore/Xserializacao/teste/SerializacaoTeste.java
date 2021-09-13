package br.com.abc.javacore.Xserializacao.teste;

import br.com.abc.javacore.Xserializacao.classe.Aluno;
import br.com.abc.javacore.Xserializacao.classe.Turma;

import java.io.*;


public class SerializacaoTeste  {
    public static void main(String[] args) {
        gravadorObjeto();
        leitorObjeto();
    }

    private static void gravadorObjeto(){
        Turma turma = new Turma("Maratona Java");
        Aluno aluno = new Aluno(1L, "Amanda Marques", "155i2845");
        aluno.setTurma(turma);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("aluno.serializado"))){
            // Salvar um objeto num arquivo
            objectOutputStream.writeObject(aluno);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void leitorObjeto(){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("aluno.serializado"))){
            Aluno aluno = (Aluno) objectInputStream.readObject();
            System.out.println(aluno);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
