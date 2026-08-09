public class OperadorCaixa extends Funcionario {

    private int numeroCaixa;
    private String status;

    public OperadorCaixa() {
        status = "FECHADO";
    }

    public int getNumeroCaixa() {
        return numeroCaixa;
    }

    public void setNumeroCaixa(int numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void abrirCaixa() {
        status = "ABERTO";
    }

    public void fecharCaixa() {
        status = "FECHADO";
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Numero do Caixa: " + numeroCaixa);
        System.out.println("Status do Caixa: " + status);
    }
}