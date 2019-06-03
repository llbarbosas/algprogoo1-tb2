package app;
import util.Validador;
import util.TratamentoErro;
import java.util.Arrays;

public class Experimento {
    private int dia, mes, ano;
    private Resultado[] resultados;

    public Experimento(int dia, int mes, int ano){
        if(Validador.verificaData(dia, mes, ano)){
            resultados = new Resultado[10];
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else{
            TratamentoErro.erro("Data inválida.");
        }

    }

    private static <T> T[] append(T[] arr, T element) {
        final int N = arr.length;
        arr = Arrays.copyOf(arr, N + 1);
        arr[N] = element;
        return arr;
    }

    private Resultado[] getResultadosValidos(){
        Resultado[] resultados = {};

        for(Resultado resultado: this.resultados)
            if(resultado!=null)
                resultados = append(resultados, resultado);

        return resultados;
    }

    public boolean addResultado(Resultado resultado){
        System.out.println(resultado.getAlgoritmo().getNome());

        if(!Validador.verificaArrayCheio(this.resultados)){//verifica se há campo vazio
            for(Resultado obj: getResultadosValidos() ){
                if(obj.equals(resultado)){
                    System.out.println("Não foi possível cadastrar, objeto já cadastrado anteriormente.");
                    return false;
                }
            }
            for(int i=0; i<10; i++){//percorre o vetor até o campo vazio encontrado
                if(!Validador.verificaObjetoValido(this.resultados[i])){
                    this.resultados[i] = resultado;
                    return true;
                }
            }
        }
        System.out.println("Não foi possível cadastrar, já foram cadastrados 10 resultados.");
        return false;
    }

    public float[] getValoresResultados(String medida){
        // Percorrer this.resultados procurando pelo ValorAvaliacao com 
        // medida igual a medida do parametro.
        float[] valores;
        int numeroDeValores = 0;

        // Percorre os resultados procurando por avaliacoes com a medida passada
        for(Resultado resultado: getResultadosValidos())
            if(resultado != null && resultado.getAvaliacaoPorMedida(medida) != null)
                numeroDeValores++;

        // Se nenhuma avaliacao foi encontrada, retorna um float[] vazio
        if(numeroDeValores == 0)
            return new float[]{};
        else
            // Senão, inicializa o vetor de valores que será retornado com o
            // numero de valores encontrados
            valores = new float[numeroDeValores];
 
        // Percorre os resultados novamente, incluindo os valores no vetor que será retornado
        for(Resultado resultado: getResultadosValidos())
            if(resultado.getAvaliacaoPorMedida(medida) != null){
                valores[valores.length - numeroDeValores] = 
                    resultado.getAvaliacaoPorMedida(medida).getValor();
                numeroDeValores--;
            }

        return valores;
    }

    public float getMediaResultados(String medida){
        float mediaResultados = 0;
        int numeroDeResultados = 0;
        for(Resultado resultado: getResultadosValidos()){
            if(resultado.getAvaliacaoPorMedida(medida) != null){
                mediaResultados += resultado.getAvaliacaoPorMedida(medida).getValor();
            }
        }
        if(numeroDeResultados!=0){
            mediaResultados /= numeroDeResultados;
            return mediaResultados;
        }else{
            return Float.MAX_VALUE;
        }
    }

    public float getMediaResultadosPorAlgoritmo(String algoritmo, String medida){
        float mediaResultados = 0;
        int numeroDeResultados = 0;
        for(Resultado resultado: getResultadosValidos()){
            if(resultado.getAvaliacaoPorMedida(medida) != null && resultado.getAlgoritmo().equals(algoritmo)){
                mediaResultados += resultado.getAvaliacaoPorMedida(medida).getValor();
            }
        }
        if(numeroDeResultados!=0){
            mediaResultados /= numeroDeResultados;
            return mediaResultados;
        }else{
            return Float.MAX_VALUE;
        }
    }

    public float getMediaResultadosPorDataset(String dataset, String medida){//vou fazer esse hoje, by Jorge
        float media = 0;

        return media;
    }

    public Resultado getMelhorResultado(String medida){
        // Caso o resultado não exista, retorna null
        Resultado melhorResultado = null;

        for(Resultado resultado: getResultadosValidos()){
            // Tentando encontrar a avaliacao da medida passada
            ValorAvaliacao avaliacao = resultado.getAvaliacaoPorMedida(medida);

             // Testando se a avaliacao realmente existe
            if(avaliacao!=null){
                float novoValor = avaliacao.getValor();

                // Se o melhor resultado não foi definido ainda,
                // ele recebe o resultado atual
                if(melhorResultado == null)
                    melhorResultado = resultado;

                // Caso ele já tenha sido definido, testa se o
                // melhor valor atual é menor que o novo valor
                else {
                    float melhorValor = melhorResultado.getAvaliacaoPorMedida(medida).getValor();
                    
                    if(melhorValor<novoValor)
                        melhorResultado = resultado;
                }
           }
                
        }

        return melhorResultado;
    }

    public Resultado getMelhorResultadoPorAlgoritmo(String algoritmo, String medida){
        // Caso o resultado não exista, retorna null
        Resultado melhorResultado = null;

        for(Resultado resultado: getResultadosValidos()){
            String nomeAlgoritmo = resultado.getNomeDoAlgoritmo();

            // Testa se o resultado atual é do algoritmo esperado
            if(nomeAlgoritmo.equals(algoritmo)){
                ValorAvaliacao avaliacao = resultado.getAvaliacaoPorMedida(medida);

                // Testa se esse resultado possui avaliacao com a medida passada
                if(avaliacao!=null){

                    // Se o melhor resultado ainda não tiver sido definido,
                    // define com o resultado atual
                    if(melhorResultado == null)
                        melhorResultado = resultado;
                    else{
                        float melhorValor = melhorResultado.getAvaliacaoPorMedida(medida).getValor(),
                                novoValor = avaliacao.getValor();

                        // Caso contrário, testa se o valor atual é menor que
                        // o novo valor
                        if(melhorValor<novoValor)
                            melhorResultado = resultado;
                    }
                }
            }
        }

        return melhorResultado;
    }

    public Resultado getMelhorResultadoPorDataset(String dataset, String medida){
        Resultado melhorResultado = null;

        for(Resultado resultado: getResultadosValidos()){
            String nomeDataset = resultado.getNomeDoDataset();

            if(nomeDataset.equals(dataset)){
                ValorAvaliacao avaliacao = resultado.getAvaliacaoPorMedida(medida);

                if(avaliacao!=null){
                    if(melhorResultado == null)
                        melhorResultado = resultado;
                    else{
                        float melhorValor = melhorResultado.getAvaliacaoPorMedida(medida).getValor(),
                                novoValor = avaliacao.getValor();
                                
                        if(melhorValor<novoValor)
                            melhorResultado = resultado;
                    }
                }
            }
        }

        return melhorResultado;
    }

    public Resultado getPiorResultado(String medida){
        Resultado piorResultado = null;

        for(Resultado resultado: getResultadosValidos()){
            ValorAvaliacao avaliacao = resultado.getAvaliacaoPorMedida(medida);

            if(avaliacao != null){
                float novoValor = avaliacao.getValor();

                if(piorResultado == null)
                    piorResultado = resultado;
                else {
                    float piorValor = piorResultado.getAvaliacaoPorMedida(medida).getValor();
                    
                    if(piorValor>novoValor)
                        piorResultado = resultado;
                }
            }
                
        }

        return piorResultado;
    }

    public Resultado getPiorResultadoPorAlgoritmo(String algoritmo, String medida){
        Resultado piorResultado = null;

        for(Resultado resultado: getResultadosValidos()){
            String nomeAlgoritmo = resultado.getNomeDoAlgoritmo();

            if(nomeAlgoritmo.equals(algoritmo)){
                ValorAvaliacao avaliacao = resultado.getAvaliacaoPorMedida(medida);

                if(avaliacao!=null){
                    if(piorResultado == null)
                        piorResultado = resultado;
                    else{
                        float piorValor = piorResultado.getAvaliacaoPorMedida(medida).getValor(),
                                novoValor = avaliacao.getValor();

                        if(piorValor>novoValor)
                            piorResultado = resultado;
                    }
                }
            }
        }

        return piorResultado;
    }

    public Resultado getPiorResultadoPorDataset(String dataset, String medida){
        Resultado piorResultado = null;

        for(Resultado resultado: getResultadosValidos()){
            String nomeDataset = resultado.getNomeDoDataset();

            if(nomeDataset.equals(dataset)){
                ValorAvaliacao avaliacao = resultado.getAvaliacaoPorMedida(medida);

                if(avaliacao!=null){
                    if(piorResultado == null)
                        piorResultado = resultado;
                    else{
                        float piorValor = piorResultado.getAvaliacaoPorMedida(medida).getValor(),
                                novoValor = avaliacao.getValor();

                        if(piorValor>novoValor)
                            piorResultado = resultado;
                    }
                }
            }
        }

        return piorResultado;
    }

    public Dataset getDatasetMelhorResultado(String medida){
        Dataset melhorDataset = null;
        float melhorDatasetValor = 0;

        for(Resultado resultado: getResultadosValidos()){
            ValorAvaliacao avaliacao = resultado.getAvaliacaoPorMedida(medida);

            if(avaliacao != null){
                float novoValor = avaliacao.getValor();
                Dataset novoDataset = resultado.getDataset();

                if(melhorDataset == null){
                    melhorDataset = novoDataset;
                    melhorDatasetValor = novoValor;
                } else if(melhorDatasetValor<novoValor)
                    melhorDataset = novoDataset;
            
            }
        }

        return melhorDataset;
    }

    public Dataset getDatasetMelhorResultadoAlgoritmo(String algoritmo, String medida){
        Dataset melhorDataset = null;

        return melhorDataset;
    }

    public String[] getNomesAlgoritmosUtilizados(){
        String[] nomesAlgoritmos = new String[getResultadosValidos().length];

        for(int i=0; i<nomesAlgoritmos.length; i++)
            nomesAlgoritmos[i] = resultados[i].getNomeDoAlgoritmo();

        return nomesAlgoritmos;
    }

    public Algoritmo getAlgoritmoMelhorResultado(String medida){
        Algoritmo melhorAlgoritmo = null;// Caso o resultado não exista, retorna null
        float melhorAlgoritmoValor = 0;

        for(Resultado resultado: getResultadosValidos()){
            ValorAvaliacao avaliacao = resultado.getAvaliacaoPorMedida(medida);

            if(avaliacao != null){
                float novoValor = avaliacao.getValor();
                Algoritmo novoAlgoritmo = resultado.getAlgoritmo();

                if(melhorAlgoritmo == null){
                    melhorAlgoritmo = novoAlgoritmo;
                    melhorAlgoritmoValor = novoValor;
                } else if(melhorAlgoritmoValor<novoValor)
                    melhorAlgoritmo = novoAlgoritmo;
            
            }
        }

        return melhorAlgoritmo;
    }

    public Algoritmo getAlgoritmoMelhorResultadoDataset(String dataset, String medida){
        Algoritmo melhorAlgoritmo = null;

        return melhorAlgoritmo; 
    }

    public void imprimeResumoExperimento(){
    
    }
}
