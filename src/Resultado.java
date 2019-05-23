public class Resultado {
    private Algoritmo algoritmo;
    private Dataset dataset;
    private ValorAvaliacao[] avaliacao;

    public Resultado(Algoritmo algoritmo, Dataset dataset){
    
    }

    public Algoritmo getAlgoritmo(){
   	return Algoritmo; 
    }

    public Dataset getDataset(){
    	
    }

    public String getNomeDoAlgoritmo(){
    
    }

    public String getNomeDoDataset(){
    
    }
    
    public boolean addAvaliacao(ValorAvaliacao avaliacao){
	//Validar se o vetor avaliacao está cheio, se o vetor estiver cheio return false
	//Validar se ja possui uma medida de avaliacao igual, se caso possuir return false.
	//
    	if(){
		return false;
	}else
		// System.out.println("Impossivel adicionar esta avaliacao");
		return true;
    }
	

    public ValorAvaliacao[] getAvaliacoes(){
    	return avaliacao;
    }

    public ValorAvaliacao getAvaliacaoPorMedida(String medida){
    	for(int i = 0; i < avaliacoes.length; i++){
		if(avaliacoes[i].equalsIgnoreCase(medida){
			return avaliacao[i];
		}else
			return null;

    }

   /* private int verificarVetorCheio(){
	    for(int i = 0; i < this.avalicao.length; i++){
		    if(ValorAvaliacao[i] == null){
			    return i;
		    }
	    }

	    return -1;//Está cheio
    }*/
}
