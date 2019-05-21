public class Algoritmo {
    private String nome;
    private float[] parametros;

    public Algoritmo(String nome, float[] parametros){
        this.nome = nome;

        /*
         * "Um algoritmo pode ter de 0 a 3 parâmetros. Assim, nem todas as posições do vetor 
         * poderão ser utilizadas. Posições não utilizadas deverão ser preenchidas com o 
         * valor curinga Float.MAX_VALUE."
         *
         * Esse preenchimento com os coringas deve ser feito na instanciação ou a classe já
         * recebe vetor com as 3 posições preenchidas?
         */
        this.parametros = parametros.clone();
    }

    public String getNome(){
        return nome;
    }

    public float[] getParametros(){
        return parametros;
    }
}
