public class Pix extends Pagamento {

    private String chavePix;

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void realizarPagamento() {

        if (getValor() <= 0) {
            System.out.println("Valor invalido.");
            return;
        }

        if (chavePix == null || chavePix.isEmpty()) {
            System.out.println("Chave PIX nao informada.");
            return;
        }

        setStatus("APROVADO");
    }

    @Override
    public void mostrarPagamento() {
        super.mostrarPagamento();
        System.out.println("Chave PIX: " + chavePix);
    }
}