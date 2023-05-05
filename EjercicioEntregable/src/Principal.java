public class Principal {
    public static void main(String[] args) {

        OperacionesAnimales o = new OperacionesAnimales();
        /*Añadimos los Gatos*/
        o.addGato(new Gato("Misifu",1,true));
        o.addGato(new Gato("Garfield",1,true));
        o.addGato(new Gato("Lume",1,true));
        o.addGato(new Gato("Salem",1,true));
        o.addGato(new Gato("Cat",1,true));

        /* Añadimos los perros */
        o.addPerro(new Perro("Firulais",2,true));
        o.addPerro(new Perro("Dana",2,true));
        o.addPerro(new Perro("Chuspy",2,true));
        o.addPerro(new Perro("Canca",2,true));
        o.addPerro(new Perro("Dogui",2,true));
        /*------------------------------------------------------------------------*/


    }




}
