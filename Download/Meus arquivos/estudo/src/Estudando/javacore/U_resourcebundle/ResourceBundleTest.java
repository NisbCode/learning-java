package Estudando.javacore.U_resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {
    public static void main(String[] args) {
        System.out.println(Locale.getDefault());
//               Aq tem q tá o base name, o nome antes do 1 underline               Linguá do file             País do file
//                                                                  |                            |             |
        ResourceBundle rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        System.out.println(rb.getString("Hello"));
        System.out.println(rb.getString("good.morning"));
        System.out.println(rb.getString("show"));
        rb = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
        System.out.println(rb.getString("Hello"));
        System.out.println(rb.getString("good.morning"));
        System.out.println(rb.getString("show"));

//        Locale locale =  new Locale("fr", "CA");
//        ResourceBundle.getBundle("message", locale);
//
//        Este é o caminho q seu pc faz para achar um resource Bundle
//        messages_fr_CA.propriedades
//        messages_fr.propriedades
//        messages_en_USA.propriedades
//        messages_en.propriedades
//        messages.propriedades
    }
}