package app;
import util.Validador;
import util.TratamentoErro;

public class Dataset {
    private int numExemplos;
    private int numAtributos;
    private int numClasses;
    private String nome;

    public Dataset(int nExemplos, int nAtributos, int nClasses, String nome){
        this.numExemplos = nExemplos;
        this.numAtributos = nAtributos;
        this.numClasses = nClasses;

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

    public boolean equals(Dataset dataSet){

        if(dataSet.getNumExemplos() == this.numExemplos && dataSet.getNumAtributos() == this.numAtributos && dataSet.getNumClasses() == this.numClasses && dataSet.getNome() == this.nome){
            return true;
        }else{
            return false;
        }

    }
}
