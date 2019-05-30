package app;
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

        // Inicializando com valor default: 0.0
        this.valor = 0.0f;
    }

    public boolean setValor(float valor){
        float menorValor = this.medida.getMenorValor(), 
              maiorValor = this.medida.getMaiorValor();
        
        // Verificando se o valor informado está entre o intervalo permitido
        if (Validador.verificaValorIntervalo(valor, menorValor, maiorValor)) {
            this.valor = valor;
            return true;
        } else {
            TratamentoErro.alerta("Nao eh possivel atribuir o valor informado pois nao"
                + " esta dentro do intervalo permitido.");
            return false;
        }
    }

    public MedidaAvaliacao getMedida(){
        return this.medida;
    }

    public float getValor(){
        return this.valor;
    }
    
    public boolean equals(ValorAvaliacao valorAvaliacao){
        
        if(valorAvaliacao.getValor() == this.valor && valorAvaliacao.getMedida().equals(this.medida)){

            return true;

        }else{

            return false;
            
        }

    }

}
