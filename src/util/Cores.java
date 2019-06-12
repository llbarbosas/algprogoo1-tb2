package util;
    
/*
 * Uso:
 *  import static util.Cores.*;
 *  ...
 *  System.out.println(VERMELHO.on("Essa string eh vermelha!"));
 */

public final class Cores{
    public static final String _RESET = "\u001B[0m";
    public static final String _AMARELO = "\u001B[33m";
    public static final String _VERMELHO = "\u001B[31m";
    public static final String _PRETO = "\u001B[30m";
    public static final String _BRANCO = "\u001B[37m";
    public static final String _VERDE = "\u001B[32m";
    public static final String _AZUL = "\u001B[34m";
    public static final String _ROXO = "\u001B[35m";
    public static final String _CIANO = "\u001B[36m";
    public static final String _FUNDO_PRETO = "\u001B[40m";
    public static final String _FUNDO_VERMELHO = "\u001B[41m";
    public static final String _FUNDO_VERDE = "\u001B[42m";
    public static final String _FUNDO_AMARELO = "\u001B[43m";
    public static final String _FUNDO_AZUL = "\u001B[44m";
    public static final String _FUNDO_ROXO = "\u001B[45m";
    public static final String _FUNDO_CIANO = "\u001B[46m";
    public static final String _FUNDO_BRANCO = "\u001B[47m";
    public static final String _ITALICO = "\033[3m";
    public static final String _NEGRITO = "\033[1m";


    public interface Colorir {
        public String on(String msg);
    }

    public static final Colorir AMARELO = (String str) -> _AMARELO + str + _RESET;
    public static final Colorir VERMELHO = (String str) -> _VERMELHO + str + _RESET;
    public static final Colorir PRETO = (String str) -> _PRETO + str + _RESET;
    public static final Colorir BRANCO = (String str) -> _BRANCO + str + _RESET;
    public static final Colorir VERDE = (String str) -> _VERDE + str + _RESET;
    public static final Colorir AZUL = (String str) -> _AZUL + str + _RESET;
    public static final Colorir ROXO = (String str) -> _ROXO + str + _RESET;
    public static final Colorir CIANO = (String str) -> _CIANO + str + _RESET;
    public static final Colorir FUNDO_PRETO = (String str) -> _FUNDO_PRETO + str + _RESET;
    public static final Colorir FUNDO_VERMELHO = (String str) -> _FUNDO_VERMELHO + str + _RESET;
    public static final Colorir FUNDO_VERDE = (String str) -> _FUNDO_VERDE + str + _RESET;
    public static final Colorir FUNDO_AMARELO = (String str) -> _FUNDO_AMARELO + str + _RESET;
    public static final Colorir FUNDO_AZUL = (String str) -> _FUNDO_AZUL + str + _RESET;
    public static final Colorir FUNDO_ROXO = (String str) -> _FUNDO_ROXO + str + _RESET;
    public static final Colorir FUNDO_CIANO = (String str) -> _FUNDO_CIANO + str + _RESET;
    public static final Colorir FUNDO_BRANCO = (String str) -> _FUNDO_BRANCO + str + _RESET;
    public static final Colorir ITALICO = (String str) -> _ITALICO + str + _RESET;
    public static final Colorir NEGRITO = (String str) -> _NEGRITO + str + _RESET;
    
    private Cores() {}
}