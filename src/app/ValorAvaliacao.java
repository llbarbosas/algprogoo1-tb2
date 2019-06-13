package app;
import util.Validador;
import util.TratamentoErro;
    
    /**@Autores
    * Carlos Eduardo Dias Giacomini
    * Jorge Eduardo Dullius dos Santos
    * Lucas Lima Barbosa Silva
    * Lucas Vinicius Cardoso Moro
    */
    
public class ValorAvaliacao {
    private float valor;
    private MedidaAvaliacao medida;

    // Método construtor responsável por invocar os métodos responsáveis pela validação e 
    // inicialização dos atributos
    public ValorAvaliacao(MedidaAvaliacao medida){
        this.verificaMedidaAvaliacaoValida(medida); // Invoca método responsável por verificar se a medida de avaliação é nula
        this.inicializaMedidaAvaliacao(medida); // Invoca método responsável por inicializar a medida de avaliação
        
        this.inicializaValor(); // Invoca método responsável por inicializar o atributo valor
    }

    // Método responsável por validar a medida de avaliação
    private void verificaMedidaAvaliacaoValida(MedidaAvaliacao medida) {
        // Se a medidade avaliação for nula o programa irá tratar o erro por meio
        // da invocação de outro método
        if (!Validador.verificaObjetoValido(medida)) {
            TratamentoErro.erro("O objeto informado não pode ser nulo.");
        }
    }

    // Método responsável por inicializar o atributo medida
    private void inicializaMedidaAvaliacao(MedidaAvaliacao medida) {
        this.medida = medida;
    }

    // Método responsável por inicializar o atributo valor
    private void inicializaValor() {
        this.valor = 0.0f;
    }

    // Método responsável por atribuir um valor ao atributo valor
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

    // Método responsável por retornar a medida de avaliação
    public MedidaAvaliacao getMedida(){
        return this.medida;
    }

    // Método responsável por retornar o valor
    public float getValor(){
        return this.valor;
    }
    
    // Método responsável por verificar se dois objetos da classe ValorAvaliacao são iguais ou não
    public boolean equals(ValorAvaliacao valorAvaliacao){
        if(!Validador.verificaObjetoValido(valorAvaliacao)){
            return false;
        } 
        if(valorAvaliacao.getValor() == this.valor && valorAvaliacao.getMedida().equals(this.medida)){
            return true;
        }else{
            return false;
        }
    }

}
