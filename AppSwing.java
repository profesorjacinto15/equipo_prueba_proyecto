import javax.swing.*;
import java.awt.*;

public class AppSwing {

    public static void main(String[] args) {
        crearVentana();
    }

    private static void crearVentana() {
        //Creamos la ventana
        JFrame ventana = new JFrame("Probando Swing");
        //Asignamos el tamaño a la ventana
        ventana.setSize(600, 480);
        //Hacemos que al dar al botón de cerrar la ventana esta se cierre
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Centramos la ventana en pantalla
        ventana.setLocationRelativeTo(null);
        //Creamos un panel para organizar los componentes con un GridLayout 4 filas y 2 columnas y 10 de separación
        JPanel panel = new JPanel(new GridLayout(4,2,10,10));
        //Asignamos un border al panel con 20 para los bordes
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        //Añadimos los componentes JLabel y JTextFiled
        JLabel lbCelsius = new JLabel("Temperatura en ºC:");
        JTextField tfCelsius = new JTextField();
        JLabel lbFahrenheit = new JLabel("Resultado en ºF:");
        JTextField tfFahrenheit = new JTextField();
        //Añadimos el boton
        JButton btnConversion = new JButton("Convertir");
        JLabel lbestado = new JLabel("");

        //Añadimos el ActionListener para maneja que hagan clic en el ratóan
        btnConversion.addActionListener(e -> {
            try {
                //Convertirmos los valores introducidos en un de los JTextField para realizar los cálculos
                //Usamos un try catch por si se produce alguna excepción
                double celsius = Double.parseDouble((tfCelsius.getText()));
                double fahrenheit = celsius *9/5 + 32;
                tfFahrenheit.setText(String.format("%.2f ºF", fahrenheit));
                lbestado.setText("Conversion realizada de forma correcta");
                lbestado.setForeground(Color.GREEN);
            } catch (NumberFormatException ex) {
                lbestado.setText("El numero no tiene el formato correcto.");
                lbestado.setForeground(Color.RED);
            }
        });

        
        //Añadimos los componentes al panel
        panel.add(lbCelsius);
        panel.add(tfCelsius);
        panel.add(lbFahrenheit);
        panel.add(tfFahrenheit);
        panel.add(btnConversion);
        panel.add(lbestado);
        //Añadimos el panel a nuestra ventana.
        ventana.add(panel);
        //Mostramos nuestra ventana.
        ventana.setVisible(true);
    }

}
