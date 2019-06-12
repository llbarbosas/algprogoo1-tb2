package test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import static util.Cores.*;

public class Teste {
	private Class classeTestada;
	private Object[] objetosDependencias;
	private static final String SIMBOLO_ERRO = "x";
	private static final String SIMBOLO_OK = "✓";
	private static final String SIMBOLO_RAMO = "└──";
	private static final String SIMBOLO_LISTA = "├──";

	public Teste(Class classeTestada){
		this.classeTestada = classeTestada;
		this.objetosDependencias = null;
		
		// Recebendo atributos e metodos da classe para serem identificados
		String nome = classeTestada.getName();
		java.lang.reflect.Field[] atributos = classeTestada.getDeclaredFields();
		Method[] metodos = classeTestada.getDeclaredMethods();

		System.out.println(
			FUNDO_ROXO.on("[Teste.java]")
			+ " Iniciando teste da classe " 
			+ ROXO.on(nome)
		);

		identificaAtributos(atributos);
		identificaMetodos(metodos);
	}

	// Testa os metodos e os atributos da classe testada num
	// objeto instanciado, definindo parametros default para
	// determinados tipos de parametro
	public void run(Object objetoTestado, Object... objetosDependencias){
		this.objetosDependencias = objetosDependencias;

		run(objetoTestado);
	}

	// Testa os metodos e os atributos da classe testada num
	// objeto instanciado
	public void run(Object objetoTestado){
		Method[] metodos = objetoTestado.getClass().getDeclaredMethods();
		java.lang.reflect.Field[] atributos = objetoTestado.getClass().getDeclaredFields();

		System.out.println(
			"\t"
			+ FUNDO_AZUL.on("[Objetos]")
			+ " Iniciando teste num objeto instanciado da classe"
		);

		visibilidadeAtributos(atributos, objetoTestado);
		imprimeMetodos(metodos, objetoTestado);
	}

	// Identifica e imprimd os atributos da classe testada,
	// exibindo seu tipo e nome
	private void identificaAtributos(java.lang.reflect.Field[] atributos){
		System.out.println("\t"
			+ FUNDO_VERDE.on("[Atributos]")
			+ " Identificando atributos"
		);

		int atbIndex = atributos.length;
		for(java.lang.reflect.Field atributo: atributos){
			String tipo = atributo.getType().getSimpleName(),
					nome = atributo.getName();


			System.out.println("\t\t" 
				+ VERDE.on(
					(--atbIndex > 0 ? SIMBOLO_LISTA + " " 
					: SIMBOLO_RAMO + " ") 
					+ tipo
				) 
				+ " " + nome
			);
		}
	}

	// Identifica e imprime os métodos da classe testada, 
	// exibindo o nome, tipo do retorno e tipo dos parâmetros
	private void identificaMetodos(Method[] metodos){
		System.out.println(
			"\t"
			+ FUNDO_AMARELO.on("[Metodos]")
			+ " Identificando metodos"
		);

		int metodoIndex = metodos.length;
		for(Method metodo: metodos){
			String tipoMetodo = metodo.getReturnType().getSimpleName(),
					nomeMetodo = metodo.getName();
			int numeroParametros = metodo.getParameterTypes().length;

			System.out.print("\t\t" 
				+ AMARELO.on(
					(--metodoIndex > 0 ? 
						SIMBOLO_LISTA + " " 
						: SIMBOLO_RAMO + " ") 
					+ tipoMetodo
				) 
				+ " " + nomeMetodo
				+ "(" + (numeroParametros==0?")\n":"")
			);
			
			int parametroIndex = numeroParametros;
			for(Class parametro: metodo.getParameterTypes()){
				String parametroNome = parametro.getSimpleName();

				System.out.print(
					AMARELO.on(parametroNome) 
					+ (--parametroIndex==0 ? ")\n" : ", ")
				);
			}
		}
	}

