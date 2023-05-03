

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream extends ObjectOutputStream {

//Constructor sin parámetros

    protected MiObjectOutputStream() throws IOException,

            SecurityException {

        super();

    }

//Constructor que recibe como parámetro un objeto OutputStream

    protected MiObjectOutputStream(OutputStream out) throws IOException {

        super(out);

    }

    /*redefinición del método que escribe la cabecera para que no haga nada en caso de que el fichero ya tenga datos

     */

    @Override
    protected void writeStreamHeader() {

    }
}