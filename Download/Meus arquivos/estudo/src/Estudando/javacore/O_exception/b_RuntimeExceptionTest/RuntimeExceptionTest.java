package Estudando.javacore.O_exception.b_RuntimeExceptionTest;

public class RuntimeExceptionTest {
    public static void main(String[] args) {
        try {
            divisor(10, 0);

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    private static void divisor(int num1, int num2){
        if(num2 == 0){
            throw new IllegalArgumentException("Passe um número diferente de 0 para num2");
        }
        System.out.println(num1/num2);
    }
}