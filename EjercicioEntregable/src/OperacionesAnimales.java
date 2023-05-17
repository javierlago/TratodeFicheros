import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class OperacionesAnimales {

    ArrayList<Mascotas> listadoPerro = new ArrayList<>();
    ArrayList<Mascotas> listadoGatos = new ArrayList<>();

    ArrayList<Mascotas> listadoCompleto = new ArrayList<>();




    public void addPerro(Perro Perro){
        if(listadoPerro.size()<5){
            listadoPerro.add(Perro);
        }else {
            System.out.println("Imposible añadir mas animales");
        }
        if (listadoPerro.size() == 5) { listadoCompleto.addAll(listadoPerro);
        }
        }



    public void addGato(Gato Gato) {
        if (listadoGatos.size() < 5) {
            listadoGatos.add(Gato);
        } else {
            System.err.println("Imposible añadir mas animales");
        }
        if (listadoGatos.size() == 5) {
            listadoCompleto.addAll(listadoGatos);
        }
    }
    public  File createFile(String fileName) throws IOException {
    File newFile = new File(fileName);
        if(!newFile.exists()) {
            newFile.createNewFile();
        }
    return  newFile;
    }






    public void saveMascostas(ArrayList<Mascotas> Listado,File Archivo) throws IOException {
    ObjectOutputStream out = null;
    try{out = new ObjectOutputStream(new FileOutputStream(Archivo));
        out.writeObject(Listado);

    }finally {
        if(out !=null){
            out.close();
        }
    }
    }


public void printMascotas(File Archivo) throws IOException,ClassNotFoundException{

    ObjectInputStream in = null;
    ArrayList<Mascotas> Listado = new ArrayList<>();
    try {
        in = new ObjectInputStream(new FileInputStream(Archivo));
    try{while(true) {
        Listado.addAll((Collection<? extends Mascotas>) in.readObject());
    }}catch (EOFException e){}



    }finally{
        if(in != null){
            in.close();
        }
        for (Mascotas m : Listado
        ) {
            m.showInfo();
        }


    }










}

    public void recuperar(File Archivo) throws IOException,ClassNotFoundException{

        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream(new FileInputStream(Archivo));

            listadoCompleto= (ArrayList<Mascotas>) in.readObject();
            System.err.println("Se añadiran elementos a un listado existente");


        }catch (EOFException e){
            System.err.println("Archivo sin contenido");
        }
        finally{
            if(in != null){
                in.close();
            }



        }



}
}
