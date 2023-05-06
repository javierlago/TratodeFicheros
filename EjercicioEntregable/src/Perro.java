import java.io.Serializable;

public class Perro extends Mascotas{

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


    public void setRabolargo(boolean rabolargo) {
        this.rabolargo = rabolargo;
    }

    @Override
    String habla() {
        return "Guau";
    }

    @Override
   String Quiensoy() {
        return getClass().getName() ;
    }

     String rabo(){
        String rabo;
        if(isRabolargo()){rabo="largo";}else {
            rabo="corto";
        }

        return rabo;
     }

    @Override
    public void showInfo() {
        System.out.print("Soy un "+Quiensoy()+" y mi nombre es "+getNombredelAnimal()+" y tengo "+getEdad() +" años y tengo el rabo "+ rabo()+"\n");

    }
}
