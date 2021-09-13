package br.com.abc.javacore.Npolimorfismo.classes;

                //DAO: data access object
                //objeto usado para persistencia
                // de dados
public interface GenericDAO {
    //Lembrando do conceito de interface,
    //em que a classe filha deve necessariamente
    // cumprir o metodo, n importa como
    public abstract void save();

}
