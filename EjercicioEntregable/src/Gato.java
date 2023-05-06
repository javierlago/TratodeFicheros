import java.io.Serializable;

public class Gato extends Mascotas {

    public Gato(String nombredelAnimal, int edad, boolean tienebigote) {
        super(nombredelAnimal, edad);
        this.tienebigote = tienebigote;
    }

    boolean tienebigote;

    public boolean isTienebigote() {
        return tienebigote;
    }

    public void setTienebigote(boolean tienebigote) {
        this.tienebigote = tienebigote;
    }

    @Override
    String habla() {
        return "Miau";
    }

    @Override
    String Quiensoy() {
        return getClass().getName();
    }



    String bigote(){
        String bigote;
        if(isTienebigote()){bigote="largo";}else {
            bigote="corto";
        }

        return bigote;
    }

    @Override
    public void showInfo() {
        System.out.print("Soy un "+Quiensoy()+" Mi nombre es "+getNombredelAnimal()+" y tengo"+getEdad()+ "años y tengo el bigote "+bigote() );
    }
}
