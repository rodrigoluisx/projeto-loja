public class CartaoCredito extends Cartao {

    private double limiteDisponivel;
    private int quantidadeParcelas;

    public CartaoCredito() {
        quantidadeParcelas = 1;
    }

    public CartaoCredito(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

    public void setLimiteDisponivel(double limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    @Override
    public void realizarPagamento() {

        if (getValor() <= 0) {
            System.out.println("Valor invalido.");
            return;
        }

        if (!dadosCartaoValidos()) {
            return;
        }

        if (limiteDisponivel < getValor()) {
            System.out.println("Pagamento nao aprovado: limite insuficiente.");
            return;
        }

        if (quantidadeParcelas <= 0) {
            System.out.println("Quantidade de parcelas invalida.");
            return;
        }

        double valorParcela = getValor() / quantidadeParcelas;

        limiteDisponivel -= getValor();
        setStatus("APROVADO");

        System.out.println("Pagamento aprovado!");
        System.out.println("Valor total: R$ " + getValor());
        System.out.println("Quantidade de parcelas: " + quantidadeParcelas);
        System.out.println("Valor de cada parcela: R$ " + valorParcela);
    }

    @Override
    public void mostrarPagamento() {
        super.mostrarPagamento();
        System.out.println("Limite Disponivel: R$ " + limiteDisponivel);
        System.out.println("Quantidade de Parcelas: " + quantidadeParcelas);

        if (getStatus() != null && getStatus().equals("APROVADO")) {
            double valorParcela = getValor() / quantidadeParcelas;
            System.out.println("Valor de cada parcela: R$ " + valorParcela);
        }
    }
}