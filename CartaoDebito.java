public class CartaoDebito extends Cartao {

    private double saldoDisponivel;
    private String senha;

    public double getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public void setSaldoDisponivel(double saldoDisponivel) {
        this.saldoDisponivel = saldoDisponivel;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

        if (senha == null || senha.isEmpty()) {
            System.out.println("Senha nao informada.");
            return;
        }

        if (saldoDisponivel < getValor()) {
            System.out.println("Pagamento nao aprovado: saldo insuficiente.");
            return;
        }

        saldoDisponivel -= getValor();
        setStatus("APROVADO");

        System.out.println("Pagamento aprovado!");
    }

    @Override
    public void mostrarPagamento() {
        super.mostrarPagamento();
        System.out.println("Saldo Disponivel: R$ " + saldoDisponivel);
        System.out.println("Senha: " + senha);
    }
}