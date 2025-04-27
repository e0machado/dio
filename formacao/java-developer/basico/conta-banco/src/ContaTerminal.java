
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        //Exibir as mensagens para o nosso usuário
        //Obter pela scanner os valores digitados no terminal
        //Exibir a mensagem conta criada
        System.out.println("Por favor, digite seu nome completo:");
        String nome = scanner.nextLine();

        System.out.println("Digite o número da Agência:");
        String agencia = scanner.next();

        System.out.println("Digite o número da conta:");
        int numeroConta = scanner.nextInt();

        System.out.println("Digite seu saldo:");
        double saldo = scanner.nextDouble();

        System.out.println("Olá " + nome + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + numeroConta + " e seu saldo de R$ " + saldo + " já está disponível para saque.");

    }
}
