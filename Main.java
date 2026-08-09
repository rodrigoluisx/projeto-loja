import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Loja loja = new Loja();

        int opcao;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Gerente");
            System.out.println("2 - Cadastrar Operador de Caixa");
            System.out.println("3 - Realizar Pagamento");
            System.out.println("4 - Listar Funcionarios");
            System.out.println("5 - Listar Pagamentos");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    Gerente gerente = new Gerente();

                    System.out.print("ID: ");
                    gerente.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Nome: ");
                    gerente.setNome(sc.nextLine());

                    System.out.print("CPF: ");
                    gerente.setCpf(sc.nextLine());

                    System.out.print("Salario: ");
                    gerente.setSalario(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Cargo: ");
                    gerente.setCargo(sc.nextLine());

                    System.out.print("Setor: ");
                    gerente.setSetor(sc.nextLine());

                    System.out.print("Bonus: ");
                    gerente.setBonus(sc.nextDouble());
                    sc.nextLine();

                    loja.adicionarFuncionario(gerente);

                    break;

                case 2:

                    OperadorCaixa operador = new OperadorCaixa();

                    System.out.print("ID: ");
                    operador.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Nome: ");
                    operador.setNome(sc.nextLine());

                    System.out.print("CPF: ");
                    operador.setCpf(sc.nextLine());

                    System.out.print("Salario: ");
                    operador.setSalario(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Cargo: ");
                    operador.setCargo(sc.nextLine());

                    System.out.print("Numero do Caixa: ");
                    operador.setNumeroCaixa(sc.nextInt());
                    sc.nextLine();

                    loja.adicionarFuncionario(operador);

                    System.out.println("Operador cadastrado com sucesso!");

                    break;

                case 3:

                    Pagamento pagamento = new Pagamento();

                    System.out.print("Numero do Pagamento: ");
                    pagamento.setNumeroPagamento(sc.nextInt());

                    System.out.print("Valor da Venda: ");
                    pagamento.setValorVenda(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Modalidade de Pagamento: ");
                    pagamento.setModalidadePagamento(sc.nextLine());

                    pagamento.realizarPagamento();

                    if ("APROVADO".equals(pagamento.getStatus())) {
                        loja.cadastrarPagamento(pagamento);
                        System.out.println("Pagamento aprovado!");
                    }

                    break;

                case 4:

                    loja.listarFuncionarios();

                    break;

                case 5:

                    loja.listarPagamentos();

                    break;

                case 6:

                    System.out.println("Sistema encerrado.");

                    break;

                default:

                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 6);

        sc.close();
    }
}