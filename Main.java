import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Loja loja = new Loja();

        int opcao;

        do {

            System.out.println("\n===== BEM VINDO AO PDV =====");
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

                    break;

                case 3:

                    System.out.println("\n===== FORMA DE PAGAMENTO =====");
                    System.out.println("1 - PIX");
                    System.out.println("2 - Boleto");
                    System.out.println("3 - Cartao");
                    System.out.print("Escolha uma opcao: ");

                    int formaPagamento = sc.nextInt();
                    sc.nextLine();

                    switch (formaPagamento) {

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

                            System.out.println("\n===== TIPO DE CARTAO =====");
                            System.out.println("1 - Debito");
                            System.out.println("2 - Credito");
                            System.out.print("Escolha uma opcao: ");

                            int tipoCartao = sc.nextInt();
                            sc.nextLine();

                            switch (tipoCartao) {

                                case 1:

                                    CartaoDebito debito = new CartaoDebito();

                                    System.out.print("Numero do Pagamento: ");
                                    debito.setNumeroPagamento(sc.nextInt());

                                    System.out.print("Valor: ");
                                    debito.setValor(sc.nextDouble());
                                    sc.nextLine();

                                    System.out.print("Numero do Cartao: ");
                                    debito.setNumeroCartao(sc.nextLine());

                                    System.out.print("Nome do Titular: ");
                                    debito.setNomeTitular(sc.nextLine());

                                    System.out.print("Bandeira: ");
                                    debito.setBandeira(sc.nextLine());

                                    System.out.print("CVV: ");
                                    debito.setCvv(sc.nextLine());

                                    System.out.print("Saldo Disponivel: ");
                                    debito.setSaldoDisponivel(sc.nextDouble());
                                    sc.nextLine();

                                    System.out.print("Senha: ");
                                    debito.setSenha(sc.nextLine());

                                    debito.realizarPagamento();

                                    if ("APROVADO".equals(debito.getStatus())) {
                                        loja.adicionarPagamento(debito);
                                    }

                                    break;

                                case 2:

                                    System.out.print("Pagamento a vista ou parcelado? (1 - A vista / 2 - Parcelado): ");
                                    int tipoPagamento = sc.nextInt();

                                    CartaoCredito credito;

                                    if (tipoPagamento == 2) {

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

                                    System.out.print("Numero do Cartao: ");
                                    credito.setNumeroCartao(sc.nextLine());

                                    System.out.print("Nome do Titular: ");
                                    credito.setNomeTitular(sc.nextLine());

                                    System.out.print("Bandeira: ");
                                    credito.setBandeira(sc.nextLine());

                                    System.out.print("CVV: ");
                                    credito.setCvv(sc.nextLine());

                                    System.out.print("Limite Disponivel: ");
                                    credito.setLimiteDisponivel(sc.nextDouble());
                                    sc.nextLine();

                                    credito.realizarPagamento();

                                    if ("APROVADO".equals(credito.getStatus())) {
                                        loja.adicionarPagamento(credito);
                                    }

                                    break;

                                default:

                                    System.out.println("Opcao invalida.");
                            }

                            break;

                        default:

                            System.out.println("Opcao invalida.");
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