package misclases;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // PASO 1: Crear la ventana
            JFrame ventana = new JFrame("Calculadora de compras");

            ventana.setSize(400, 250);
            ventana.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE);

            // PASO 2: Crear los componentes
            JLabel lblPrecio = new JLabel("Precio (S/):");
            JTextField txtPrecio = new JTextField(10);

            JLabel lblCantidad = new JLabel("Cantidad:");
            JTextField txtCantidad = new JTextField(10);

            JCheckBox chkDescuento =
                    new JCheckBox("Descuento del 10%");

            JButton btnCalcular = new JButton("CALCULAR");

            JLabel lblTotal = new JLabel("Total: S/ 0.00");

            // PASO 3: Organizar la interfaz
            JPanel panel = new JPanel();

            panel.setLayout(new GridLayout(4, 2, 10, 10));

            panel.setBorder(
                    BorderFactory.createEmptyBorder(20, 20, 20, 20));

            panel.add(lblPrecio);
            panel.add(txtPrecio);

            panel.add(lblCantidad);
            panel.add(txtCantidad);

            panel.add(chkDescuento);
            panel.add(new JLabel(""));

            panel.add(btnCalcular);
            panel.add(lblTotal);

            ventana.add(panel);

            // PASO 4: Programar el evento del botón
            btnCalcular.addActionListener(e -> {

                try {

                    // Leer los datos
                    double precio = Double.parseDouble(
                            txtPrecio.getText());

                    int cantidad = Integer.parseInt(
                            txtCantidad.getText());

                    // Validar
                    if (precio <= 0 || cantidad <= 0) {
                        JOptionPane.showMessageDialog(
                                ventana,
                                "Precio y cantidad deben ser mayores a 0");
                        return;
                    }

                    // Calcular importe
                    double total = precio * cantidad;

                    // Aplicar descuento
                    if (chkDescuento.isSelected()) {
                        total = total * 0.90;
                    }

                    // Mostrar el resultado en la interfaz
                    lblTotal.setText(
                            String.format("Total: S/ %.2f", total));

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                            ventana,
                            "Ingrese valores numéricos válidos");
                }
            });

            // PASO 5: Mostrar la ventana
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}