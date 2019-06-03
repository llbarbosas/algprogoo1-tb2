package test;
import app.Experimento;
import app.Resultado;
import app.Algoritmo;
import app.Dataset;

public class ExperimentoTeste {
    public static void main(String[] args) {
        int casos = 3;
        int[] dia = {1, 4, 5};
        int[] mes = {4, 6, 5};
        int[] ano = {0, 2, 11};
        String[] nomesTeste = {"Teste 1", "Teste 2", "hey"};
        float[][] parametrosTeste = {{0,1,2}, {1,2,3}, {1,3,4}};
        int[] nExemplosTeste = {1, 4, 5};
        int[] nAtributosTeste = {4, 6, 5};
        int[] nClassesTeste = {0, 2, 11};
        Teste teste = new Teste(Experimento.class);
        
        for(int i=0; i<casos; i++)
            teste.run(
                new Experimento(dia[i], mes[i], ano[i]),
                new Resultado(
                    new Algoritmo(nomesTeste[i], parametrosTeste[i]),
                    new Dataset(nExemplosTeste[i], nAtributosTeste[i],
                        nClassesTeste[i], nomesTeste[i])
                )
            );
    }
}