package org.dio.IOBytes;

import java.io.*;

//Faça uma cópia do arquivo "recomendacoes-copy.txt".
public class ExemploIOBytes {
    public static void copiarArquivo() throws IOException {
        File f = new File("C:\\Users\\evand\\OneDrive\\Documentos\\dio\\formacao\\java-developer\\io\\recomendacoes-copy.txt");
        String nameArquivo = f.getName();

        /*InputStream is = new FileInputStream(f.getName());
        BufferedInputStream bis = new BufferedInputStream(is);*/
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f.getName()));

        String nameArquivoCopy = nameArquivo.substring(0, nameArquivo.indexOf("-")).concat("-copy2.txt");
        File fCopy = new File(nameArquivoCopy);

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(nameArquivoCopy));

        int line = 0;
        while ((line = bis.read()) != -1) {
            bos.write((char) line);
            bos.flush();

        }

        bis.close();
        bos.close();

        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo %s copiado com sucesso e está no diretório %s com %d bytes.",
                fCopy.getName(), fCopy.getPath(), fCopy.length());

    }

    public static void main(String[] args) throws IOException {
        copiarArquivo();

    }

}
