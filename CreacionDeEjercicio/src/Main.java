import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException ,ClassNotFoundException{

        ArrayList<Vehiculo> listadoVehiculos= new ArrayList<>();
        Vehiculo v1 = new Vehiculo("Ford","Fiesta");
        Vehiculo v2 = new Vehiculo("Renault","Megane");
        Vehiculo v3 = new Vehiculo("Renault","Clio");
        Vehiculo v4 = new Vehiculo("Ford","Kuga");
        Vehiculo v5 = new Vehiculo("Nissan","Almera");

        listadoVehiculos.add(v1);
        listadoVehiculos.add(v2);
        listadoVehiculos.add(v3);
        listadoVehiculos.add(v4);
        listadoVehiculos.add(v5);


        String rutaFicheroDeDestino = "listado.dat";
        File ficherodestino=new File(rutaFicheroDeDestino);
        if(!ficherodestino.exists()) ficherodestino.createNewFile();


        guardarCoches(listadoVehiculos,rutaFicheroDeDestino);
        mostrarCoches(rutaFicheroDeDestino);






    }



    public static void guardarCoches(ArrayList<Vehiculo> coches,String ficherodestino) throws IOException{


        ObjectOutputStream out = null, out1=null;
        try{

            if(new File(ficherodestino).length()!=0){

                out1 = new MiObjectOutputStream(new FileOutputStream(ficherodestino,new File(ficherodestino).exists()));

                for(Vehiculo  veh : coches){
                    out1.writeObject(veh);
                }

            }else {
                out = new ObjectOutputStream(new FileOutputStream(ficherodestino,new File(ficherodestino).exists()));
                for(Vehiculo veh : coches ){
                    out.writeObject(veh);
                }
            }

        }finally {
            if (out1 != null) {
                out1.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
public static void mostrarCoches(String rutaFichero) throws IOException{
    int contador=0;
    ObjectInputStream in =null;
    try{
        in =new ObjectInputStream(new FileInputStream(rutaFichero));
        try{
            while(true){

               Vehiculo vehiculo = (Vehiculo) in.readObject();
               vehiculo.show();
               contador=contador+1;
               System.out.println("Coche nº="+ contador);


            }
        }catch (EOFException e){
            System.err.println("Fin Fichero");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }finally {
        if (in != null) {
            in.close();
        }

    }



}



}