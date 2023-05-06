import java.io.*;
import java.util.ArrayList;

public class OperacionesAnimales {

    ArrayList<Mascotas> listadoPerro = new ArrayList<>();
    ArrayList<Mascotas> listadoGatos = new ArrayList<>();

    public void addPerro(Perro Perro){
        if(listadoPerro.size()<5){
            listadoPerro.add(Perro);
        }else {
            System.out.println("Imposible añadir mas animales");
        }
    }

    public void addGato(Gato Gato){
        if(listadoGatos.size()<5){
            listadoGatos.add( Gato);
        }else {
            System.err.println("Imposible añadir mas animales");
        }

    }

    public  File createFile(String fileName) throws IOException {
    File newFile = new File(fileName);
        if (!newFile.exists()) {
            newFile.createNewFile();
        }
    return  newFile;
    }




public void saveMascostas(ArrayList<Mascotas> Listado, File Archivo) throws IOException {
    ObjectOutputStream out = null;
    try{out = new ObjectOutputStream(new FileOutputStream(Archivo,true));
        out.writeObject(Listado);
    }finally {
        if(out !=null){
            out.close();
        }
    }
    }

public void printMascotas(File Archivo) throws IOException,ClassNotFoundException{

    ObjectInputStream in = null;

    try {
        in= new ObjectInputStream(new FileInputStream(Archivo));
        ArrayList<Mascotas> clients;
        ArrayList<Mascotas> clients2;

            clients = (ArrayList<Mascotas>) in.readObject();
        for (Mascotas m: clients
             ) {m.showInfo();

        }

        clients2 = (ArrayList<Mascotas>) in.readObject();
        for (Mascotas m: clients2
        ) {m.showInfo();

        }



    }finally{
        if(in != null){
            in.close();
        }

    }










}





}
