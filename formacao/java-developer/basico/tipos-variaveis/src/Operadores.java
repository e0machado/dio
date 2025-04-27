
public class Operadores {

    public static void main(String[] args) {

        String nomeCompleto = "LINGUAGEM" + "JAVA";

        System.out.println(nomeCompleto);

        int numero = 5;
        numero = -numero;
        System.out.println(numero);
        numero = -numero;
        System.out.println(numero);

        numero++;
        System.out.println(numero);

        boolean variavel = true;
        variavel = !variavel;
        System.out.println(variavel);

        int a, b;
        a = 6;
        b = 7;

        String resultado = a == b ? "verdadeiro" : "falso";

        System.out.println(resultado);

    }
}
