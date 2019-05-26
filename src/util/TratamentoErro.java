package util;
import static util.Cores.*;

public class TratamentoErro {
	public static void erro(String mensagem){
		System.out.printf("%s[ERRO] %s%s\n", VERMELHO, mensagem, RESET);
		System.exit(0);
	}	

	public static void erroSimples(String mensagem){
		System.out.printf("%s[ERRO] %s%s\n", AMARELO, mensagem, RESET);
	}
}
