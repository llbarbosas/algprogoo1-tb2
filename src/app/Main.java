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
        Resultado resultado1 = new Resultado(
            new Algoritmo("Algoritmo 1", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 1")
        );
        Resultado resultado2 = new Resultado(
            new Algoritmo("Algoritmo 2", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 2")
        );

        ValorAvaliacao valorAvaliacao1 = new ValorAvaliacao(
            new MedidaAvaliacao("Medida top", 0f, 10f)
        );

        ValorAvaliacao valorAvaliacao2 = new ValorAvaliacao(
            new MedidaAvaliacao("Medida top", 0f, 10f)
        );

        valorAvaliacao1.setValor(8);
        valorAvaliacao2.setValor(2);
        
        resultado1.addAvaliacao(valorAvaliacao1);
        resultado2.addAvaliacao(valorAvaliacao2);

        experimento.addResultado(resultado1);
        experimento.addResultado(resultado2);

        casoTeste(
            "Testando getMediaResultados",
            (float) (8+2)/2,
            experimento.getMediaResultados("Medida top")
        );

        casoTeste(
            "Testando asdaasfa",
            new float[]{1, 2, 3},
            new float[]{1, 2, 3}
        );
    }

    private static void casoTeste(String nome, Object retornoEsperado, Object retornoObtido){
        // Um resultado pode ser: 
        //      OK: os dois retornos são iguais
        //      ERRO: os dois valores são diferentes
        //      INDEFINIDO: não dá pra comparar os valores   
        Retorno resultado;

        // Se os retornos são arrays, não temos como comparar
        // usando o toString()
        if(retornoEsperado.getClass().isArray() || retornoObtido.getClass().isArray())
            resultado = Retorno.INDEFINIDO;

        // Senão, comparamos com toString()
        else if (retornoObtido.toString().equals(retornoEsperado.toString()))
            resultado = Retorno.OK;

        // Se nem com toString() forem iguais, determinamos
        // que são diferentes
        else
            resultado = Retorno.ERRO;

        String resultadoString = (resultado == Retorno.OK ? VERDE.on("✓") : (resultado == Retorno.ERRO ? VERMELHO.on("x") : AMARELO.on("?")));

        System.out.println(
            "[" + resultadoString +"] "
            + "\"" + nome + "\"\n\t"
            + retornoObtido + ITALICO.on(" (esperado: " + retornoEsperado + ")")
        );
    }

    enum Retorno {
        OK, ERRO, INDEFINIDO
    };
}