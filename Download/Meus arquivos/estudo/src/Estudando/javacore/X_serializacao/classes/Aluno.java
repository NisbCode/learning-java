package Estudando.javacore.X_serializacao.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//Ele extender Pessoa faz c q ela mostre tb
public class Aluno extends Pessoa implements Serializable {
    private long id;
    private String nome;
    private transient String password;  //transiente faz c que o atributo seja ignorado já q a senha n deve ser repassada, ela virá vazia
    private static String nomeEscola = "DevDojo";
    private transient Turma turma;  //aquela associação básica, caso vc n possa serializar essa classe mas queira a classe Aluno? transient

    //                                    Nesse caso, se vc precisar do q tem na classe Turma, existem dois métodos da classe Serializable#1
//    Construtor
    public Aluno(Long id, String nome, String password) {
        System.out.println("Dentro do construtor");
        this.id = id;
        this.nome = nome;
        this.password = password;
    }


    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", nomeEscola='" + nomeEscola + '\'' +
                ", turma=" + turma +
                '}';
    }



    //    #1  esses aq q tem q ser escritos na classe q vc quer serializar, eles tem q ter uma assinatura perfeita por serem especiais:
    private void writeObject(ObjectOutputStream oos) {
        try {
            oos.defaultWriteObject();       //Tente escrever e fazer a inicialização normal
            oos.writeUTF(turma.getNome());  //Escreva uma string
//            A ordem de ambas n importa desde q na leitura vc siga a msm ordem q colocou
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream ois) {
        try {
            ois.defaultReadObject();
            turma = new Turma(ois.readUTF());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getNomeEscola() {
        return nomeEscola;
    }

    public static void setNomeEscola(String nomeEscola) {
        Aluno.nomeEscola = nomeEscola;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}