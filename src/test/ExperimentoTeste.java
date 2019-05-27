package test;
import sisapam.Experimento;;

public class ExperimentoTeste {
    public static void main(String[] args) {
        int casos = 3;
        int[] dia = {1, 4, 5};
        int[] mes = {4, 6, 5};
        int[] ano = {0, 2, 11};
        Teste teste = new Teste(Experimento.class);
        
        for(int i=0; i<casos; i++)
            teste.run(
                new Experimento(dia[i], mes[i], ano[i])
            );
    }
}