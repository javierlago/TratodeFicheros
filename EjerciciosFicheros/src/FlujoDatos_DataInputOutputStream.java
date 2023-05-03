

import java.io.*;
import java.util.ArrayList;

public class FlujoDatos_DataInputOutputStream {

    public static void main(String[] args) throws IOException {
        ArrayList<Client> clients=new ArrayList<>();
        Client c1=new Client(1,"Pepe Perez",1.0);
        Client c2=new Client(2,"Maria Rodriguez",2.0);

        clients.add(c1);
        clients.add(c2);

        String destFilePath="archiDataInputOutput.dat";
        File destFile = new File(destFilePath);
        if(!destFile.exists()) destFile.createNewFile();

        saveClients(clients,destFilePath);
        System.out.println("Leyendo archivo");
        showClients(destFilePath);

    }

    public static void saveClients(ArrayList<Client> clients, String destFilePath)
            throws IOException {
        // Declaramos o fluxo de datos de saída
        DataOutputStream out = null;
        try {
            // Abrimos o fluxo de datos sobre o ficheiro
            out = new DataOutputStream(new FileOutputStream(destFilePath));
            // Escribimos na saída os atributos dos clientes
            for (Client client : clients) {
                out.writeInt(client.getId());
                out.writeUTF(client.getName());
                out.writeDouble(client.getAccount());
            }
        } finally {
            // En calquera caso, producirase ou non unha excepción, pechamos o
            // fluxo de saída se está aberto
            if (out != null) {
                out.close();
            }
        }
    }

    public static void showClients(String sourceFilePath) throws IOException {
        // Declaramos o fluxo de datos de entrada
        DataInputStream in = null;
        try {
            // Abrimos o fluxo de datos sobre o ficheiro
            in = new DataInputStream(new FileInputStream(sourceFilePath));
            // Lemos os datos dos cliente, na mesma orde na que os escribimos,
            // ata que se produza a excepción de fin de ficheiro
            try {
                while (true) {
                    Client client = new Client();
                    client.setId(in.readInt());
                    client.setName(in.readUTF());
                    client.setAccount(in.readDouble());
                    client.show();
                }
            } catch (EOFException e) {
            }
        } finally {
            // En calquera caso, producirase ou non unha excepción, pechamos o
            // fluxo de entrada se está aberto
            if (in != null) {
                in.close();
            }
        }
    }
}
