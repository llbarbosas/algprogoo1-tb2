import aux.Validador;
import aux.TratamentoErro;

public class Algoritmo {
    private String nome;
    private float[] parametros;

    public Algoritmo(String nome, float[] parametros){

        // Verifica se o nome do algoritmo é válido
        if(Validador.verificaStringValida(nome))
            this.nome = nome;
        else
            TratamentoErro.erro("Nome do algoritmo inválido: " + nome);

        // Verifica se parametros é valido
        if(parametros.length == 3)
            this.parametros = parametros.clone();
        else
            TratamentoErro.erro(parametros + " foram passados. 3 parametros eram esperados.");
    }

    public String getNome(){
        return nome;
    }

    public float[] getParametros(){
        return parametros;
    }
}
