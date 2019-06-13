package app;
import util.Validador;
import util.TratamentoErro;
    
    /**@Autores
    * Carlos Eduardo Dias Giacomini
    * Jorge Eduardo Dullius dos Santos
    * Lucas Lima Barbosa Silva
    * Lucas Vinicius Cardoso Moro
    */
    
public class MedidaAvaliacao {
    private String nome;
    private float menorValor;
    private float maiorValor;

    public MedidaAvaliacao(String nome, float menorValor, float maiorValor){
        this.verificaNomeValido(nome); // Invoca método responsável por verificar se o atributo nome é válido
        this.inicializaNome(nome); // Invoca método responsável por inicializar o atributo nome

        this.verificaValoresValidos(menorValor, maiorValor); // Invoca método responsável por verificar se há um maior e menor valor
        this.inicializaMenorValor(menorValor); // Invoca método responsável por inicializar o atributo menorValor
        this.inicializaMaiorValor(maiorValor); // Invoca método responsável por inicializar o atributo maiorValor
    }

    // Método responsável por validar o atributo nome
    private void verificaNomeValido(String nome) {
        // Se o nome não for válido o programa irá tratar o erro por meio da invocação de outro
        // método
        if(!Validador.verificaStringValida(nome)) {
            TratamentoErro.erro("Nome da medida de avaliação inválido: " + nome);
        }
    }

    // Método responsável por inicializar o atributo nome
    private void inicializaNome(String nome) {
        this.nome = nome;
    }

    // Método responsável por validar o atributo menorValor e o atributo maiorValor
    private void verificaValoresValidos(float menorValor, float maiorValor) {
        // Se o primeiro valor não for menor que o segundo o programa irá tratar o erro por meio da invocação
        // de outro método
        if (!Validador.verificaExistenciaMenorMaiorValor(menorValor, maiorValor)) {
            TratamentoErro.erro("O primeiro valor informado: " + menorValor + " não é menor que o segundo"
            + " valor informado: " + maiorValor);
        }
    }

    // Método responsável por inicializar o atributo menorValor
    private void inicializaMenorValor(float menorValor) {
        this.menorValor = menorValor;
    }

    // Método responsável por inicializar o atributo maiorValor
    private void inicializaMaiorValor(float maiorValor) {
        this.maiorValor = maiorValor;
    }

    // Método responsável por retornar o nome
    public String getNome(){
        return this.nome; 
    }

    // Método responsável por retornar o menorValor
    public float getMenorValor(){
        return this.menorValor;
    }

    // Método responsável por retornar o maiorValor
    public float getMaiorValor(){
        return this.maiorValor;
    }

    // Método responsável por verificar se dois objetos da classe MedidaAvaliacao são iguais ou não
    public boolean equals(MedidaAvaliacao medida){
        if(!Validador.verificaObjetoValido(medida)){
            return false;
        }
        if (medida.getNome().equals(this.nome) && medida.getMenorValor() == this.menorValor && medida.getMaiorValor() == this.maiorValor){
            return true;
        } else{
            return false;  
        }
    }
}
