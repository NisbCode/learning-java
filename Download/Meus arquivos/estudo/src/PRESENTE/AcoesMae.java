package PRESENTE;

import java.util.concurrent.TimeUnit;

public enum AcoesMae {
        DAR_CASTIGO("Mãe: ~dando castigo"),
        DAR_AMOR("Mãe: ~dando amor"),
        DEIXA_FAZER_ALGO("Mãe: - Tá, pode fazer isso aí..."),
        NAO_DEIXA_FAZER_ALGO("Mãe: - Não vai fazer isso 'u' "),
        DEIXA_FILHO_NO_CELULAR_E_DORME("Mãe: ZzZzZzZzZ..."),
        FILHO_CHEGA_EM_CASA_DE_MADRUGADA("Mãe: ~coloca o colchão do filho pra fora de casa"),
        DAR_WHOPPER("Mãe: ~dá whopper"),
        MANDA_COMER_VEGETAIS("Mãe: - Anda, come a vagem"),
        ABRACA("Mãe: ~abraça"),
        NO_DIA_DAS_MAES("Mãe: ~acorda e encontra um bilhete ao seu lado na cama, abrindo-o para ler");

        ;

        private String descricao;

        AcoesMae(String descricao) {
            this.descricao = descricao;

        }

        public String getDescricao() {
            return descricao;
        }

        public void sleep() {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


