public class Boleto extends Pagamento {

    private String codigoBarras;

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void realizarPagamento() {

        if (getValor() <= 0) {
            System.out.println("Valor invalido.");
            return;
        }

        if (codigoBarras == null || codigoBarras.isEmpty()) {
            System.out.println("Codigo de barras nao informado.");
            return;
        }

        setStatus("APROVADO");
    }

    @Override
    public void mostrarPagamento() {
        super.mostrarPagamento();
        System.out.println("Codigo de Barras: " + codigoBarras);
    }
}