	// Imprime a visibilidade dos atributos da classe
	// para um determinado objeto (public ou private) 
	private void visibilidadeAtributos(java.lang.reflect.Field[] atributos, Object objetoTestado){
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
	}

	// Chama todos os métodos da classe no objeto testado
	private void imprimeMetodos(Method[] metodos, Object objetoTestado){
		System.out.println(
			"\t\t"
			+ FUNDO_AMARELO.on("[Metodos]")
			+ " Chamando metodos"
		);

		for(Method metodo: metodos){
			String nome = metodo.getName();
			Class[] tipoParametros = metodo.getParameterTypes();
			Object[] parametros = getParametrosPorClasse(tipoParametros);

			chamarMetodo(objetoTestado, metodo, parametros);
		}
	}

	// Chama um método no objeto testado passando os parametros
	// necessários
	private void chamarMetodo(Object objetoTestado, Method metodo, Object[] parametros){
		String nome = metodo.getName();
		Object retorno = null;
		String parametrosString = "";

		int indexParametros = parametros.length;
		for(Object tipo: parametros)
			parametrosString += tipo.getClass().getSimpleName() + (--indexParametros==0 ? "" : ", ");

		try {
			retorno = metodo.invoke(objetoTestado, parametros);

			System.out.println("\t\t\t" 
				+ "["
				+ FUNDO_VERDE.on(SIMBOLO_OK)
				+ "] " 
				+ AMARELO.on(nome + "(" + parametrosString +")")
				+ ": " +
				(retorno != null ? 
					AMARELO.on(retorno.getClass().getSimpleName()) + " " + ITALICO.on(retorno.toString()) 
					: AMARELO.on("null"))
			);
		} catch (IllegalAccessException e) {
			System.out.println("\t\t\t"
				+ "[" + FUNDO_VERMELHO.on("private") + "] "
				+ AMARELO.on(nome + "(" + parametrosString +") ")
			);

		} catch (IllegalArgumentException e) {
			System.out.println("\t\t\t"
				+ "[" + FUNDO_VERMELHO.on(SIMBOLO_ERRO) + "] "
				+ AMARELO.on(nome + "(" + parametrosString +") ")
				+ FUNDO_BRANCO.on(VERMELHO.on(parametrosString + " genérico")) + " "
				+ FUNDO_VERMELHO.on(
					"não é um parâmetro adequado para o método "
					+ metodo.getName() 
				)
			);
		} catch (InvocationTargetException e) {
			StackTraceElement[] stackTraceElements = e.getCause().getStackTrace();

			System.out.println("\t\t\t"
				+ "[" + FUNDO_VERMELHO.on(SIMBOLO_ERRO) + "] "
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
	
	// Dada um array de classes, retorna um array de objetos
	// aleatórios para cada uma das classes do array
	private Object[] getParametrosPorClasse(Class[] tipos){
		Object[] parametros = new Object[tipos.length];

		for(int i=0; i<tipos.length; i++)
			parametros[i] = getParametroRandom(tipos[i]);

		return parametros;
	}

	// Retorna um objeto da classe fornecida
	private Object getParametroRandom(Class classe){
		Random random = new Random();

		if(objetosDependencias != null)
			for(Object obj: objetosDependencias){
				if(obj.getClass().isArray()){
					Object[] objArray = (Object[]) obj;

					return objArray[random.nextInt(objArray.length)];
				} else if(classe.equals(obj.getClass()))
					return obj;
			}

			int randomInt = random.nextInt(100);

			if(classe.equals(String.class))
				return "DEFAULT_STR" + randomInt;
			else if(classe.equals(float.class))
				return random.nextFloat() + randomInt;
			else if(classe.equals(double.class))
				return random.nextDouble() + randomInt;
			else if(classe.equals(boolean.class))
				return random.nextBoolean();
			else if(classe.equals(long.class))
				return random.nextLong();
			else if(classe.equals(int.class))
				return randomInt;
			else
				return new Object();

	}

}