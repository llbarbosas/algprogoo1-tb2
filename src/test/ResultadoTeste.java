package test;
import sisapam.Resultado;
import sisapam.Algoritmo;
import sisapam.Dataset;

public class ResultadoTeste {
    public static void main(String[] args) {
        int casos = 3;
        String[] nomesTeste = {"Algoritmo 1", "Algoritmo 2", "hey"};
        float[][] parametrosTeste = {{0,1,2}, {1,2,3}, {1,3,4}};
        int[] nExemplosTeste = {1, 4, 5};
        int[] nAtributosTeste = {4, 6, 5};
        int[] nClassesTeste = {0, 2, 11};
        Teste teste = new Teste(Resultado.class);
        
        for(int i=0; i<casos; i++)
            teste.run(
                new Resultado(
                    new Algoritmo(nomesTeste[i], parametrosTeste[i]),
                    new Dataset(nExemplosTeste[i], nAtributosTeste[i],
                        nClassesTeste[i], nomesTeste[i])
                )
            );
    }
}