package app;
import util.Validador;
import util.TratamentoErro;

public class MedidaAvaliacao {
    private String nome;
    private float menorValor;
    private float maiorValor;

    public MedidaAvaliacao(String nome, float menorValor, float maiorValor){
        // Verifica se o nome da medida de avaliação é válido
        if (Validador.verificaStringValida(nome)) {
            this.nome = nome;
        } else {
            TratamentoErro.erro("Nome da medida de avaliação inválido: " + nome);
        }

        // Verifica se existe um menor e um maior valor
        if (Validador.verificaExistenciaMenorMaiorValor(menorValor, maiorValor)) {
            this.menorValor = menorValor;
            this.maiorValor = maiorValor;
        } else {
            TratamentoErro.erro("O primeiro valor não é maior do que o segundo.");
        }
    }

    public String getNome(){
        return this.nome; 
    }

    public float getMenorValor(){
        return this.menorValor;
    }

    public float getMaiorValor(){
        return this.maiorValor;
    }

    public boolean equals(MedidaAvaliacao medida){

        if(medida.getNome() == this.nome && medida.getMenorValor() == this.menorValor && medida.getMaiorValor() == this.maiorValor){

            return true;

        }else{

            return false;
            
        }

    }
}
