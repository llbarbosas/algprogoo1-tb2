package test;
import sisapam.ValorAvaliacao;
import sisapam.MedidaAvaliacao;

public class ValorAvaliacaoTeste {
    public static void main(String[] args) {
        int casos = 4;
        String[] medidasNome = {"Medida 1", "Medida 2", "Medida 3", "Medida 4"};
        float[] menoresValores = {23.5f, 15f, 2.5f, 36.4f},
        maioresValores = {50f, 35f, 4.5f, 60f};
    
        for(int i=0; i<casos; i++)
            new Teste(
                new ValorAvaliacao(
                    new MedidaAvaliacao(medidasNome[i], menoresValores[i], maioresValores[i])
                ),
                new Object[]{ "getMedida", new Object[]{} },
                new Object[]{ "setValor", new Object[]{45.5f} },
                new Object[]{ "getValor", new Object[]{} }
            );
    }
}