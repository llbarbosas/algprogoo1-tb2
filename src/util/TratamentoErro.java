package util;
import static util.Cores.*;

public class TratamentoErro {
	public static void erro(String mensagem){
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

		System.out.println(
			VERMELHO.on("[ERRO] em ") 
			+ stackTraceElements[2] + ": "
			+ VERMELHO.on(mensagem)
		);
		System.exit(0);
	}	

	public static void alerta(String mensagem){
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

		System.out.println(
			AMARELO.on("[ALERTA] em ")
			+ stackTraceElements[2] + ": "
			+ AMARELO.on(mensagem)
		);
	}
}
