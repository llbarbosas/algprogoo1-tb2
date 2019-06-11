package util;

    /**@Autores
    * Carlos Eduardo Dias Giacomini
    * Jorge Eduardo Dullius dos Santos
    * Lucas Lima Barbosa Silva
    * Lucas Vinicius Cardoso Moro
    */

public class Validador {

    /*
     * INTEIROS - Metodos auxiliares para verificacao de valores inteiros
     */

    //  Verifica se um valor inteiro é maior ou igual à zero
    public static boolean verificaValorInteiroPositivo(int numero) {
        if (numero >= 0) {
            return true;
        } else {
            return false;
        }
    } 
    
    
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
            if(!Validador.verificaObjetoValido(obj))
                return false;// Array não está cheio


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

    //retorna true se a data for válida e false caso seja inválida
    public static boolean verificaData(int dia, int mes, int ano){
        if(dia > 0 && mes <= 12 ){//não existe datas com dia menor que 0 ou mes maior que 12
            if(mes == 1 || mes == 3 || mes == 5 || mes ==7 || mes == 8 || mes == 10 || mes == 12 ){//meses com 31 dias
                if(dia < 32) {
                    return true;
                }else{
                    return false;
                }
            }else if(mes == 2){//pode ter 29 ou 28 dias
                if((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))){//se for um ano bissexto
                    if(dia < 30){//em anos bissextos fevereiro tem 29 dias
                        return true;
                    }else{
                        return false;
                    }
                }else{//se nao for um ano bissexto
                    if(dia < 29){//em anos não-bissexto, fevereiro tem 28 dias
                        return true;
                    }else{
                        return false;
                    }
                }
            }else{//meses com 30 dias
                if(dia < 31) {
                    return true;
                }else{
                    return false;
                }
            }

        }else{
            return false;
        }
    }
    //retornar true se o objeto já está cadastrado no array e false caso não esteja;
    public static boolean verificaObjetoNoArray(Object objeto, Object[] array){
        for(Object obj: array){
            if(objeto == obj){
                return true;
            }
        }
        return false;    
    }
}
