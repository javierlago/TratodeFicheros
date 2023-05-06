import java.io.Serializable;

abstract class Mascotas implements Serializable {


    public Mascotas(String nombredelAnimal, int edad) {
        NombredelAnimal = nombredelAnimal;
        Edad = edad;
    }

    String NombredelAnimal;
    int Edad;


    abstract String habla();

    public String getNombredelAnimal() {
        return NombredelAnimal;
    }

    public void setNombredelAnimal(String nombredelAnimal) {
        NombredelAnimal = nombredelAnimal;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    abstract String Quiensoy();

    abstract void showInfo();
}

