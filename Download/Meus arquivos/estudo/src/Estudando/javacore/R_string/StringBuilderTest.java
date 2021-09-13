package Estudando.javacore.R_string;

public class StringBuilderTest {
    public static void main(String[] args) {
        String s = "Uma frase comum";
        StringBuilder sb = new StringBuilder(16); //<--- O num. é a capacidade de caracteres q ele te disponibiliza,limite é 16
//      Transforma StringBuilder em String:   s = sb.toString();
        sb.append(" test");
        sb.append("def").insert(3, "ghi").reverse().delete(2, 4);
        System.out.println(sb);
    }
}
