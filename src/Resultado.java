public class Resultado {
    private Algoritmo algoritmo;
    private Dataset dataset;
    private ValorAvaliacao[] avaliacao;

    public Resultado(Algoritmo algoritmo, Dataset dataset){
    
    }

    public Algoritmo getAlgoritmo(){
    
    }

    public Dataset getDataset(){
    
    }

    public String getNomeDoAlgoritmo(){
    
    }

    public String getNomeDoDataset(){
    
    }

    public boolean addAvaliacao(ValorAvaliacao avaliacao){
    
    }

    public ValorAvaliacao[] getAvaliacoes(){
    
    }

    public ValorAvaliacao getAvaliacaoPorMedida(String medida){
    
    }

    public boolean verificarVetor(){
	    for(int i = 0; i < ValorAvalicao.length; i++){
		    if(ValorAvaliacao[i] == null){
			    return false;
		    }
	    }

	    return true;
    }
}
