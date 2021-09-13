package br.com.abc.javacore.Kenum.classe;

public class Cliente {
    /***
     * TIPO ENUM:
     * Usados para estrutura de dados organizados,
     * agrupando valores que tenham o mesmo sentido
     * dentro dessa estrutura
     */
    //Variável do tipo enumeração
    // (feita dentro dessa classe (não recomendado));
    public enum TipoPagamento{
        AVISTA, APRAZO;
    }
    private String nome;
    //Variável do tipo enumeração
    // (feita em outra classe)
    private TipoCliente tipoCliente;
    private TipoPagamento tipoPagamento;

    public Cliente(String nome, TipoCliente tipoCliente, TipoPagamento tipoPagamento) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", tipo=" + tipoCliente.getNome() +
                ", tipoPagamento=" + tipoPagamento +
                ", numero=" + tipoCliente.getTipo() +
                '}';
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCliente getTipo() {
        return tipoCliente;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipoCliente = tipo;
    }
}
