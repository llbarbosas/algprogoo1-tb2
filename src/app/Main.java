package app;
import util.TratamentoErro;

/*
 * Um teste é composto por vários casos de teste
 * Cada caso de teste é composto por um retorno
 * esperado e o retorno obtido.
 * Se o retorno esperado for igual ao retorno
 * obtido, o caso de teste foi bem sucedido
 */
class Caso{
    private Object retornoEsperado, retornoObtido;

    public Caso(Object retornoEsperado, Object retornoObtido){
        if(retornoEsperado != null && retornoObtido != null){
            this.retornoEsperado = retornoEsperado;
            this.retornoObtido = retornoObtido;
        } else
            TratamentoErro.erro("Testes mal declarados");
    }

    public boolean getResultado(){
        boolean resultado = retornoEsperado.equals(retornoObtido);

        return resultado;
    }

    public void imprimeResultadoDetalhado(){
        System.out.println(
            "Resultado: " + (getResultado() ? "ok" : "deu ruim") + "\n"
             + retornoEsperado + (getResultado() ? " = " : " != ") + retornoObtido
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
        for(Caso caso: casos)
            caso.imprimeResultadoDetalhado();
    }
}

public class Main{
    public static void main(String[] args){
        Teste teste = new Teste();

        teste.adicionaCaso(new Caso(1, 1));
        teste.adicionaCaso(new Caso(2, 1));
        teste.adicionaCaso(new Caso(4.5, 4.5));

        teste.imprimeResultadoDetalhado();
    }
}