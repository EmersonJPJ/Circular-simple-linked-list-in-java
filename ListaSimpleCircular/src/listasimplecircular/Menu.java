package listasimplecircular;

import javax.swing.JOptionPane;

/**
 *
 * @author EMERSON
 */
public class Menu {

    int op = 0;
    Lista x = new Lista();

    public void mostrar() {
        while (op != 7) {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "MENU PRINCIPAL\n"
                    + "1- Agregar nodo\n"
                    + "2- Extraer nodo al inicio\n"
                    + "3- Eliminar nodo especifico\n"
                    + "4. Modificar Nodo\n"
                    + "5. Existencia del Nodo\n"
                    + "6- Mostrar nodo\n"
                    + "7- Salir\n"));

            switch (op) {
                case 1:
                    x.agregar();
                    break;
                case 2:
                    x.extraerInicio();
                    break;
                case 3:
                    x.extraerEspecifico();
                    break;
                case 4:
                    x.modificar();
                    break;
                case 5:
                    x.existe();
                    break;
                case 6:
                    x.mostrar();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }
}
