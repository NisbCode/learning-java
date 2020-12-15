package Estudando.javacore.B_introducaometodos.classes;


//1- Primeiro define a classe
public class Estudante {

    //2- Depois as variaveis (e se elas serão públicas ou não)
    private String nome;
    private int idade;
    private double[] notas;

    //3- E agora os métodos, este será o responsável por imprimir
    public void print() {
        System.out.println("Nome: " + this.nome + "\n");
        System.out.println("Idade: " + this.idade);
        if (this.notas != null) {
            for (double nota : this.notas) {
                System.out.print(nota + " ");
                //Esta forma acima faria com que a referencia se torne os valores por conta do for que recebe uma variável
                //Assim abaixo você está imprimindo apenas uma referencia e não o valor em si
                //System.out.print("Notas: " + this.notas);
            }
        }
    }

    //4- Este vai ser o método criado para tirar a média
    public void tirarMedia() {
        double media = 0;

        //NÃO ESQUECE QUE AQUI ABAIXO O "NOTA" VAI RECEBER CADA VALOR DE "NOTAS", CÊ TÁ CONFUNDINDO SAPOHA
        for (double nota : this.notas) {

            //E agora a média vai receber ela mesma mais nota, ou seja, somar a poha td
            //Ex.: media = 0; media +nota[0] = 8.5; media = 8.5; media + nota[1] = 13.5; media = 13.5, etc e esse processo
            //vai durar até que o valor "notas", no caso 3, acabe como mostrado no for
            media += nota;
        }

        //5- Nesse caso a soma de todas as notas vai receber ela dividida pelo número de notas
        media /= this.notas.length;
        if (media >= 6) {
            System.out.println("\n A média é " + media + ", situação do aluno: Aprovado");
        } else {
            System.out.println("\n A média é " + media + ", situação do aluno: Reprovado");
        }
    }

    //6- Esta é a hora de pôr o set que definirá o que pode ser alterado e o que não
    public void setNome(String nome) {
        this.nome = nome;
    }

    //CASO REMOVA ESTA PARTE(IDADE) O CÓDIGO NÃO PERMITIRÁ QUE QUALQUER UM MUDE A IDADE PRÉ DEFINIDA
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    //7- Agora iremos pegar as informações setadas retornando o valor de nome
    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public double[] getNotas() {
        return this.notas;
    }
}




