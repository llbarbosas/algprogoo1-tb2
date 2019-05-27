package test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import static util.Cores.*;

public class Teste {
	private Class classeTestada;
	private static final String[] DEFAULT_STRINGS = {
		"DEFAULT_STR1", "DEFAULT_STR2", "DEFAULT_STR3", "DEFAULT_STR4"
	};

	public Teste(Class classeTestada){
		this.classeTestada = classeTestada;
		java.lang.reflect.Field[] atributos = classeTestada.getDeclaredFields();
		Method[] metodos = classeTestada.getDeclaredMethods();

		System.out.println(
			FUNDO_ROXO.on("[Teste.java]")
			+ " Iniciando teste da classe " 
			+ ROXO.on(classeTestada.getName())
		);

		/*
	     * ATRIBUTOS
		 */

		System.out.println("\t"
			+ FUNDO_VERDE.on("[Atributos]")
			+ " Identificando atributos"
		);

		for(java.lang.reflect.Field atributo: atributos)
			System.out.println("\t\t" 
				+ VERDE.on(atributo.getType().getSimpleName()) 
				+ " " + atributo.getName()
			);

		/*
	     * METODOS
		 */

		System.out.println(
			"\t"
			+ FUNDO_AMARELO.on("[Metodos]")
			+ " Identificando metodos"
		);

		for(Method metodo: metodos){
			System.out.print("\t\t" 
				+ AMARELO.on(metodo.getReturnType().getSimpleName()) 
				+ " " + metodo.getName()
				+ "(" + (metodo.getParameterTypes().length==0?")\n":"")
			);
			
			int index = metodo.getParameterTypes().length;

			for(Class parametro: metodo.getParameterTypes())
				System.out.print(AMARELO.on(parametro.getSimpleName()) + (--index==0 ? ")\n" : ", "));
		}

	}
	
	public void run(Object objetoTestado){
		Method[] metodos = objetoTestado.getClass().getDeclaredMethods();
		java.lang.reflect.Field[] atributos = objetoTestado.getClass().getDeclaredFields();

		System.out.println(
			"\t"
			+ FUNDO_AZUL.on("[Objetos]")
			+ " Iniciando teste num objeto instanciado da classe"
		);

		System.out.println(
			"\t\t"
			+ FUNDO_VERDE.on("[Atributos]")
			+ " Visibilidade dos atributos da instância"
		);

		for(java.lang.reflect.Field atributo: atributos)
			System.out.println("\t\t\t"
				+ VERDE.on(atributo.getType().getSimpleName()) 
				+ " " + atributo.getName() + ": "
				+ (atributo.canAccess(objetoTestado) ? 
				FUNDO_VERDE.on("public")
				: FUNDO_VERMELHO.on("private")) 
			);

		System.out.println(
			"\t\t"
			+ FUNDO_AMARELO.on("[Metodos]")
			+ " Chamando metodos"
		);

		for(Method metodo: metodos){
			String nome = metodo.getName();
			Class[] tipoParametros = metodo.getParameterTypes();
			Object[] parametros = parametrosDefault(tipoParametros);
			String parametrosString = "";
			int index = tipoParametros.length;

			for(Object tipo: parametros)
				parametrosString += tipo + (--index==0 ? "" : ", ");

			System.out.print(
				"\t\t\t" + AMARELO.on(nome + "(" + parametrosString +"): ")
			);

			chamarMetodo(objetoTestado, metodo, parametros);
		}

		System.out.println("\t"
			+ FUNDO_AZUL.on("[Objetos]")
			+ " Fim do teste no objeto"
		);
	}

	private Object[] parametrosDefault(Class[] tipos){
		Object[] parametros = new Object[tipos.length];

		for(int i=0; i<tipos.length; i++)
			parametros[i] = getRandom(tipos[i]);

		return parametros;
	}

	private Object getRandom(Class classe){
		Random random = new Random();

		if(classe.equals(String.class))
			return DEFAULT_STRINGS[random.nextInt(DEFAULT_STRINGS.length)];
		else if(classe.equals(float.class))
			return random.nextFloat();
		else if(classe.equals(double.class))
			return random.nextDouble();
		else if(classe.equals(boolean.class))
			return random.nextBoolean();
		else if(classe.equals(long.class))
			return random.nextLong();
		else if(classe.equals(int.class))
			return random.nextInt();
		else
			return new Object();
	}

	private void chamarMetodo(Object objetoTestado, Method metodo, Object[] parametros){		
		try {
			Object retorno = metodo.invoke(objetoTestado, parametros);

			System.out.println( 
				AMARELO.on(retorno.getClass().getSimpleName())
				+ " " + retorno
			);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
}