package app;
import static util.Cores.*;

public class Main {
    public static void main(String[] args) {
        /*
         * Teste das funcões relacionadas as médias
         */

        // Colocando teste num metodo pra não ter varios
        // valores/resultados/experimentos no mesmo escopo
        testeMedias();
        
        /*
         * Teste das funcões relacionadas aos melhores resultados
         */

        // ...

        /*
         * Teste da função getNomeAlgoritmos
         */

        // ...

        /*
         * Teste da função getValoresResultados e addResultados
         */

        // ...
    }

    private static void testeMedias(){
        Experimento experimento = new Experimento(14, 6, 2019);
        final String MEDIDA = "Medida teste";
        final float VALOR1 = 8, VALOR2 = 2;

        Resultado resultado1 = new Resultado(
            new Algoritmo("Algoritmo 1", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 1")
        );
        Resultado resultado2 = new Resultado(
            new Algoritmo("Algoritmo 2", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 2")
        );

        ValorAvaliacao valorAvaliacao1 = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );

        ValorAvaliacao valorAvaliacao2 = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );

        valorAvaliacao1.setValor(VALOR1);
        valorAvaliacao2.setValor(VALOR2);
        
        resultado1.addAvaliacao(valorAvaliacao1);
        resultado2.addAvaliacao(valorAvaliacao2);

        float retornoEsperado1 = Float.MAX_VALUE;
        float retornoObtido1 = experimento.getMediaResultados(MEDIDA);
        boolean saoIguais1 = (retornoEsperado1 == retornoObtido1);

        casoTeste(
            "Executando getMediaResultados num experimento sem avaliações",
            saoIguais1,
            retornoEsperado1,
            retornoObtido1
        );

        // Adiconando os resultados com valores setados
        experimento.addResultado(resultado1);
        experimento.addResultado(resultado2);

        float retornoEsperado2 = (VALOR1+VALOR2)/2;
        float retornoObtido2 = experimento.getMediaResultados(MEDIDA);
        boolean saoIguais2 = (retornoEsperado2 == retornoObtido2);

        casoTeste(
            "Executando getMediaResultados num experimento com avaliações",
            saoIguais2,
            retornoEsperado2,
            retornoObtido2
        );

        casoTeste(
            "Exemplo: apenas exibindo dois retornos que não sabemos como comparar",
            retornoEsperado2,
            retornoObtido2
        );
    }

    private static final String OK = VERDE.on("✓"), ERRO = VERMELHO.on("x"), INDEFINIDO = AMARELO.on("?");

    private static void casoTeste(String nome, boolean condicaoIgualdade, Object retornoEsperado, Object retornoObtido){
        System.out.println(
            "[" + (condicaoIgualdade ? OK : ERRO) +"] "
            + "\"" + nome + "\"\n\t"
            + retornoEsperado + " == " + retornoObtido
        );
    }

    private static void casoTeste(String nome, Object retornoEsperado, Object retornoObtido){
        System.out.println(
            "[" + INDEFINIDO +"] "
            + "\"" + nome + "\"\n\t"
            + retornoEsperado + " == " + retornoObtido
        );
    }
}