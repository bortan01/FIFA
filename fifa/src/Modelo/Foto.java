
package Modelo;

import java.io.File;
import java.io.FileInputStream;

public class Foto {
    File archivo;
    FileInputStream imagen ;

    public Foto(File archivo, FileInputStream imagen) {
        this.archivo = archivo;
        this.imagen = imagen;
    }

    public Foto() {
    }

    
    
    
    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public FileInputStream getImagen() {
        return imagen;
    }

    public void setImagen(FileInputStream imagen) {
        this.imagen = imagen;
    }
    
    
    
    
}
