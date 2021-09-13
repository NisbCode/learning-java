package Estudando.introducao.EstudoArrays;

public class Arrays5 {
    public static void main(String[] args) {
        int[][] dias = new int[3][];

        //Temos essas 2 formas:
        dias[0] = new int [2];
        // está faz com que ela tenha esse valor:
        dias[1] = new int []{1, 2, 3};
        dias[2] = new int [4];

        for(int[] ref : dias){
            for (int num : ref ){
                System.out.println(num);
            }
        }
    }
}
