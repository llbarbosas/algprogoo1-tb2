package app;
import util.Validador;
import util.TratamentoErro;

public class Experimento {
    private int dia;
    private int mes;
    private int ano;
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
    
    }

    public Resultado getMelhorResultadoPorAlgoritmo(String algoritmo, String medida){
    
    }

    public Resultado getMelhorResultadoPorDataset(String dataset, String medida){
    
    }

    public Resultado getPiorResultado(String medida){
    
    }

    public Resultado getPiorResultadoPorAlgoritmo(String algoritmo, String medida){
    
    }

    public Resultado getPiorResultadoPorDataset(String dataset, String medida){
    
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
