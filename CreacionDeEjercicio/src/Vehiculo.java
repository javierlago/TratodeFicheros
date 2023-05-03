import java.io.Serializable;

public class Vehiculo implements Serializable {
    String marca,modelo;


    public Vehiculo() {
    }

    public Vehiculo(String matricula, String modelo) {
        this.marca = matricula;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void show() {
        System.out.println("--------------");
        System.out.println("Marca");
        System.out.println(getMarca());
        System.out.println("Modelo");
        System.out.println(getModelo());
        System.out.println("--------------");
    }
}
