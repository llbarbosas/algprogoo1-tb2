package app;
import util.Validador;
import util.TratamentoErro;

public class Resultado {
    private Algoritmo algoritmo;
    private Dataset dataset;
    private ValorAvaliacao[] avaliacao;

    public Resultado(Algoritmo algoritmo, Dataset dataset){
        this.algoritmo = algoritmo;
        this.dataset = dataset;
    }

    public Algoritmo getAlgoritmo(){
   	    return algoritmo; 
    }

    public Dataset getDataset(){
    	return dataset;
    }

    public String getNomeDoAlgoritmo(){
        return algoritmo.getnome();
    }

    public String getNomeDoDataset(){
        return dataset.getNome();
    }
    
    public boolean addAvaliacao(ValorAvaliacao avaliacao){
	//Validar se o vetor avaliacao está cheio, se o vetor estiver cheio return false
        //Validar se ja possui uma medida de avaliacao igual, se caso possuir return false.
    	if(!Validador.verificaArrayCheio(this.avaliacao)){ //Verificar se o vetor está cheio
            for(int i = 0; i < this.avaliacao.length; i++){
                if(this.avaliacao[i] != null){
                    this.avaliacao[i] = avaliacao;
                    return true;
                }
            }
        }else
            TratamentoErro.alerta("Não foi possível adicionar avaliação");
            return false;// Caso o array de avaliacao estiver cheio, então retorna false.
    }            
 
    public ValorAvaliacao[] getAvaliacoes(){
    	return avaliacao;
    }

    public ValorAvaliacao getAvaliacaoPorMedida(String medida){
    	for(int i = 0; i < avaliacao.length; i++){
            // Adicionar metodo equals() na MedidaAvaliacao
            if(avaliacao[i].getMedida().equals(medida)){
                return avaliacao[i];
            } else
                return null;
        }
    
    }
}
