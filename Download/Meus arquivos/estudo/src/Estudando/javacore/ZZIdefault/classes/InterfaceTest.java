package Estudando.javacore.ZZIdefault.classes;


import Estudando.javacore.ZZIdefault.interfacess.MyList;

public class InterfaceTest implements MyList {
    public static void main(String[] args) {
        MyList.sort();
        new InterfaceTest().remove();
    }

    @Override
    public void add() {
        System.out.println("dentro do add");
    }
}
