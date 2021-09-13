package PRESENTE;

public class MaeFilho {
    public static void main(String[] args) {
        Mae mae = new Mae();
        Filho filha = new Filho(mae);



        /**
         * A MÁGICA ACONTECE AQUI
         * Depois do AcoesMae., você
         * pode colocar qualquer uma das
         * ações presentes na lista:
         * DAR_CASTIGO
         * DAR_AMOR
         * DEIXA_FAZER_ALGO
         * NAO_DEIXA_FAZER_ALGO
         * DEIXA_FILHO_NO_CELULAR_E_DORME
         * FILHO_CHEGA_EM_CASA_DE_MADRUGADA
         * DAR_WHOPPER
         * MANDA_COMER_VEGETAIS
         * ABRACA,
         * daí, é só dar alt + shift + f10
         *
         * E QUANDO EXPLORAR TODOS
         * Use a opção NO_DIA_DAS_MAES,
         * precisa ser no fim do tour
         *
         */
        mae.acao = AcoesMae.ABRACA;
        filha.reacao();
    }
}

