package app;
import util.Validador;
import util.TratamentoErro;

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

    public boolean addResultado(Resultado resultado){
        if(!Validador.verificaArrayCheio(this.resultados)){//verifica se há campo vazio
            for(Resultado obj: this.resultados ){
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
        for(Resultado resultado: resultados)
            if(resultado.getAvaliacaoPorMedida(medida) != null)
                numeroDeValores++;

        // Se nenhuma avaliacao foi encontrada, retorna um float[] vazio
        if(numeroDeValores == 0)
            return new float[]{};
        else
            // Senão, inicializa o vetor de valores que será retornado com o
            // numero de valores encontrados
            valores = new float[numeroDeValores];
 
        // Percorre os resultados novamente, incluindo os valores no vetor que será retornado
        for(Resultado resultado: resultados)
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
        for(Resultado resultado : resultados){
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
        for(Resultado resultado : resultados){
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
    
    }

    public Resultado getMelhorResultado(String medida){
        Resultado melhorResultado = null;

        for(Resultado resultado: resultados){
            ValorAvaliacao avaliacao = resultado.getAvaliacaoPorMedida(medida);
            float novoValor = avaliacao.getValor();

            if(melhorResultado == null)
                melhorResultado = resultado;
            else {
                float melhorResultadoValor = melhorResultado.getAvaliacaoPorMedida(medida).getValor()/
                
                if(melhorResultadoValor<novoValor)
                    melhorResultado = resultado;
            }
                
        }

        return melhorResultado;
    }

    public Resultado getMelhorResultadoPorAlgoritmo(String algoritmo, String medida){
        Resultado melhorResultado = null;

        for(Resultado resultado: resultados){
            String nomeAlgoritmo = resultado.getNomeDoAlgoritmo();

            if(nomeAlgoritmo.equals(algoritmo)){
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

    public Resultado getMelhorResultadoPorDataset(String dataset, String medida){
        Resultado melhorResultado = null;

        for(Resultado resultado: resultados){
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

        for(Resultado resultado: resultados){
            ValorAvaliacao avaliacao = resultado.getAvaliacaoPorMedida(medida);
            float novoValor = avaliacao.getValor();

            if(piorResultado == null)
                piorResultado = resultado;
            else {
                float piorValor = piorResultado.getAvaliacaoPorMedida(medida).getValor()/
                
                if(piorValor>novoValor)
                    piorResultado = resultado;
            }
                
        }

        return piorResultado;
    }

    public Resultado getPiorResultadoPorAlgoritmo(String algoritmo, String medida){
        Resultado piorResultado = null;

        for(Resultado resultado: resultados){
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

        for(Resultado resultado: resultados){
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
    
    }

    public Dataset getDatasetMelhorResultadoAlgoritmo(String algoritmo, String medida){
    
    }

    public String[] getNomesAlgoritmosUtilizados(){
        String[] nomesAlgoritmos = new String[resultados.length];

        for(int i=0; i<nomesAlgoritmos.length; i++)
            nomesAlgoritmos[i] = resultados[i].getNomeDoAlgoritmo();

        return nomesAlgoritmos;
    }

    public Algoritmo getAlgoritmoMelhorResultado(String medida){
    
    }

    public Algoritmo getAlgoritmoMelhorResultadoDataset(String dataset, String medida){
    
    }

    public void imprimeResumoExperimento(){
    
    }
}
