package Estudando.introducao.EstudoArrays;

public class Arrays6 {
    public static void main(String[] args) {
        int[][] dias = {{0, 0}, {1, 2, 3}, {0, 22, 0, 0}};
        for (int[] ref : dias) {
            for (int num : ref) {
                System.out.println(num);
            }
        }
    }
}