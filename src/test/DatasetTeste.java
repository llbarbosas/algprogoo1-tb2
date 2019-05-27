package test;
import sisapam.Dataset;

public class DatasetTeste {
    public static void main(String[] args) {
        /*
         * Criação dos casos de teste
         * Parametros: int nExemplos, int nAtributos, 
         * int nClasses, String nome
         */
        int casos = 4;
        int[] nExemplosTeste = {1, 4, 5, 7};
        int[] nAtributosTeste = {4, 6, 5, 2};
        int[] nClassesTeste = {0, 2, 11, 9};
        String[] nomesTeste = {"Dataset 1", "Dataset 2", "\n", ""};

        for(int i=0; i<casos; i++)
            new Teste(
                new Dataset(nExemplosTeste[i], nAtributosTeste[i],
                nClassesTeste[i], nomesTeste[i]),
                new Object[]{ "getNumExemplos", new Object[]{} },
                new Object[]{ "getNumAtributos", new Object[]{} },
                new Object[]{ "getNumClasses", new Object[]{} },
                new Object[]{ "getNome", new Object[]{} }
            );

    }
}