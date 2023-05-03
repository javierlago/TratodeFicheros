

import java.io.*;

public class Flujo_E_S_InputOuputStream {
    public void copyFile(String sourceFilePath, String destFilePath)
            throws IOException {
        // Declaramos os streams de entrada e saída
        InputStream in = null;
        OutputStream out = null;
        try {
            // Abrimos os streams
            in = new FileInputStream(sourceFilePath);
            out = new FileOutputStream(destFilePath);
            // Usamos os métodos read e write para ler e escribir byte a byte
            int oneByte;
            while ((oneByte = in.read()) != -1) {
                out.write(oneByte);
            }
        } finally {
            // En calquera caso, producirase ou non unha excepción, pechamos os
            // streams se están abertos
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public static void copyFile_static(String sourceFilePath, String destFilePath)
            throws IOException {
        // Declaramos os streams de entrada e saída
        InputStream in = null;
        OutputStream out = null;
        try {
            File sourceFile = new File(sourceFilePath);
            File destFile = new File(destFilePath);

            if(!sourceFile.exists())
                System.out.println("Fichero a copiar aún no existe, créalo. ");
            else {
                System.out.println("ficheros entrada existe");
                if(!destFile.exists()) {
                    destFile.createNewFile();
                }
                // Abrimos os streams
                in = new FileInputStream(sourceFilePath);
                out = new FileOutputStream(destFilePath);
                // Usamos os métodos read e write para ler e escribir byte a byte
                int oneByte;
                while ((oneByte = in.read()) != -1) {
                    out.write(oneByte);
                }
            }
        } finally {
            // En calquera caso, producirase ou non unha excepción, pechamos os
            // streams se están abertos
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
