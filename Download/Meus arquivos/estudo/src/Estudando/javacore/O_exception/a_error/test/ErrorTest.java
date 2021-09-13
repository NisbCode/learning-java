package Estudando.javacore.O_exception.a_error.test;

public class ErrorTest {
    public static void main(String[] args) {
        stackOverFlowError();
    }

//  Erro de estourar a memória por se tornar um looping
    public static void stackOverFlowError(){
        stackOverFlowError();
    }
}
