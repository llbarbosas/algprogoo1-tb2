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

        testeGetMelhorPiorResultado();
        testeGetMelhorPiorResultadoPorAlgoritmo();
        testeGetMelhorPiorResultadoPorDataset();

        testeGetDatasetMelhorResultado();

        /*
         * Teste da função getNomeAlgoritmos
         */

        testeGetNomeAlgoritmos();

        /*
         * Teste da função addResultados
         */

        testeAddResultados();

        /*
         * Teste da função GetAlgoritmoMelhorResultado
         */
        testeGetAlgoritmoMelhorResultado();
        testeGetAlgoritmoMelhorResultadoDataset();

    }

    private static void testeGetDatasetMelhorResultado(){
        final String MEDIDA = "Medida teste";
        final float VALOR = 8, PIOR_VALOR = 2, MELHOR_VALOR = 9;
        final Dataset MELHOR_DATASET = new Dataset(3, 2, 1, "Dataset melhor");
        final Dataset DATASET = new Dataset(3, 2, 1, "Dataset");

        Experimento experimento = new Experimento(14, 6, 2019);

        Resultado resultado = new Resultado(
            new Algoritmo("Algoritmo 1", new float[]{1, 2, 3}),
            DATASET
        );
        Resultado piorResultado = new Resultado(
            new Algoritmo("Algoritmo 2", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 2")
        );
        Resultado melhorResultado = new Resultado(
            new Algoritmo("Algoritmo 3", new float[]{1, 2, 3}),
            MELHOR_DATASET
        );

        ValorAvaliacao avaliacao = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );
        ValorAvaliacao piorAvaliacao = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );
        ValorAvaliacao melhorAvaliacao = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );

        avaliacao.setValor(VALOR);
        piorAvaliacao.setValor(PIOR_VALOR);
        melhorAvaliacao.setValor(MELHOR_VALOR);

        resultado.addAvaliacao(avaliacao);
        piorResultado.addAvaliacao(piorAvaliacao);
        melhorResultado.addAvaliacao(melhorAvaliacao);

        Dataset retornoEsperado1 = null;
        Dataset retornoObtido1 = experimento.getDatasetMelhorResultado(MEDIDA);
        boolean saoIguais1 = (retornoObtido1 == retornoEsperado1);

        // Primeiro caso de teste
        casoTeste(
            "Executando getDatasetMelhorResultado num experimento sem resultados",
            saoIguais1,
            retornoEsperado1,
            retornoObtido1
        );
        
        // Adiconando os resultados com valores setados
        experimento.addResultado(resultado);
        experimento.addResultado(piorResultado);
        experimento.addResultado(melhorResultado);

        Dataset retornoEsperado2 = MELHOR_DATASET;
        Dataset retornoObtido2 = experimento.getDatasetMelhorResultado(MEDIDA);
        boolean saoIguais2 = (retornoObtido2.equals(retornoEsperado2));

        // Segundo caso de teste
        casoTeste(
            "Executando getDatasetMelhorResultado num experimento com avaliações",
            saoIguais2,
            retornoEsperado2,
            retornoObtido2
        );

        Dataset retornoEsperado3 = DATASET;
        Dataset retornoObtido3 = experimento.getDatasetMelhorResultadoAlgoritmo("Algoritmo 1", MEDIDA);
        boolean saoIguais3 = (retornoObtido3.equals(retornoEsperado3));

        casoTeste(
            "Executando getDatasetMelhorResultadoAlgoritmo num experimento com avaliações",
            saoIguais3,
            retornoEsperado3,
            retornoEsperado3
        );
    }

    private static void testeGetMelhorPiorResultado(){
        final String MEDIDA = "Medida teste";
        final float VALOR = 8, PIOR_VALOR = 2, MELHOR_VALOR = 9;

        Experimento experimento = new Experimento(14, 6, 2019);

        Resultado resultado = new Resultado(
            new Algoritmo("Algoritmo 1", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 1")
        );
        Resultado piorResultado = new Resultado(
            new Algoritmo("Algoritmo 2", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 2")
        );
        Resultado melhorResultado = new Resultado(
            new Algoritmo("Algoritmo 3", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 3")
        );

        ValorAvaliacao avaliacao = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );
        ValorAvaliacao piorAvaliacao = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );
        ValorAvaliacao melhorAvaliacao = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );

        avaliacao.setValor(VALOR);
        piorAvaliacao.setValor(PIOR_VALOR);
        melhorAvaliacao.setValor(MELHOR_VALOR);

        resultado.addAvaliacao(avaliacao);
        piorResultado.addAvaliacao(piorAvaliacao);
        melhorResultado.addAvaliacao(melhorAvaliacao);

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
        experimento.addResultado(resultado);
        experimento.addResultado(piorResultado);
        experimento.addResultado(melhorResultado);

        Resultado retornoEsperado2 = melhorResultado;
        Resultado retornoObtido2 = experimento.getMelhorResultado(MEDIDA);
        boolean saoIguais2 = (retornoObtido2.equals(retornoEsperado2));

        // Segundo caso de teste
        casoTeste(
            "Executando getMelhorResultado num experimento com avaliações",
            saoIguais2,
            retornoEsperado2,
            retornoObtido2
        );

        casoTeste(
            "Executando getPiorResultado num experimento com avaliações",
            experimento.getPiorResultado(MEDIDA).equals(piorResultado),
            true,
            experimento.getPiorResultado(MEDIDA)
        );
    }

    private static void testeGetMelhorPiorResultadoPorAlgoritmo(){
        final String MEDIDA = "Medida teste";
        final float VALOR = 8, PIOR_VALOR = 2, MELHOR_VALOR = 9;

        Experimento experimento = new Experimento(14, 6, 2019);

        Resultado resultado = new Resultado(
            new Algoritmo("Algoritmo 1", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 1")
        );
        Resultado melhorResultado = new Resultado(
            new Algoritmo("Algoritmo 1", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 2")
        );
        Resultado piorResultado = new Resultado(
            new Algoritmo("Algoritmo 1", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 3")
        );

        ValorAvaliacao avaliacao = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );
        ValorAvaliacao melhorAvaliacao = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );
        ValorAvaliacao piorAvaliacao = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );

        avaliacao.setValor(VALOR);
        melhorAvaliacao.setValor(MELHOR_VALOR);
        piorAvaliacao.setValor(PIOR_VALOR);

        resultado.addAvaliacao(avaliacao);
        melhorResultado.addAvaliacao(melhorAvaliacao);
        piorResultado.addAvaliacao(piorAvaliacao);

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
        experimento.addResultado(resultado);
        experimento.addResultado(melhorResultado);
        experimento.addResultado(piorResultado);

        Resultado retornoEsperado2 = melhorResultado;
        Resultado retornoObtido2 = experimento.getMelhorResultadoPorAlgoritmo("Algoritmo 1", MEDIDA);
        boolean saoIguais2 = (retornoObtido2.equals(retornoEsperado2));

        // Segundo caso de teste
        casoTeste(
            "Executando getMelhorResultadoPorAlgoritmo num experimento com avaliações",
            saoIguais2,
            retornoEsperado2,
            retornoObtido2
        );

        casoTeste(
            "Executando getPiorResultadoPorAlgoritmo num experimento com avaliações",
            experimento.getPiorResultadoPorAlgoritmo("Algoritmo 1", MEDIDA).equals(piorResultado),
            true,
            experimento.getPiorResultadoPorAlgoritmo("Algoritmo 1", MEDIDA)
        );
    }

    private static void testeGetMelhorPiorResultadoPorDataset(){
        final String MEDIDA = "Medida teste";
        final float VALOR = 8, PIOR_VALOR = 2, MELHOR_VALOR = 9;

        Experimento experimento = new Experimento(14, 6, 2019);

        Resultado resultado = new Resultado(
            new Algoritmo("Algoritmo 1", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 1")
        );
        Resultado melhorResultado = new Resultado(
            new Algoritmo("Algoritmo 2", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 1")
        );
        Resultado piorResultado = new Resultado(
            new Algoritmo("Algoritmo 3", new float[]{1, 2, 3}),
            new Dataset(3, 2, 1, "Dataset 1")
        );

        ValorAvaliacao avaliacao = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );
        ValorAvaliacao melhorAvaliacao = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );
        ValorAvaliacao piorAvaliacao = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );

        avaliacao.setValor(VALOR);
        melhorAvaliacao.setValor(MELHOR_VALOR);
        piorAvaliacao.setValor(PIOR_VALOR);

        resultado.addAvaliacao(avaliacao);
        melhorResultado.addAvaliacao(melhorAvaliacao);
        piorResultado.addAvaliacao(piorAvaliacao);

        Resultado retornoEsperado1 = null;
        Resultado retornoObtido1 = experimento.getMelhorResultadoPorDataset("Dataset 1", MEDIDA);
        boolean saoIguais1 = (retornoObtido1 == retornoEsperado1);

        // Primeiro caso de teste
        casoTeste(
            "Executando getMelhorResultadoPorDataset num experimento sem resultados",
            saoIguais1,
            retornoEsperado1,
            retornoObtido1
        );
        
        // Adiconando os resultados com valores setados
        experimento.addResultado(resultado);
        experimento.addResultado(melhorResultado);
        experimento.addResultado(piorResultado);

        Resultado retornoEsperado2 = melhorResultado;
        Resultado retornoObtido2 = experimento.getMelhorResultadoPorDataset("Dataset 1", MEDIDA);
        boolean saoIguais2 = (retornoObtido2.equals(retornoEsperado2));

        // Segundo caso de teste
        casoTeste(
            "Executando getMelhorResultadoPorDataset num experimento com avaliações",
            saoIguais2,
            retornoEsperado2,
            retornoObtido2
        );

        casoTeste(
            "Executando getPiorResultadoPorDataset num experimento com avaliações",
            experimento.getPiorResultadoPorDataset("Dataset 1", MEDIDA).equals(piorResultado),
            true,
            experimento.getPiorResultadoPorDataset("Dataset 1", MEDIDA)
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

    public static void testeGetAlgoritmoMelhorResultado(){
        final String MEDIDA = "Medida teste";
        final float melhorValor = 8, piorValor = 2;
        final Algoritmo melhorAlgoritmo = new Algoritmo("Algoritmo 1", new float[]{1, 2, 3});

        Experimento experimento = new Experimento(14, 6, 2019);

        Resultado melhorResultado = new Resultado(
            melhorAlgoritmo,
            new Dataset(3, 2, 1, "Dataset 1")
        );
        Resultado piorResultado = new Resultado(
            melhorAlgoritmo,
            new Dataset(3, 2, 1, "Dataset 2")
        );

        ValorAvaliacao melhorAvaliacao = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );
        ValorAvaliacao piorAvaliacao = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );

        melhorAvaliacao.setValor(melhorValor);
        piorAvaliacao.setValor(piorValor);

        melhorResultado.addAvaliacao(melhorAvaliacao);
        piorResultado.addAvaliacao(piorAvaliacao);

        Algoritmo retornoEsperado1 = null;
        Algoritmo retornoObtido1 = experimento.getAlgoritmoMelhorResultado(MEDIDA);
        boolean saoIguais1 = (retornoObtido1 == retornoEsperado1);

        // Primeiro caso de teste
        casoTeste(
            "Executando getAlgoritmoMelhorResultado num experimento sem resultados",
            saoIguais1,
            retornoEsperado1,
            retornoObtido1
        );
        
        // Adiconando os resultados
        experimento.addResultado(melhorResultado);
        experimento.addResultado(piorResultado);

        Algoritmo retornoEsperado2 = melhorAlgoritmo ;
        Algoritmo retornoObtido2 = experimento.getAlgoritmoMelhorResultado(MEDIDA);
        boolean saoIguais2 = (retornoObtido2.equals(retornoEsperado2));

        // Segundo caso de teste
        casoTeste(
            "Executando getAlgoritmoMelhorResultado num experimento com avaliações",
            saoIguais2,
            retornoEsperado2,
            retornoObtido2
        );
    }

    public static void testeGetAlgoritmoMelhorResultadoDataset(){
        final String MEDIDA = "Medida teste";
        final float melhorValor = 8, piorValor = 2;
        final Algoritmo melhorAlgoritmo = new Algoritmo("Algoritmo 1", new float[]{1, 2, 3});

        Experimento experimento = new Experimento(14, 6, 2019);

        Resultado melhorResultado = new Resultado(
            melhorAlgoritmo,
            new Dataset(3, 2, 1, "Dataset 1")
        );
        Resultado piorResultado = new Resultado(
            melhorAlgoritmo,
            new Dataset(3, 2, 1, "Dataset 2")
        );

        ValorAvaliacao melhorAvaliacao = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );
        ValorAvaliacao piorAvaliacao = new ValorAvaliacao(
            new MedidaAvaliacao(MEDIDA, 0f, 10f)
        );

        melhorAvaliacao.setValor(melhorValor);
        piorAvaliacao.setValor(piorValor);

        melhorResultado.addAvaliacao(melhorAvaliacao);
        piorResultado.addAvaliacao(piorAvaliacao);

        Algoritmo retornoEsperado1 = null;
        Algoritmo retornoObtido1 = experimento.getAlgoritmoMelhorResultadoDataset(melhorResultado.getNomeDoDataset(), MEDIDA);
        boolean saoIguais1 = (retornoObtido1 == retornoEsperado1);

        // Primeiro caso de teste
        casoTeste(
            "Executando getAlgoritmoMelhorResultadoDataset num experimento sem resultados com carinho pelo jorge",
            saoIguais1,
            retornoEsperado1,
            retornoObtido1
        );
        
        // Adiconando os resultados
        experimento.addResultado(melhorResultado);
        experimento.addResultado(piorResultado);

        Algoritmo retornoEsperado2 = melhorAlgoritmo ;
        Algoritmo retornoObtido2 = experimento.getAlgoritmoMelhorResultadoDataset(melhorResultado.getNomeDoDataset(), MEDIDA);
        boolean saoIguais2 = (retornoObtido2.equals(retornoEsperado2));

        // Segundo caso de teste
        casoTeste(
            "Executando getAlgoritmoMelhorResultadoDataset num experimento com avaliações com carinho pelo jorge",
            saoIguais2,
            retornoEsperado2,
            retornoObtido2
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