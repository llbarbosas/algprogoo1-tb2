package app;
import util.Validador;
import util.TratamentoErro;
    
    /**@Autores
    * Carlos Eduardo Dias Giacomini
    * Jorge Eduardo Dullius dos Santos
    * Lucas Lima Barbosa Silva
    * Lucas Vinicius Cardoso Moro
    */
    
public class Experimento {
    private int dia, mes, ano;
    private Resultado[] resultados;

    public Experimento(int dia, int mes, int ano){
        // Validacao da data
        if(Validador.verificaData(dia, mes, ano)){
            resultados = new Resultado[10];
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else
            TratamentoErro.erro("Data inválida.");

    }

    public boolean addResultado(Resultado resultado){
        if(Validador.verificaObjetoValido(resultado) && // Verifica se o objeto não é nulo
            !Validador.verificaArrayCheio(this.resultados)){//verifica se há campo vazio
            for(Resultado obj: getResultadosValidos() ){
                if(obj.equals(resultado)){
                    TratamentoErro.alerta("Não foi possível cadastrar, objeto já cadastrado anteriormente.");
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

        TratamentoErro.alerta("Não foi possível cadastrar, já foram cadastrados 10 resultados.");
        return false;
    }

    public float[] getValoresResultados(String medida){
        float[] valores = new float[10];

        for(int i=0; i<resultados.length; i++)
            if(resultados[i] != null 
            && resultados[i].getAvaliacaoPorMedida(medida) != null)
                valores[i] = resultados[i].getAvaliacaoPorMedida(medida).getValor();
            else 
                valores[i] = Float.MAX_VALUE;
    

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

    public float getMediaResultadosPorDataset(String dataset, String medida){
        float mediaResultados = 0;
        int numeroDeResultados = 0;
        for(Resultado resultado: getResultadosValidos()){
            if(resultado.getAvaliacaoPorMedida(medida) != null && resultado.getDataset().equals(dataset)){
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
        float melhorDatasetValor = 0;

        if (Validador.verificaStringValida(algoritmo)) {
            for(Resultado resultado: getResultadosValidos()){
                String nomeAlgoritmo = resultado.getAlgoritmo().getNome();

                if(algoritmo.equals(nomeAlgoritmo)){
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
            }
        }

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
        float melhorAlgoritmoValor = 0;

        if (Validador.verificaStringValida(dataset)) {
            for(Resultado resultado: getResultadosValidos()){
                String nomeDataset = resultado.getDataset().getNome();

                if(dataset.equals(nomeDataset)){
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
            }
        }

        return melhorAlgoritmo; 
    }

    // Método responsável por imprimir o resumo completo do experimento
    public void imprimeResumoExperimento(){
        System.out.println(
            "Data do experimento: "
            + formataDataExperimento()
        );

        imprimeResultados();
    }

    /*
     * Funções auxiliares
     * ----------------------------
     */

    // Método responsável por formatar a data do experimento
    private String formataDataExperimento() {
        String data = (dia<10 ? "0"+dia : dia) + "/"
                    + (mes<10 ? "0"+mes : mes) + "/"
                    + ano;

        return data;
    }

    // Método responsável por verificar se o objeto é válido e por invocar
    // os métodos responsáveis por cada impressão
    private void imprimeResultados() {
        for (Resultado resultado: this.resultados) {
            if (Validador.verificaObjetoValido(resultado)) {
                System.out.println(
                    resultado.getAlgoritmo() + "\n"
                    + resultado.getDataset()
                );

                System.out.println("Avaliação");
                for(ValorAvaliacao avaliacao: resultado.getAvaliacoes())
                    if(Validador.verificaObjetoValido(avaliacao))
                        System.out.printf(
                            "Nome da medida de avaliação: %s\n"
                            + "Valor: %.2f\n",
                            avaliacao.getMedida().getNome(),
                            avaliacao.getValor()
                        );

                System.out.println(); // Pular uma linha após cada impressão
            }
        }
    }

    // Função auxiliar para acrescentar elementos num vetor
    // de Resultado
    private static Resultado[] append(Resultado[] arr, Resultado element){
        Resultado[] newArray = new Resultado[arr.length+1];

        for(int i=0; i<newArray.length; i++)
            newArray[i] = (i<arr.length ? arr[i] : element);

        return newArray;
    }

    // Função auxiliar para retornar apenas os resultados 
    // validos no vetor this.resultados
    private Resultado[] getResultadosValidos(){
        Resultado[] resultados = {};

        for(Resultado resultado: this.resultados)
            if(resultado != null)
                resultados = append(resultados, resultado);

        return resultados;
    }

}
