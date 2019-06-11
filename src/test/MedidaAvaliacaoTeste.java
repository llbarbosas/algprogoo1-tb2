package test;
import app.MedidaAvaliacao;
    
    /**@Autores
    * Carlos Eduardo Dias Giacomini
    * Jorge Eduardo Dullius dos Santos
    * Lucas Lima Barbosa Silva
    * Lucas Vinicius Cardoso Moro
    */

public class MedidaAvaliacaoTeste {
    public static void main(String[] args) {
        /*
        * Criação dos casos de teste
        * Parametros: int nExemplos, int nAtributos, 
        * int nClasses, String nome
        */
        int casos = 4;
        String[] medidasNome = {"Medida 1", "Medida 2", "Medida 3", "Medida 4"};
        float[] menoresValores = {23.5f, 15f, 2.5f, 36.4f},
        maioresValores = {50f, 35f, 4.5f, 60f};
        Teste teste = new Teste(MedidaAvaliacao.class);

        for(int i=0; i<casos; i++)
            teste.run(
                // Objeto da classe testada
                new MedidaAvaliacao(medidasNome[i], menoresValores[i], maioresValores[i]),
                // Objetos que serão utilizados nos métodos testados
                new MedidaAvaliacao(medidasNome[2], menoresValores[2], maioresValores[2])
            );

    }
}