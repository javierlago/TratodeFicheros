package Json_Gson;

import XML.Xtream_Ejemplos.Clientes.ClientSer;

import java.util.ArrayList;
import java.util.List;

public class ListadoClientes {

    private List<XML.Xtream_Ejemplos.Clientes.ClientSer> ListadoClientes = new ArrayList<>();

    public ListadoClientes(){super();}


    public void add(XML.Xtream_Ejemplos.Clientes.ClientSer ClienteSer){ListadoClientes.add(ClienteSer);}

    public List<ClientSer> getList(){return ListadoClientes;}

}
