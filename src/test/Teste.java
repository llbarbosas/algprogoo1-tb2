package test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import static util.Cores.*;

public class Teste {
	Object objeto;

	public Teste(Object objeto, Object[]... metodos){
		System.out.println(
			FUNDO_ROXO + "[Teste]" + RESET
			+ " Iniciando teste de " 
			+ FUNDO_AZUL + objeto.getClass() + RESET
		);

		this.objeto = objeto;

		for(Object[] metodo: metodos){
			String nome = (String) metodo[0];
			Object[] parametros = (Object[]) metodo[1];

			String param = "";
			int index = parametros.length;

			for(Object o: parametros)
				param += o + (--index==0 ? "" : ", ");

			System.out.println(
				"|\t" + FUNDO_CIANO + "[" + nome + "(" + param +")]" + RESET
				+ " Chamando metodo"
			);

			callMethod(nome, parametros);
		}

		System.out.println(
			FUNDO_ROXO + "[Teste]" + RESET
			+ " Finalizando teste\n"
		);
	}
	
	private void callMethod(String nome, Object[] parametros){
		try {
			Method method = this.objeto.getClass().getMethod(nome);

			System.out.println(
				"|\t\t" 
				+ "Retorno: " + method.invoke(objeto) + RESET
			);
			// (resultado.getClass().isArray() ? Arrays.deepToString(resultado) : resultado)

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

	private boolean isArray(Object obj){
    	return obj!=null && obj.getClass().isArray();
	} 
}
