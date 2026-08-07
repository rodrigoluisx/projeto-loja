import java.util.ArrayList;

public class Loja {

    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Caixa> caixas;
    private ArrayList<Pagamento> pagamentos;

    public Loja() {
        funcionarios = new ArrayList<>();
        caixas = new ArrayList<>();
        pagamentos = new ArrayList<>();
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void cadastrarCaixa(Caixa caixa) {
        caixas.add(caixa);
    }

    public void cadastrarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    public void listarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            funcionario.mostrarDados();
            System.out.println("--------------------");
        }
    }

    public void listarCaixas() {
        for (Caixa caixa : caixas) {
            caixa.mostrarDados();
            System.out.println("--------------------");
        }
    }

    public void listarPagamentos() {
        for (Pagamento pagamento : pagamentos) {
            pagamento.mostrarPagamento();
            System.out.println("--------------------");
        }
    }
}