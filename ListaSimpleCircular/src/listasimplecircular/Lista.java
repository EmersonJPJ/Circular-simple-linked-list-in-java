package listasimplecircular;

import javax.swing.JOptionPane;

/**
 *
 * @author EMERSON
 */
public class Lista {

    private Nodo inicio;
    private Nodo fin;

    public Lista() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean vacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregar() {
        Vehiculo v = new Vehiculo();
        v.setMarca(JOptionPane.showInputDialog("Digite la marca: "));
        v.setModelo(Integer.parseInt(JOptionPane.showInputDialog("Digite el modelo")));

        Nodo nuevo = new Nodo();
        nuevo.setDato(v);

        if (vacia()) {
            inicio = nuevo;
            fin = nuevo;
            fin.setSiguiente(inicio);
        } else if (v.getModelo() < inicio.getDato().getModelo()) {
            Nodo aux = new Nodo();
            aux = nuevo;
            aux.setSiguiente(inicio);
            inicio = aux;
            fin.setSiguiente(inicio);
        } else if (fin.getDato().getModelo() <= v.getModelo()) {
            fin.setSiguiente(nuevo);
            fin = fin.getSiguiente();
            fin.setSiguiente(inicio);
        } else {
            Nodo aux = inicio;
            while (aux.getSiguiente().getDato().getModelo() < v.getModelo()) {
                aux = aux.getSiguiente();
            }
            Nodo temporal = new Nodo();
            temporal = nuevo;
            temporal.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(temporal);
        }
        fin.setSiguiente(inicio);
    }

    public void extraerInicio() {
        if (!vacia()) {
            inicio = inicio.getSiguiente();
            fin.setSiguiente(inicio);
            JOptionPane.showMessageDialog(null, "Elemento fue extraído!");
        } else {
            JOptionPane.showMessageDialog(null, "No se puede extraer, lista vacía");
        }
    }

    public void modificar() {
        if (!vacia()) {
            Nodo aux = inicio;
            boolean encontrado = false;
            int buscarNodo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la marca del vehiculo a modificar"));
            while (aux != null && encontrado != true) {
                if (aux.getDato().getModelo() == buscarNodo) {
                    JOptionPane.showMessageDialog(null, "El vehiculo buscado: " + aux.getDato().getModelo() + ", si existe");
                    aux.getDato().setMarca((JOptionPane.showInputDialog(null, "Ingrese la nueva marca del vehiculo")));
                    aux.getDato().setModelo(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo modelo")));
                    JOptionPane.showMessageDialog(null, "Se ha modificado los datos del vehiculo");
                    encontrado = true;
                }
                aux = aux.getSiguiente();
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "El vehiculoo");

            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay vehiculos, cola vacía");

        }
    }

    public void existe() {
        if (!vacia()) {
            Nodo aux = inicio;
            boolean encontrado = false;
            int buscarNodo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el modelo del vehiculo a buscar"));
            while (aux != null && encontrado != true) {
                if (aux.getDato().getModelo() == buscarNodo) {
                    JOptionPane.showMessageDialog(null, "El vehiculo buscado: " + aux.getDato().getModelo() + ", si existe");
                    encontrado = true;
                }
                aux = aux.getSiguiente();
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "El vehiculo no ha sido registrado");

            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay vehiculos, cola vacía");

        }

    }

    public void extraerEspecifico() {
        try {
            if (!vacia()) {
                String marca = JOptionPane.showInputDialog("Digite la marca a extraer: ");
                if (inicio.getDato().getMarca().equals(marca)) {
                    inicio = inicio.getSiguiente();
                    JOptionPane.showMessageDialog(null, "Elemento extraído");
                } else {
                    Nodo anterior;
                    Nodo aux;

                    anterior = inicio;
                    aux = inicio.getSiguiente();

                    while ((aux != inicio) && (!aux.getDato().getMarca().equals(marca))) {
                        anterior = anterior.getSiguiente();
                        aux = aux.getSiguiente();
                    }
                    if (aux != inicio) {
                        anterior.setSiguiente(aux.getSiguiente());
                        fin.setSiguiente(inicio);
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El vehiculo puede que no exista");
        }
    }

    public void mostrar() {
        String s = "";
        Nodo aux = inicio;
        if (aux != null) {
            s += aux.getDato().getMarca() + " / " + aux.getDato().getModelo() + " -> ";
            aux = aux.getSiguiente();
            while (aux != inicio) {
                s += aux.getDato().getMarca() + " / " + aux.getDato().getModelo() + " -> ";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Los vehiculos actuales son: \n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "No hay vehiculos, cola vacía");

        }
    }
}
