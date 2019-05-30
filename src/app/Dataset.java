package app;
import util.Validador;
import util.TratamentoErro;

public class Dataset {
    private int numExemplos;
    private int numAtributos;
    private int numClasses;
    private String nome;

    public Dataset(int nExemplos, int nAtributos, int nClasses, String nome){
        // Verifica se o nExemplos é maior ou igual à zero
        if (Validador.verificaValorInteiroMaiorIgualAZero(nExemplos)) {
            this.numExemplos = nExemplos;
        } else {
            TratamentoErro.erro("Número de exemplos deve ser maior/igual à zero.");
        }
        
        // Verifica se o nAtributos é maior ou igual à zero
        if (Validador.verificaValorInteiroMaiorIgualAZero(nExemplos)) {
            this.numAtributos = nAtributos;
        } else {
            TratamentoErro.erro("Número de atributos deve ser maior/igual à zero.");
        }

        // Verifica se o nClasses é maior ou igual à zero
        if (Validador.verificaValorInteiroMaiorIgualAZero(nExemplos)) {
            this.numClasses = nClasses;
        } else {
            TratamentoErro.erro("Número de classes deve ser maior/igual à zero.");
        }

        // Verifica se o nome do dataset é válido
        if(Validador.verificaStringValida(nome))
            this.nome = nome;
        else
            TratamentoErro.erro("Nome do dataset inválido: " + nome);  
    } 

    public int getNumExemplos(){
        return numExemplos;
    }

    public int getNumAtributos(){
        return numAtributos;
    }

    public int getNumClasses(){
        return numClasses;
    }

    public String getNome(){
        return nome; 
    }
}
