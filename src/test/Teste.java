package test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import static util.Cores.*;

public class Teste {
	private Class classeTestada;
	private Object[] objetosDependencias;
	private static final String[] DEFAULT_STRINGS = {
		"DEFAULT_STR1", "DEFAULT_STR2", "DEFAULT_STR3", "DEFAULT_STR4"
	};

	public Teste(Class classeTestada){
		this.classeTestada = classeTestada;
		this.objetosDependencias = null;
		java.lang.reflect.Field[] atributos = classeTestada.getDeclaredFields();
		Method[] metodos = classeTestada.getDeclaredMethods();

		System.out.println(
			FUNDO_ROXO.on("[Teste.java]")
			+ " Iniciando teste da classe " 
			+ ROXO.on(classeTestada.getName())
		);

		identificaAtributos(atributos);
		identificaMetodos(metodos);
	}

	private void identificaAtributos(java.lang.reflect.Field[] atributos){
		System.out.println("\t"
			+ FUNDO_VERDE.on("[Atributos]")
			+ " Identificando atributos"
		);

		int atbIndex = atributos.length;
		for(java.lang.reflect.Field atributo: atributos)
			System.out.println("\t\t" 
				+ VERDE.on(
					(--atbIndex > 0 ? "├── " : "└── ") 
					+ atributo.getType().getSimpleName()
				) 
				+ " " + atributo.getName()
			);
	}

	private void identificaMetodos(Method[] metodos){
		System.out.println(
			"\t"
			+ FUNDO_AMARELO.on("[Metodos]")
			+ " Identificando metodos"
		);

		int metIndex = metodos.length;
		for(Method metodo: metodos){
			System.out.print("\t\t" 
				+ AMARELO.on(
					(--metIndex > 0 ? "├── " : "└── ") 
					+ metodo.getReturnType().getSimpleName()
				) 
				+ " " + metodo.getName()
				+ "(" + (metodo.getParameterTypes().length==0?")\n":"")
			);
			
			int index = metodo.getParameterTypes().length;

			for(Class parametro: metodo.getParameterTypes())
				System.out.print(AMARELO.on(parametro.getSimpleName()) + (--index==0 ? ")\n" : ", "));
		}
	}

	public void run(Object objetoTestado, Object... objetosDependencias){
		this.objetosDependencias = objetosDependencias;

		run(objetoTestado);
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

		for(java.lang.reflect.Field atributo: atributos){
			String tipoAtributo = atributo.getType().getSimpleName(),
					nomeAtributo = atributo.getName();
			boolean acessoAtributo = atributo.canAccess(objetoTestado);

			System.out.print("\t\t\t"
				+ "[" + (acessoAtributo ? 
					FUNDO_VERDE.on("public")
					: FUNDO_VERMELHO.on("private")) + "] "
				+ VERDE.on(tipoAtributo) 
				+ " " + nomeAtributo
			);

			try {
				System.out.print(": "
					+ atributo.get(objetoTestado)
				);
			} catch (IllegalAccessException e){
				/*
				System.out.println("\t\t\t"
					+ FUNDO_VERMELHO.on("erro ao obter atributo")
				);
				*/
			} 

			System.out.println();
		}

		System.out.println(
			"\t\t"
			+ FUNDO_AMARELO.on("[Metodos]")
			+ " Chamando metodos"
		);

		for(Method metodo: metodos){
			String nome = metodo.getName();
			Class[] tipoParametros = metodo.getParameterTypes();
			Object[] parametros = parametrosDefault(tipoParametros);

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

		if(objetosDependencias != null)
			for(Object obj: objetosDependencias){
				if(obj.getClass().isArray()){
					Object[] objArray = (Object[]) obj;

					return objArray[random.nextInt(objArray.length)];
				} else if(classe.equals(obj.getClass()))
					return obj;
			}

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
		String nome = metodo.getName();
		Object retorno = null;
		String parametrosString = "";

		int index = parametros.length;
		for(Object tipo: parametros)
			parametrosString += tipo.getClass().getSimpleName() + (--index==0 ? "" : ", ");

		try {
			retorno = metodo.invoke(objetoTestado, parametros);

			System.out.println("\t\t\t" 
				+ "["
				+ FUNDO_VERDE.on("✓")
				+ "] " 
				+ AMARELO.on(nome + "(" + parametrosString +")")
				+ ": " +
				AMARELO.on((retorno != null ? retorno.getClass().getSimpleName() : "null")) 
				+ " " + retorno
			);
		} catch (IllegalAccessException e) {
			System.out.println(
				FUNDO_VERMELHO.on("private") + "] "
				+ AMARELO.on(nome + "(" + parametrosString +") ")
			);

		} catch (IllegalArgumentException e) {
			System.out.println(
				FUNDO_VERMELHO.on("x") + "] "
				+ AMARELO.on(nome + "(" + parametrosString +") ")
				+ FUNDO_BRANCO.on(VERMELHO.on(parametrosString + " genérico")) + " "
				+ FUNDO_VERMELHO.on(
					"não é um parâmetro adequado para o método "
					+ metodo.getName() 
				)
			);
		} catch (InvocationTargetException e) {
			StackTraceElement[] stackTraceElements = e.getCause().getStackTrace();

			System.out.println(
				FUNDO_VERMELHO.on("x") + "] "
				+ AMARELO.on(nome + "(" + parametrosString +")")
				+ ": "
				+ VERMELHO.on("Exception ")
				+ e.getClass().getSimpleName()
				+ VERMELHO.on(" caused by ")
				+ e.getCause().toString()
				+ VERMELHO.on(" at ")
				+ stackTraceElements[0]
			);
		}
		
	}
}