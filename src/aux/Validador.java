package aux;

public class Validador {
	
	// STRINGS - Metodos auxiliares para validacao de Strings

	// Descricao: Verifica se uma string e valida
    private boolean verificaStringValida(String str) {
        if (!this.verificaStringVazia(str) && !this.verificaObjetoNulo(str)) {
            return true;
        } else {
            return false;
        }
    }

	// Descricao: Verifica se uma string nao possui nenhum caractere alem do espaco
    private boolean verificaStringVazia(String str) {
        if (str.replaceAll(" ", "").equals("")) {
            return true;
        } else {
            return false;
        }
    }

    // OBJETOS - Metodos auxiliares para validacao de objetos

    // Descricao: Verifica se um objeto e nulo
    private boolean verificaObjetoNulo(Object obj) {
        if (obj == null) {
            return true;
        } else {
            return false;
        }
    }
}
