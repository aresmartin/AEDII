package ventanas;

import javax.swing.*;
import java.awt.event.*;

public class Formulario extends JFrame implements ActionListener {
    
    private JTextField textField1;
    private JLabel label1;
    private JButton boton1;
    
    public Formulario(){
        setLayout(null);
        // Evitar que una vez que se cierrra la interfaz, el programa siga ejecutandose
        //en segundo plano (que se crease un demonio)
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        label1 = new JLabel("Mensaje: ");
        label1.setBounds(15, 10, 100, 30);
        add(label1);
        
        textField1 = new JTextField();
        textField1.setBounds(80, 16, 190, 20);
        add(textField1);
        
        boton1 = new JButton("Mostrar");
        boton1.setBounds(10, 60, 100, 30);
        add(boton1);
        boton1.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
