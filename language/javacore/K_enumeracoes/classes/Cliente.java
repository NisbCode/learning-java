package Estudando.javacore.k_enumeracoes.classes;

public class Cliente {
    public enum TipoPagamento {
        AVISTA, APRAZO
    }
    private String nome;
    //Isso vai servir como uma espécime de associação para a outra classe
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
                "nome = '" + nome + '\'' +
                ", tipoCliente = " + tipoCliente +
                ", tipoPagamento = " + tipoPagamento +
                ", número = "+tipoCliente.getTipo()+
                ", nome = "+ tipoCliente.getNome()+
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
