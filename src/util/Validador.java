package util;

public class Validador {
    
    /*
	 * STRINGS - Metodos auxiliares para validacao de Strings
     */

	// Verifica se uma string eh valida
    public static boolean verificaStringValida(String str) {
        if (Validador.verificaObjetoValido(str)
            && Validador.verificaStringPreenchida(str))
            return true;
        else 
            return false;
    }

	// Verifica se uma string nao possui nenhum caractere alem do espaco
    public static boolean verificaStringPreenchida(String str) {
        if (str.replaceAll(" ", "").equals(""))
            return false;
        else
            return true;
    }

    /*
     * OBJETOS - Metodos auxiliares para validacao de objetos
     */

    // Verifica se um objeto e nulo
    public static boolean verificaObjetoValido(Object obj) {
        if (obj != null)
            return true;
        else
            return false;
    }

    // Verifica se há um valor maior e outro menor
    public static boolean verificaExistenciaMenorMaiorValor(float menorValor, float maiorValor) {
        if (menorValor < maiorValor)
            return true;
        else
            return false;
    }

    /*
     * ARRAYS - Metodos auxiliares para validacao de arrays
     */

    // Verifica se um array de objetos está cheio
    public static boolean verificaArrayCheio(Object[] array) {
        for(Object obj: array)
            if(Validador.verificaObjetoValido(obj))
                return false;

        return true;
    }

    // Verifica se um array de float não possui o valor curinga Float.MAX_VALUE
    public static boolean verificaArrayCheio(float[] array) {
        for(float valor: array)
            if(valor == Float.MAX_VALUE)
                return false;

        return true;
    }

    /*
     *  OUTROS - Metodos auxiliares para outros casos
     */

    // Verifica se o valor informado esta dentro do intervalo especificado
    public static boolean verificaValorIntervalo(float valor, float menorValor, float maiorValor) {
        if (valor >= menorValor && valor <= maiorValor) {
            return true;
        } else {
            return false;
        }
    }
}
