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

        this.avaliacao = new ValorAvaliacao[3];
    }

    public Algoritmo getAlgoritmo(){
   	    return this.algoritmo; 
    }

    public Dataset getDataset(){
    	return this.dataset;
    }

    public String getNomeDoAlgoritmo(){
        return this.algoritmo.getNome();
    }

    public String getNomeDoDataset(){
        return this.dataset.getNome();
    }
    
    public boolean addAvaliacao(ValorAvaliacao avaliacao){
    	if(!Validador.verificaArrayCheio(this.avaliacao)){ // Verifica se o vetor está cheio
            if(this.verificaMedidaAvaliacaoIgual(avaliacao)){ // Verifica se possui medida de avaliação igual.
                System.out.println("Impossivel adicionar avaliacao, pois ja existe esta medida de avaliacao");
                return false;
            }

            int posicaoDeInsercao = this.verificaPosicaoDeInsercao();// Auxiliar para receber qual a primeira posição vazia do vetor.
            if (posicaoDeInsercao > -1){
                this.avaliacao[posicaoDeInsercao] = avaliacao;
                return true;
            }
        }
        TratamentoErro.alerta("Não foi possível adicionar avaliação, pois o vetor esta cheio.");
        return false;// Caso o array de avaliacao estiver cheio, então retorna false.
    }

    private int verificaPosicaoDeInsercao(){
        for(int i = 0; i < this.avaliacao.length; i++){
            if(this.avaliacao[i] == null){
                return i;// Retorna qual a posição do vetor esta livre
            }
        }
        return -1;// Retorna valor coringa caso vetor esteja cheio.
    }            
    
    private boolean verificaMedidaAvaliacaoIgual(ValorAvaliacao avaliacao){
        for(int i = 0; i < this.avaliacao.length; i++){//Laço de repetição para percorrer as avaliacões.
            if(Validador.verificaObjetoValido(this.avaliacao[i]) &&
                this.avaliacao[i].getMedida().equals(avaliacao.getMedida())){// Verifica se possui medidade de avaliação igual.
                return true;// Existe medida de avaliação igual.
            }
        }
        return false;
    }

    public ValorAvaliacao[] getAvaliacoes(){
    	return this.avaliacao;
    }

    public ValorAvaliacao getAvaliacaoPorMedida(String medida){
    	for(int i = 0; i < this.avaliacao.length; i++){// Laço para percorrer o vetor de avaliações.
            if(Validador.verificaObjetoValido(this.avaliacao[i]) && // Verifica se o objeto é valido e Verificar se existe a medida, caso exista retorna a avaliação.
                this.avaliacao[i].getMedida().getNome().equalsIgnoreCase(medida)){ 
                return avaliacao[i];// Retorna a avaliação.
            }
        }

        TratamentoErro.alerta("Nenhuma avaliação foi encontrada com a medida " + medida);
        return null;
    }
    
    //verifica se um objeto Resultado é igual ao objeto instanciado
    public boolean equals(Resultado resultado){

        if(resultado.getAlgoritmo().equals(this.algoritmo) && resultado.getDataset().equals(this.dataset)){//compara os algoritmos e os datasets
            int avaliacoesIguais = 0;//auxiliar para comparar ValorAvaliacao[]
            for(int i =0; i<3; i++){//percorre ValorAvaliacao[]
                if(resultado.getAvaliacoes()[i].equals(this.avaliacao[i])){//compara todas as posicoes do ValorAvaliacao[]
                    avaliacoesIguais++;
                }
            }
            if(avaliacoesIguais == 3){//se todos os elementos de ValorAvaliacao[] forem iguais
                return true;
            }
        }
        return false;//se algoritmo, dataset ou ValorAvaliacao forem diferentes
        
    }
   
}
