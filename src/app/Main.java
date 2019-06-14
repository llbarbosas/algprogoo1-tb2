package app;

public class Main {
    public static void main(String[] args) {
        Algoritmo algoritmo = new Algoritmo("Algoritmo 1", new float[]{2.1f, 5.1f, 8.1f});
        Dataset dataset = new Dataset(10, 10, 5, "Dataset 1");
        MedidaAvaliacao medidaAvaliacao = new MedidaAvaliacao("Medida de Avaliação 1", 0, 10);
        Resultado resultado = new Resultado(algoritmo, dataset);
        ValorAvaliacao valorAvaliacao = new ValorAvaliacao(medidaAvaliacao);
        Experimento experimento = new Experimento(13, 06, 2019);

        System.out.println("Adicionando resultado: " + experimento.addResultado(resultado));
        float[] valoresResultados = experimento.getValoresResultados("Medida de Avaliação 1");
        System.out.println(valoresResultados.length);
        for (int i = 0; i < valoresResultados.length; i++) {
            System.out.println(valoresResultados[i]);
        }
    }
}