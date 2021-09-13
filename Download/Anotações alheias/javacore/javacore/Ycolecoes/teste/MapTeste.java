package br.com.abc.javacore.Ycolecoes.teste;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/***
 * INTERFACE MAP
 */

public class MapTeste {
    public static void main(String[] args) {
        // K = key, V = value
                            // Para manter a ordem de inserção
        Map<String, String> map = new LinkedHashMap<>();
        map.put("teklado", "teclado");
        map.put("mouze", "mouse");
        map.put("vc", "você");
        // Diferente do hashSet, no hashMap o valoro repetido
        // substitui o antigo, não é ignorado
        map.put("meza", "mesa");

        // É possível iterar tanto sobre as chaves
        // quanto sobre os valores
        for(String key : map.keySet()){
            System.out.println(key);
        }

        // Mas para usar o for tanto em chave quanto
        // em valor, só assim
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

    }
}
