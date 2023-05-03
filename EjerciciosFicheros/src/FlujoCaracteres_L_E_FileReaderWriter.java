

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FlujoCaracteres_L_E_FileReaderWriter {
    public static void copyFile(String sourceFilePath, String destFilePath)
            throws IOException {
        // Declaramos o reader e o writer
        FileReader in = null;
        FileWriter out = null;

        try {

            File sourceFile = new File(sourceFilePath);
            File destFile = new File(destFilePath);

            if(!sourceFile.exists())
                System.out.println("Fichero a copiar aún no existe, créalo. ");
            else
            {
                System.out.println("ficheros entrada existe");
                if(!destFile.exists()) {
                    destFile.createNewFile();
                }
                    // Abrimos o reader e o writer
                    in = new FileReader(sourceFile);
                    out = new FileWriter(destFile);
                    // Usamos os métodos read e write para ler e escribir caracter a caracter
                    int oneChar;
                    while ((oneChar = in.read()) != -1) {
                        out.write(oneChar);
                    }

            }
        } finally {
            // En calquera caso, producirase ou non unha excepción, pechamos o
            // reader e o writer se están abertos
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
