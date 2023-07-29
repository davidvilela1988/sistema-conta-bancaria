import java.util.Scanner;
public class ContaBancaria {
    public static void main(String[] args) {
        Scanner dadosNome = new Scanner(System.in); //variável de recebimento do nome
        Scanner senhaDigitada = new Scanner(System.in); //Variável para recebimento da senha
        Scanner digitada = new Scanner(System.in); //variável de recebimento da opção desejada
        Scanner valorDigitado = new Scanner(System.in); //variável para valores digitados

        boolean continuar = true;
        int senha;
        String conta = "Corrente";
        Double saldo = 2000.00;
        int opcaoDigitada = 0; //variável com valor da opção digitada


        System.out.println("Insira o seu nome: ");
        String nome = dadosNome.nextLine();

        while (continuar) {
            System.out.println("Insira a senha de quatro números do sistema:");
            senha = senhaDigitada.nextInt();

            if (senha==1234) {
                continuar=false;
                break;
            } else {
                System.out.println("Senha inválida! Tente novamente.");
            }
        }

        System.out.println("Bem vindo, " + nome + ".");


        String dadosDoCliente = """
                            
                **********************************
                            
                Nome do(a) Cliente: %s.
                Tipo de Conta: %s.
                Saldo Inicial: %.2f
                            
                **********************************      
                
                """.formatted(nome, conta, saldo);
        System.out.println(dadosDoCliente);

        String menu = """
                
                 Operações:
                            
                1- Consultar saldo;
                2- Receber valor;
                3- Transferir valor;
                4- Sair.
                
                Digite a opção desejada:
                """;



        while (opcaoDigitada != 4) {
            System.out.println(menu);
            opcaoDigitada = digitada.nextInt();

            if (opcaoDigitada == 1) {
                System.out.println("Seu saldo atual é: " + saldo);
            } else if (opcaoDigitada == 2) {
                System.out.println("Valor a receber: ");
                double valor = valorDigitado.nextDouble();
                saldo += valor;
                System.out.println("Seu novo saldo é: " + saldo);
            } else if (opcaoDigitada == 3) {
                System.out.println("Qual o valor que deseja transferir?");
                double valor = valorDigitado.nextDouble();
                if (valor > saldo) {
                    System.out.println("Não há saldo suficiente para realizar esta transição.");
                } else {
                    saldo -= valor;
                    System.out.println("Transferência realizada! Seu novo saldo é: " + saldo);
                }
            } else if (opcaoDigitada != 4){
                System.out.println("Opção inválida!");
            } else if (opcaoDigitada == 4) {
                System.out.println("Obrigado por utilizar nosso sistema!");
                System.out.println("Volte sempre!");
                System.out.println("\n\nSistema Desenvolvido por: David Vilela");
                break;
            }
        }
    }
}