package Json_Gson;

import XML.Xtream_Ejemplos.Clientes.ClientSer;
import XML.Xtream_Ejemplos.Clientes.ListadoClientes;
import XML.Xtream_Ejemplos.Clientes.gestionDeClientes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;

public class GestionDeClientes {

    public static void main(String[] args) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        ListadoClientes lista = new ListadoClientes();
        lista.add(new ClientSer(01, "Manolo", 1000));
        lista.add(new ClientSer(02, "Pepa", 2000));
        lista.add(new ClientSer(03, "Luisa", 1500));
        lista.add(new ClientSer(04, "Pepe", 4500));
        lista.add(new ClientSer(05, "Maria", 1000));


        //
        try (FileWriter writer = new FileWriter("Xml_Json/src/main/java/ficheros/miyeison.json")) {
            gson.toJson(lista, writer);
            String json = gson.toJson(lista);
            System.out.printf(json);
        }

        ListadoClientes Lista2;
        try (FileReader reader = new FileReader("Xml_Json/src/main/java/ficheros/miyeison.json")) {

            Lista2 = gson.fromJson(reader, ListadoClientes.class);
        }

        for (ClientSer a : Lista2.getList()
        ) {
            System.out.println(a);

        }

    }

}