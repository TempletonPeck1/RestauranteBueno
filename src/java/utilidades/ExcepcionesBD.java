/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

/**
 *
 * @author admin
 */
public class ExcepcionesBD extends RuntimeException {
    
     public ExcepcionesBD() {
        super();
    }
//constructor con la causa
    public ExcepcionesBD(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public ExcepcionesBD(String mensaje) {
        super(mensaje);
    }

    public ExcepcionesBD(Throwable causa) {
        super(causa);
    }
    
}
