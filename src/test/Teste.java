package test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
			Class[] classes = new Class[parametros.length];

			for(int i=0; i<classes.length; i++)
				classes[i] = getPrimitiveClass(parametros[i].getClass());

			Method method = this.objeto.getClass().getMethod(nome, classes); // getMethod(nome, param1.class, ...);

			System.out.println(
				"|\t\t" 
				+ "Retorno: " + method.invoke(objeto, parametros) + RESET // invoke(obj, param1, ...);
			);

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

	private final Class<?> getPrimitiveClass(Class clazz) {
		String typeName = clazz.getName();

		if (typeName.equals("java.lang.Byte"))
			return byte.class;
		if (typeName.equals("java.lang.Short"))
			return short.class;
		if (typeName.equals("java.lang.Integer"))
			return int.class;
		if (typeName.equals("java.lang.Long"))
			return long.class;
		if (typeName.equals("java.lang.Character"))
			return char.class;
		if (typeName.equals("java.lang.Float"))
			return float.class;
		if (typeName.equals("java.lang.Double"))
			return double.class;
		if (typeName.equals("java.lang.Boolean"))
			return boolean.class;
		if (typeName.equals("java.lang.Void"))
			return void.class;
		else
			return clazz;
	}
}
