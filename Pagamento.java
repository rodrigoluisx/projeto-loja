public abstract class Pagamento {

    private int numeroPagamento;
    private double valor;
    private String status;

    public int getNumeroPagamento() {
        return numeroPagamento;
    }

    public void setNumeroPagamento(int numeroPagamento) {
        this.numeroPagamento = numeroPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public abstract void realizarPagamento();

    public void mostrarPagamento() {
        System.out.println("Numero do Pagamento: " + numeroPagamento);
        System.out.println("Valor: R$ " + valor);
        System.out.println("Status: " + status);
    }
}