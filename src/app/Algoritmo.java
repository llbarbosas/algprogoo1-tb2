package app;
import util.Validador;
import util.TratamentoErro;

public class Algoritmo {
    private String nome;
    private float[] parametros;

    // Método construtor responsável por invocar os métodos responsáveis pela validação e 
    // inicialização dos atributos
    public Algoritmo(String nome, float[] parametros){
        this.verificaNomeValido(nome); // Invoca método responsável por verificar se o atributo nome é válido
        this.inicializaNome(nome); // Invoca método responsável por inicializar o atributo nome

        this.verificaParametrosValido(parametros); // Invoca método responsável por verificar se os parâmetros são válidos
        this.inicializaParametros(parametros); // Invoca método responsável por inicializar o atributo parametros
    }

    // Método responsável por validar o nome
    private void verificaNomeValido(String nome) {
        // Se o nome não for válido, o programa irá tratar o erro por meio da invocação de outro
        // método
        if(!Validador.verificaStringValida(nome)) {
            TratamentoErro.erro("Nome do algoritmo inválido: " + nome);
        }
    }

    // Método responsável por inicializar o atributo nome
    private void inicializaNome(String nome) {
        this.nome = nome;
    }

    // Método responsável por validar a quantidade de parâmetros
    private void verificaParametrosValido(float[] parametros) {
        // Se a quantidade de parâmetros for diferente de 3, o programa irá tratar o erro por meio
        // da invocação de outro método
        if(parametros.length != 3) {
            TratamentoErro.erro(parametros.length + " foram passados. "
                + "3 parametros eram esperados.");
        }
    }

    // Método responsável por inicializar a quantidade de parâmetros
    private void inicializaParametros(float[] parametros) {
        this.parametros = parametros.clone();
    }

    // Método responsável por retornar o nome do objeto algoritmo
    public String getNome(){
        return this.nome;
    }

    // Método responsável por retornar o endereço de memória do atributo parâmetros
    public float[] getParametros(){
        return this.parametros;
    }

    // Método responsável por verificar se dois objetos da classe Algoritmo são iguais ou não
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
