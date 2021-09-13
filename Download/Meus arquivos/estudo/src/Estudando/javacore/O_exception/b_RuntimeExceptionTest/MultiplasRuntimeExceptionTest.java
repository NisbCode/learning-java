package Estudando.javacore.O_exception.b_RuntimeExceptionTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class MultiplasRuntimeExceptionTest {
    public static void main(String[] args) {
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("dentro do ArrayIndexOutOfBoundsException");
        } catch (IllegalArgumentException e) {
            System.out.println("dentro do IllegalArgumentException");
        } catch (ArithmeticException e) {
            System.out.println("dentro do ArithmeticException");
        } catch (RuntimeException e) {
            System.out.println("dentro do RuntimeException");
        }
        try {
            talvezLanceException();
        }catch (SQLException | IOException e){
            System.out.println("Isso do Java 7 em diante");
        }
    }
    private static void talvezLanceException() throws SQLException, FileNotFoundException {

    }
}
