
public class Usuario {

    public static void main(String[] args) {

        SmartTv smartTv = new SmartTv();

        System.out.println("TV ligada? " + smartTv.ligada);
        System.out.println("Canal atual: " + smartTv.canal);
        System.out.println("Volume atual: " + smartTv.volume);

        smartTv.diminiurVolume();
        smartTv.diminiurVolume();
        smartTv.diminiurVolume();

        System.out.println("Volume atual: " + smartTv.volume);

        smartTv.mudarCanal(13);

        smartTv.aumentarCanal();
        smartTv.aumentarCanal();
        smartTv.aumentarCanal();

    }
}
