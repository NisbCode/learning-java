package br.com.abc.javacore.Xserializacao.classe;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/***
 * SERIALIZAÇÃO:
 * Salvar um objeto num arquivo de dados
 * Classes utilizadas FileOutputStream e ObjectOutputString
 */

                // Se não tiver isso, uma exception é lançada
public class Aluno implements Serializable {
    private Long id;
    private String nome;
    // Para não serializar um atributo, deve-se chamar
    // este de transient
    // Após isso, deve-se gravar novamente o objeto e,
    // então, ele virá como null
    private transient String password;
    private static String nomeEscola = "devDojo";
    // Método do qual teoricamente não se tem acesso,
    // veja como lidar usando os 2 métodos especiais
    private transient Turma turma;

    public Aluno(Long id, String nome, String password) {
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
                ", nomeEscola='" + nomeEscola +
                ", turma='" + turma +
                '}';
    }

    // Quando você quer serializar um atributo, mas não tem
    // acesso a ele, segue dois métodos:
    private void writeObject(ObjectOutputStream objectOutputStream){
        try{
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeUTF(turma.getNome());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream objectInputStream){
        try{
            objectInputStream.defaultReadObject();
            turma = new Turma(objectInputStream.readUTF());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
