package app;
import util.Validador;
import util.TratamentoErro;

public class Algoritmo {
    private String nome;
    private float[] parametros;

    public Algoritmo(String nome, float[] parametros){
        // Verifica se o nome do algoritmo é válido
        if(Validador.verificaStringValida(nome)) {
            this.nome = nome;
        } else {
            TratamentoErro.erro("Nome do algoritmo inválido: " + nome);
        }

        // Verifica se a quantidade de parâmetros é valida
        if(parametros.length == 3) {
            this.parametros = parametros.clone();
        } else {
            TratamentoErro.erro(parametros.length + " foram passados. "
                + "3 parametros eram esperados.");
        }
    }

    public String getNome(){
        return this.nome;
    }

    public float[] getParametros(){
        return this.parametros;
    }

    public boolean equals(Algoritmo algoritmo){

        if(algoritmo.getNome() == this.nome){
            int parametrosIguais=0;
            for(int i=0; i < 3; i++){
                if(algoritmo.getParametros()[i] == this.parametros[i]){
                    parametrosIguais++;
                }
            }
            if(parametrosIguais == 3){
                return true;
            }else{
                return false;
            }
        }
        return false; 
        
    }

}
