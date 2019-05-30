package app;
import util.Validador;
import util.TratamentoErro;

public class Resultado {
    private Algoritmo algoritmo;
    private Dataset dataset;
    private ValorAvaliacao[] avaliacao;

    public Resultado(Algoritmo algoritmo, Dataset dataset){
        // Verifica se o algoritmo não é nulo
        if(Validador.verificaObjetoValido(algoritmo)) {
            this.algoritmo = algoritmo;
        } else {
            TratamentoErro.erro("O objeto informado não pode ser nulo.");
        }

        // Verifica se o dataset não é nulo
        if(Validador.verificaObjetoValido(dataset)) {
            this.dataset = dataset;
        } else {
            TratamentoErro.erro("O objeto informado não pode ser nulo.");
        }
    }

    public Algoritmo getAlgoritmo(){
   	    return algoritmo; 
    }

    public Dataset getDataset(){
    	return dataset;
    }

    public String getNomeDoAlgoritmo(){
        return algoritmo.getNome();
    }

    public String getNomeDoDataset(){
        return dataset.getNome();
    }
    
    public boolean addAvaliacao(ValorAvaliacao avaliacao){
    //Validar se o vetor avaliacao está cheio, se o vetor estiver cheio return false
    	if(!Validador.verificaArrayCheio(this.avaliacao)){
            for(int i = 0; i < this.avaliacao.length; i++){//Array para percorrer as avaliacões.
                for(int j = 0; j < this.avaliacao.length; j++){//Array para percorrer as medidas de cada avaliação.
                    if(this.avaliacao.getMedida[i].equals(avaliacao.getMedida[j])){
                        System.out.println("Impossivel adicionar avaliacao, pois ja existe esta medida de avaliacao");
                        return false;
                    }
                }
            }

            for(int i = 0; i < this.avaliacao.length; i++){
                if(this.avaliacao[i] == null){
                    this.avaliacao[i] = avaliacao;
                    return true;
                }
            }
        }else{
            TratamentoErro.alerta("Não foi possível adicionar avaliação");
            return false;// Caso o array de avaliacao estiver cheio, então retorna false.
        }
    }            
 

    public ValorAvaliacao[] getAvaliacoes(){
    	return avaliacao;
    }

    public ValorAvaliacao getAvaliacaoPorMedida(String medida){
    	for(int i = 0; i < avaliacao.length; i++)
            if(avaliacao[i].getMedida().getNome().equals(medida))
                return avaliacao[i];

        return null;
    }

    public boolean equals(Resultado resultado){

        if(resultado.getAlgoritmo().equals(this.algoritmo) && resultado.getDataset().equals(this.dataset) && resultado.getAvaliacoes().equals(this.avaliacao)){
            return true;
        }else{
            return false;
        }

    }
   
}
