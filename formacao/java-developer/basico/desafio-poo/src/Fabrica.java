import equipamentos.Iphone;

public class Fabrica {

    public static void main(String[] args) {

        Iphone iphone = new Iphone();

        iphone.ligar("33223445");
        iphone.atualizarPagina();
        iphone.atender();
        iphone.exibirPagina("www.google.com");
        iphone.iniciarCorreioVoz();

    }
}
