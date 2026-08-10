public abstract class Cartao extends Pagamento {

    private String numeroCartao;
    private String nomeTitular;
    private String bandeira;
    private String cvv;

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    protected boolean dadosCartaoValidos() {

        if (numeroCartao == null || numeroCartao.isEmpty()) {
            System.out.println("Numero do cartao nao informado.");
            return false;
        }

        if (nomeTitular == null || nomeTitular.isEmpty()) {
            System.out.println("Nome do titular nao informado.");
            return false;
        }

        if (bandeira == null || bandeira.isEmpty()) {
            System.out.println("Bandeira nao informada.");
            return false;
        }

        if (cvv == null || cvv.isEmpty()) {
            System.out.println("CVV nao informado.");
            return false;
        }

        return true;
    }

    @Override
    public void mostrarPagamento() {
        super.mostrarPagamento();
        System.out.println("Numero do Cartao: " + numeroCartao);
        System.out.println("Nome do Titular: " + nomeTitular);
        System.out.println("Bandeira: " + bandeira);
        System.out.println("CVV: " + cvv);
    }
}