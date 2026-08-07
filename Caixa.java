public class Caixa {

    private int numero;
    private String operador;
    private String status;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
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

    public void mostrarDados() {
        System.out.println("Número: " + numero);
        System.out.println("Operador: " + operador);
        System.out.println("Status: " + status);
    }
}