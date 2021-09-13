package br.com.abc.javacore.Ycolecoes.classe;

public class Celular {
    /**
     * Comparando a igualdade entre dois celulares
     * (e montando nosso proprio método equals)
     */
    private String nome;
    private String IMEI;

    public Celular(String nome, String IMEI) {
        this.nome = nome;
        this.IMEI = IMEI;
    }

    /***
     * HASHCODE:
     * Usado como código numérico para identificação de Strings
     * baseado em tomar como pontos asposições das letras utilizadas no
     * alfabeto
     * Ex: Alex = 1 + 12 + 5 + 24 = 42 <-- Esse é o HashCode
     * Para invocá-lo, basta dar ctrl + o
     * Regras:
     * 1- Se em x.equals(y), y é true, em y.hashCode() == x.hashCode(),
     * 2- 2 hashCodes iguais não vai fazer o equals retornar true
     * 3- x.equals(y) == false, nada no hashCode
     * 4- Se y.hashCode() != x.hashCode() deverá ser false
     */

    @Override
    public int hashCode() {
        // Se o IMEI for diferente de null, retorna o hashCode do IMEI,
        // caso contrário, vai retornar 1
        return IMEI != null ? IMEI.hashCode() : 1;
    }

    /**
     * REGRAS PARA CRIAÇÃO DO MÉTODO EQUALS
     * 1- Deve ser reflexivo: x.equals(x) tem que ser true
     * para tudo que for diferente de null
     * 2- Simétrico: para x e y diferentes de null, se x.equals(y) == true,
     * logo, y.equals(x) também deve ser true
     * 3- Transitividade: para x, y, z diferentes de null, se x.equals(y) for true,
     * logo, y.equals(x) true e x.equals(z) == true, então, y.equals(z) também
     * é true
     * 4- Consistente: x.equals(y) deve sempre retornar o mesmo valor
     * 5- para c diferente de null, x.equals(null) tem que retornar false;
     */
    // Agora para criar, ctrl + o e selecione o equals
    @Override
    public boolean equals(Object obj) {
        // Checar se um objeto e nulo e retornar false se sim
        if(obj == null) return false;
        // Checar se os objetos estão no mesmo endereço de memoria
        if (this == obj) return true;
        // Além disso, checar ser as classes são do mesmot tipo
        if (this.getClass() != obj.getClass()) return false;
        Celular outroCelular = (Celular) obj;
        // Dois celulares são identicos se os IMEIs deles forem iguais
                            // Comparando duas Strings aqui, não mais
                            // o objeto Celular, por isso esse uso do equals
        //"Retorne IMEI sendo diferente de null e comparando o IMEI padrão com o IMEI dado no objeto"
        return "O IMEI dos celulares é igual?:" + IMEI != null && IMEI.equals(outroCelular.getIMEI());
    }

    @Override
    public String toString() {
        return "Celular{" +
                "nome='" + nome + '\'' +
                ", IMEI='" + IMEI + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }
}
