package Estudando.javacore.T_expressoesregulares;

public class TokenTest {
    public static void main(String[] args) {
//        Os tokens são os nomes nesse caso, e os delimitadores oq agt pôr no método split
        String str = "Willian9 Paulo1 Joana2 Camila3 Anna4 John5 Matheus";
        String[] tokens = str.split("\\d");
        for (String arr : tokens){
            System.out.println(arr.trim());
//            Método trim elimina o espaço em branco
        }
    }
}
