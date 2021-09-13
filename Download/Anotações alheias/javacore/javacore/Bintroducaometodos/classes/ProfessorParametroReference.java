package br.com.abc.javacore.Bintroducaometodos.classes;

/***
 * EXERCICIO
 * CRIE OS SEGUINTES ATRIBUTOS PRA ESSA CLASSE:
 * Nome
 * Matricula
 * Rg
 * cpf
 *
 * EM SEGUIDA, CRIE UMA CLASSE DE TESTE PARA
 * PREENCHER E IMPRIMIR OS DADOS
 */

public class ProfessorParametroReference {

    public String nome;
//  Certas instituições adicionam também letras
//  à matricula, sendo assim necessário utilizar
//  String, ao inves de int
//  SÓ SE DEVE USAR INT SE TIVER A CERTEZA DE QUE
//  SÓ NUMEROS SERÃO UTILIZADOS
    public String matricula;
    public int rg;
    public String cpf;

    /***
     * PARÂMETROS TIPO REFERENCE:
     * da mesma forma que temos parâmetros de tipo
     * primitivo em objetos ~public void soma(int num1, int num2){~,
     * por exemplo, também temos PARÂMETROS TIPO REFERENCE,
     * parâmetros em que os tipos vêm de objetos que nós
     * mesmos criamos
     */
//                ProfessorParametroReference: classe autoral criada
//                prof: parâmetro a ser preenchido
//    public void imprime(ProfessorParametroReference prof){
//        System.out.println("-------------------");
//        System.out.println(prof.cpf);
//        System.out.println(prof.matricula);
//        System.out.println(prof.rg);
//        System.out.println(prof.nome);
//        prof.nome = "Ariana";
//        System.out.println(prof.nome);
//    }

    /***
     * Mas usar um parâmetro no método pode gerar
     * erros no código, então é mais fácil usar
     * a palavra reservada "this", assim
     * o método é diretamente chamado, assim:
     */

    public void imprime(){
        System.out.println("-------------------");
        System.out.println(this.cpf);
        System.out.println(this.matricula);
        System.out.println(this.rg);
        System.out.println(this.nome);

    }

    }
