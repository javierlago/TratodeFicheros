public class Perro extends Mascotas {

    public Perro(String nombredelAnimal, int edad, boolean rabolargo) {
        super(nombredelAnimal, edad);
        this.rabolargo = rabolargo;
    }


    public Perro(String nombredelAnimal, int edad) {
        super(nombredelAnimal, edad);
    }

    public boolean isRabolargo() {
        return rabolargo;
    }

    boolean rabolargo;




    @Override
    String habla() {
        return "Guau";
    }

    @Override
   String Quiensoy() {
        return getClass().getName() ;
    }
}
