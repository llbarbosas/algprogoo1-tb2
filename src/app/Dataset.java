package app;
import util.Validador;
import util.TratamentoErro;

public class Dataset {
    private int numExemplos;
    private int numAtributos;
    private int numClasses;
    private String nome;

    // Método construtor responsável por invocar os métodos responsáveis pela validação e 
    // inicialização dos atributos
    public Dataset(int nExemplos, int nAtributos, int nClasses, String nome){
        this.verificaNumeroValido(nExemplos); // Invoca método responsável por verificar se o nExemplos é positivo
        this.inicializaNumeroExemplos(nExemplos); // Invoca método responsável por inicializar o atributo numExemplos

        this.verificaNumeroValido(nAtributos); // Invoca método responsável por verificar se o nAtributos é positivo
        this.inicializaNumeroAtributos(nAtributos); // Invoca método responsável por inicializar o atributo numAtributos

        this.verificaNumeroValido(nClasses); // Invoca método responsável por verificar se o nClasses é positivo
        this.inicializaNumeroClasses(nClasses); // Invoca método responsável por inicializar o atributo numClasses

        this.verificaNomeValido(nome); // Invoca método responsável por verificar se o nome é válido
        this.inicializaNome(nome); // Invoca método responsável por inicializar o atributo nome  
    }

    // Método responsável por validar o número passado como parâmetro
    private void verificaNumeroValido(int numero) {
        // Se o número for negativo, o programa irá tratar o erro por meio da invocação de outro
        // método
        if(!Validador.verificaValorInteiroPositivo(numero)) {
            TratamentoErro.erro("O número informado deve ser maior/igual à zero.");
        }
    }
    
    // Método responsável por inicializar o atributo numExemplos
    private void inicializaNumeroExemplos(int nExemplos) {
        this.numExemplos = nExemplos;
    }

    // Método responsável por inicializar o atributo numAtributos
    private void inicializaNumeroAtributos(int nAtributos) {
        this.numAtributos = nAtributos;
    }

    // Método responsável por inicializar o atributo numClasses
    private void inicializaNumeroClasses(int nClasses) {
        this.numClasses = nClasses;
    }

    // Método responsável por validar o nome
    private void verificaNomeValido(String nome) {
        // Se o nome não for válido, o programa irá tratar o erro por meio da invocação de outro
        // método
        if (!Validador.verificaStringValida(nome)) {
            TratamentoErro.erro("Nome do dataset inválido: " + nome);
        }
    }

    // Método responsável por inicializar o atributo nome
    private void inicializaNome(String nome) {
        this.nome = nome;
    }

    // Método responsável por retornar o valor do atributo numExemplos
    public int getNumExemplos(){
        return this.numExemplos;
    }

    // Método responsável por retornar o valor do atributo numAtributos
    public int getNumAtributos(){
        return this.numAtributos;
    }

    // Método responsável por retornar o valor do atributo numClasses
    public int getNumClasses(){
        return this.numClasses;
    }

    // Método responsável por retornar o atributo nome
    public String getNome(){
        return nome; 
    }

    // Método responsável por verificar se dois objetos da classe Dataset são iguais ou não
    public boolean equals(Dataset dataSet){

        if(dataSet.getNumExemplos() == this.numExemplos && dataSet.getNumAtributos() == this.numAtributos &&
            dataSet.getNumClasses() == this.numClasses && dataSet.getNome() == this.nome){
            return true;
        }else{
            return false;
        }

    }

    // Método responsável por sobrescrever o método padrão de impressão do objeto
    public String toString() {
        String resposta = "Dataset\n";
        resposta += this.atribuiNome();
        resposta += this.atribuiNumeroDeExemplos();
        resposta += this.atribuiNumeroDeAtributos();
        resposta += this.atribuiNumeroDeClasses();

        return resposta;
    }

    // Método responsável  por retornar o nome com formatação
    private String atribuiNome() {
        return "Nome: " + this.nome + "\n";
    }

    // Método responsável  por retornar o número de exemplos com formatação
    private String atribuiNumeroDeExemplos() {
        return "Número de exemplos: " + this.numExemplos + "\n";
    }

    // Método responsável  por retornar o número atributos com formatação
    private String atribuiNumeroDeAtributos() {
        return "Número de atributos: " + this.numAtributos + "\n";
    }

    // Método responsável  por retornar o número de classes com formatação
    private String atribuiNumeroDeClasses() {
        return "Número de classes: " + this.numClasses + "\n";
    }
}
