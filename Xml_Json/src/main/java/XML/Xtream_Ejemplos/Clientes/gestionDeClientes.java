package XML.Xtream_Ejemplos.Clientes;

import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class gestionDeClientes {
    public static void main(String[] args) throws FileNotFoundException {


        File XMLclientes = new File("Xml_Json/src/main/java/ficheros/ListadoClientes.xml");
        XStream xstream = new XStream();
        xstream.allowTypes(new Class[]{ClientSer.class, ListadoClientes.class});

        xstream.alias("Listado", ListadoClientes.class);
        xstream.alias("Cliente", ClientSer.class);

        //Creacion de los clientes//

        ClientSer Jose = new ClientSer(01,"Jose",2500);
        ClientSer Manuel = new ClientSer(01,"Manuel",2500);
        ClientSer Pepe = new ClientSer(01,"Pepe",2500);
        ClientSer Victor = new ClientSer(01,"Victor",2500);

        ListadoClientes Lista = new ListadoClientes();
        Lista.add(Jose);
        Lista.add(Manuel);
        Lista.add(Pepe);
        Lista.add(Victor);

        pasarAxml(xstream,Lista,XMLclientes);

        recibirXML(xstream,XMLclientes);
    }



    public static void pasarAxml(XStream xstream,ListadoClientes Lista ,File clientesXML) throws FileNotFoundException {

        xstream.toXML(Lista,new FileOutputStream(clientesXML));
        System.out.printf("Se ha creado xml");

    }

    public static void recibirXML(XStream xstream , File ficheroDeClientes){
        ListadoClientes Listado = (ListadoClientes) xstream.fromXML(ficheroDeClientes);

        for (ClientSer a : Listado.getList()
             ) {
            System.out.printf(a.toString());

        }




    }



}
