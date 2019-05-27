import util.Validador;
import util.TratamentoErro;

public class ValorAvaliacao {
    private float valor;
    private MedidaAvaliacao medida;

    public ValorAvaliacao(MedidaAvaliacao medida){
        // Verifica se a medida não é nula
        if(Validador.verificaObjetoValido(medida))
            this.medida = medida;
        else
            TratamentoErro.erro("O objeto informado não pode ser nulo.");

        // Inicializando
        this.valor = 0.0f;
    }

    public boolean setValor(float valor){
        float menorValor = this.medida.getMenorValor();
        float maiorValor = this.medida.getMaiorValor();
        
        // Verificando se o valor está entre o intervalo permitido
        if (Validador.verificaValorIntervalo(valor, menorValor, maiorValor)) {
            this.valor = valor;
            return true;
        } else {
            TratamentoErro.erroSimples("Nao e possivel atribuir o valor informado pois nao"
                + " esta dentro do intervalo permitido.");
            return false;
        }
    }

    public float getValor(){
        return this.valor;
    }

    public MedidaAvaliacao getMedida(){
        return this.medida;
    }
}
