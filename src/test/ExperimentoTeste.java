package test;
import app.Experimento;
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

public class ExperimentoTeste {
    public static void main(String[] args) {
        final int casos = 3;
        
        // Agoritmo
        String[] nomesTeste = {"Teste 1", "Teste 2", "hey"};
        float[][] parametrosTeste = {{0,1,2}, {1,2,3}, {1,3,4}};
        
        // Dataset
        int[] nExemplosTeste = {1, 4, 5};
        int[] nAtributosTeste = {4, 6, 5};
        int[] nClassesTeste = {0, 2, 11};

        // ValorAvaliacao
        String[] medidasNome = {"Medida 1", "Medida 2", "Medida 3"};
        float[] menoresValores = {23.5f, 15f, 2.5f},
            maioresValores = {50f, 35f, 4.5f},
            valores = {30, 36, 3};
        ValorAvaliacao[] avaliacoes = new ValorAvaliacao[casos];
        for(int i=0; i<avaliacoes.length; i++){
           avaliacoes[i] = new ValorAvaliacao(
                new MedidaAvaliacao(medidasNome[i], menoresValores[i], maioresValores[i])
            ); 
            avaliacoes[i].setValor(valores[i]);
        }

        // Resultados
        Resultado[] resultados = new Resultado[casos];
        for(int i=0; i<resultados.length; i++){
            resultados[i] = new Resultado(
                new Algoritmo(nomesTeste[i], parametrosTeste[i]),
                new Dataset(nExemplosTeste[i], nAtributosTeste[i],
                    nClassesTeste[i], nomesTeste[i])
            );

            resultados[i].addAvaliacao(avaliacoes[i]);
        }
       
        // Experimento
        int[] dia = {1, 4, 5};
        int[] mes = {4, 6, 5};
        int[] ano = {0, 2, 11};
        Experimento[] experimentos = new Experimento[casos];
        for(int i=0; i<experimentos.length; i++)
            experimentos[i] = new Experimento(dia[i], mes[i], ano[i]);

        Teste teste = new Teste(Experimento.class);
        
        for(int i=0; i<casos; i++)
            teste.run(
                // Objeto testado
                experimentos[i],

                // Objetos que serão passados como parametros
                // dos métodos do objeto testado
                resultados[i],

                medidasNome
            );
    }
}