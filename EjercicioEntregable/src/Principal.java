import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        OperacionesAnimales o = new OperacionesAnimales();
        if(o.createFile("l.dat").exists()){
            o.recuperar(o.createFile("l.dat"));}

        /*Añadimos los Gatos*/
        o.addGato(new Gato("Misifu",1,true));
        o.addGato(new Gato("Garfield",1,true));
        o.addGato(new Gato("Lume",1,true));
        o.addGato(new Gato("Salem",1,true));
        o.addGato(new Gato("Cat",1,true));
        /* Añadimos los perros */
        o.addPerro(new Perro("Firulais",2,true));
        o.addPerro(new Perro("Dana",3,true));
        o.addPerro(new Perro("Chuspy",4,false));
        o.addPerro(new Perro("Canca",5,false));
        o.addPerro(new Perro("Dogui",2,true));

        /*------------------------------------------------------------------------*/

        o.saveMascostas(o.listadoCompleto,o.createFile("l.dat"));
       o.printMascotas(o.createFile("l.dat"));


    }




}
