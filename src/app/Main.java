package app;
import util.TratamentoErro;
import static util.Cores.*;

public class Main{
    public static void main(String[] args){
        Experimento experimento = new Experimento(
            31, 1, 2019
        );
        Resultado resultado = new Resultado(
            new Algoritmo("Algoritmo", new float[]{1,3,4}),
            new Dataset(1, 2, 3, "Dataset")
        );
        Teste teste = new Teste();

        /*
         * Testando a funcionalidade de adicionar resultados
         * Caso 1.:   A um experimento com menos de 10 resultados
         * Caso 2.:   A um experimento com mais de 10 resultados
        */

        // Adicionando o caso 1 ao teste 
        teste.adicionaCaso(
            // Instanciando um caso de teste já como parametro
            new Caso(
                // Nome do caso de teste
                "Adicionar um resultado a um experimento com menos de 10 resultados",
                // Resultado esperado
                true,
                // Resultado obtido
                experimento.addResultado(resultado)
            )
        );

        // Adicionando mais 9 resultados
        for(int i=0; i<9; i++)
            experimento.addResultado(resultado);

        // Adicionando o caso 2 ao teste 
        teste.adicionaCaso(new Caso(
            "Adicionar um resultado a um experimento com mais de 10 resultados",
            false,
            experimento.addResultado(resultado)
        ));
        
        // Após adicionar todos os casos de teste,
        // exibe o resultado obtido do teste
        teste.imprimeResultadoDetalhado();
    }
}

/*
 * Um teste é composto por vários casos de teste.
 * Cada caso de teste é composto por um retorno
 * esperado e o retorno obtido.
 * Se o retorno esperado for igual ao retorno
 * obtido, o caso de teste foi bem sucedido
 */
class Caso{
    private String nome;
    private Object retornoEsperado, retornoObtido;
    private boolean resultado;

    public Caso(String nome, Object retornoEsperado, Object retornoObtido){
        if(retornoEsperado != null && retornoObtido != null && nome != null){
            this.nome = nome;
            this.retornoEsperado = retornoEsperado;
            this.retornoObtido = retornoObtido;
            this.resultado = retornoEsperado.equals(retornoObtido);
        } else
            TratamentoErro.erro("Testes mal declarados");
    }

    public boolean getResultado(){
        return resultado;
    }

    public String getNome(){
        return nome;
    }

    public void imprimeResultadoDetalhado(){
        System.out.println(
            "[" + (resultado ? VERDE.on("✓") : VERMELHO.on("x")) + "]"
            + " \"" + nome + "\"" + "\n\t"
            + retornoObtido + ITALICO.on(" (esperado: " + retornoEsperado + ")") 
        );
    }
}

class Teste{
    private Caso[] casos;

    public Teste(){
        casos = new Caso[0];
    }

    public void adicionaCaso(Caso caso){
        Caso[] casosAux = casos.clone();
        casos = new Caso[casos.length+1];

        for(int i=0; i<casos.length; i++)
            casos[i] = (i<casosAux.length ? casosAux[i] : caso);
    }

    public void imprimeResultadoDetalhado(){
        for(Caso caso: casos){
            caso.imprimeResultadoDetalhado();
            System.out.println();
        }
    }
}
