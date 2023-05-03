

import java.io.*;
import java.util.ArrayList;

public class FlujoObjetos_ObjectInputOutputStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<ClientSer> clients=new ArrayList<>();
        ClientSer c1=new ClientSer(1,"Pepe Perez",1.0);
        ClientSer c2=new ClientSer(2,"Maria Rodriguez",2.0);

        clients.add(c1);
        clients.add(c2);

        //Tratando como colección de Objetos
        String destFilePath="archiObjectInputOutput.dat";
        File destFile = new File(destFilePath);
        if(!destFile.exists()) destFile.createNewFile();

        saveClients(clients,destFilePath);
        System.out.println("Leyendo archivo Colección");
        showClients(destFilePath);

        //Tratando como Objetos Individuales
        String destFilePathOneByOne="archiObjectInputOutputOneByOne.dat";
        File destFileOneByOne = new File(destFilePathOneByOne);
        if(!destFileOneByOne.exists()) destFile.createNewFile();

        saveClientsOneByOne(clients,destFilePathOneByOne);
        System.out.println("Leyendo archivo One By One");
        showClientsOneByOne(destFilePathOneByOne);
    }

        public static void saveClients(ArrayList<ClientSer> clients, String destFilePath)
            throws IOException {
            // Declaramos o fluxo de datos de saída
            ObjectOutputStream out = null;
            //MiObjectOutputStream out2 = null;
            try {
                    // Abrimos o fluxo de datos sobre o ficheiro
                    out = new ObjectOutputStream(new FileOutputStream(destFilePath));
                    // Escribimos na saída os clientes
                    out.writeObject(clients);
            } finally {
                // En calquera caso, producirase ou non unha excepción, pechamos o
                // fluxo de saída se está aberto
                if (out != null) {
                    out.close();
                }
            }
        }

        public static void showClients(String sourceFilePath)
            throws IOException, ClassNotFoundException {
            // Declaramos o fluxo de datos de entrada
            ObjectInputStream in = null;
            try {
                // Abrimos o fluxo de datos sobre o ficheiro

                in = new ObjectInputStream(new FileInputStream(sourceFilePath));
                // Lemos a colección de clientes
                ArrayList<ClientSer> clients;
                clients = (ArrayList<ClientSer>) in.readObject();
                for (ClientSer client : clients) {
                    client.show();
                }
            } finally {
                // En calquera caso, producirase ou non unha excepción, pechamos o
                // fluxo de entrada se está aberto
                if (in != null) {
                    in.close();
                }
            }
        }

    public static void saveClientsOneByOne(ArrayList<ClientSer> clients, String destFilePath)
            throws IOException {
        // Declaramos o fluxo de datos de saída
        ObjectOutputStream out = null,out1 = null;
        try {
            if(new File(destFilePath).exists()){
                // Abrimos o fluxo de datos sobre o ficheiro
                out1 = new MiObjectOutputStream(new FileOutputStream(destFilePath,new File(destFilePath).exists()));
                // Escribimos na saída os clientes
                for (ClientSer client : clients) {
                    out1.writeObject(client);
                }
            }
            else{
            // Abrimos o fluxo de datos sobre o ficheiro
            out = new ObjectOutputStream(new FileOutputStream(destFilePath,new File(destFilePath).exists()));
            // Escribimos na saída os clientes
            for (ClientSer client : clients) {
                out.writeObject(client);
            }
            }
        } finally {
            // En calquera caso, producirase ou non unha excepción, pechamos o
            // fluxo de saída se está aberto
            if (out1 != null) {
                out1.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public static void showClientsOneByOne(String sourceFilePath) throws IOException {
        // Declaramos o fluxo de datos de entrada
        ObjectInputStream in = null;
        try {
            // Abrimos o fluxo de datos sobre o ficheiro
            in = new ObjectInputStream(new FileInputStream(sourceFilePath));
            // Lemos os datos dos cliente, na mesma orde na que os escribimos,
            // ata que se produza a excepción de fin de ficheiro
            try {
                while (true) {
                    ClientSer client = (ClientSer)in.readObject();
                    client.show();
                }
            } catch (EOFException e) {
                System.err.println("Fin Fichero");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
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
