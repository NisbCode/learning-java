package Estudando.javacore.ZZFpadroesdeprojeto.classes;

public interface Moeda {
    String getSimbolo();
}

class Real implements Moeda {

    @Override
    public String getSimbolo() {
        return "R$";
    }
}

class Dolar implements Moeda {

    @Override
    public String getSimbolo() {
        return "USD";
    }
}
