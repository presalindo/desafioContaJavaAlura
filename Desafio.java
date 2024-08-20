import java.util.Scanner;
public class Desafio {
    public static void main(String[] args) {
        //Inicialização da leitura de tela
        Scanner prompt = new Scanner(System.in);
        String nomeCliente;
        String tipoConta = "";
        int opcaoConta=0;
        int operacao=0;
        double valor;
        double saldo=0;
        String textoConta = """
                **********************************
                Escolha o tipo da conta
                1 - Conta corrente
                2 - Poupança
                """;
        System.out.println("Digite seu nome:");
        nomeCliente = prompt.nextLine();
        while (opcaoConta!=1 && opcaoConta!=2){
            System.out.println(textoConta);
            opcaoConta = prompt.nextInt();
            if (opcaoConta == 1) {
                tipoConta = "Conta Corrente";
            } else if (opcaoConta == 2) {
                tipoConta = "Poupança";
            }
        }
        System.out.println("Digite o saldo inicial:");
        valor = prompt.nextDouble();
        saldo +=valor;
        while (operacao != 4) {
            String tela = """
                    ************************************
                    Dados iniciais do cliente:
                    Nome: %s
                    Tipo Conta: %s
                    Saldo inicial: R$%.2f
                    ************************************
                    
                    Operações
                    1- Consultar saldos
                    2- Receber valor
                    3- Transferir valor
                    4- Sair
                    """.formatted(nomeCliente,tipoConta,saldo);
            System.out.println(tela);
            System.out.println("Digite a operação:");
            operacao = prompt.nextInt();
            switch (operacao){
                case 1:
                    System.out.println("Seu saldo atual é: R$" +saldo );
                    break;
                case 2:
                    System.out.println("Digite o valor de deposito:");
                    valor = prompt.nextDouble();
                    saldo +=valor;
                    break;
                case 3:
                    System.out.println("Digite o valor de transferência:");
                    valor = prompt.nextDouble();
                    if(valor <= saldo) {
                        saldo -= valor;
                    }else {
                        System.out.println("Não há saldo suficiente para fazer essa transferência!");
                    }
                    break;
                case 4:
                    System.out.println("Saindo do sistema até logo");
                    break;
                default:
                    System.out.println("Opção invalida:");
                    break;
            }
        }
    }
}