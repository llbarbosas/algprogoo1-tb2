package app;
import static util.Cores.*;

public class Main {
    public static void main(String[] args) {
        /*
         * Teste das funcões relacionadas as médias e getValoresResultados
         */

        // Colocando teste num metodo pra não ter varios
        // valores/resultados/experimentos no mesmo escopo
        testeMedias();
        
        /*
         * Teste das funcões relacionadas aos melhores resultados
         */

        testeGetMelhorResultado();
        testeGetMelhorResultadoPorAlgoritmo();

        /*
         * Teste da função getNomeAlgoritmos
         */

        testeGetNomeAlgoritmos();

        /*
         * Teste da função addResultados
         */

        testeAddResultados();
    }

    private static void testeGetMelhorResultado(){
        final String MEDIDA = "Medida teste";
        final float VALOR1 = 8, VALOR2 = 2, VALOR3 = 9;

        Experimento experimento = new Experimento(14, 6, 2019);

        Resultado resultado1 = new Resultado(
            new Algoritmo("Algoritmo 1", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 1")
        );
        Resultado resultado2 = new Resultado(
            new Algoritmo("Algoritmo 2", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 2")
        );
        Resultado resultado3 = new Resultado(
            new Algoritmo("Algoritmo 3", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 3")
        );

        ValorAvaliacao valorAvaliacao1 = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );
        ValorAvaliacao valorAvaliacao2 = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );
        ValorAvaliacao valorAvaliacao3 = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );

        valorAvaliacao1.setValor(VALOR1);
        valorAvaliacao2.setValor(VALOR2);
        valorAvaliacao3.setValor(VALOR3);

        resultado1.addAvaliacao(valorAvaliacao1);
        resultado2.addAvaliacao(valorAvaliacao2);
        resultado3.addAvaliacao(valorAvaliacao3);

        Resultado retornoEsperado1 = null;
        Resultado retornoObtido1 = experimento.getMelhorResultado(MEDIDA);
        boolean saoIguais1 = (retornoObtido1 == retornoEsperado1);

        // Primeiro caso de teste
        casoTeste(
            "Executando getMelhorResultado num experimento sem resultados",
            saoIguais1,
            retornoEsperado1,
            retornoObtido1
        );
        
        // Adiconando os resultados com valores setados
        experimento.addResultado(resultado1);
        experimento.addResultado(resultado2);
        experimento.addResultado(resultado3);

        Resultado retornoEsperado2 = resultado3;
        Resultado retornoObtido2 = experimento.getMelhorResultado(MEDIDA);
        boolean saoIguais2 = (retornoObtido2.equals(retornoEsperado2));

        // Segundo caso de teste
        casoTeste(
            "Executando getMelhorResultado num experimento com avaliações",
            saoIguais2,
            retornoEsperado2,
            retornoObtido2
        );
    }

    private static void testeGetMelhorResultadoPorAlgoritmo(){
        final String MEDIDA = "Medida teste";
        final float VALOR1 = 8, VALOR2 = 2, VALOR3 = 9;

        Experimento experimento = new Experimento(14, 6, 2019);

        Resultado resultado1 = new Resultado(
            new Algoritmo("Algoritmo 1", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 1")
        );
        Resultado resultado2 = new Resultado(
            new Algoritmo("Algoritmo 1", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 2")
        );
        Resultado resultado3 = new Resultado(
            new Algoritmo("Algoritmo 1", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 3")
        );

        ValorAvaliacao valorAvaliacao1 = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );
        ValorAvaliacao valorAvaliacao2 = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );
        ValorAvaliacao valorAvaliacao3 = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );

        valorAvaliacao1.setValor(VALOR1);
        valorAvaliacao2.setValor(VALOR2);
        valorAvaliacao3.setValor(VALOR3);

        resultado1.addAvaliacao(valorAvaliacao1);
        resultado2.addAvaliacao(valorAvaliacao2);
        resultado3.addAvaliacao(valorAvaliacao3);

        Resultado retornoEsperado1 = null;
        Resultado retornoObtido1 = experimento.getMelhorResultadoPorAlgoritmo("Algoritmo 1", MEDIDA);
        boolean saoIguais1 = (retornoObtido1 == retornoEsperado1);

        // Primeiro caso de teste
        casoTeste(
            "Executando getMelhorResultadoPorAlgoritmo num experimento sem resultados",
            saoIguais1,
            retornoEsperado1,
            retornoObtido1
        );
        
        // Adiconando os resultados com valores setados
        experimento.addResultado(resultado1);
        experimento.addResultado(resultado2);
        experimento.addResultado(resultado3);

        Resultado retornoEsperado2 = resultado3;
        Resultado retornoObtido2 = experimento.getMelhorResultadoPorAlgoritmo("Algoritmo 1", MEDIDA);
        boolean saoIguais2 = (retornoObtido2.equals(retornoEsperado2));

        // Segundo caso de teste
        casoTeste(
            "Executando getMelhorResultadoPorAlgoritmo num experimento com avaliações",
            saoIguais2,
            retornoEsperado2,
            retornoObtido2
        );
    }

