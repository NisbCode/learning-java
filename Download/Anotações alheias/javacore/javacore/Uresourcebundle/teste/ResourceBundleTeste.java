package br.com.abc.javacore.Uresourcebundle.teste;

import java.util.Locale;
import java.util.ResourceBundle;

/***
 * RESOURCE BUNDLE:
 * Serve para traduzir seu código em outra língua através
 * de um arquivo properties
 */

public class ResourceBundleTeste {
    public static void main(String[] args) {
        System.out.println(Locale.getDefault());
                                // Note que não é um objeto,
                                // é criado através do getBundle
                                                // baseName: o título do arquivo criado
                                                // antes da lingua
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("good.morning"));

        //Traduzindo para o português

        resourceBundle = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("good.morning"));
        System.out.println(resourceBundle.getString("show"));

        // ORDEM DE BUSCA DOS RESOURCE BUNDLES:
        // Supondo que tenhamos criado algo assim:
        // Locale local = new Locale("fr", "CA");
        // RessourceBundle.getBundle("messages", locale;
        // O java vai lidar da seguinte forma:
        // 1- vai procurar por messages_fr_CA.properties
        // 2- vai procurar por messages_fr.properties
        // 3- vai procurar pelo arquivo da lingua e pais do seu sistema operacional
        // messages_pt_BR.messages
        // 4- vai procurar pela lingua do seu SI
        // messages_pt.properties
        // 5- vai procurar pela base message.properties
        // 6- Se ele não encontrar nada, vai lançar uma exceção

    }
}
