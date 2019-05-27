package test;
import sisapam.Algoritmo;

public class AlgoritmoTeste {
    public static void main(String[] args) {
        /*
         * Criação dos casos de teste
         * Parametros: String nome, float parametros 
         */
        int casos = 3;
        String[] nomesTeste = {"Algoritmo 1", "Algoritmo 2", "hey"};
        float[][] parametrosTeste = {{0,1,2}, {1,2,3}, {1,3,4}};
        Teste teste = new Teste(Algoritmo.class); // Iniciando teste da classe
        
        for(int i=0; i<casos; i++)
            teste.run(
                new Algoritmo(nomesTeste[i], parametrosTeste[i]) // Rodando teste num objeto instanciado
            );
    }
}
