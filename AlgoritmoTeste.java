import src.Algoritmo;

public class AlgoritmoTeste {
    public static void main(String[] args) {
        /*
         * Criação dos casos de teste
         * Parametros: String nome, float parametros 
         */
        String[] nomesTeste = {"Algoritmo 1", "Algoritmo 2", ""};
        float[][] parametrosTeste = {{0,1,2}, {1,2,3}, {}};
        Algoritmo[] casos = new Algoritmo[nomesTeste.length];

        for(int i=0; i<nomesTeste.length; i++)
            casos[i] = new Algoritmo(nomesTeste[i], parametrosTeste[i]);

        /*
         * Criação dos casos de teste
         * Métodos: String getNome(), float[] getParametros()  
         */
        for(Algoritmo teste: casos){
            System.out.printf("Nome: %s\n", teste.getNome());

            System.out.print("Parametros: ");
            for(float parametro: teste.getParametros())
                System.out.print(parametro + " ");
            
            System.out.println();
        }

    }
}
