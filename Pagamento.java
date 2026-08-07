public class Pagamento {

    private int numeroPagamento;
    private double valorVenda;
    private String modalidadePagamento;
    private String status;

    public int getNumeroPagamento() {
        return numeroPagamento;
    }

    public void setNumeroPagamento(int numeroPagamento) {
        this.numeroPagamento = numeroPagamento;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getModalidadePagamento() {
        return modalidadePagamento;
    }

    public void setModalidadePagamento(String modalidadePagamento) {
        this.modalidadePagamento = modalidadePagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void realizarPagamento() {

        if (valorVenda <= 0) {
            System.out.println("Valor inválido.");
            return;
        }

        if (modalidadePagamento == null || modalidadePagamento.isEmpty()) {
            System.out.println("Informe a modalidade.");
            return;
        }

        status = "APROVADO";
    }

    public void mostrarPagamento() {
        System.out.println("Número do Pagamento: " + numeroPagamento);
        System.out.println("Valor da Venda: R$ " + valorVenda);
        System.out.println("Modalidade: " + modalidadePagamento);
        System.out.println("Status: " + status);
    }
}