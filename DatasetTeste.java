import src.Dataset;

public class DatasetTeste {
    public static void main(String[] args) {
        /*
         * Criação dos casos de teste
         * Parametros: int nExemplos, int nAtributos, 
         * int nClasses, String nome
         */
        int[] nExemplosTeste = {1, 4, 5, 7};
        int[] nAtributosTeste = {4, 6, 5, 2};
        int[] nClassesTeste = {0, 2, 11, 9};
        String[] nomesTeste = {"Dataset 1", "Dataset 2", "\n", ""};
        Dataset[] casos = new Dataset[nomesTeste.length];

        for(int i=0; i<nomesTeste.length; i++)
            casos[i] = new Dataset(nExemplosTeste[i], nAtributosTeste[i],
                                    nClassesTeste[i], nomesTeste[i]);

        /*
         * Criação dos casos de teste
         * Métodos: int getNumExemplos(), int getNumAtributos(), 
         * int getNumClasses(), String getNome() 
         */
        for(Dataset teste: casos)
            System.out.printf("getNome(): %s\ngetNumExemplos(): %d\ngetNumAtributos(): %d\ngetNumClasses(): %d\n\n", 
            teste.getNome(), teste.getNumExemplos(), teste.getNumAtributos(),
            teste.getNumClasses());

    }
}