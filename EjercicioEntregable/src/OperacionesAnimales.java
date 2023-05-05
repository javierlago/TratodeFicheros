import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class OperacionesAnimales {

    ArrayList<Mascotas> listadoPerro = new ArrayList<>();
    ArrayList<Mascotas> listadoGatos = new ArrayList<>();

    public void addPerro(Perro Perro){
        if(listadoPerro.size()<5){
            listadoPerro.add((Mascotas) Perro);
        }else {
            System.out.println("Imposible añadir mas animales");
        }
    }

    public void addGato(Gato Gato){
        if(listadoGatos.size()<5){
            listadoGatos.add((Mascotas) Gato);
        }else {
            System.err.println("Imposible añadir mas animales");
        }

    }
public void saveMascostas(ArrayList<Mascotas> Listado, String NombreArchivo) throws IOException {


    File FicheroDestino = new File(NombreArchivo);
    if(!FicheroDestino.exists()) FicheroDestino.createNewFile();
    ObjectOutputStream out = null;
    try{out = new ObjectOutputStream(new FileOutputStream(FicheroDestino,true));
        out.writeObject(Listado);
    }finally {
        if(out !=null){
            out.close();
        }
    }
    }

public void printearMascotas(ArrayList<Mascotas> Listado,String ArchivoLeer){








}





}
