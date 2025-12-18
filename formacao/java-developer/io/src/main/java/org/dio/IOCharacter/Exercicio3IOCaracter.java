package org.dio.IOCharacter;

import java.io.*;

//Faça uma copia do arquivo "recomendacoes.txt" e agora adicione 3 recomendações de livros.
public class Exercicio3IOCaracter {
    public static void copiarArquivo() throws IOException {
        File f = new File("C:\\Users\\evand\\OneDrive\\Documentos\\dio\\formacao\\java-developer\\io\\recomendacoes.txt");
        String nameArquivo = f.getName();

        /*Reader r = new FileReader(nameArquivo);
        BufferedReader br = new BufferedReader(r);*/
        BufferedReader br = new BufferedReader(new FileReader(nameArquivo));
        String line = br.readLine();

        String nameArquivoCopy = nameArquivo.substring(0, nameArquivo.indexOf(".")).concat("-copy.txt");
        File fCopy = new File(nameArquivoCopy);

        BufferedWriter bw = new BufferedWriter(new FileWriter(fCopy.getName()));

        do {
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = br.readLine();
        } while (!(line == null));

        System.out.printf("Arquivo \"%s\" copiado com sucesso! Com o tamanho '%d' bytes.\n", f.getName(), f.length());
        System.out.printf("Arquivo \"%s\" criado com sucesso! Com o tamanho '%d' bytes.\n\n", fCopy.getName(), fCopy.length());

        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Recomende 3 livros: ");
        pw.flush();

        adicionarInfoNoArquivo(fCopy.getName());

        pw.printf("Ok! Tudo certo. Tamanho do arquivo %d bytes.", fCopy.length());

        br.close();
        bw.close();
        pw.close();

    }

    public static void adicionarInfoNoArquivo(String arquivo) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));

        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while (!(line.equalsIgnoreCase("fim")));

        bw.flush();

        br.close();
        bw.close();


    }

    public static void main(String[] args) throws IOException {
        copiarArquivo();

    }

}
