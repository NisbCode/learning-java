package br.com.abc.javacore.Ycolecoes.classe;

import java.util.Objects;

/***
 * INTERFACE COMPARABLE:
 * Serve para definir o padrão de ordem de uma lista
 */
public class Produto implements Comparable<Produto> {
    private String serialNumber;
    private String nome;
    private Double preco;
    private int quantidade;

    public Produto(String serialNumber, String nome, Double preco) {
        this.serialNumber = serialNumber;
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(String serialNumber, String nome, Double preco, int quantidade) {
        this.serialNumber = serialNumber;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // métodos equals e hashcode: "Se um produto tiver o HASHCODE do serial number
    // EQUALS ao de outro produto, eles serão considerados iguais"
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(serialNumber, produto.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "serialNumber='" + serialNumber + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Ao implementar a interface Comparable, deve-se também
    // implementar os métodos dela, ness caso, o compareTo
    @Override
    public int compareTo(Produto outroObjeto) {
        // Para pôr o serialNumber em ordem crescente
//        return this.serialNumber.compareTo(outroObjeto.getSerialNumber());
        // Para pôr os nomes em ordem crescente
//        return this.nome.compareTo(outroObjeto.getNome());
        // Para pôr os precos em ordem crescente (lembrando que
        // os tipos devem ser Wrappers, não primitivos)
        return this.preco.compareTo(outroObjeto.getPreco());
    }

}
