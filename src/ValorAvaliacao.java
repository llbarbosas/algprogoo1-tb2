public class ValorAvaliacao {
    private float valor;
    private MedidaAvaliacao medida;

    public ValorAvaliacao(MedidaAvaliacao medida){
        this.medida = medida;
    }

    public boolean setValor(float valor){
        if (this.verificaValorIntervalo(valor)) {
            this.valor = valor;
            return true;
        } else {
            System.out.println("Nao e possivel atribuir o valor informado pois nao"
                + " esta dentro do intervalo permitido.\n");
            return false;
        }
    }

    public float getValor(){
        return this.valor;
    }

    public MedidaAvaliacao getMedida(){
        return this.medida;
    }

    private boolean verificaValorIntervalo(float valor) {
        float menorValor = this.medida.getMenorValor();
        float maiorValor = this.medida.getMaiorValor();

        if (valor >= menorValor && valor <= maiorValor) {
            return true;
        } else {
            return false;
        }
    }
}