import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Loja loja = new Loja();

        int opcao;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Funcionario");
            System.out.println("2 - Cadastrar Caixa");
            System.out.println("3 - Realizar Pagamento");
            System.out.println("4 - Listar Funcionarios");
            System.out.println("5 - Listar Caixas");
            System.out.println("6 - Listar Pagamentos");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    Funcionario funcionario = new Funcionario();

                    System.out.print("ID: ");
                    funcionario.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Nome: ");
                    funcionario.setNome(sc.nextLine());

                    System.out.print("CPF: ");
                    funcionario.setCpf(sc.nextLine());

                    System.out.print("Salario: ");
                    funcionario.setSalario(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Cargo: ");
                    funcionario.setCargo(sc.nextLine());

                    loja.cadastrarFuncionario(funcionario);

                    System.out.println("Funcionario cadastrado com sucesso!");
                    break;

                case 2:

                    Caixa caixa = new Caixa();

                    System.out.print("Numero do Caixa: ");
                    caixa.setNumero(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Operador: ");
                    caixa.setOperador(sc.nextLine());

                    caixa.abrirCaixa();

                    loja.cadastrarCaixa(caixa);

                    System.out.println("Caixa cadastrado com sucesso!");
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

                    loja.cadastrarPagamento(pagamento);

                    System.out.println("Pagamento realizado com sucesso!");
                    break;

                case 4:
                    loja.listarFuncionarios();
                    break;

                case 5:
                    loja.listarCaixas();
                    break;

                case 6:
                    loja.listarPagamentos();
                    break;

                case 7:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 7);

        sc.close();
    }
}