    private static void testeGetNomeAlgoritmos(){
        Experimento experimento = new Experimento(14, 6, 2019);

        Resultado resultado1 = new Resultado(
            new Algoritmo("Algoritmo 1", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 1")
        );
        Resultado resultado2 = new Resultado(
            new Algoritmo("Algoritmo 2", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 2")
        );

        experimento.addResultado(resultado1);
        experimento.addResultado(resultado2);

        String resultadoEsperado = "Algoritmo 1Algoritmo 2";
        for(int i=0; i<8; i++)
            resultadoEsperado += null;

        String resultadoObtido = "";
        for(String nome: experimento.getNomesAlgoritmosUtilizados())
            resultadoObtido += nome;

        casoTeste(
            "Testando getNomesAlgoritmos",
            resultadoEsperado.equals(resultadoObtido),
            resultadoEsperado,
            resultadoObtido
        );

        experimento.addResultado(resultado2);

        String resultadoObtido2 = "";
        for(String nome: experimento.getNomesAlgoritmosUtilizados())
            resultadoObtido2 += nome;

        casoTeste(
            "Testando getNomesAlgoritmos com algoritmos repetidos",
            resultadoEsperado.equals(resultadoObtido2),
            resultadoEsperado,
            resultadoObtido2
        );



    }

    private static void testeMedias(){
        final String MEDIDA = "Medida teste";
        final float VALOR1 = 8, VALOR2 = 2;

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

        String retornoEsperado3 = "" + VALOR1 + " " + VALOR2 + " ";
        for(int i=0; i<8; i++)
            retornoEsperado3 += Float.MAX_VALUE + " ";

        String retornoObtido3 = "";
        for(float valor: experimento.getValoresResultados(MEDIDA))
            retornoObtido3 += valor + " ";

        boolean saoIguais3 = retornoEsperado3.equals(retornoObtido3);

        casoTeste(
            "Executando getValoresResultados num experimento com avaliações",
            saoIguais3,
            retornoEsperado3,
            retornoObtido3
        );
    }

    private static void testeAddResultados(){
        Experimento experimento = new Experimento(14, 6, 2019);
        Resultado resultado = new Resultado(
            new Algoritmo("Algoritmo inicial", new float[]{1, 2, 3}),
            new Dataset(1, 2, 3, "Dataset inicial")
        );

        boolean retorno1 = experimento.addResultado(resultado);

        casoTeste(
            "Adicionando um resultado a um experimento vazio",
            (retorno1 == true),
            true,
            retorno1
        );

        boolean retorno2 = experimento.addResultado(resultado);

        casoTeste(
            "Adicionando um resultado já cadastrado num experimento",
            (retorno2 == false),
            false,
            retorno2
        );

        for(int i=0; i<9; i++)
            experimento.addResultado(
                new Resultado(
                    new Algoritmo("Algoritmo " + i, new float[]{1, 2, 3}),
                    new Dataset(1, 2, 3, "Dataset " + i)
                )
            );

        Resultado resultado2 = new Resultado(
            new Algoritmo("Algoritmo final", new float[]{1, 2, 3}),
            new Dataset(1, 2, 3, "Dataset final")
        );

        boolean retorno3 = experimento.addResultado(resultado2);
            
        casoTeste(
            "Adicionando um resultado a um experimento com 10 resultados",
            (retorno3 == false),
            false,
            retorno3
        );
    }

    /*
     * Funções auxiliares para organizar os testes
     */
    
    private static final String OK = VERDE.on("✓"), ERRO = VERMELHO.on("x"), INDEFINIDO = AMARELO.on("?");

    /*
     * Para casos que sabemos como comparar os retornos
     * 
     * USO:
     *      casoTeste(
     *          String nomeDoTeste,
     *          boolean condicaoIgualdade,
     *          QualquerTipo retornoEsperado,
     *          QualquerTipo retornoObtido
     *      );
     */
    private static void casoTeste(String nome, boolean condicaoIgualdade, Object retornoEsperado, Object retornoObtido){
        System.out.println(
            "[" + (condicaoIgualdade ? OK : ERRO) +"] "
            + "\"" + nome + "\"\n\t"
            + retornoEsperado + " == " + retornoObtido
        );
    }

    /*
     * Para casos que não sabemos como comparar os retornos
     * 
     * USO:
     *      casoTeste(
     *          String nomeDoTeste,
     *          QualquerTipo retornoEsperado,
     *          QualquerTipo retornoObtido
     *      );
     */
    private static void casoTeste(String nome, Object retornoEsperado, Object retornoObtido){
        System.out.println(
            "[" + INDEFINIDO +"] "
            + "\"" + nome + "\"\n\t"
            + retornoEsperado + " == " + retornoObtido
        );
    }
}