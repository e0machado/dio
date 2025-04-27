package equipamentos;

import interfaces.AparelhoTelefonico;
import interfaces.NavegadorInternet;
import interfaces.ReprodutorMusical;

public class Iphone implements AparelhoTelefonico, ReprodutorMusical, NavegadorInternet {

    @Override
    public void ligar(String num) {
        System.out.println("LIGANDO PARA " + num + " VIA IPHONE");

    }

    @Override
    public void atender() {
        System.out.println("ATENDENDO VIA IPHONE");

    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("INICIANDO CORREIO DE VOZ VIA IPHONE");

    }

    @Override
    public void tocar() {
        System.out.println("TOCANDO MÚSICA VIA IPHONE");

    }

    @Override
    public void pausar() {
        System.out.println("PAUSANDO MÚSICA VIA IPHONE");

    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("SELECIONANDO MÚSICA " + musica + " VIA IPHONE");

    }

    @Override
    public void exibirPagina(String url) {
        System.out.println("EXIBINDO PÁGINA " + url + " VIA IPHONE");

    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("ADICIONANDO NOVA ABA VIA IPHONE");

    }

    @Override
    public void atualizarPagina() {
        System.out.println("ATUALIZANDO PÁGINA VIA IPHONE");

    }
}
