import java.util.ArrayList;

public class Loja {

    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Pagamento> pagamentos;

    public Loja() {
        funcionarios = new ArrayList<>();
        pagamentos = new ArrayList<>();
    }

    public boolean adicionarFuncionario(Funcionario funcionario) {

        for (Funcionario f : funcionarios) {

            if (f.getId() == funcionario.getId()) {
                System.out.println("Ja existe um funcionario com esse ID.");
                return false;
            }
        }

        funcionarios.add(funcionario);
        System.out.println("Funcionario cadastrado com sucesso.");
        return true;
    }

    public Funcionario realizarLogin(int id, String senha) {

        for (Funcionario funcionario : funcionarios) {

            if (funcionario.getId() == id &&
                funcionario.getSenha().equals(senha)) {

                return funcionario;
            }
        }

        return null;
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

    public void alterarFuncionario(int id, String nome, String cpf,
                                   double salario, String cargo) {

        for (Funcionario funcionario : funcionarios) {

            if (funcionario.getId() == id) {

                funcionario.setNome(nome);
                funcionario.setCpf(cpf);
                funcionario.setSalario(salario);
                funcionario.setCargo(cargo);

                System.out.println("Funcionario alterado com sucesso.");
                return;
            }
        }

        System.out.println("Funcionario nao encontrado.");
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

    public void gerarRelatorioVendas() {

        if (pagamentos.isEmpty()) {
            System.out.println("Nao existem vendas registradas.");
            return;
        }

        double total = 0;

        System.out.println("\n===== RELATORIO DE VENDAS =====");

        for (Pagamento pagamento : pagamentos) {

            pagamento.mostrarPagamento();

            if ("APROVADO".equals(pagamento.getStatus())) {
                total += pagamento.getValor();
            }

            System.out.println("--------------------");
        }

        System.out.println("TOTAL DE VENDAS: R$ " + total);
    }
}