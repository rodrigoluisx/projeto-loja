import java.util.ArrayList;

public class Loja {

    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Pagamento> pagamentos;

    public Loja() {
        funcionarios = new ArrayList<>();
        pagamentos = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {

        for (Funcionario f : funcionarios) {

            if (f.getId() == funcionario.getId()) {
                System.out.println("Ja existe um funcionario com esse ID.");
                return;
            }
        }

        funcionarios.add(funcionario);
        System.out.println("Funcionario cadastrado com sucesso!");
    }

    public void listarFuncionarios() {

        if (funcionarios.isEmpty()) {
            System.out.println("Nao existem funcionarios cadastrados.");
            return;
        }

        for (Funcionario funcionario : funcionarios) {
            funcionario.mostrarDados();
            System.out.println("--------------------");
        }
    }

    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    public void listarPagamentos() {

        if (pagamentos.isEmpty()) {
            System.out.println("Nao existem pagamentos cadastrados.");
            return;
        }

        for (Pagamento pagamento : pagamentos) {
            pagamento.mostrarPagamento();
            System.out.println("--------------------");
        }
    }
}