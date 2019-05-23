package helpers;

public class TratamentoErro {
	private static final String RESET = "\u001B[0m";
	private static final String AMARELO = "\u001B[33m";
	private static final String VERMELHO = "\u001B[31m";

	public static void erro(String mensagem){
		System.out.printf("%s[ERRO] %s%s\n", VERMELHO, mensagem, RESET);
		System.exit(0);
	}	
}
