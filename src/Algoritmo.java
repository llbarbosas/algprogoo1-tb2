import util.Validador;
import util.TratamentoErro;

public class Algoritmo {
    private String nome;
    private float[] parametros;

    // Constante com a quantidade de parâmetros
    private static final int QUANTIDADE_PARAMETROS = 3;

    public Algoritmo(String nome, float[] parametros){

        // Verifica se o nome do algoritmo é válido
        if(Validador.verificaStringValida(nome))
            this.nome = nome;
        else
            TratamentoErro.erro("Nome do algoritmo inválido: " + nome);

        // Verifica se parametros é valido
        if(parametros.length == this.QUANTIDADE_PARAMETROS)
            this.parametros = parametros.clone();
        else
            TratamentoErro.erro(parametros.length + " foram passados. "
                + this.QUANTIDADE_PARAMETROS + " parametros eram esperados.");
    }

    public String getNome(){
        return nome;
    }

    public float[] getParametros(){
        return parametros;
    }
}
