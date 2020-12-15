package Estudando.javacore.Q_whappers;

public class WhappersTest {
    public static void main(String[] args) {
        byte bytePrimitivo = 1;
        short shortPrimitivo = 1;
        int intPrimitivo = 10;
        long longPrimitivo = 10;
        float floatPrimitivo = 10;
        double doublePrimitivo = 10;
        char charPrimitivo = 'A';
        boolean booleanPrimitivo = true;

        Byte byteWhapper = 1;
        Short shortWhapper = 1;
        Integer intWhapper = new Integer("10");
        Long longWhapper = Long.valueOf("10");
        Float floatWhapper = new Float("10");
        Double doubleWhapper = 10D;
        Character charWhapper = 'A';
        Boolean booleanWhapper = new Boolean("TrUE");




        System.out.println(Character.isDigit('9'));
        System.out.println(Character.isLetter('1'));
        System.out.println(Character.isLetterOrDigit('#'));
        System.out.println(Character.isUpperCase('A'));
        System.out.println(Character.isLowerCase('A'));
        System.out.println(Character.toUpperCase('s'));
    }
}
