package Estudando.javacore.Y_colecoes.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/***
 * INTERFACE MAP
 */

public class MapTest {
    public static void main(String[] args) {
        // K = key, V = value
        // Para manter a ordem de inserção


//  Q tipo é a chave?  |---> E o valor?
//             |       |
        Map<String, String> map = new LinkedHashMap<>(); //Se usa Hash n tem cm garantir cm os elementos estarão organizados
                                                         // (A n ser q use LinkedHashMap q mantém a ordem de iserção)
        map.put("teklado", "teclado");
        map.put("mouze", "mouse");
        map.put("vc", "você");
        // Diferente do hashSet, no hashMap o valoro repetido
        // substitui o antigo, não é ignorado
        map.put("meza", "mesa");

        // É possível iterar tanto sobre as chaves
        // quanto sobre os valores
        for(String key : map.keySet()){  //É um Set pq n pode ter elementos duplicados
            System.out.println(key);
        }

        // Mas para usar o for tanto em chave quanto
        // em valor, só assim
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

    }
}