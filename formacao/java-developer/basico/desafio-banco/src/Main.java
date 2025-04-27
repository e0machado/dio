public class Main {
    public static void main(String[] args) {

        Cliente evandro = new Cliente();

        evandro.setNome("Evandro");

        Conta cc = new ContaCorrente(evandro);
        ContaPoupanca poupanca = new ContaPoupanca(evandro);

        cc.depositar(100);
        cc.transferir(30, poupanca);
        cc.depositar(50);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

    }
}
