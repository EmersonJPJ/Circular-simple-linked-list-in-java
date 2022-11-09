package listasimplecircular;

/**
 *
 * @author EMERSON
 */
public class Nodo {

    private Vehiculo dato;
    private Nodo siguiente;

    public Nodo() {
        this.siguiente = null;
    }

    /**
     * @return the dato
     */
    public Vehiculo getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Vehiculo dato) {
        this.dato = dato;
    }

    /**
     * @return the siguiente
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
