package app;
import util.Validador;
public class Experimento {
    private int dia;
    private int mes;
    private int ano;
    private Resultado[] resultados;

    public Experimento(int dia, int mes, int ano){
        if(Validador.verificaData(dia,mes,ano)){
            resultados = new Resultado[10];
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }else{
            System.out.println("Data inválida.");
            System.exit(0);
        }

    }

    public boolean addResultado(Resultado resultado){
        if(!Validador.verificaArrayCheio(this.resultados)){//verifica se há campo vazio
            if(!Validador.verificaObjetoNoArray(resultado, this.resultados)){//verifica se o objeto já existe no array
                for(int i=0; i<10; i++){//percorre o vetor até o campo vazio encontrado
                    if(this.resultados[i]==null){
                        if(this.resultados[i].equals(resultado)){
                            return true;
                        }
                    }
                }
            }
            System.out.println("Não foi possível cadastrar, objeto já cadastrado anteriormente");
        }
        System.out.println("Não foi possível cadastrar, já foram cadastrados 10 resultados");
        return false;
    
    }

    public float[] getValoresResultados(String medida){
    
    }

    public float getMediaResultadosPorAlgoritmo(String algoritmo, String medida){
    
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
    
    }

    public Algoritmo getAlgoritmoMelhorResultado(String medida){
    
    }

    public Algoritmo getAlgoritmoMelhorResultadoDataset(String dataset, String medida){
    
    }

    public void imprimeResumoExperimento(){
    
    }
}
