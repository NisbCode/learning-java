package br.com.abc.javacore.Minterfaces.teste;

import br.com.abc.javacore.Minterfaces.classes.Produto;

public class TesteProduto {
    public static void main(String[] args) {
        //15- Criação do objeto notebook, derivado de produto
        //Lembrete: interface é uma classe abstrata,
        // sendo assim, não deve criar objeto
        Produto p = new Produto("Notebook", 4, 3000);
        p.cacularImposto();
        p.calculaFrete();
        System.out.println(p);
    }
}
