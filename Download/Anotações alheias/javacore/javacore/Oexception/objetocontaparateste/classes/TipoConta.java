package br.com.abc.javacore.Oexception.objetocontaparateste.classes;

public enum TipoConta {
    COMUM("Comum"),
    PREMIUM("Premium");

    private String tipoParaImpressão;

    TipoConta(String tipoParaImpressão) {
        this.tipoParaImpressão = tipoParaImpressão;
    }

    public String getTipoParaImpressão() {
        return tipoParaImpressão;
    }
}
