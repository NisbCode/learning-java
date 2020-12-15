package Estudando.javacore.ZZFpadroesdeprojeto.teste;


import Estudando.javacore.ZZFpadroesdeprojeto.classes.AviaoSingleton;
import Estudando.javacore.ZZFpadroesdeprojeto.classes.AviaoSingletonEnum;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class viaoSingletonTeste {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("Assento agendado?: ");
        agendarAssento("1A");
        System.out.println("Assento agendado?: ");
        agendarAssento("1A");

        //Criando objeto msm c construtor privado:

//        AviaoSingleton aviaoSingleton = AviaoSingleton.getINSTANCE();
//        AviaoSingleton aviaoSingleton1 = null;
//        Constructor[] constructors = AviaoSingletonEnum.class.getDeclaredConstructors();  <---Lembrete: Retirar o enum p ver o quão quebrado esta classe é sendo class normal
//        for (Constructor constructor : constructors){
//            constructor.setAccessible(true);
//            aviaoSingleton1 = (AviaoSingleton) constructor.newInstance();
//            break;
//        }
    }

    private static void agendarAssento(String assento){
        // Agora, nesse caso, o objeto é especificamente
        // o que tá dentro do método getINSTANCE, o que
        // vai impedir que objetos sejam removidos duplamente
        AviaoSingleton a = AviaoSingleton.getINSTANCE();  //Vc faz assim se o construtor tá privado(Nesse caso estava qnd tava fazendo a EAGER)
        System.out.println(a.escolherAssento(assento));
    }
}
