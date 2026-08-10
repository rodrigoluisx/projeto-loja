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

        if (status.equals("ABERTO")) {
            System.out.println("O caixa ja esta aberto.");
            return;
        }

        status = "ABERTO";
        System.out.println("Caixa aberto com sucesso.");
    }

    public void fecharCaixa() {

        if (status.equals("FECHADO")) {
            System.out.println("O caixa ja esta fechado.");
            return;
        }

        status = "FECHADO";
        System.out.println("Caixa fechado com sucesso.");
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Numero do Caixa: " + numeroCaixa);
        System.out.println("Status do Caixa: " + status);
    }
}
