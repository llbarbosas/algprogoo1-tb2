package app;

public class Main {
    public static void main(String[] args) {
        String[] nomeAlgoritmo = {"Algoritmo 1", "Algoritmo 2", "Algoritmo 3"},
                nomeDataset = {"Dataset 1", "Dataset 2", "Dataset 3"};
        float[][] parametros = {{2.1f, 5.1f, 8.1f}, {1.3f, 4.1f, 123.f}, {1.2f, 3.3f}};
        int[] nExemplosTeste = {1, 4, 5};
        int[] nAtributosTeste = {4, 6, 5};
        int[] nClassesTeste = {0, 2, 11};
        
        Algoritmo[] algoritmos = new Algoritmo[nomeAlgoritmo.length];
        for(int i=0; i<algoritmos.length; i++)
            algoritmos[i] = new Algoritmo(nomeAlgoritmo[i], parametros[i]);

        Dataset[] datasets = new Dataset[nomeDataset.length];
        for(int i=0; i<datasets.length; i++)
            datasets[i] = new Dataset(nExemplosTeste[i], nAtributosTeste[i], nClassesTeste[i], nomeDataset[i]);

        Resultado[] resultados = new Resultado[algoritmos.length];
        for(int i=0; i<resultados.length; i++)
            resultados[i] = new Resultado(algoritmos[i], datasets[i]);
        
        String[] medidasNome = {"Medida 1", "Medida 2", "Medida 3"};
        float[] menoresValores = {23.5f, 15f, 2.5f},
                maioresValores = {50f, 35f, 4.5f},
                valores = {30, 36, 3};

        MedidaAvaliacao[] medidasAvaliacao = new MedidaAvaliacao[medidasNome.length];
        for(int i=0; i<medidasAvaliacao.length; i++)
            medidasAvaliacao[i] = new MedidaAvaliacao(medidasNome[i], menoresValores[i], maioresValores[i]);

        ValorAvaliacao[] valoresAvaliacao = new ValorAvaliacao[medidasAvaliacao.length];
        for(int i=0; i<valoresAvaliacao.length; i++){
            valoresAvaliacao[i] = new ValorAvaliacao(medidasAvaliacao[i]);
            valoresAvaliacao[i].setValor(valores[i]);
        }

        for(Resultado resultado: resultados)
            for(ValorAvaliacao avaliacao: valoresAvaliacao)
                resultado.addAvaliacao(avaliacao);

        Experimento experimento = new Experimento(13, 06, 2019);

        for(Resultado resultado: resultados)
            experimento.addResultado(resultado);

        experimento.imprimeResumoExperimento();

        /*
        valorAvaliacao.setValor(5);
        resultado.addAvaliacao(valorAvaliacao);
        System.out.println("Adicionando resultado: " + experimento.addResultado(resultado));
        float[] valoresResultados = experimento.getValoresResultados("Medida de Avaliação 1");
        System.out.println(valoresResultados.length);
        for (int i = 0; i < valoresResultados.length; i++) {
            System.out.println(valoresResultados[i]);
        }
        */
    }
}