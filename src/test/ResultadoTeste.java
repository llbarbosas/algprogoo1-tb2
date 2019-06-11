package test;
import app.Resultado;
import app.Algoritmo;
import app.Dataset;
import app.ValorAvaliacao;
import app.MedidaAvaliacao;
    
    /**@Autores
    * Carlos Eduardo Dias Giacomini
    * Jorge Eduardo Dullius dos Santos
    * Lucas Lima Barbosa Silva
    * Lucas Vinicius Cardoso Moro
    */

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
                // Objeto da classe testada
                new Resultado(
                    new Algoritmo(nomesTeste[i], parametrosTeste[i]),
                    new Dataset(nExemplosTeste[i], nAtributosTeste[i],
                        nClassesTeste[i], nomesTeste[i])
                ),
                // Objetos que serão utilizados nos métodos testados
                new Resultado(
                    new Algoritmo(nomesTeste[2], parametrosTeste[2]),
                    new Dataset(nExemplosTeste[2], nAtributosTeste[2],
                        nClassesTeste[2], nomesTeste[2])
                ),
                new ValorAvaliacao(
                    new MedidaAvaliacao("Nome teste", 0.5f, 2f)
                )
            );
    }
}