import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Loja loja = new Loja();

        Gerente gerenteInicial = new Gerente();

        gerenteInicial.setId(1);
        gerenteInicial.setNome("Gerente Principal");
        gerenteInicial.setCpf("00000000000");
        gerenteInicial.setSalario(3000);
        gerenteInicial.setCargo("Gerente");
        gerenteInicial.setSetor("Administrativo");
        gerenteInicial.setBonus(500);
        gerenteInicial.setSenha("1234");

        loja.adicionarFuncionario(gerenteInicial);

        int opcao;

        do {

            System.out.println("\n========================================");
            System.out.println("           LOJA JAVAVEIRA");
            System.out.println("========================================");
            System.out.println("1 - Acessar Sistema");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n===== PERFIL =====");
                    System.out.println("1 - Gerente");
                    System.out.println("2 - Operador de Caixa");
                    System.out.println("3 - Voltar");
                    System.out.print("Escolha uma opcao: ");

                    int perfil = sc.nextInt();
                    sc.nextLine();

                    if (perfil == 3) {
                        break;
                    }

                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Senha: ");
                    String senha = sc.nextLine();

                    Funcionario funcionario = loja.realizarLogin(id, senha);

                    if (funcionario == null) {
                        System.out.println("ID ou senha incorretos.");
                        break;
                    }

                    if (perfil == 1 && !(funcionario instanceof Gerente)) {
                        System.out.println("Este usuario nao e um gerente.");
                        break;
                    }

                    if (perfil == 2 && !(funcionario instanceof OperadorCaixa)) {
                        System.out.println("Este usuario nao e um operador de caixa.");
                        break;
                    }

                    if (funcionario instanceof Gerente) {

                        menuGerente(sc, loja);

                    } else if (funcionario instanceof OperadorCaixa) {

                        menuOperador(sc, loja, (OperadorCaixa) funcionario);
                    }

                    break;

                case 2:

                    System.out.println("Sistema encerrado.");

                    break;

                default:

                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 2);

        sc.close();
    }

    public static void menuGerente(Scanner sc, Loja loja) {

        int opcao;

        do {

            System.out.println("\n===== MENU GERENTE =====");
            System.out.println("1 - Cadastrar Funcionario");
            System.out.println("2 - Alterar Funcionario");
            System.out.println("3 - Listar Funcionarios");
            System.out.println("4 - Gerar Relatorio de Vendas");
            System.out.println("5 - Voltar");
            System.out.print("Escolha uma opcao: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n1 - Cadastrar Gerente");
                    System.out.println("2 - Cadastrar Operador de Caixa");
                    System.out.print("Escolha: ");

                    int tipo = sc.nextInt();
                    sc.nextLine();

                    if (tipo == 1) {

                        Gerente gerente = new Gerente();

                        preencherFuncionario(sc, gerente);

                        System.out.print("Setor: ");
                        gerente.setSetor(sc.nextLine());

                        System.out.print("Bonus: ");
                        gerente.setBonus(sc.nextDouble());
                        sc.nextLine();

                        System.out.print("Senha: ");
                        gerente.setSenha(sc.nextLine());

                        loja.adicionarFuncionario(gerente);

                    } else if (tipo == 2) {

                        OperadorCaixa operador = new OperadorCaixa();

                        preencherFuncionario(sc, operador);

                        System.out.print("Numero do Caixa: ");
                        operador.setNumeroCaixa(sc.nextInt());
                        sc.nextLine();

                        System.out.print("Senha: ");
                        operador.setSenha(sc.nextLine());

                        loja.adicionarFuncionario(operador);

                    } else {

                        System.out.println("Opcao invalida.");
                    }

                    break;

                case 2:

                    System.out.print("ID do funcionario: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Novo CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Novo salario: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Novo cargo: ");
                    String cargo = sc.nextLine();

                    loja.alterarFuncionario(
                        id,
                        nome,
                        cpf,
                        salario,
                        cargo
                    );

                    break;

                case 3:

                    loja.listarFuncionarios();

                    break;

                case 4:

                    loja.gerarRelatorioVendas();

                    break;

                case 5:

                    System.out.println("Voltando...");

                    break;

                default:

                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 5);
    }

    public static void menuOperador(
            Scanner sc,
            Loja loja,
            OperadorCaixa operador) {

        int opcao;

        do {

            System.out.println("\n===== MENU OPERADOR =====");
            System.out.println("Caixa: " + operador.getNumeroCaixa());
            System.out.println("Status: " + operador.getStatus());
            System.out.println("1 - Abrir Caixa");
            System.out.println("2 - Realizar Pagamento");
            System.out.println("3 - Fechar Caixa");
            System.out.println("4 - Listar Pagamentos");
            System.out.println("5 - Voltar");
            System.out.print("Escolha uma opcao: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    operador.abrirCaixa();

                    break;

                case 2:

                    if (!operador.getStatus().equals("ABERTO")) {

                        System.out.println(
                            "Pagamento nao pode ser realizado."
                        );

                        System.out.println(
                            "O caixa esta fechado."
                        );

                        break;
                    }

                    realizarPagamento(sc, loja);

                    break;

                case 3:

                    operador.fecharCaixa();

                    break;

                case 4:

                    loja.listarPagamentos();

                    break;

                case 5:

                    System.out.println("Voltando...");

                    break;

                default:

                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 5);
    }

    public static void preencherFuncionario(
            Scanner sc,
            Funcionario funcionario) {

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
    }

    public static void realizarPagamento(
            Scanner sc,
            Loja loja) {

        System.out.println("\n===== FORMA DE PAGAMENTO =====");
        System.out.println("1 - PIX");
        System.out.println("2 - Boleto");
        System.out.println("3 - Cartao");
        System.out.print("Escolha uma opcao: ");

        int forma = sc.nextInt();
        sc.nextLine();

        switch (forma) {

            case 1:

                Pix pix = new Pix();

                System.out.print("Numero do Pagamento: ");
                pix.setNumeroPagamento(sc.nextInt());

                System.out.print("Valor: ");
                pix.setValor(sc.nextDouble());
                sc.nextLine();

                System.out.print("Chave PIX: ");
                pix.setChavePix(sc.nextLine());

                pix.realizarPagamento();

                if ("APROVADO".equals(pix.getStatus())) {
                    loja.adicionarPagamento(pix);
                }

                break;

            case 2:

                Boleto boleto = new Boleto();

                System.out.print("Numero do Pagamento: ");
                boleto.setNumeroPagamento(sc.nextInt());

                System.out.print("Valor: ");
                boleto.setValor(sc.nextDouble());
                sc.nextLine();

                System.out.print("Codigo de Barras: ");
                boleto.setCodigoBarras(sc.nextLine());

                boleto.realizarPagamento();

                if ("APROVADO".equals(boleto.getStatus())) {
                    loja.adicionarPagamento(boleto);
                }

                break;

            case 3:

                realizarPagamentoCartao(sc, loja);

                break;

            default:

                System.out.println("Opcao invalida.");
        }
    }

    public static void realizarPagamentoCartao(
            Scanner sc,
            Loja loja) {

        System.out.println("\n===== TIPO DE CARTAO =====");
        System.out.println("1 - Debito");
        System.out.println("2 - Credito");
        System.out.print("Escolha uma opcao: ");

        int tipo = sc.nextInt();
        sc.nextLine();

        if (tipo == 1) {

            CartaoDebito debito = new CartaoDebito();

            System.out.print("Numero do Pagamento: ");
            debito.setNumeroPagamento(sc.nextInt());

            System.out.print("Valor: ");
            debito.setValor(sc.nextDouble());
            sc.nextLine();

            preencherCartao(sc, debito);

            System.out.print("Saldo Disponivel: ");
            debito.setSaldoDisponivel(sc.nextDouble());
            sc.nextLine();

            System.out.print("Senha do Cartao: ");
            debito.setSenha(sc.nextLine());

            debito.realizarPagamento();

            if ("APROVADO".equals(debito.getStatus())) {
                loja.adicionarPagamento(debito);
            }

        } else if (tipo == 2) {

            System.out.print(
                "1 - A vista\n2 - Parcelado\nEscolha: "
            );

            int parcelasTipo = sc.nextInt();

            CartaoCredito credito;

            if (parcelasTipo == 2) {

                System.out.print("Quantidade de parcelas: ");
                int parcelas = sc.nextInt();

                credito = new CartaoCredito(parcelas);

            } else {

                credito = new CartaoCredito();
            }

            System.out.print("Numero do Pagamento: ");
            credito.setNumeroPagamento(sc.nextInt());

            System.out.print("Valor: ");
            credito.setValor(sc.nextDouble());
            sc.nextLine();

            preencherCartao(sc, credito);

            System.out.print("Limite Disponivel: ");
            credito.setLimiteDisponivel(sc.nextDouble());
            sc.nextLine();

            credito.realizarPagamento();

            if ("APROVADO".equals(credito.getStatus())) {
                loja.adicionarPagamento(credito);
            }

        } else {

            System.out.println("Opcao invalida.");
        }
    }

    public static void preencherCartao(
            Scanner sc,
            Cartao cartao) {

        System.out.print("Numero do Cartao: ");
        cartao.setNumeroCartao(sc.nextLine());

        System.out.print("Nome do Titular: ");
        cartao.setNomeTitular(sc.nextLine());

        System.out.print("Bandeira: ");
        cartao.setBandeira(sc.nextLine());

        System.out.print("CVV: ");
        cartao.setCvv(sc.nextLine());
    }
}